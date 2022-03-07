package by.issoft.XML_And_Sorting_Service;

import by.issoft.XML_And_Sorting_Service.Comparators.ProductComparator;
import by.issoft.XML_And_Sorting_Service.Enums.FieldTypes;
import by.issoft.XML_And_Sorting_Service.Enums.SortingTypes;
import by.issoft.domain.Category;
import by.issoft.domain.Product;

import java.util.*;



public class Sorter {
    public static List<Product> mainSort(List<Product> list, Map<FieldTypes, SortingTypes> sortingOrders){ /////// ???????????????????

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
        comparator = ProductComparator.getComparatorFor(mapPair.getKey(), mapPair.getValue());
        while (iterator.hasNext()) {
           mapPair = iterator.next();
           Comparator<Product> tmp = ProductComparator.getComparatorFor(mapPair.getKey(), mapPair.getValue());
           comparator.thenComparing(tmp);
        }

        List<Product> finalList = new ArrayList<>(List.copyOf(list));
        finalList.sort(comparator);
        return finalList;

    }

    public static List<Product> sortProductsFromStoreBy(FieldTypes field, SortingTypes direction, List<Category> categoryList) {
        //getListOfProductsSortedBy
        ArrayList<Product> finalList = new ArrayList<>();
        for (Category c : categoryList){
            finalList.addAll(c.getProductList());
        }
        sortBy(field, direction, finalList);
        return finalList;
    }

    //sortBy(FieldTypes, SortingTypes, List<Category>)' clashes with 'sortBy(FieldTypes, SortingTypes, List<Product>)'; both methods have same erasure Проблема со стиранием типов, как решить без переименования методов?

    private static List<Product> sortBy(FieldTypes fieldType, SortingTypes sortingOrder, List<Product> list){
        Comparator<Product> c = ProductComparator.getComparatorFor(fieldType, sortingOrder);
        Collections.sort(list, c);
        /*if (sortingOrder == SortingTypes.DESC){
            // Вместо реверса можно написать еще 3 компаратора. Есть ли в этом смысл?
            Collections.reverse(list);
        }*/
        return list;
    }
}
