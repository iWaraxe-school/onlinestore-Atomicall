package by.issoft.store.database.repository;

import java.sql.SQLException;

public class BikeCategoryDB extends BaseCategoryDB{

    String tableCreateQuery = """
            CREATE TABLE `bike_category_products` (
            `id` INT NOT NULL AUTO_INCREMENT,
            `product_name` VARCHAR(255) NOT NULL,
            `product_rate` FLOAT NOT NULL DEFAULT '0',
            `product_price` FLOAT NOT NULL DEFAULT '0', PRIMARY KEY (`id`)
            );""";
    public BikeCategoryDB() throws SQLException {
        super("bike_category_products");
    }

    public void createTable(){
        super.createTable(tableCreateQuery);
    }


}
