package by.issoft.XML_And_Sorting_Service.Comparators;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import by.issoft.domain.Product;
import org.junit.runner.RunWith;
import org.mockito.runners.*;
import static org.junit.Assert.*;

class PriceComparatorTest {
    PriceComparator comparator = new PriceComparator();
    @org.junit.jupiter.api.Test
    void compare() {
        float priceLarger = 500.2F;
        float priceLesser = 12.3F;
        Product p1 = new Product("", 0, priceLarger);
        Product p2 = new Product("", 0, priceLesser);
        assertEquals(comparator.compare(p1, p2), Float.compare(priceLarger, priceLesser));
        assertEquals(comparator.compare(p2, p1), Float.compare(priceLesser, priceLarger));
        p1.setPrice(priceLesser);
        assertEquals(comparator.compare(p1, p2), Float.compare(priceLesser, priceLesser));
    }
}