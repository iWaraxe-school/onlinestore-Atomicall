package by.issoft.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public class Product implements Serializable {

    private long id;
    private String name;
    private float rate;
    private float price;

    @JsonCreator
    public Product(@JsonProperty("id") long id,
                   @JsonProperty("name") String name,
                   @JsonProperty("rate") float rate,
                   @JsonProperty("price") float price) {
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
