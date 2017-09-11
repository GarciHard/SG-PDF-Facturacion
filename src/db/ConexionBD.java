package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class ConexionBD {
    
    protected Connection conexion;

    public Connection getConexion() {
        return conexion;
    }
    
    private final String driverJDBC = "net.ucanaccess.jdbc.UcanaccessDriver";   
    //URL PRUEBA PRR1TL
    private final String urlDB = "jdbc:ucanaccess://" + "I:/Dept/MOE1/Shared/Informacion_general/proyectos  SG/Proyecto Factura/DB/dbFacturas.accdb";
    
    public void conectar() throws Exception {
        try {
            conexion = DriverManager.getConnection(urlDB);
            Class.forName(driverJDBC);
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
