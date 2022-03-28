package by.issoft.XML_And_Sorting_Service.Comparators;

import by.issoft.XML_And_Sorting_Service.Enums.FieldTypes;
import by.issoft.XML_And_Sorting_Service.Enums.SortingTypes;
import by.issoft.domain.Product;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class DescComparatorCreatorTest {
    DescComparatorCreator comparatorCreator = new DescComparatorCreator();
    @Test
    void getComparatorFor() {
        Comparator<Product> comparator = new NameComparator().reversed();
        Assert.assertEquals(comparatorCreator.getComparatorFor(FieldTypes.NAME, SortingTypes.DESC).getClass(),
                comparator.getClass());
        comparator = new RateComparator().reversed();
        Assert.assertEquals(comparatorCreator.getComparatorFor(FieldTypes.RATE, SortingTypes.DESC).getClass(),
                comparator.getClass());
        comparator = new PriceComparator().reversed();
        Assert.assertEquals(comparatorCreator.getComparatorFor(FieldTypes.PRICE, SortingTypes.DESC).getClass(),
                comparator.getClass());

    }
}