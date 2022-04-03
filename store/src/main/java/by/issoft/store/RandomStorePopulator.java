package by.issoft.store;
import by.issoft.domain.Category;
import by.issoft.domain.Product;
import com.github.javafaker.Faker;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class RandomStorePopulator {
    private static Faker faker = new Faker(Locale.ENGLISH);
    private static final int maxRandomAmountOfProducts = 40;
    private static final int minRandomAmountOfProducts = 30;
    private static final NumberFormat nf = NumberFormat.getInstance();

    public static void populateCategory(Category c) {
        Product p;
        List<Product> productList = c.getProductList();
        int randomAmountOfProducts = (int)Math.floor(Math.random()*
                (maxRandomAmountOfProducts-minRandomAmountOfProducts+1)+minRandomAmountOfProducts);

        for (int i = 0; i < randomAmountOfProducts; i++){
            p = new Product(c.getCategoryName() + "_" + faker.commerce().productName()+"_" +i);
            try {
                p.setPrice(nf.parse(faker.commerce().price(1, 100)).floatValue());
            }
            catch (Exception e){};
            p.setRate((float)faker.number().numberBetween(1, 5));
            productList.add(p);
        }
    }
}
