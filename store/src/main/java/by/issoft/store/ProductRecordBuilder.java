package by.issoft.store;

public interface ProductRecordBuilder {
    public ProductRecordBuilder setProductNameField (String name);
    public ProductRecordBuilder setProductRateField(float rate);
    public ProductRecordBuilder setProductPriceField(float price);
    // Record на будущее, чтобы
    // Можно было бы использовать данный метод для конструирования
    // записи при добавлении в базу данных и для конструирования строки
    public ProductRecord build();

}
