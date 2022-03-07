package by.issoft.XML_And_Sorting_Service.Comparators;

import by.issoft.domain.Product;

import java.util.Comparator;

class RateAscComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Float.compare(o1.getRate(), o2.getRate());
    }
}

class RateDescComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Float.compare(o2.getRate(), o1.getRate());
    }
}