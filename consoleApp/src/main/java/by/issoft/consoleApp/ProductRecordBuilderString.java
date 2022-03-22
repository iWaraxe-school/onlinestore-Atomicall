package by.issoft.consoleApp;

public class ProductRecordBuilderString implements ProductRecordBuilder{

    private String name;
    private float rate;
    private float price;

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
        ProductRecord stringRecord = new ProductRecordString();






        return  stringRecord;
    }
}
