package by.issoft.XML_And_Sorting_Service.Comparators;

import by.issoft.domain.Product;

import java.util.Comparator;

class PriceAscComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Float.compare(o1.getPrice(), o2.getPrice());
    }
}

class PriceDescComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Float.compare(o2.getPrice(), o1.getPrice());
    }
}