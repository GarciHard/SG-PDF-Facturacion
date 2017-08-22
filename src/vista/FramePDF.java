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
public class FramePDF extends javax.swing.JFrame {

    private JFileChooser fchBuscarFactura;
    private File[] arx = null;
    int arxSize = 0;
    private File f = null;
    
    private static String URL = "";
    static String consecutivos = "";
    static String vendor = "";
    static String factura = "";
    static String compania = "";
    static String codigoQr ="";
    
    /****diseno*****/
    private static final int qr_image_width = 40;
    private static final int qr_image_height = 40;
    private static final String IMAGE_FORMAT = "png";
    
    
    /** Creates new form FramePDF */
    public FramePDF() {
        initComponents();
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
        mniEdicionManual = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlBackground.setLayout(new java.awt.BorderLayout());

        pnlBotonesArx.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 0, 18))); // NOI18N

        btnBuscarFactura.setText("Buscar Factura (s)");
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

        mnuEdicion.setText("Edición");

        mniEdicionManual.setText("Modificar Factura Manual");
        mniEdicionManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEdicionManualActionPerformed(evt);
            }
        });
        mnuEdicion.add(mniEdicionManual);

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
        System.err.println(arx);
        if (arx != null){
            try {
                cargaArchivos();
            } catch (IOException | DocumentException | WriterException | InterruptedException ex) {
                Logger.getLogger(FramePDF.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay Archivos ");
        }        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void mniEdicionManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEdicionManualActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_mniEdicionManualActionPerformed

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
        int hoja[] = new int[100];
        int ultPag = 0;
        boolean permiso = false;
        int vcons;
        BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        
        consecutivos = "000000";
        
        for (int i = 0; i < arxSize; i++){ //para los archivos\
            PdfReader reader = new PdfReader(arx[i].getPath());
                                  
            /******************* Corte de nombre PDF ***********************/
            String nombres = arx[i].getName();
            String[] arrayNombres = nombres.split("_");

            // En este momento tenemos un array en el que cada elemento es un color.
            for (int n = 0; n < arrayNombres.length; n++) {
                if (n == 0 ){
                    vendor = arrayNombres[n];
                }else if (n == 1){
                    factura = arrayNombres[n];
                }else if(n == 2){
                    compania = arrayNombres[n];
                }
            }
            /**************************************************************/
            PdfStamper stamper = new PdfStamper(reader, new  FileOutputStream("C:\\temp\\"+arx[i].getName())) ;
            //for (int pag = 0; pag <= reader.getNumberOfPages(); pag++) { //para las hojas
                /*hoja[pag] = pag;
                if (hoja[pag] > ultPag) {
                    ultPag = hoja[pag];
                }*/
            //}
                                    
            for (int pag = 0; pag <= reader.getNumberOfPages(); pag++) {
                if (pag == 1){                 
                    codigoQr = compania+"-"+consecutivos;
                    generaQr();
                    PdfContentByte over = stamper.getOverContent(pag);
                    
                    //Imprime Rectangulo
                    over.setColorStroke(BaseColor.BLACK);
                    over.setColorFill(BaseColor.WHITE);
                    over.rectangle(538,5,70,45);
                    over.fill();
                    over.stroke();
                    
                    //Abre Qr
                    java.awt.Image awtImage = Toolkit.getDefaultToolkit().createImage("C:\\temp\\codigoQR.png");
                    Image image = Image.getInstance(awtImage, null);
                    image.setAbsolutePosition(551, 8);
                    over.addImage(image);
                    
                    //imprime Texto
                    over.beginText();
                    over.setColorFill(BaseColor.BLACK);
                    over.setFontAndSize(bf, 7);    // set font and size
                    over.setTextMatrix(540, 5);   // set x,y position (0,0 is at the bottom left)
                    over.showText(codigoQr);  // set text
                    over.endText();
                }
            }
            vcons = Integer.parseInt(consecutivos);
            consecutivos =  String.valueOf(vcons+1);
            if(consecutivos.length() < 6){
                if (consecutivos.length() == 1){
                    consecutivos = "00000"+consecutivos;
                }else if (consecutivos.length() == 2){
                    consecutivos = "0000"+consecutivos;
                }else if (consecutivos.length() == 3){
                    consecutivos = "000"+consecutivos;
                }else if (consecutivos.length() == 4){
                    consecutivos = "00"+consecutivos;
                }else if (consecutivos.length() == 5){
                    consecutivos = "0"+consecutivos;
                }
            }
            stamper.close();
            // Aqui vamos a insertar en la Base de Dato 
            
            
            ////////////////////////////////////
            //System.err.println("a: "+i+"u: "+ultPag);
            ultPag = 0;    
        }
    }

    public static void generaQr() throws WriterException, FileNotFoundException, IOException{        
        String data = codigoQr;
 
        // Codifica los datos para el QR
        BitMatrix matrix;
        QRCodeWriter writer = new QRCodeWriter();
        matrix = writer.encode(data, BarcodeFormat.QR_CODE, qr_image_width, qr_image_height);
 
        // Create buffered image to draw to
        BufferedImage image = new BufferedImage(qr_image_width,qr_image_height, BufferedImage.TYPE_INT_RGB);
 
        // Iterate through the matrix and draw the pixels to the image
        for (int y = 0; y < qr_image_height; y++) {
            for (int x = 0; x < qr_image_width; x++) {
                int grayValue = (matrix.get(x, y) ? 0 : 1) & 0xff;
                image.setRGB(x, y, (grayValue == 0 ? 0 : 0xFFFFFF));
            }
        }
        String IMG_PATH = "c:/temp/codigoQR.png";
        // Write the image to a file
        FileOutputStream qrCode = new FileOutputStream(IMG_PATH);
        ImageIO.write(image, IMAGE_FORMAT, qrCode);
        qrCode.close();
    }
    
    public static void cargarDatos(){
        Object[] regDatos = new Object[5];
        
        regDatos[0] = vendor; 
        //regDatos[1] = 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarFactura;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblIndicadorArx;
    private javax.swing.JMenuItem mniEdicionManual;
    private javax.swing.JMenuBar mnuBarra;
    private javax.swing.JMenu mnuEdicion;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlBotonesArx;
    private javax.swing.JPanel pnlEdicionArx;
    private javax.swing.JPanel pnlIndicadorArx;
    // End of variables declaration//GEN-END:variables

}