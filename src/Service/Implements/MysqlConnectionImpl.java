package Service.Implements;

import Service.Service.MysqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnectionImpl implements MysqlConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/BookStore";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "abc@123";
    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
