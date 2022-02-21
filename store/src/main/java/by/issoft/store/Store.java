package by.issoft.store;
import by.issoft.domain.Category;

import java.util.ArrayList;
import java.util.List;


public class Store {
private List<Category> categoryList = new ArrayList<>();
    public List<Category> getCategoryList() {
        return categoryList;
    }
    public void init(){
        ReflectionsService reflectionsService = ReflectionsService.getService();
        for (Class<? extends Category> c: reflectionsService.getSubClasses(Category.class)){


            //Casting??
           /* Class<? extends Category> instanceOf1 = reflectionsService.createInstanceOf1(c);
            categoryList.add ((Category) instanceOf1);*/

            //works
            /*try {
                categoryList.add(((Category)Class.forName(c.getName()).getConstructor().newInstance()));
            }
            catch (Exception e){};*/

            //works
            try {
                categoryList.add(c.getConstructor().newInstance());
            }
            catch (Exception e){};
        }
    }

    public void populateCategories(){
        if (categoryList.isEmpty()) return;
        for (Category c: categoryList) {
            RandomStorePopulator.populateCategory(c);
        }
    }
}
