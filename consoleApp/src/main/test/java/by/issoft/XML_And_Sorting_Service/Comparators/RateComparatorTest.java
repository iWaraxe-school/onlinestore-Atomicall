package by.issoft.XML_And_Sorting_Service.Comparators;

import by.issoft.domain.Product;
import org.junit.runner.RunWith;
import org.mockito.runners.*;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
class RateComparatorTest {

   /* Product p1 = mock(Product.class);
    Product p2 = mock(Product.class);*/
    //Product p2 = mock(Product.class);
    RateComparator comparator = new RateComparator();

    @org.junit.jupiter.api.Test
    void compare() {
      /*  when(p1.getRate()).thenReturn(10F);
        when(p2.getRate()).thenReturn(2F);*/
        float rateLarger = 10F;
        float rateLesser = 2F;
        Product p1 = new Product("", rateLarger, 0);
        Product p2 = new Product("", rateLesser, 0);
        assertEquals(comparator.compare(p1, p2), Float.compare(rateLarger, rateLesser));
        assertEquals(comparator.compare(p2, p1), Float.compare(rateLesser, rateLarger));
        p1.setRate(rateLesser);
        assertEquals(comparator.compare(p1, p2), Float.compare(rateLesser, rateLesser));
    }
}