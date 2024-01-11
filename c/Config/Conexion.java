package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/registro";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    
    private Connection con;
    
    public Connection getConnection(){
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Config.Conexion.getConnection()" + e);
            
            System.err.println("Nuevo codigo");
        }
        return con;
    }
}
