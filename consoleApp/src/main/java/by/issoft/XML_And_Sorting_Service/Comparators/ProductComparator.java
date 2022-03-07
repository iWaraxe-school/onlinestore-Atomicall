package by.issoft.XML_And_Sorting_Service.Comparators;

import by.issoft.XML_And_Sorting_Service.Enums.FieldTypes;
import by.issoft.XML_And_Sorting_Service.Enums.SortingTypes;
import by.issoft.domain.Product;

import java.util.Comparator;

public class ProductComparator {
    public static Comparator<Product> getComparatorFor(FieldTypes fieldType, SortingTypes sortingOrder){
        Comparator<Product> c;
        switch (fieldType) {
            case NAME: {
                c =  (sortingOrder==SortingTypes.ASC)? new NameAscComparator() : new NameDescComparator() ; break;
            }
            case PRICE: {
                c =  (sortingOrder==SortingTypes.ASC)? new PriceAscComparator() : new PriceDescComparator() ; break;
            }
            case RATE: {
                c =  (sortingOrder==SortingTypes.ASC)? new RateAscComparator() : new RateDescComparator() ; break;
            }
            default :{ c = new NameAscComparator(); break;}
        }
        return c;
    }
}
