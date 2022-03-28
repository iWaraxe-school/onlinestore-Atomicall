package by.issoft.XML_And_Sorting_Service.Comparators;

import by.issoft.XML_And_Sorting_Service.Enums.FieldTypes;
import by.issoft.XML_And_Sorting_Service.Enums.SortingTypes;
import by.issoft.domain.Product;

import java.util.Comparator;

public class ProductComparator {
    public static Comparator<Product> getComparatorFor(FieldTypes fieldType, SortingTypes sortingOrder){ //+-Fabric
        Comparator<Product> c;
        switch (fieldType) {
            case NAME: {
                c =  (sortingOrder==SortingTypes.ASC)? new NameComparator() : new NameComparator().reversed(); break;
            }
            case PRICE: {
                c =  (sortingOrder==SortingTypes.ASC)? new PriceComparator() : new PriceComparator().reversed() ; break;
            }
            case RATE: {
                c =  (sortingOrder==SortingTypes.ASC)? new RateComparator() : new RateComparator().reversed() ; break;
            }
            default :{ c = new NameComparator(); break;}
        }
        return c;
    }
}
