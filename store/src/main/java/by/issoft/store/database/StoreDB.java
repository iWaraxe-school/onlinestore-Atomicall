package by.issoft.store.database;


import by.issoft.store.database.repository.BikeCategoryDB;
import by.issoft.store.database.repository.MilkCategoryDB;
import by.issoft.store.database.repository.PhoneCategoryDB;

import java.sql.*;

public class StoreDB {
    private static final String DB_URL = "jdbc:h2:file:./db/mainDB";
    private static final String DB_Driver = "org.h2.Driver";
    private static StoreDB storeDB = null;
    private BikeCategoryDB bikeCategoryDB;
    private MilkCategoryDB milkCategoryDB;
    private PhoneCategoryDB phoneCategoryDB;

    private StoreDB () {
        try {
            Class.forName(DB_Driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void initTables()
    {
        try {
            bikeCategoryDB = new BikeCategoryDB();
            milkCategoryDB = new MilkCategoryDB();
            phoneCategoryDB = new PhoneCategoryDB();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void createCategoryTables(){
        bikeCategoryDB.createTable();
        milkCategoryDB.createTable();
        phoneCategoryDB.createTable();
    }

    public BikeCategoryDB getBikeCategoryDB() {
        return bikeCategoryDB;
    }

    public MilkCategoryDB getMilkCategoryDB() {
        return milkCategoryDB;
    }

    public PhoneCategoryDB getPhoneCategoryDB() {
        return phoneCategoryDB;
    }

    public static StoreDB getStoreDB(){
        if (null == storeDB){
            storeDB = new StoreDB();
        }
        return storeDB;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }



}
