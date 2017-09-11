/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.ArrayList;

/**
 *
 * @author PRR1TL
 */
public interface RegistrosDAO {
    //public void registrarUsuarios(UsuarioDTO usuario) throws Exception;
    public void registroFactura(Object[] registro) throws Exception;
    public int validaArchivoExistente (String vendor, String factura, String compania) throws Exception;
    public String consultaUltimoConsecutivo (String factura, String compania)throws Exception;
}
