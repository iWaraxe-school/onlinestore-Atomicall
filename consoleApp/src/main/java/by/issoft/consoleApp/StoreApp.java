package by.issoft.consoleApp;
import by.issoft.store.Store;

import java.lang.reflect.InvocationTargetException;

public class StoreApp {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Store store = new Store();
        store.init();
        store.populateCategories();
        try {
            debugPrintService.printStore(store);
        }
        catch (Exception e){ throw e;}
    }


}
