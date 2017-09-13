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
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import com.sun.pdfview.PagePanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.ArrayList;

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
    
    private PagePanel pnlPDF;
    private PDFFile pdffile;
    
    private static String URL = "";
    static String consecu = "" ;
    static String consecutivos = "";
    static String vendor = "";
    static String factura = "";
    static String compania = "";
    static String codigoQr ="";
    
    /****diseno*****/
    private static final int qr_image_width = 40;
    private static final int qr_image_height = 40;
    private static final String IMAGE_FORMAT = "png";
       
    private static db.RegistrosDAOImpl registro = new db.RegistrosDAOImpl();
    
    //COMPANY CODE 
    static String manufacturing = "G8D0";
    static String service = "G8F0";
    static String llc = "G9C0";
    
    //CONTADORES PARA AVISOS
    static int conEncontrados = 0;
    static int conMalEscritos = 0;
    static int conCargadosCorrectos = 0; 
    //
    private ArrayList encontrados = new ArrayList(); 
    private ArrayList malEscrito = new ArrayList();
    
    PdfStamper stamper ;
    
    /** Creates new form FramePDF */
    public FramePDF() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEdicionArx = new javax.swing.JPanel();
        pnlBackground = new javax.swing.JPanel();
        pnlBotonesArx = new javax.swing.JPanel();
        btnBuscarFactura = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        pnlIndicadorArx = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lblIndicadorArx = new javax.swing.JLabel();
        mnuBarra = new javax.swing.JMenuBar();
        mnuEdicion = new javax.swing.JMenu();
        mniEdicionCarpeta = new javax.swing.JMenuItem();
        mniEdicionArchivo = new javax.swing.JMenuItem();

        pnlEdicionArx.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Visor Factura", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 0, 18))); // NOI18N
        pnlEdicionArx.setPreferredSize(new java.awt.Dimension(700, 500));

        javax.swing.GroupLayout pnlEdicionArxLayout = new javax.swing.GroupLayout(pnlEdicionArx);
        pnlEdicionArx.setLayout(pnlEdicionArxLayout);
        pnlEdicionArxLayout.setHorizontalGroup(
            pnlEdicionArxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
        );
        pnlEdicionArxLayout.setVerticalGroup(
            pnlEdicionArxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );

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
        btnGuardar.setEnabled(false);
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

        mniEdicionCarpeta.setText("Modificar Factura Carpeta");
        mniEdicionCarpeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEdicionCarpetaActionPerformed(evt);
            }
        });
        mnuEdicion.add(mniEdicionCarpeta);

        mniEdicionArchivo.setText("Modificar Factura Archivo");
        mniEdicionArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEdicionArchivoActionPerformed(evt);
            }
        });
        mnuEdicion.add(mniEdicionArchivo);

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
        removePanelPDF();
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        abrirJFileChooser(this, JFileChooser.DIRECTORIES_ONLY);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnBuscarFacturaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            setCursor(new Cursor(Cursor.WAIT_CURSOR));
            cargaArchivos();
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            //System.out.println(arxSize+" . "+conCargadosCorrectos);
            if (arxSize == conCargadosCorrectos) {
                //System.out.println("-*1");
                JOptionPane.showMessageDialog(this, "(" + conCargadosCorrectos + ") Archivos Guardados Correctamente de (" + arxSize + ")", "Mensaje",
                        JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/img/bien.png"));
            } else {
                if (conCargadosCorrectos != 0) {
                    if (conEncontrados > 0 && conEncontrados <= 3 && conMalEscritos > 0 && conMalEscritos <= 3) {
                        //System.out.println("-*2");
                        JOptionPane.showMessageDialog(this, "(" + conCargadosCorrectos + ") Archivos Guardados Correctamente de (" + arxSize + ")"
                                + "\n\n(" + conEncontrados + ") Archivos ya han sido usados previamente" + encontrados
                                + "\n\n(" + conMalEscritos + ") Archivos estan mal escritos, favor de revisar" + malEscrito, "Mensaje",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else if ((conEncontrados != 0 && conMalEscritos == 0) || conEncontrados > 3) {
                        //System.out.println("-*3");
                        JOptionPane.showMessageDialog(this, "(" + conCargadosCorrectos + ") Archivos Guardados Correctamente de (" + arxSize + ")"
                                + "\n\n(" + conEncontrados + ") Archivos ya han sido usados previamente" + encontrados, "Mensaje",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else if ((conEncontrados == 0 && conMalEscritos != 0) || conEncontrados > 3) {
                        //System.out.println("-*4");
                        JOptionPane.showMessageDialog(this, "(" + conCargadosCorrectos + ") Archivos Guardados Correctamente de (" + arxSize + ")"
                                + "\n\n(" + conMalEscritos + ") Archivos estan mal escritos, favor de revisar" + malEscrito, "Mensaje",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        System.out.println("... cc" + conCargadosCorrectos + "en " + conEncontrados + " mEs " + conMalEscritos);
                    }
                } else {
                    if (conEncontrados > 0 && conEncontrados <= 3 && conMalEscritos > 0 && conMalEscritos <= 3) {
                        //System.out.println("+*2");
                        JOptionPane.showMessageDialog(this, "(" + conCargadosCorrectos + ") Archivos Guardados Correctamente de (" + arxSize + ")"
                                + "\n\n(" + conEncontrados + ") Archivos ya han sido usados previamente" + encontrados
                                + "\n\n(" + conMalEscritos + ") Archivos estan mal escritos, favor de revisar" + malEscrito, "Mensaje",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else if ((conEncontrados != 0 && conMalEscritos == 0) || conEncontrados > 3) {
                        //System.out.println("+*3");
                        JOptionPane.showMessageDialog(this, "(" + conCargadosCorrectos + ") Archivos Guardados Correctamente de (" + arxSize + ")"
                                + "\n\n(" + conEncontrados + ") Archivos ya han sido usados previamente" + encontrados, "Mensaje",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else if ((conEncontrados == 0 && conMalEscritos != 0) || conEncontrados >= 3) {
                        //System.out.println("+*4");
                        JOptionPane.showMessageDialog(this, "(" + conCargadosCorrectos + ") Archivos Guardados Correctamente de (" + arxSize + ")"
                                + "\n\n(" + conMalEscritos + ") Archivos estan mal escritos, favor de revisar" + malEscrito, "Mensaje",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        System.out.println("... cc " + conCargadosCorrectos + " en " + conEncontrados + " mEs " + conMalEscritos);
                    }
                }
            }
            btnGuardar.setEnabled(false);
            lblIndicadorArx.setText("");
        } catch (WriterException | DocumentException | HeadlessException | IOException | InterruptedException e) {
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            lblIndicadorArx.setText("Error: " + e);
            inhabilitarBtnGuardar();
        }
        conCargadosCorrectos = 0;
        conEncontrados = 0;
        conMalEscritos = 0;
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void mniEdicionManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEdicionManualActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_mniEdicionManualActionPerformed

    private void mniEdicionArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEdicionArchivoActionPerformed
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        abrirJFileChooser(this, JFileChooser.FILES_ONLY);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_mniEdicionArchivoActionPerformed

    private void mniEdicionCarpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEdicionCarpetaActionPerformed
        removePanelPDF();
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        abrirJFileChooser(this, JFileChooser.DIRECTORIES_ONLY);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_mniEdicionCarpetaActionPerformed

    private void abrirJFileChooser(Component parent, int opcion) {
        fchBuscarFactura = new JFileChooser();
        fchBuscarFactura.setDialogTitle("Buscar Facturas");
        fchBuscarFactura.setFileSelectionMode(opcion);
        fchBuscarFactura.addChoosableFileFilter(new FileNameExtensionFilter("Factura Formato PDF", "pdf", "PDF"));
        fchBuscarFactura.setAcceptAllFileFilterUsed(false);

        if (fchBuscarFactura.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
            if (opcion == JFileChooser.DIRECTORIES_ONLY) {
                arx = fchBuscarFactura.getSelectedFile().listFiles((File pathname) -> pathname.toString().endsWith(".pdf") || pathname.toString().endsWith(".PDF"));
            } else if (opcion == JFileChooser.FILES_ONLY) {
                arx = fchBuscarFactura.getSelectedFiles();
            }

            if (arx != null) {
                arxSize = arx.length;
                if (arxSize > 0) {
                    if (opcion == JFileChooser.FILES_ONLY) {
                        try {
                            File file = new File(arx[0].getAbsolutePath());
                            RandomAccessFile raf = new RandomAccessFile(file, "r");
                            FileChannel channel = raf.getChannel();
                            ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
                            pdffile = new PDFFile(buf);
                            viewPage();
                            raf.close();
                            setResizable(true);
                            lblIndicadorArx.setText("Nombre del archivo: " + arx[0].getName());
                            btnGuardar.setEnabled(true);
                            JOptionPane.showMessageDialog(this, "Para visualizar mejor el documento\n"
                                    + "maximize la ventana", "Sugerencia", JOptionPane.INFORMATION_MESSAGE
                            );
                        } catch (HeadlessException | IOException e) {
                            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            lblIndicadorArx.setText("Error: " + e);
                            inhabilitarBtnGuardar();
                        }
                    } else if (opcion == JFileChooser.DIRECTORIES_ONLY) {
                        lblIndicadorArx.setText("Numero de archivos seleccionados: " + arxSize);
                        btnGuardar.setEnabled(true);
                    }
                } else {
                    lblIndicadorArx.setText("No se encontraron archivos con la extensión adecuada");
                }
            } else {
                lblIndicadorArx.setText("La carpeta esta vacía. Código de error: ICO-NPE");
            }
        } else {
            lblIndicadorArx.setText("Debe seleccionar una carpeta o archivo");
        }
    }

    public void cargaArchivos () throws BadElementException, IOException, DocumentException, WriterException, InterruptedException{
        int bnPermisoCarga = 0;
        BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        
        for (int i = 0; i < arxSize; i++) { //para los archivos
            PdfReader reader = new PdfReader(arx[i].getPath());
                                  
            /******************* Corte de nombre PDF ***********************/
            String nombres = arx[i].getName();
            String[] arrayNombres = nombres.split("_");

            // SE HACEN LOS CORTES PARA OBTENER LOS VALORES DE VENDOR, FACTURA, COMPANIA
            for (int n = 0; n < arrayNombres.length; n++) {
                if (n == 0) {
                    vendor = arrayNombres[n];
                } else if (n == 1) {
                    factura = arrayNombres[n];
                } else if (n == 2) {
                    compania = arrayNombres[n];
                }
            }
                        
            /******RUTAS DE GUARDADO DE ACUERDO A LA COMPANIA****************************/
            if (compania.length() < 7 ){
                //conCargadosCorrectos += 1;
                if (compania.contains(service)){
                    compania = service;
                    //System.out.println(compania+" service "+i+" "+arx[i].getName());
                    stamper = new PdfStamper(reader, new  FileOutputStream("C:/Users/PRR1TL/Desktop/Rutas/Service/"+arx[i].getName()));
                } else if (compania.contains(llc)){
                    compania = llc;
                    //System.out.println(compania+" llc "+i+" "+arx[i].getName());
                    stamper = new PdfStamper(reader, new  FileOutputStream("C:/Users/PRR1TL/Desktop/Rutas/LLC/"+arx[i].getName())) ;
                } else if (compania.equals(manufacturing)){
                    compania = manufacturing;
                    //System.out.println(compania+" manufacturing " +i+" "+arx[i].getName());
                    stamper = new PdfStamper(reader, new  FileOutputStream("C:/Users/PRR1TL/Desktop/Rutas/Manufacturing/"+arx[i].getName()));
                }else {
                    stamper = new PdfStamper(reader, new  FileOutputStream("C:/Users/PRR1TL/Desktop/Rutas/"+arx[i].getName()));
                }
                
                //CARGA LOS ARCHIVOS
                
                for (int pag = 0; pag <= reader.getNumberOfPages(); pag++) {
                    if (pag == 1) {
                        codigoQr = compania + "-" + consecutivos;
                        generaQr();
                        PdfContentByte over = stamper.getOverContent(pag);

                        //Imprime Rectangulo
                        over.setColorStroke(BaseColor.BLACK);
                        over.setColorFill(BaseColor.WHITE);
                        over.rectangle(538, 5, 70, 45);
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
                        over.setFontAndSize(bf, 7);    // COLOR Y TAMANO
                        over.setTextMatrix(570, 5);   // set x,y posiCION (0,0)
                        over.showText(codigoQr);  // IMPRIME TEXTO
                        over.endText();
                    }
                }

                /************EVALUA QUE LOS ARCHIVOS NO HAYAN SIDO MODIFICADOS PREVIAMENTE**************************/

                try {
                    if (registro.validaArchivoExistente(vendor, factura, compania) == 0) {
                        if (registro.consultaUltimoConsecutivo(compania, factura) == null) {
                            consecutivos = "000000";
                            registra();
                        } else {
                            consecu = registro.consultaUltimoConsecutivo(compania, factura);
                            int con = Integer.parseInt(consecu);
                            consecutivos = Integer.toString(con + 1);                  

                            if (consecutivos.length() < 6) {
                                if (consecutivos.length() == 1) {
                                    consecutivos = "00000" + consecutivos;
                                } else if (consecutivos.length() == 2) {
                                    consecutivos = "0000" + consecutivos;
                                } else if (consecutivos.length() == 3) {
                                    consecutivos = "000" + consecutivos;
                                } else if (consecutivos.length() == 4) {
                                    consecutivos = "00" + consecutivos;
                                } else if (consecutivos.length() == 5) {
                                    consecutivos = "0" + consecutivos;
                                }
                            }
                            if (consecutivos.length() == 6) {
                                registra();
                            }
                        }

                    } else {
                        conEncontrados = conEncontrados+1; 
                        encontrados.add("\n"+arx[i].getName());
                        //JOptionPane.showMessageDialog(this, "El Archivo " + arx[i].getName() + "\nNo se puede cargar, ya que ha sido usado previamente.");//+vendor +", "+ factura + ", "+ vendor);
                    }
                } catch (Exception ex) {
                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    lblIndicadorArx.setText("Error: " + ex);
                    inhabilitarBtnGuardar();
                }            
                stamper.close(); //cierra archivo
                
            }else {
                conMalEscritos += 1; 
                malEscrito.add("\n"+arx[i].getName());
                stamper = new PdfStamper(reader, new  FileOutputStream("C:/Users/PRR1TL/Desktop/Rutas/MalEscritos"+arx[i].getName()));
                stamper.close();
            }
            
            //stamper = new PdfStamper(reader, new  FileOutputStream("C:/Users/PRR1TL/Desktop/Rutas/"+arx[i].getName()));
            /*************************************************************/
        }
    }

    public static void generaQr() throws WriterException, FileNotFoundException, IOException {
        String data = codigoQr;

        // Encode URL in QR format
        BitMatrix matrix;
        QRCodeWriter writer = new QRCodeWriter();
        matrix = writer.encode(data, BarcodeFormat.QR_CODE, qr_image_width, qr_image_height);

        // Create buffered image to draw to
        BufferedImage image = new BufferedImage(qr_image_width, qr_image_height, BufferedImage.TYPE_INT_RGB);

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

    public static void registra () throws Exception{
        
        conCargadosCorrectos += 1;
        //System.out.println(conCargadosCorrectos);
        
        Object[] reg = new Object[4];
        try {
            reg[0] = vendor;
            reg[1] = factura;
            reg[2] = compania;
            reg[3] = consecutivos;

            registro.registroFactura(reg);

        } catch (Exception ex) {
            throw ex;
        }
    }
    
    private void viewPage() {
        pnlPDF = new PagePanel();

        pnlPDF.setPreferredSize(new Dimension(700, 500));
        setPreferredSize(new Dimension(700, 500));

        pnlEdicionArx = new javax.swing.JPanel();
        pnlEdicionArx.add(pnlPDF);
        
        pnlBackground.add(pnlEdicionArx, BorderLayout.CENTER);

        repaint();
        pack();

        PDFPage page = pdffile.getPage(1);
        pnlPDF.useZoomTool(false);
        pnlPDF.showPage(page);
        pnlPDF.repaint();
    }

    private void removePanelPDF() {
        if (pnlPDF != null) {
            setResizable(false);
            pnlBackground.remove(pnlPDF);
            repaint();
            setPreferredSize(new Dimension(700, 200));
            pack();
        }
    }

    private void inhabilitarBtnGuardar() {
        if (btnGuardar.isEnabled()) {
            btnGuardar.setEnabled(false);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarFactura;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblIndicadorArx;
    private javax.swing.JMenuItem mniEdicionArchivo;
    private javax.swing.JMenuItem mniEdicionCarpeta;
    private javax.swing.JMenuBar mnuBarra;
    private javax.swing.JMenu mnuEdicion;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlBotonesArx;
    private javax.swing.JPanel pnlEdicionArx;
    private javax.swing.JPanel pnlIndicadorArx;
    // End of variables declaration//GEN-END:variables

}
