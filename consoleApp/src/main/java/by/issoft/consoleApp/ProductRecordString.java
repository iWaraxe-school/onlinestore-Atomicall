package by.issoft.consoleApp;

import by.issoft.domain.Product;

public class ProductRecordString implements ProductRecord{
    private String recordString = "";

    private StringBuilder stringBuilder = new StringBuilder();

    public ProductRecordString() {

    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }




    public static String buildProductString(Product p){
        StringBuilder str = new StringBuilder();
        str.append("\t");
        str.append(String.format("%-50s",p.getName())).append("|");
        str.append(String.format("%10s",p.getPrice())).append("|");
        str.append((String.format("%10s",p.getRate()))).append("|");
        return str.toString();
    }
    public static String buildProductString(Product p, StringBuilder str){
        str.append(buildProductString(p));
        return str.toString();
    }

}
