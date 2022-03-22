package by.issoft.store;

public class ProductRecordString implements ProductRecord{
    private String recordString = "";
    private StringBuilder stringBuilder = null;

    public ProductRecordString() {
        stringBuilder = new StringBuilder();
    }
    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    void append(String what) {
        stringBuilder.append(what);
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
