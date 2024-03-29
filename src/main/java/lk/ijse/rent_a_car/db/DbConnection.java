package lk.ijse.rent_a_car.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static DbConnection dbConnection;
    private static Connection connection;

    private DbConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_hire", "root", "123456");
    };

    public static DbConnection getInstance() throws SQLException {
        return (dbConnection==null)? dbConnection= new DbConnection() : dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }
}
