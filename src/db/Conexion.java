/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PRR1TL
 */
public class Conexion {
     protected Connection conexion;

    public Connection getConexion() {
        return conexion;
    }
    
    private final String driverJDBC = "net.ucanaccess.jdbc.UcanaccessDriver";
    
    //URL PRUEBA GITHUB
    private final String urlDB = "jdbc:ucanaccess://" + "src/db/dbFacturas.accdb";
    
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
