package main;

import com.alee.laf.WebLookAndFeel;
import vista.PDFCabecera;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class FacturacionPDFMain {

    public static void main(String[] args) {
        WebLookAndFeel.install();
        new PDFCabecera().setVisible(true);
    }
}
