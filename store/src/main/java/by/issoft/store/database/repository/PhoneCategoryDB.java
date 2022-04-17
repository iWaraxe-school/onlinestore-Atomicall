package by.issoft.store.database.repository;

import java.sql.SQLException;

public class PhoneCategoryDB extends BaseCategoryDB {
    String tableCreateQuery = """
            CREATE TABLE `phone_category_products` (
            `id` INT NOT NULL AUTO_INCREMENT,
            `product_name` VARCHAR(255) NOT NULL,
            `product_rate` FLOAT NOT NULL DEFAULT '0',
            `product_price` FLOAT NOT NULL DEFAULT '0', PRIMARY KEY (`id`)
            );""";
    public PhoneCategoryDB() throws SQLException {
        super("phone_category_products");
    }

    public void createTable(){
        super.createTable(tableCreateQuery);
    }

}
