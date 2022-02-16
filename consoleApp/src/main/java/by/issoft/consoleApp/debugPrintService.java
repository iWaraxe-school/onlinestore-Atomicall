package by.issoft.consoleApp;
import by.issoft.store.Store;
import by.issoft.domain.Category;
import org.reflections.Reflections;


import java.util.Set;


public class debugPrintService {
    static void printStore (Store s){
        Reflections reflections = new Reflections("by.issoft.domain");
        Set<Class<? extends Category>> subTypesOf = reflections.getSubTypesOf(Category.class);
        System.out.println(subTypesOf);

    }

}
