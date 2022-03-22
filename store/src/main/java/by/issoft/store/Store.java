package by.issoft.store;
import by.issoft.domain.Category;

import java.util.ArrayList;
import java.util.List;


public class Store {
    private List<Category> categoryList = new ArrayList<>();
    public List<Category> getCategoryList() {
        return categoryList;
    }
    private static Store store = null;

    private Store () {};

    public static Store getInstance(){
        if (null == store){
            store = new Store();
        }
        return store;
    }

    public void init() {
        ReflectionsService reflectionsService = ReflectionsService.getService();
        for (Class<? extends Category> c: reflectionsService.getSubClasses(Category.class)){
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
