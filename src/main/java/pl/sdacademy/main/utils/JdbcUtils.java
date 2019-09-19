package pl.sdacademy.main.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static JdbcUtils instance;
    private Connection connection;

    public static JdbcUtils instance() {
        if(instance == null){
            instance = new JdbcUtils();
        }
        return instance;
    }

    private JdbcUtils() {
        String connectionString = "jdbc:mysql://localhost:3306/runs";

        Properties prop = new Properties();
        prop.put("password", "1234");
        prop.put("user", "user0");
        prop.put("serverTimezone", "UTC");

        try{
            connection = DriverManager.getConnection(connectionString,prop);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
