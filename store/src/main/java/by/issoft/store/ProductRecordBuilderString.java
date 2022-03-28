package by.issoft.store;

import by.issoft.domain.Product;

public class ProductRecordBuilderString implements ProductRecordBuilder{

    private String name;
    private float rate;
    private float price;
    private boolean ready = false;

    public ProductRecordBuilderString(Product product) {
        this.name = product.getName();
        this.rate = product.getRate();
        this.price = product.getPrice();
    }

    @Override
    public ProductRecordBuilder setProductNameField(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ProductRecordBuilder setProductRateField(float rate) {
        this.rate = rate;
        return this;
    }

    @Override
    public ProductRecordBuilder setProductPriceField(float price) {
        this.price = price;
        return this;
    }

    @Override
    public ProductRecord build() {
        ProductRecordString stringRecord = new ProductRecordString();
        stringRecord.append("\t");
        stringRecord.append(String.format("%-50s",name));
        stringRecord.append("|");
        stringRecord.append(String.format("%10s",price));
        stringRecord.append("|");
        stringRecord.append((String.format("%10s",rate)));
        stringRecord.append("|");
        ready = true;
        return  stringRecord;
    }
}
