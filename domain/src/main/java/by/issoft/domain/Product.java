package by.issoft.domain;

public class Product {
    private final String name; // не лучше ли отнаследовавть product
    // в конкретный продукт со своими критериями?
    private float rate;
    private float price;

    public Product(String name, float rate, float price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }
    public Product(String name){
        this.name = name;
    };

    public String getName() {
        return name;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
