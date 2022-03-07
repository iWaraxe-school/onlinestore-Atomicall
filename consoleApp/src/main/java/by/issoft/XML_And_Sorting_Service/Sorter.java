package by.issoft.XML_And_Sorting_Service;

import by.issoft.XML_And_Sorting_Service.Comparators.PriceComparator;
import by.issoft.XML_And_Sorting_Service.Enums.FieldTypes;
import by.issoft.XML_And_Sorting_Service.Enums.SortingTypes;
import by.issoft.domain.Category;
import by.issoft.domain.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Sorter {
    public static void mainSort(ArrayList<Product> list, Map<FieldTypes, SortingTypes> sortingOrders){

        ArrayList<Product> toSortList = (ArrayList<Product>) List.copyOf(list);
        Map<FieldTypes, SortingTypes> orders_of_sorting = Map.copyOf(sortingOrders);


    }

    public static /*ArrayList<Product>*/ void sortByPrice(ArrayList<Product> products){ // Модифицирует входной лист
        /*ArrayList<Product> sorted = (ArrayList<Product>) products.stream().sorted(new PriceComparator()).collect(Collectors.toList());
        Collections.reverse(sorted); // как сделать лучше, чтобы не тратить время на реверс?*/
// как сделать лучше, чтобы не тратить время на реверс?
        Collections.sort(products, new PriceComparator());
        Collections.reverse(products);

        //return sorted;
    }

    public static ArrayList<Product> sortByPrice(List<Category> categoryList) { // Не модифицирует входной лист
        ArrayList<Product> finalList = new ArrayList<>();
        for (Category c : categoryList){
            finalList.addAll(c.getProductList());
        }
        sortByPrice(finalList);
        return finalList;
    }

}
