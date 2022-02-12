package by.issoft.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private final String name;

    public List<Product> getProductList() {
        return productList;
    }

    private List<Product> productList = new ArrayList<>(); // ?

    public Category(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
