package by.issoft.XML_And_Sorting_Service.Comparators;

import by.issoft.domain.Product;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Float.compare(o1.getPrice(), o2.getPrice());
    }
}
