package by.issoft.store;
import by.issoft.domain.Category;
import by.issoft.domain.Product;
import by.issoft.store.database.StoreDB;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class Store {
    private List<Category> categoryList = new ArrayList<>();
    private static Store store = null;
    private BlockingQueue<Product> purchasedProducts = new LinkedBlockingDeque<>();
    // для отладки выполняется с захардкоженой частотой раз в 2 секунды, а не минуты
    private int purchasedProductsQueueCleaningPeriodSeconds = 180;
    private Store () {};

    public static Store getInstance(){
        if (null == store){
            store = new Store();
        }
        return store;
    }

    public BlockingQueue<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    private void startPurchasedProductsCleaner(long msPeriod){
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(new PurchasedProductsCleaner(purchasedProducts),
                msPeriod, msPeriod, TimeUnit.MILLISECONDS);
    }
    public void init() {
        ReflectionsService reflectionsService = ReflectionsService.getService();
        for (Class<? extends Category> c: reflectionsService.getSubClasses(Category.class)){
            try {
                categoryList.add(c.getConstructor().newInstance());
            }
            catch (Exception e){};
        }
        startPurchasedProductsCleaner(TimeUnit.SECONDS.toMillis(purchasedProductsQueueCleaningPeriodSeconds));
    }

    public void populateCategories(StoreDB db){
        if (categoryList.isEmpty()) return;
        Category c = categoryList.get(0);
        c.getProductList().addAll(
                db.getPhoneCategoryDB().getListOfProducts()
        );
        c = categoryList.get(1);
        c.getProductList().addAll(
                db.getBikeCategoryDB().getListOfProducts()
        );
        c = categoryList.get(2);
        c.getProductList().addAll(
               db.getMilkCategoryDB().getListOfProducts()
        );
    }

    public void populateCategories(List<Category> categoryListFromDB){
        if (categoryListFromDB.isEmpty()) return;
        categoryList.addAll(categoryListFromDB); // ?

    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

}
