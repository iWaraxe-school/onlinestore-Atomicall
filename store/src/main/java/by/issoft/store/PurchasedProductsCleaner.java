package by.issoft.store;

import by.issoft.domain.Product;

import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;

public class PurchasedProductsCleaner implements Runnable {

    private final BlockingQueue<Product> purchasedProducts;

    public PurchasedProductsCleaner(BlockingQueue<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }


    @Override
    public void run() {
        if (!purchasedProducts.isEmpty()){
            System.out.println("Cleaning queue...");
            for (Product p: purchasedProducts) {
                System.out.printf("\t%s\n", p.toString());
            }
            purchasedProducts.clear();
        }
        else {
            System.out.println("purchasedProducts queue is empty");
        }


    }
}
