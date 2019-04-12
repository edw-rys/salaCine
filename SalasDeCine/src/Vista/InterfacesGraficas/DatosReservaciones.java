package Vista.InterfacesGraficas;

import Entidades.ReservacionesSalas;
import OtrosOperaciones.DetalleComponentes;
import OtrosOperaciones.EventosJButton;
import Vista.Paneles.panelMostrarReservacion;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;


public class DatosReservaciones extends javax.swing.JFrame {
    
    public ReservacionesSalas verReservacion;
    public DatosReservaciones() {
        initComponents();
        verReservacion=new ReservacionesSalas();
        this.setIconImage(DetalleComponentes.getIconImage());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);//Modificar el estado de extendido
        EventosJButton eventoColorear=new EventosJButton();         
        eventoColorear.colorearBotones(btnRegresar, new Color(0 ,92 ,12   ), new Color(0 ,63 ,12));
    }
    
    public void setVerReservacion(ReservacionesSalas verReservacion) {
        this.verReservacion = verReservacion;        
    }

    
    public void setLblDatosSala(String titulo){
        lblSalaDatos.setText(titulo);
    }
    
    public void agregarPanelCentral(){
        panelMostrarReservacion mostrar =new panelMostrarReservacion();
        mostrar.cargarDatosReservacion(verReservacion);
        mostrar.panelSuperior.setVisible(false);
        panelCentral.removeAll();
        panelCentral.add(mostrar,BorderLayout.CENTER );
        panelCentral.revalidate();
        panelCentral.repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        panelSuperior = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        lblSalaDatos = new javax.swing.JLabel();
        panelCentral = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new java.awt.BorderLayout());

        panelSuperior.setBackground(new java.awt.Color(0, 102, 0));

        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        lblSalaDatos.setFont(new java.awt.Font("Pristina", 0, 36)); // NOI18N
        lblSalaDatos.setText("Datos Pertenecientes Sala");

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperiorLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblSalaDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 442, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addContainerGap())
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(lblSalaDatos))
                .addContainerGap())
        );

        jPanel1.add(panelSuperior, java.awt.BorderLayout.NORTH);

        panelCentral.setOpaque(false);
        panelCentral.setLayout(new java.awt.BorderLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/imagenDefault.png"))); // NOI18N
        panelCentral.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.add(panelCentral, java.awt.BorderLayout.CENTER);

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        MenuPrincipal principal=new MenuPrincipal();
        principal.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DatosReservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatosReservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatosReservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatosReservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatosReservaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSalaDatos;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelSuperior;
    // End of variables declaration//GEN-END:variables
}
