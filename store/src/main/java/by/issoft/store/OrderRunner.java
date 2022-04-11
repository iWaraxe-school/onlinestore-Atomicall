package by.issoft.store;

import by.issoft.domain.Product;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class OrderRunner implements Runnable{

    private final Product product;
    private final int runningTime;
    private final BlockingQueue<Product> queue;


    public OrderRunner(Product product, int runningTime, BlockingQueue<Product> queue) {
        this.product = product;
        this.runningTime = runningTime;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(runningTime));
            queue.put(product);
            System.out.printf("%s slept for %d second(s) and put %s to queue\n",
                    Thread.currentThread(), runningTime, product.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
