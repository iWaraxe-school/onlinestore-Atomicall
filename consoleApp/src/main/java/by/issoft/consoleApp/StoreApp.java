package by.issoft.consoleApp;
import by.issoft.store.Store;
import com.github.javafaker.Faker;

import java.util.Locale;

public class StoreApp {
    public static void main(String[] args) {
        Store store = new Store();
        store.init();
        store.populateCategories();
    }


}
