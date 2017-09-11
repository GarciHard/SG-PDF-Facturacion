/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author PRR1TL
 */
public abstract class InsertsAlb  {
    
    /*static Conexion con = new Conexion();
    
    private static ResultSet rs;
    private static PreparedStatement pstm;
    private static JFrame form;
    
    
    public static void insertaPerdida(Object[] registro) throws Exception {
        String consulta = "";
        try {
            con.conectar();
            
            consulta = "INSERT INTO registros (Vendor, Factura, Consecutivos) VALUES";
            pstm = con.conexion.prepareStatement(consulta + "(?,?,?)");
            System.err.println("entra");
            pstm.setString(1, registro[0].toString());
            pstm.setString(2, registro[1].toString());
            pstm.setString(3, registro[2].toString());
            System.err.println("+2");
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(form, "Registro Guardado", "Registro Guardado", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(form, "No se pudo realizar la consulta insertaPerdida ", "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("No se pudo realizar la consulta insertaPerdida ");
        } finally{
            pstm.close();
            rs.close();
            con.cerrar();
        }
    }*/
}
