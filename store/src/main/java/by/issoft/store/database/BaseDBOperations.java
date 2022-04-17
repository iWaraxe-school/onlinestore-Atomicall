package by.issoft.store.database;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDBOperations implements Closeable
{
    Connection dbConnection;
    StoreDB db;

    public BaseDBOperations() throws SQLException {
        this.db = StoreDB.getStoreDB();
        this.dbConnection = db.getConnection();
    }


    private void reopenConnection() throws SQLException {
        if (dbConnection == null || dbConnection.isClosed()) {
            dbConnection = db.getConnection();
        }
    }

    @Override
    public void close() throws IOException {
        try {
            if (dbConnection != null && !dbConnection.isClosed()) {
                dbConnection.close();
            }
        } catch (SQLException e) {
            System.out.println("Failed; While: close");
        }
    }
    public ResultSet executeSqlQuery(String sql) throws SQLException {
        reopenConnection();
        Statement statement = dbConnection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        // как правильно закрыть statement ( и надо ли?)
        return result;
    };

    public int executeSqlUpdate(String sql) throws SQLException {
        reopenConnection();
        Statement statement = dbConnection.createStatement();
        int rows = statement.executeUpdate(sql);
        statement.close();
        return rows;
    };

    public boolean executeSqlStatement(String sql) throws SQLException {
        reopenConnection();
        Statement statement = dbConnection.createStatement();
        boolean result = statement.execute(sql);
        statement.close();
        return result;
    };

    public Connection getDbConnection() {
        return dbConnection;
    }

    public Statement getStatement() throws SQLException {
        return dbConnection.createStatement();
    }
}
