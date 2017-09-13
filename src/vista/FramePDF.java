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
import com.itextpdf.text.pdf.PdfWriter;
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
    private PDFPage page;
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
        pnlEdicionArx.setVisible(false);
        setSize(new Dimension(700, 210));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlBackground = new javax.swing.JPanel();
        pnlBotonesArx = new javax.swing.JPanel();
        btnBuscarFactura = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        pnlIndicadorArx = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lblIndicadorArx = new javax.swing.JLabel();
        pnlEdicionArx = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        rdbSuperiorIzq = new javax.swing.JRadioButton();
        rdbInferiorIzq = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        rdbSuperiorDer = new javax.swing.JRadioButton();
        rdbInferiorDer = new javax.swing.JRadioButton();
        pnlVisorFactura = new javax.swing.JPanel();
        mnuBarra = new javax.swing.JMenuBar();
        mnuEdicion = new javax.swing.JMenu();
        mniEdicionCarpeta = new javax.swing.JMenuItem();
        mniEdicionArchivo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlBackground.setLayout(new java.awt.BorderLayout());

        pnlBotonesArx.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 0, 18))); // NOI18N

        btnBuscarFactura.setText("Buscar Factura (s)");
        btnBuscarFactura.setFocusable(false);
        btnBuscarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFacturaActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setFocusable(false);
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

        pnlBackground.add(pnlBotonesArx, java.awt.BorderLayout.NORTH);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        lblIndicadorArx.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblIndicadorArx.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout pnlIndicadorArxLayout = new javax.swing.GroupLayout(pnlIndicadorArx);
        pnlIndicadorArx.setLayout(pnlIndicadorArxLayout);
        pnlIndicadorArxLayout.setHorizontalGroup(
            pnlIndicadorArxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIndicadorArxLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        pnlBackground.add(pnlIndicadorArx, java.awt.BorderLayout.SOUTH);

        pnlEdicionArx.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Visor Factura", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 0, 18))); // NOI18N
        pnlEdicionArx.setPreferredSize(new java.awt.Dimension(700, 500));

        buttonGroup1.add(rdbSuperiorIzq);
        rdbSuperiorIzq.setActionCommand("_rdbSuperiorIzq");
        rdbSuperiorIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbSuperiorIzqActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbInferiorIzq);
        rdbInferiorIzq.setActionCommand("_rdbInferiorIzq");
        rdbInferiorIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbInferiorIzqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbSuperiorIzq, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rdbInferiorIzq, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdbSuperiorIzq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdbInferiorIzq)
                .addContainerGap())
        );

        buttonGroup1.add(rdbSuperiorDer);
        rdbSuperiorDer.setActionCommand("_rdbSuperiorDer");
        rdbSuperiorDer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbSuperiorDerActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbInferiorDer);
        rdbInferiorDer.setActionCommand("_rdbInferiorDer");
        rdbInferiorDer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbInferiorDerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbSuperiorDer)
                    .addComponent(rdbInferiorDer))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdbSuperiorDer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(rdbInferiorDer)
                .addContainerGap())
        );

        pnlVisorFactura.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pnlEdicionArxLayout = new javax.swing.GroupLayout(pnlEdicionArx);
        pnlEdicionArx.setLayout(pnlEdicionArxLayout);
        pnlEdicionArxLayout.setHorizontalGroup(
            pnlEdicionArxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEdicionArxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlVisorFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlEdicionArxLayout.setVerticalGroup(
            pnlEdicionArxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlVisorFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlBackground.add(pnlEdicionArx, java.awt.BorderLayout.CENTER);

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
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
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

    private void rdbSuperiorIzqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbSuperiorIzqActionPerformed
        selectorPosicion(evt);
    }//GEN-LAST:event_rdbSuperiorIzqActionPerformed

    private void rdbInferiorIzqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbInferiorIzqActionPerformed
        selectorPosicion(evt);
    }//GEN-LAST:event_rdbInferiorIzqActionPerformed

    private void rdbSuperiorDerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbSuperiorDerActionPerformed
        selectorPosicion(evt);
    }//GEN-LAST:event_rdbSuperiorDerActionPerformed

    private void rdbInferiorDerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbInferiorDerActionPerformed
        selectorPosicion(evt);
    }//GEN-LAST:event_rdbInferiorDerActionPerformed

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
                            crearVisorFactura(arx[0].getAbsolutePath());
                            setResizable(true);
                            lblIndicadorArx.setText("Nombre del archivo: " + arx[0].getName());
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
                    inhabilitarBtnGuardar();
                }
            } else {
                lblIndicadorArx.setText("La carpeta esta vacía. Código de error: ICO-NPE");
                inhabilitarBtnGuardar();
            }
        } else {
            lblIndicadorArx.setText("Debe seleccionar una carpeta o archivo");
            inhabilitarBtnGuardar();
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
        pnlEdicionArx.setVisible(true);
        pnlPDF = new PagePanel();
        
        //pnlPDF.setPreferredSize(new Dimension(700, 500));
        //setPreferredSize(new Dimension(700, 500));
        
        pnlVisorFactura.add(pnlPDF, BorderLayout.CENTER);
        
        pnlBackground.add(pnlEdicionArx, BorderLayout.CENTER);

        repaint();
        pack();

        page = pdffile.getPage(1);
        pnlPDF.useZoomTool(false);
        pnlPDF.showPage(page);
        pnlPDF.repaint();
    }

    private void removePanelPDF() {
        if (pnlEdicionArx != null) {
            setResizable(false);
            pnlBackground.remove(pnlEdicionArx);
            repaint();
            setPreferredSize(new Dimension(700, 210));
            pack();
        }
    }

    private void inhabilitarBtnGuardar() {
        if (btnGuardar.isEnabled()) {
            btnGuardar.setEnabled(false);
        }
    }

    private void crearVisorFactura(String pathFile) throws HeadlessException, IOException {
        try {
            File file = new File(pathFile);
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            FileChannel channel = raf.getChannel();
            ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
            pdffile = new PDFFile(buf);
            viewPage();
            raf.close();
        } catch (HeadlessException | IOException e) {
            throw e;
        }
    }

    private void selectorPosicion(java.awt.event.ActionEvent evt) {
        switch (evt.getActionCommand()) {
            case "_rdbSuperiorIzq":
                try {
                    inhabilitarBtnGuardar();
                    edicionManual(8, page.getHeight() - 45);
                    btnGuardar.setEnabled(true);
                } catch (WriterException | DocumentException | HeadlessException | IOException e) {
                    //Exception
                    System.out.println("izq " + e);
                }               
                break;
            case "_rdbSuperiorDer":
                try {
                    inhabilitarBtnGuardar();
                    edicionManual(page.getWidth() - 70, page.getHeight() - 45);
                    btnGuardar.setEnabled(true);
                } catch (WriterException | DocumentException | HeadlessException | IOException e) {
                    //Exception
                    System.out.println("der " + e);
                }
                break;
        }
    }
    
    private void edicionManual(float x, float y) throws WriterException, DocumentException, HeadlessException, IOException{
        try {
            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            PdfReader reader = new PdfReader(arx[0].getPath());
            stamper = new PdfStamper(reader, new FileOutputStream("C:/Users/GJA5TL/Documents/" + arx[0].getName(), true));
            codigoQr = "XXX" + "-" + "000";
            generaQr();
            PdfContentByte over = stamper.getOverContent(1);

            //Imprime Rectangulo
            over.setColorStroke(BaseColor.BLACK);
            over.setColorFill(BaseColor.WHITE);
            over.rectangle(538, 5, 70, 45);
            over.fill();
            over.stroke();

            //Abre Qr
            java.awt.Image awtImage = Toolkit.getDefaultToolkit().createImage("C:\\temp\\codigoQR.png");
            Image image = Image.getInstance(awtImage, null);
            image.setAbsolutePosition(x, y);
            over.addImage(image);

            //imprime Texto
            over.beginText();
            over.setColorFill(BaseColor.BLACK);
            over.setFontAndSize(bf, 7);    // COLOR Y TAMANO
            over.setTextMatrix(x, y);   // set x,y posiCION (0,0)
            over.showText(codigoQr);  // IMPRIME TEXTO
            over.endText();
            stamper.close();
            reader.close();
            crearVisorFactura("C:/Users/GJA5TL/Documents/" + arx[0].getName());
        } catch (WriterException | DocumentException | HeadlessException | IOException e) {
            throw e;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarFactura;
    private javax.swing.JButton btnGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
    private javax.swing.JPanel pnlVisorFactura;
    private javax.swing.JRadioButton rdbInferiorDer;
    private javax.swing.JRadioButton rdbInferiorIzq;
    private javax.swing.JRadioButton rdbSuperiorDer;
    private javax.swing.JRadioButton rdbSuperiorIzq;
    // End of variables declaration//GEN-END:variables

}
