package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */

public class ConexionBD {
    
    Connection conexion = null;
    String dbName = "DB_Barcode_SQL";
    String serverip = "SGLERSQL01";
    String serverport = "1433";
    String userName = "BCAdmin";
    String password = "m1ImrgaaXBwRlj7g";

    String url = "jdbc:sqlserver://"+serverip+"\\SQLEXPRESS:"+serverport+";databaseName="+dbName+";user="+userName+";password="+password+";";
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        
    public void conectar() throws Exception {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);   
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }
    
    public void cerrar() throws Exception {
        try {
            if (conexion != null) {
                if (!conexion.isClosed()) {
                    conexion.close();
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }      
}
