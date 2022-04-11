package by.issoft.consoleApp;
import by.issoft.XML_And_Sorting_Service.Enums.FieldTypes;
import by.issoft.XML_And_Sorting_Service.Enums.SortingTypes;
import by.issoft.XML_And_Sorting_Service.Sorter;
import by.issoft.domain.Product;
import by.issoft.store.OrderRunner;
import by.issoft.store.ProductRecordBuilderString;
import by.issoft.store.ReflectionsService;
import by.issoft.store.Store;
import by.issoft.domain.Category;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.min;


public class UserInteractService {
    public static String buildHeadString(){
        return String.format("\t%-50s|%-10s|%-10s%s", "ProductName", "Price", "Rate", "|");
    }
    public static void printProductsList( List<Product> list){
        System.out.println(buildHeadString());
        for (Product product : list) {
            ProductRecordBuilderString productStringBuilder = new ProductRecordBuilderString(product);
            System.out.println(productStringBuilder.build());
        }
    }

    private static List<Product> getListOfAllProductsFromStore(Store store){
        List<Product> productList = new ArrayList<>();
        productList.addAll(store.getCategoryList().stream()
                .map( (categoryList)->{return categoryList.getProductList();})
                .flatMap( (products) -> {return products.stream();}).collect(Collectors.toList()));
        return productList;
    }
    public static void printStore (Store s) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (s == null) return;
        ReflectionsService service = ReflectionsService.getService();
        Set<Class<? extends Category>> subCategories = service.getSubClasses(Category.class);
        int t = 0;
        for(Class<? extends Category> subCategoryClass: subCategories){
            Method method = subCategoryClass.getMethod("getCategoryName");
            StringBuilder str = new StringBuilder ("CategoryName: ");
            str.append(method.invoke(s.getCategoryList().get(t))).append("\n");
            str.append(buildHeadString()).append("\n");
            subCategoryClass.getMethod("getProductList").invoke(s.getCategoryList().get(t));
            List<Product> productList = (List<Product>) subCategoryClass
                    .getMethod("getProductList")
                    .invoke(s.getCategoryList()
                            .get(t));
            for (Product p: productList) {
                ProductRecordBuilderString productStringBuilder = new ProductRecordBuilderString(p);
                str.append(productStringBuilder.build());
                str.append("\n");
            }
            System.out.println(str.toString());
            t++;
        }
    }
    private static String getCommandsString(){
        String commands = """
                top (alias - t)- show top5 by price
                sort (alias - s)- sort according config.xml
                create order (alias - cr)
                help (alias - h) - get commands
                quit (alias - q)
                """;
        return commands;
    }

    private static void createOrder(Store store){
        List<Product> allProducts = getListOfAllProductsFromStore(store);
        int randomInt = (int)Math.floor(Math.random()* (30)+ 1);
        Thread thread = new Thread(new OrderRunner(allProducts.get(randomInt),
                randomInt,
                store.getPurchasedProducts()));
        System.out.printf("Random int %d for Product %s, curr time is %d millis \n",
                randomInt, allProducts.get(randomInt).getName(), System.currentTimeMillis());
        thread.start();
    }

    static void readUserCommands(Store store, HashMap<FieldTypes, SortingTypes> sortingOrders){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        List<Product> top5ByPrice = null;
        try {
            while (true) {
                userInput = reader.readLine();
                switch (userInput.trim()) {
                    case "top":
                    case "t":{
                        if (top5ByPrice == null){
                            var topSortingEntry = Map.entry(FieldTypes.RATE,
                                    SortingTypes.DESC);
                            top5ByPrice = Sorter.mainSort( getListOfAllProductsFromStore(store),
                                    Map.ofEntries(topSortingEntry));
                        }
                        printProductsList(top5ByPrice.subList(0, min(5, top5ByPrice.size())));
                        break;
                    }
                    case "sort":
                    case "s":{
                        printProductsList(Sorter.mainSort(getListOfAllProductsFromStore(store), sortingOrders));
                        System.out.println("__\n");
                        break;
                    }
                    case "quit":
                    case "q":{
                        System.out.println("Leaving...");
                        System.exit(0);
                        break;
                    }
                    case "h":
                    case "help":{
                        System.out.println(getCommandsString());
                        break;
                    }
                    case "create order":
                    case "cr": {
                        createOrder(store);
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
