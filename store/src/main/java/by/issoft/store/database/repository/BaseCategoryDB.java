package by.issoft.store.database.repository;

import by.issoft.domain.Product;
import by.issoft.store.database.BaseDBOperations;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//dao?
// категория - это таблица с продуктами. значит, у нее поля - как у продуктов
public class BaseCategoryDB extends BaseDBOperations {
    private final String dbName;


    public BaseCategoryDB(String dbName) throws SQLException {
        super();
        this.dbName = dbName;
    }

    public String getDbName() {
        return dbName;
    }
    protected void createTable(String tableCreateQuery ){
        try {
            executeSqlStatement(tableCreateQuery);
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Failed to execute: createTableQuery: \n" + tableCreateQuery );
        }
    }

    public boolean insertProduct(Product p){
        // а надо ли как-нибудь экранировать p.getName()?
        String sqlQuery = "INSERT INTO " + dbName+ " (product_name, product_rate, product_price) " +
                "VALUES ('" + p.getName() +"', " + p.getRate() + ", " + p.getPrice() + ")";
        try {
            int result = executeSqlUpdate(sqlQuery);
            return result == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to execute: " + sqlQuery);
        }
        return false;
    }

    public List<Product> getListOfProducts(){
        List<Product> products = new ArrayList<>();
        String sqlQuery = "SELECT * FROM " + dbName;
        try {
            ResultSet resultSet = executeSqlQuery(sqlQuery);
            while(resultSet.next()){
                Product p = new Product(
                        resultSet.getLong("id"),
                        resultSet.getString("product_name"),
                        resultSet.getFloat("product_rate"),
                        resultSet.getFloat("product_price")
                        );
                products.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to execute: " + sqlQuery);
        }
        return products;
    }


}
