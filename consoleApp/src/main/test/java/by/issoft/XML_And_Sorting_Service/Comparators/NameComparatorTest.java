package by.issoft.XML_And_Sorting_Service.Comparators;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import by.issoft.domain.Product;
import org.junit.runner.RunWith;
import org.mockito.runners.*;

import static org.junit.Assert.*;

class NameComparatorTest {
    NameComparator comparator = new NameComparator();
    @org.junit.jupiter.api.Test
    void compare() {
        String nameLarger = "AAA";
        String nameLesser = "Z";
        Product p1 = new Product(nameLarger, 0, 0);
        Product p2 = new Product(nameLesser, 0, 0);
        Product p3 = new Product(nameLesser, 0, 0);
        assertEquals(comparator.compare(p1, p2), nameLarger.compareTo(nameLesser));
        assertEquals(comparator.compare(p2, p1), nameLesser.compareTo(nameLarger));
        assertEquals(comparator.compare(p3, p2), nameLarger.compareTo(nameLarger));
    }

}
