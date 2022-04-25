package by.issoft.domain;

public class Product {

    private long id;
    private String name;
    private float rate;
    private float price;

    //del
    public Product(String name, float rate, float price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }

    public Product(long id, String name, float rate, float price) {
        this.id = id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}
