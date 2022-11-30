package mx.uv.controller.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String url = "jdbc:mysql://127.0.0.1:3306/dsuenio";
    private String driverName = "com.mysql.cj.jdbc.Driver"; // com.mysql.cj.jdbc.Driver
    private String username = "dsadmin";
    private String password = "dsadmin_PW";
    
    private Connection connection = null;

    public Connection getConnection(){
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(" SQL:" + e);
        } catch (ClassNotFoundException e){
            System.out.println("Driver:" + e);
        }
        return connection;
    }
}
