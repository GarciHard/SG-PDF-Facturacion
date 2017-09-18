package visualizaPdf;


import com.itextpdf.text.pdf.PdfStamper;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import com.sun.pdfview.PagePanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import javax.swing.JButton;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Clase que visualiza un pdf en un aplicación de escritorio
 * @author Chabir Atrahouch
 *
 */
public abstract class LectorPdf extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String PDF = "pdf";
	private JButton open;
	private int pagina;
	private int paginas;
	private int number;
	private PagePanel panel;
	private LectorPdf lectorPdf;
	private PDFFile pdffile;

	public LectorPdf() {
            lectorPdf = this;
            open = new JButton("Abrir");
            
            panel = new PagePanel();

            // Botones y area texto
            open.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    JFileChooser chooser = new JFileChooser();
                    //PdfStamper stamper = new PdfStamper(pdffile, new FileOutputStream("C:\\Users\\PRR1TL\\Documents\\pruebapdf.pdf"));
                    
                    chooser.setFileFilter(new FileFilter() {
                        @Override
                        public String getDescription() {
                            //solo permite PDF
                            return PDF; 
                        }

                        @Override
                        public boolean accept(File f) {
                            return f.isDirectory() || f.getName().endsWith(PDF);
                        }
                    });
                    int select = chooser.showOpenDialog(lectorPdf);

                    if(select == JFileChooser.APPROVE_OPTION){
                        try {
                            
                            File file = new File(chooser.getSelectedFile().getAbsolutePath()); 
                            RandomAccessFile raf = new RandomAccessFile(file, "r");
                            FileChannel channel = raf.getChannel();

                            ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0,channel.size());
                            pdffile = new PDFFile(buf);
                            viewPage();
                            raf.close();
                        }catch (Exception e) {
                            e.printStackTrace();
                        }								
                    }
                }
            });
            open.setBounds(10, 14, 80, 20);

            // Dimesion del frame y panel
            Dimension pantalla;
            Dimension cuadro;
            setSize(750, 780);
            pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            cuadro = this.getSize();
            this.setLocation(((pantalla.width - cuadro.width) / 2),
                            (pantalla.height - cuadro.height) / 2);
            panel.setBounds(100, 0, 550, 780);
            panel.setBackground(Color.white);
            // Agrego todos los elementos al frame principal
            getContentPane().add(open);
            getContentPane().add(panel);
            repaint();

            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("Visualizador de pdf");
            setResizable(false);
            getContentPane().setLayout(null);
            setVisible(true);
	}

	private void viewPage(){
            PDFPage page = pdffile.getPage(pagina);
            panel.useZoomTool(false);
            panel.showPage(page);
            repaint();
            panel.repaint();
	}

	public void keyPressed(KeyEvent el) {
            if (el.getKeyCode() == KeyEvent.VK_A)
            {
                panel.removeAll();
            }
            panel.repaint();
            repaint();
	}
}
