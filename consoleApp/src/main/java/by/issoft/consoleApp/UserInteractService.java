package by.issoft.consoleApp;
import by.issoft.domain.Product;
import by.issoft.store.ReflectionsService;
import by.issoft.store.Store;
import by.issoft.domain.Category;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    static StoreCommands readCommand(){

        return null;
    }

}
