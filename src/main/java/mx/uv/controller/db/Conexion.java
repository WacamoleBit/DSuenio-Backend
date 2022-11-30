package mx.uv.controller.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String url = "jdbc:mysql://127.0.0.1:3306/dsuenio";
    private static String driverName = "com.mysql.cj.jdbc.Driver"; // com.mysql.cj.jdbc.Driver
    private static String username = "dsadmin";
    private static String password = "dsadmin_PW";
    //crear la cuenta de usuario y darle persmisos en la base de datos
    // variable de conexion
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
