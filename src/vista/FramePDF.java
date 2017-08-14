package vista;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class FramePDF extends javax.swing.JFrame {

    /** Creates new form FramePDF */
    public FramePDF() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlOpciones = new javax.swing.JPanel();
        webStepLabel1 = new com.alee.extended.label.WebStepLabel();
        webStepLabel2 = new com.alee.extended.label.WebStepLabel();
        webStepLabel3 = new com.alee.extended.label.WebStepLabel();
        webStepLabel4 = new com.alee.extended.label.WebStepLabel();
        jLabel1 = new javax.swing.JLabel();
        pnlOpcionesList = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnlBackground = new javax.swing.JPanel();
        pnlPDF = new javax.swing.JPanel();
        webPnlOpciones = new com.alee.extended.panel.WebCollapsiblePane();

        pnlOpciones.setBackground(new java.awt.Color(236, 240, 241));
        pnlOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 0, 18))); // NOI18N

        webStepLabel1.setText("<html> <center>Abrir<br> <center>PDF </html>");
        webStepLabel1.setBottomBgColor(new java.awt.Color(243, 156, 18));
        webStepLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        webStepLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                webStepLabel1MouseClicked(evt);
            }
        });

        webStepLabel2.setText("<html>\n<center>Modificar<br>\n<center>PDF\n</html>");
        webStepLabel2.setBottomBgColor(new java.awt.Color(52, 152, 219));
        webStepLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        webStepLabel3.setText("<html> <center>Guardar<br> <center>PDF </html>");
        webStepLabel3.setBottomBgColor(new java.awt.Color(46, 204, 113));
        webStepLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        webStepLabel4.setText("Cancelar");
        webStepLabel4.setBottomBgColor(new java.awt.Color(231, 76, 60));
        webStepLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel1.setText("<html>\n<center>SG-PDF<br>\n<center>Facturacion<br>\n<center>v1.0\n</html>");

        javax.swing.GroupLayout pnlOpcionesLayout = new javax.swing.GroupLayout(pnlOpciones);
        pnlOpciones.setLayout(pnlOpcionesLayout);
        pnlOpcionesLayout.setHorizontalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(webStepLabel3)
                    .addComponent(webStepLabel1)
                    .addComponent(webStepLabel2)
                    .addComponent(webStepLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlOpcionesLayout.setVerticalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(webStepLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(webStepLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(webStepLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(webStepLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlOpcionesList.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 0, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icnA.png"))); // NOI18N
        jLabel2.setText("Abrir PDF");
        jLabel2.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icnB.png"))); // NOI18N
        jLabel3.setText("Modificar PDF");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icnC.png"))); // NOI18N
        jLabel4.setText("Guardar PDF");

        javax.swing.GroupLayout pnlOpcionesListLayout = new javax.swing.GroupLayout(pnlOpcionesList);
        pnlOpcionesList.setLayout(pnlOpcionesListLayout);
        pnlOpcionesListLayout.setHorizontalGroup(
            pnlOpcionesListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOpcionesListLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlOpcionesListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
        );
        pnlOpcionesListLayout.setVerticalGroup(
            pnlOpcionesListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(341, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBackground.setLayout(new java.awt.BorderLayout());

        pnlPDF.setBackground(new java.awt.Color(236, 240, 241));
        pnlPDF.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Visor PDF", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 0, 18))); // NOI18N

        javax.swing.GroupLayout pnlPDFLayout = new javax.swing.GroupLayout(pnlPDF);
        pnlPDF.setLayout(pnlPDFLayout);
        pnlPDFLayout.setHorizontalGroup(
            pnlPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );
        pnlPDFLayout.setVerticalGroup(
            pnlPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
        );

        pnlBackground.add(pnlPDF, java.awt.BorderLayout.CENTER);

        webPnlOpciones.setContent(pnlOpcionesList);
        webPnlOpciones.setTitlePanePostion(2);
        pnlBackground.add(webPnlOpciones, java.awt.BorderLayout.EAST);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void webStepLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_webStepLabel1MouseClicked
        webPnlOpciones.setExpanded(false);
    }//GEN-LAST:event_webStepLabel1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlOpciones;
    private javax.swing.JPanel pnlOpcionesList;
    private javax.swing.JPanel pnlPDF;
    private com.alee.extended.panel.WebCollapsiblePane webPnlOpciones;
    private com.alee.extended.label.WebStepLabel webStepLabel1;
    private com.alee.extended.label.WebStepLabel webStepLabel2;
    private com.alee.extended.label.WebStepLabel webStepLabel3;
    private com.alee.extended.label.WebStepLabel webStepLabel4;
    // End of variables declaration//GEN-END:variables

}
