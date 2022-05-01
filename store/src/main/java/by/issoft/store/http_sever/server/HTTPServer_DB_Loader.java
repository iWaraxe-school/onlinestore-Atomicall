package by.issoft.store.http_sever.server;

import by.issoft.domain.Product;
import by.issoft.store.database.StoreDB;

import java.util.ArrayList;
import java.util.List;

public class HTTPServer_DB_Loader {
    private static StoreDB db = StoreDB.getStoreDB();

    public HTTPServer_DB_Loader() {
    }

    public List<Product> getListofProductsFromBikeCategory(){
        return db.getBikeCategoryDB().getListOfProducts();
    }
    public List<Product> getListofProductsFromMilkCategory(){
        return db.getMilkCategoryDB().getListOfProducts();
    }
    public List<Product> getListofProductsFromPhoneCategory(){
        return db.getPhoneCategoryDB().getListOfProducts();
    }

    public List<List<Product>> getListsOfProducts (){
        List<List<Product>> listOfCategories = new ArrayList<>();
        listOfCategories.add(getListofProductsFromBikeCategory());
        listOfCategories.add(getListofProductsFromMilkCategory());
        listOfCategories.add(getListofProductsFromMilkCategory());
        return listOfCategories;
    }
}
