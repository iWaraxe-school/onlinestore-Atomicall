package by.issoft.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private final String categoryName;
    private List<Product> productList = new ArrayList<>(); // LinkedList?
    public List<Product> getProductList() {
        return productList;
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getCategoryName() {
        return categoryName;
    }
}
