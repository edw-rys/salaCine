package Alertas.notificacionAlertas;

import OtrosOperaciones.EventosJButton;
import OtrosOperaciones.Sonidos;
import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Edw
 */
public class AlertaOperaciones extends javax.swing.JDialog {

     Timer timer = null;
    TimerTask task;
    int i = 32;
    private boolean aceptar=false;
    public AlertaOperaciones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        detallarBotones();
        Sonidos.reproducirSonido("AlertaOperacion.wav");   
    }

    private void detallarBotones(){              
        EventosJButton eventoColorear=new EventosJButton();        
        eventoColorear.colorearBotones(btnCancelar, Color.red,new Color(105,0,0));
        eventoColorear.colorearBotones(btnAceptar, new Color(0, 139, 139), new Color(0, 102, 102));
                   
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblSubT = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        jPanel1.setLayout(new java.awt.GridLayout(2, 0));

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(1, 3));
        jPanel2.add(jLabel7);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Alertas/img/warning.png"))); // NOI18N
        jPanel2.add(jLabel1);
        jPanel2.add(jLabel8);

        jPanel1.add(jPanel2);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridLayout(3, 0));

        jPanel4.setOpaque(false);

        lblTitulo.setBackground(new java.awt.Color(0, 153, 153));
        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 153, 153));
        lblTitulo.setText("jLabel2");
        jPanel4.add(lblTitulo);

        jPanel3.add(jPanel4);

        jPanel5.setOpaque(false);

        lblSubT.setBackground(new java.awt.Color(255, 255, 255));
        lblSubT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSubT.setForeground(new java.awt.Color(255, 255, 255));
        lblSubT.setText("jLabel2");
        jPanel5.add(lblSubT);

        jPanel3.add(jPanel5);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        btnAceptar.setBackground(new java.awt.Color(102, 0, 0));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel6.add(btnAceptar);

        btnCancelar.setBackground(new java.awt.Color(0, 102, 102));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel6.add(btnCancelar);

        jPanel3.add(jPanel6);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        aceptar=true;
        setVisible(false);
    }//GEN-LAST:event_btnAceptarActionPerformed
    //verificar boton presionado
    public boolean isAceptar() {
        return aceptar;
    }
    
    public void setAceptar(boolean aceptar) {
        this.aceptar = aceptar;
    }
    //fin verificar
    
    
    
     
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
            java.util.logging.Logger.getLogger(AlertaOperaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlertaOperaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlertaOperaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlertaOperaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AlertaOperaciones dialog = new AlertaOperaciones(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void setLblSubT(String t) {
        this.lblSubT.setText(t);
    }

    public void setLblTtulo(String t) {        
        this.lblTitulo.setText(t);
    }

    private void Ubicar(int y) {
        this.setLocation(450, y - 120);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    public javax.swing.JLabel lblSubT;
    public javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
