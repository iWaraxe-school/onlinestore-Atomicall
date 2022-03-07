package by.issoft.store;
import by.issoft.domain.Category;
import by.issoft.domain.Product;
import com.github.javafaker.Faker;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class RandomStorePopulator {
    static Faker faker = new Faker(Locale.ENGLISH);

    public RandomStorePopulator() {
        System.out.println("Rand store populator created");
    }
    public static void populateCategory(Category c){
        int maxRandVal = 10;
        int minRandVal = 3;
        NumberFormat nf = NumberFormat.getInstance();
        int randomAmountOfProducts = (int)Math.floor(Math.random()*(maxRandVal-minRandVal+1)+minRandVal);
        Product p;
        List<Product> productList = c.getProductList();
        for (int i = 0; i < randomAmountOfProducts; i++){
            //p= new Product(c.getCategoryName() + "_" + faker.commerce().productName()+"_" +i);
            p= new Product(String.valueOf(i));
            try {
                //p.setPrice(nf.parse(faker.commerce().price(1, 100)).floatValue());
               p.setPrice((float) 2*i);
            }
            catch (Exception e){};
            p.setRate((float)faker.number().randomDouble(2, 0, 5));
            //p.setRate((float)(2.43));
            productList.add(p);
        }
    }
    //Faker
}
