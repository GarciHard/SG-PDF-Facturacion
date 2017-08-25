/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizaPdf;

import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;

/**
 *
 * @author PRR1TL
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {			
            @Override
            public void run() {
                new LectorPdf() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };
            }
        });
    }
}
