/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author PRR1TL
 */
public class RegistrosDAOImpl extends ConexionBD implements RegistrosDAO{
    private PreparedStatement ps;
    private ResultSet rs;

    private final String REGISTRO = "INSERT INTO registros (Vendor, Factura, Compania, consecutivo) VALUES (?,?,?,?)";
    private final String CONSULTA_EXISTENCIA_DOC = "SELECT vendor, factura, compania FROM registros WHERE vendor LIKE ? AND factura LIKE ? AND compania LIKE ?";
    private final String CONSULTA_CONSECUTIVO = "SELECT Max(consecutivo)FROM registros WHERE compania LIKE ? AND factura LIKE ? ";
    //private final String CONSULTA_CONSECUTIVO = " SELECT Max(consecutivo) AS Expr1 FROM registros WHERE (((registros.[compania]) LIKE ? ) AND ((registros.[factura]) LIKE ? ))";
    @Override
    public void registroFactura(Object[] factura) throws Exception {        
        try {
            this.conectar();
            
            ps = this.conexion.prepareStatement(REGISTRO);

            ps.setString(1, factura[0].toString());
            ps.setString(2, factura[1].toString());
            ps.setString(3, factura[2].toString());
            ps.setString(4, factura[3].toString());

            ps.executeUpdate();        
            
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            this.cerrar();
        }
    }

    @Override
    public int validaArchivoExistente (String vendor, String factura, String compania) throws Exception {
        int bn = 0;
        try {   
            this.conectar();
            
            ps = this.conexion.prepareStatement(CONSULTA_EXISTENCIA_DOC );
            ps.setString(1, vendor);
            ps.setString(2, factura);
            ps.setString(3, compania);
            
            rs = ps.executeQuery();      
            while (rs.next()){  
                bn = 1;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return bn;
    }

    @Override
    public String consultaUltimoConsecutivo(String compania, String factura) throws Exception {
        String consecutivo = "";
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(CONSULTA_CONSECUTIVO);
            ps.setString(1, compania);
            ps.setString(2, factura);
            rs = ps.executeQuery();
            if (rs.next()){
                consecutivo = rs.getString(1);
            }else {
                consecutivo = null;
            } 
        } catch (Exception e) {
            throw e;
        }
        return consecutivo;
    }
}
