package by.issoft.XML_And_Sorting_Service;

import by.issoft.XML_And_Sorting_Service.Comparators.ComparatorCreator;
import by.issoft.XML_And_Sorting_Service.Comparators.NameComparator;
import by.issoft.XML_And_Sorting_Service.Comparators.ProductComparator;
import by.issoft.XML_And_Sorting_Service.Enums.FieldTypes;
import by.issoft.XML_And_Sorting_Service.Enums.SortingTypes;
import by.issoft.domain.Category;
import by.issoft.domain.Product;

import java.util.*;

public class Sorter {
    public static List<Product> mainSort(List<Product> list, Map<FieldTypes, SortingTypes> sortingOrders){
        Comparator<Product> comparator;
        Map.Entry<FieldTypes, SortingTypes> mapPair;
        var sortingOrdersElements = sortingOrders.entrySet();
        var iterator = sortingOrdersElements.iterator();

        try {
            mapPair = iterator.next();
        }
        catch (NoSuchElementException e){
            return new ArrayList<>();
        }
        comparator = ProductComparator.getComparatorFor(mapPair.getKey(), mapPair.getValue()); // get Comparator for first pair

        while (iterator.hasNext()) {
           mapPair = iterator.next();
           Comparator<Product> tmp = ProductComparator.getComparatorFor(mapPair.getKey(), mapPair.getValue()); // Comparators for others
           comparator = comparator.thenComparing(tmp);
        }
        List<Product> finalList = new ArrayList<>(list);
        finalList.sort(comparator);
        return finalList;
    }

    public static List<Product> mainSortStream(List<Product> list, Map<FieldTypes, SortingTypes> sortingOrders) {
        List<Product> finalList = new ArrayList<>(list);
        // как, если: BinaryOperator принимает (x, y) и возвращает результатом действие с ними
        // но Compststor::thenComparing принимает только (другой компаратор)
        Comparator<Product> productComparator = sortingOrders.entrySet().stream()
                .map(entry -> ProductComparator.getComparatorFor(entry.getKey(), entry.getValue()))
                .reduce(Comparator<Product>::thenComparing)
                .orElse(new NameComparator());
        finalList.sort(productComparator);
        return finalList;
    }
}
