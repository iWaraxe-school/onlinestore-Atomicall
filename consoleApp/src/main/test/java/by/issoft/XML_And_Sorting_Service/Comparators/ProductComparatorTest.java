package by.issoft.XML_And_Sorting_Service.Comparators;

import by.issoft.XML_And_Sorting_Service.Enums.FieldTypes;
import by.issoft.XML_And_Sorting_Service.Enums.SortingTypes;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import by.issoft.domain.Product;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.*;

import java.util.Comparator;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;



class ProductComparatorTest {
    @Test
    void getComparatorFor() {
        Assertions.assertEquals(ProductComparator.getComparatorFor(FieldTypes.NAME, SortingTypes.ASC).getClass(),
                NameComparator.class);
        Comparator<Product> comparator = new NameComparator().reversed();
        Assert.assertEquals(ProductComparator.getComparatorFor(FieldTypes.NAME, SortingTypes.DESC).getClass(),
               comparator.getClass());
        Assertions.assertEquals(ProductComparator.getComparatorFor(FieldTypes.RATE, SortingTypes.ASC).getClass(),
                RateComparator.class);
        comparator = new RateComparator().reversed();
        Assert.assertEquals(ProductComparator.getComparatorFor(FieldTypes.RATE, SortingTypes.DESC).getClass(),
                comparator.getClass());
        Assertions.assertEquals(ProductComparator.getComparatorFor(FieldTypes.PRICE, SortingTypes.ASC).getClass(),
                PriceComparator.class);
        comparator = new PriceComparator().reversed();
        Assert.assertEquals(ProductComparator.getComparatorFor(FieldTypes.PRICE, SortingTypes.DESC).getClass(),
                comparator.getClass());

    }
}