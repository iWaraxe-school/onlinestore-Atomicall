package by.issoft.XML_And_Sorting_Service.Comparators;

import by.issoft.domain.Product;

import java.util.Comparator;

public class RateComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Float.compare(o1.getRate(), o2.getRate());
    }
}
