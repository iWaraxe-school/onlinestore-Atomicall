package by.issoft.consoleApp;
import by.issoft.XML_And_Sorting_Service.Sorter;
import by.issoft.domain.Product;
import by.issoft.store.ReflectionsService;
import by.issoft.store.Store;
import by.issoft.domain.Category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class UserInteractService {

    static void printStore (Store s) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ReflectionsService service = ReflectionsService.getService();
        Set<Class<? extends Category>> subCategories = service.getSubClasses(Category.class);
        int t = 0;
        for(Class<? extends Category> subCategoryClass: subCategories){
            Method method = subCategoryClass.getMethod("getCategoryName");
            StringBuilder str = new StringBuilder ("CategoryName: ");
            str.append(method.invoke(s.getCategoryList().get(t))).append("\n");
            str.append("\t").append(String.format("%-50s|%-10s|%-10s", "ProductName", "Prise", "Rate")).append("|\n");
            subCategoryClass.getMethod("getProductList").invoke(s.getCategoryList().get(t));
            List<Product> productList = (List<Product>) subCategoryClass.getMethod("getProductList").invoke(s.getCategoryList().get(t));
            for (Product p: productList) {
                str.append("\t");
                str.append(String.format("%-50s",p.getName())).append("|");
                str.append(String.format("%10s",p.getPrice())).append("|");
                str.append((String.format("%10s",p.getRate()))).append("|").append("\n");
            }
            System.out.println(str.toString());
            t++;
        }


    }

    /*private static StoreCommands parseCommand(String s){
        StoreCommands command = switch (s){
            case "top" -> StoreCommands.TOP;
            case "sort"->StoreCommands.SORT;
            case "quit"->StoreCommands.QUIT;
            default -> StoreCommands.DEFAULT;
        };
        return command;
    }*/
    static void readUserCommands(Store store){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        ArrayList<Product> sorted = null;
        try {
            while (true) {
                userInput = reader.readLine();
                switch (userInput) {
                    case "top":{

                        break;
                    }
                    case "sort":{
                        if (sorted == null){
                            sorted = Sorter.sortByPrice(store.getCategoryList());
                        }
                        for (int i = 0; i < 5 && i < sorted.size(); i++) {
                            System.out.println(sorted.get(i)); // todo красивый StringBuilder
                        }
                        break;
                    }
                    case "quit":{
                        System.out.println("Leaving...");
                        System.exit(0); //
                        break;
                    }
                    default:{
                        System.out.println("Unknown command");
                    }
                }
            }
        }
    catch (Exception e){};


    }

}
