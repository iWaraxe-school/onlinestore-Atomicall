package by.issoft.XML_And_Sorting_Service.Comparators;

import by.issoft.XML_And_Sorting_Service.Enums.FieldTypes;
import by.issoft.XML_And_Sorting_Service.Enums.SortingTypes;
import by.issoft.domain.Product;

import java.util.Comparator;

public class DescComparatorCreator extends ComparatorCreator{

    @Override
    public Comparator<Product> getComparatorFor(FieldTypes fieldType, SortingTypes sortingOrder) {
        Comparator<Product> c;
        switch (fieldType) {
            case NAME: {
                c =  new NameComparator().reversed(); break;
            }
            case PRICE: {
                c =  new PriceComparator().reversed(); break;
            }
            case RATE: {
                c = new RateComparator().reversed(); break;
            }
            default :{ c = new NameComparator().reversed(); break;}
        }
        return c;
    }
}
