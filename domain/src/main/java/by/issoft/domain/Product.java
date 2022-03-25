package by.issoft.domain;

public class Product {
    public String name;
    public float rate;
    public float price;

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

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", price=" + price +
                '}';
    }
}
