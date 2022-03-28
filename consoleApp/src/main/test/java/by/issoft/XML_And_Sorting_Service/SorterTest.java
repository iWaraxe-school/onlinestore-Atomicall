package by.issoft.XML_And_Sorting_Service;

import by.issoft.XML_And_Sorting_Service.Enums.FieldTypes;
import by.issoft.XML_And_Sorting_Service.Enums.SortingTypes;
import by.issoft.domain.Product;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SorterTest {

    @Test
    void mainSort() {
        List<Product> list1 = new ArrayList<>();
        list1.add(new Product("A", 100, 1));
        list1.add(new Product("A", 90, 1));
        list1.add(new Product("A", 90, 2));
        list1.add(new Product("D", 100, 1));
        list1.add(new Product("E", 100, 1));

        var list2 = new ArrayList<>(list1);

        assertEquals(
                Sorter.mainSort(list1, Map.of(FieldTypes.NAME, SortingTypes.ASC,
                FieldTypes.RATE, SortingTypes.DESC,
                FieldTypes.PRICE, SortingTypes.ASC)),
                list2);
        assertNotEquals(Sorter.mainSort(list1, Map.of(FieldTypes.NAME, SortingTypes.DESC,
                FieldTypes.RATE, SortingTypes.DESC,
                FieldTypes.PRICE, SortingTypes.ASC)),
                list2);
        assertNotEquals(Sorter.mainSort(list1, Map.of(FieldTypes.NAME, SortingTypes.ASC,
                FieldTypes.RATE, SortingTypes.ASC,
                FieldTypes.PRICE, SortingTypes.ASC)),
                list2);
        assertNotEquals(Sorter.mainSort(list1, Map.of(FieldTypes.NAME, SortingTypes.ASC,
                FieldTypes.RATE, SortingTypes.DESC,
                FieldTypes.PRICE, SortingTypes.DESC)),
                list2);


    }

    @Test
    void mainSortStream() {
        List<Product> list1 = new ArrayList<>();
        list1.add(new Product("A", 100, 1));
        list1.add(new Product("A", 90, 1));
        list1.add(new Product("A", 90, 2));
        list1.add(new Product("D", 100, 1));
        list1.add(new Product("E", 100, 1));

        var list2 = new ArrayList<>(list1);

        assertEquals(
                Sorter.mainSortStream(list1, Map.of(FieldTypes.NAME, SortingTypes.ASC,
                        FieldTypes.RATE, SortingTypes.DESC,
                        FieldTypes.PRICE, SortingTypes.ASC)),
                list2);
        assertNotEquals(Sorter.mainSortStream(list1, Map.of(FieldTypes.NAME, SortingTypes.DESC,
                FieldTypes.RATE, SortingTypes.DESC,
                FieldTypes.PRICE, SortingTypes.ASC)),
                list2);
        assertNotEquals(Sorter.mainSortStream(list1, Map.of(FieldTypes.NAME, SortingTypes.ASC,
                FieldTypes.RATE, SortingTypes.ASC,
                FieldTypes.PRICE, SortingTypes.ASC)),
                list2);
        assertNotEquals(Sorter.mainSortStream(list1, Map.of(FieldTypes.NAME, SortingTypes.ASC,
                FieldTypes.RATE, SortingTypes.DESC,
                FieldTypes.PRICE, SortingTypes.DESC)),
                list2);
    }
}