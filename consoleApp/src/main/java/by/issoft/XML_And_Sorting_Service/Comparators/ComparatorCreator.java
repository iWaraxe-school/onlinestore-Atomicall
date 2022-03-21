package by.issoft.XML_And_Sorting_Service.Comparators;

import by.issoft.XML_And_Sorting_Service.Enums.FieldTypes;
import by.issoft.XML_And_Sorting_Service.Enums.SortingTypes;
import by.issoft.domain.Product;

import java.util.Comparator;

public abstract class ComparatorCreator {
    public abstract Comparator<Product> getComparatorFor(FieldTypes fieldType, SortingTypes sortingOrder);
}
