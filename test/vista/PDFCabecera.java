package vista;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class PDFCabecera extends javax.swing.JFrame {

    private JFileChooser fchBuscarFactura;
    private File[] arx = null;
    int arxSize = 0;
    private File f = null;
    
    private static String URL = "";
    String userHome = "user.home";
    String path = System.getProperty(userHome);
    File folder = new File (path+"//Documents/Archivos Modificados");
    
    int cont = 0; 
    
    /** Creates new form FramePDF */
    public PDFCabecera() {
        initComponents();
        if (!folder.exists()) {
            folder.mkdirs();            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        pnlBotonesArx = new javax.swing.JPanel();
        btnBuscarFactura = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        pnlEdicionArx = new javax.swing.JPanel();
        pnlIndicadorArx = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lblIndicadorArx = new javax.swing.JLabel();
        mnuBarra = new javax.swing.JMenuBar();
        mnuEdicion = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlBackground.setLayout(new java.awt.BorderLayout());

        pnlBotonesArx.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 0, 18))); // NOI18N

        btnBuscarFactura.setText("Buscar");
        btnBuscarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFacturaActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonesArxLayout = new javax.swing.GroupLayout(pnlBotonesArx);
        pnlBotonesArx.setLayout(pnlBotonesArxLayout);
        pnlBotonesArxLayout.setHorizontalGroup(
            pnlBotonesArxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesArxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBuscarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 338, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBotonesArxLayout.setVerticalGroup(
            pnlBotonesArxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesArxLayout.createSequentialGroup()
                .addGroup(pnlBotonesArxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pnlBackground.add(pnlBotonesArx, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout pnlEdicionArxLayout = new javax.swing.GroupLayout(pnlEdicionArx);
        pnlEdicionArx.setLayout(pnlEdicionArxLayout);
        pnlEdicionArxLayout.setHorizontalGroup(
            pnlEdicionArxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        pnlEdicionArxLayout.setVerticalGroup(
            pnlEdicionArxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlBackground.add(pnlEdicionArx, java.awt.BorderLayout.CENTER);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        lblIndicadorArx.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblIndicadorArx.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout pnlIndicadorArxLayout = new javax.swing.GroupLayout(pnlIndicadorArx);
        pnlIndicadorArx.setLayout(pnlIndicadorArxLayout);
        pnlIndicadorArxLayout.setHorizontalGroup(
            pnlIndicadorArxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIndicadorArxLayout.createSequentialGroup()
                .addContainerGap(185, Short.MAX_VALUE)
                .addComponent(lblIndicadorArx, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnlIndicadorArxLayout.setVerticalGroup(
            pnlIndicadorArxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIndicadorArxLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIndicadorArx, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        pnlBackground.add(pnlIndicadorArx, java.awt.BorderLayout.PAGE_END);

        mnuBarra.add(mnuEdicion);

        setJMenuBar(mnuBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFacturaActionPerformed
        abrirJFileChooser(this);
    }//GEN-LAST:event_btnBuscarFacturaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (arx != null){
            try {
                cargaArchivos();
                if (cont == arxSize){
                    JOptionPane.showMessageDialog(this, "Archivos modificados correctamente\nSe encuentran en: Documents>Archivos Modificados");
                }
            } catch (IOException | DocumentException | WriterException | InterruptedException ex) {
                if (cont == 0){
                    JOptionPane.showMessageDialog(this, "No se pudieron hacer modificaciones en los archivos \nLOS ARCHIVOS A MODIFICAR ESTAN EN USO ACTUALMENTE","Aviso", JOptionPane.ERROR_MESSAGE,null);
                }
                if (cont != 0 ){
                    JOptionPane.showMessageDialog(this, "Se modificaron los ("+cont+") primeros archivos \n\tLOS ARCHIVOS A MODIFICAR ESTAN EN USO ACTUALMENTE","Aviso", JOptionPane.ERROR_MESSAGE,null);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay Archivos ");
        }   
        cont = 0;
        btnGuardar.setEnabled(false);
        lblIndicadorArx.setText("");        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void abrirJFileChooser(Component parent) {
        fchBuscarFactura = new JFileChooser();
        fchBuscarFactura.setDialogTitle("Buscar Facturas");
        fchBuscarFactura.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fchBuscarFactura.setMultiSelectionEnabled(true);        
        fchBuscarFactura.addChoosableFileFilter(new FileNameExtensionFilter("Factura Formato PDF", "pdf","PDF"));        
        fchBuscarFactura.setAcceptAllFileFilterUsed(false);
        
        if (fchBuscarFactura.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
            arx = fchBuscarFactura.getSelectedFile().listFiles((File pathname) -> pathname.toString().endsWith(".pdf") || pathname.toString().endsWith(".PDF"));
            if (arx != null) {
                arxSize = arx.length;
                if (arxSize > 0) {
                    lblIndicadorArx.setText("Numero de archivos seleccionados: " + arxSize);
                } else {
                    lblIndicadorArx.setText("No se encontraron archivos con la extensión adecuada");
                }
            } else {
                lblIndicadorArx.setText("La carpeta esta vacía. Código de error: ICO-NPE");
            }
        } else {
            lblIndicadorArx.setText("Debe seleccionar una carpeta");
        }
    }
    
    public void cargaArchivos () throws BadElementException, IOException, DocumentException, WriterException, InterruptedException{

        BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        
        for (int i = 0; i < arxSize; i++){ //para los archivos
            PdfReader reader = new PdfReader(arx[i].getPath());            
            PdfStamper stamper = new PdfStamper(reader, new  FileOutputStream(folder+"/"+arx[i].getName())) ;
            
            for (int pag = 0; pag <= reader.getNumberOfPages(); pag++) {
                if (pag == 1){                 
                    PdfContentByte over = stamper.getOverContent(pag);
                    
                    //Imprime Rectangulo
                    over.setColorStroke(BaseColor.WHITE);
                    over.setColorFill(BaseColor.WHITE);
                    over.rectangle(461,560,225,55); //CABECERA
                    over.rectangle(30,459,63,130); //SAT
                    over.rectangle(193,459,75,6); // CLIENTE
                    over.fill();
                    over.stroke();
                    
                    //imprime Texto
                    over.beginText();
                    over.setColorFill(BaseColor.BLACK);
                    over.setFontAndSize(bf, (float) 8.5); 
                    over.setTextMatrix(462, 595);  
                    over.showText("Robert Bosch Starter Motors Generat S. DE R.L. DE C.V.");  // CABECERA
                    over.setTextMatrix(462, 595); 
                    over.showText("Robert Bosch Starter Motors Generat S. DE R.L. DE C.V.");  // CABECERA
                    over.setTextMatrix(462, 595); 
                    over.showText("Robert Bosch Starter Motors Generat S. DE R.L. DE C.V.");  // CABECERA
                    over.setTextMatrix(462, 595);  
                    over.showText("Robert Bosch Starter Motors Generat S. DE R.L. DE C.V.");  // CABECERA
                    over.setTextMatrix(540, 580);  
                    over.showText("RBS1604215S1");
                    over.setTextMatrix(540, 580);  
                    over.showText("RBS1604215S1");
                    over.setTextMatrix(540, 580);  
                    over.showText("RBS1604215S1");
                    over.setTextMatrix(540, 580);  
                    over.showText("RBS1604215S1");
                    over.setFontAndSize(bf, 7); 
                    over.setTextMatrix(520, 540);  
                    over.showText("5");  // DIRECCION
                    over.setTextMatrix(520, 540);  
                    over.showText("5");  // DIRECCION
                    over.setFontAndSize(bf, 6); 
                    over.setTextMatrix(194, (float) 459.7);  
                    over.showText("RBS1604215S1");  // CLIENTE
                    over.setTextMatrix(194, (float) 459.7);
                    over.showText("RBS1604215S1");  // CLIENTE
                    over.setTextMatrix(194, (float) 459.7);
                    over.showText("RBS1604215S1");  // CLIENTE
                    over.setTextMatrix(194, (float) 459.7);
                    over.showText("RBS1604215S1");  // CLIENTE
                    over.endText();
                }
            }
            cont += 1;
            stamper.close(); 
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarFactura;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblIndicadorArx;
    private javax.swing.JMenuBar mnuBarra;
    private javax.swing.JMenu mnuEdicion;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlBotonesArx;
    private javax.swing.JPanel pnlEdicionArx;
    private javax.swing.JPanel pnlIndicadorArx;
    // End of variables declaration//GEN-END:variables

}