package by.issoft.XML_And_Sorting_Service.Comparators;

import by.issoft.domain.Product;

import java.util.Comparator;

public class NameComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

