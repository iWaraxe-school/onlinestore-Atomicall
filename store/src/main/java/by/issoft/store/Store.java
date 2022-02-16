package by.issoft.store;
import by.issoft.domain.Category;
import by.issoft.domain.categories.BikeCategory;
import by.issoft.domain.categories.MilkCategory;
import by.issoft.domain.categories.PhoneCategory;

import java.util.ArrayList;
import java.util.List;



public class Store {
private List<Category> categoryList = new ArrayList<>();

    public List<Category> getCategoryList() {
        return categoryList;
    }
    public void init(){
        categoryList.add(new BikeCategory());
        categoryList.add(new MilkCategory());
        categoryList.add(new PhoneCategory());
    }
    public void populateCategories(){
        if (categoryList.isEmpty()) return;
        for (Category c: categoryList) {
            RandomStorePopulator.populateCategory(c);
        }
    }
}
