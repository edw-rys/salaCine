
package Alertas.notificacionAlertas;

import OtrosOperaciones.EventosJButton;
import OtrosOperaciones.Sonidos;
import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class AlertaNotificacion extends javax.swing.JDialog {
    private Color cBolton;
    private Color FondoBtn;
    EventosJButton efectoAceptar;
    public AlertaNotificacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        efectoAceptar=new EventosJButton(btnAceptar);
        btnAceptar.addMouseListener(efectoAceptar);
        btnAceptar.addMouseMotionListener(efectoAceptar);        
    }

    public void agregarImagen(int i){
         // 1 si se compelto
        ///0 si hubo error 
        //2 si solo es una advertencia        
        if(i==1)
            return ;
        
            ImageIcon imagenFondo;
            Icon icono;
            if(i==0)
            {
                imagenFondo=new ImageIcon("src/Alertas/img/error.png");   
                efectoAceptar.colorearBotones(btnAceptar, Color.red,  new Color(105,0,0));                
            }
            else 
                imagenFondo=new ImageIcon("src/Alertas/img/warning.png");
               icono=new ImageIcon(imagenFondo.getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_DEFAULT));
                lblImg.setIcon(icono);
    }

    public void colorFondoBoton(Color fondoBoton){
        FondoBtn=fondoBoton;
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblImg = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblSubT = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        jPanel1.setLayout(new java.awt.GridLayout(2, 0));

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(1, 3));
        jPanel2.add(jLabel7);

        lblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Alertas/img/success.png"))); // NOI18N
        jPanel2.add(lblImg);
        jPanel2.add(jLabel8);

        jPanel1.add(jPanel2);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridLayout(3, 0));

        jPanel4.setOpaque(false);

        lblTitulo.setBackground(new java.awt.Color(255, 255, 255));
        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("jLabel2");
        jPanel4.add(lblTitulo);

        jPanel3.add(jPanel4);

        jPanel5.setOpaque(false);

        lblSubT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSubT.setForeground(new java.awt.Color(204, 204, 204));
        lblSubT.setText("jLabel2");
        jPanel5.add(lblSubT);

        jPanel3.add(jPanel5);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));
        jPanel6.add(jLabel2);

        btnAceptar.setBackground(new java.awt.Color(0, 102, 102));
        btnAceptar.setText("ACEPTAR");
        btnAceptar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnAceptarMouseMoved(evt);
            }
        });
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAceptarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAceptarMouseReleased(evt);
            }
        });
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel6.add(btnAceptar);
        jPanel6.add(jLabel3);

        jPanel3.add(jPanel6);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseMoved
        btnAceptar.setBackground(FondoBtn);
    }//GEN-LAST:event_btnAceptarMouseMoved

    private void btnAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseExited
        btnAceptar.setBackground(cBolton);
    }//GEN-LAST:event_btnAceptarMouseExited

    private void btnAceptarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMousePressed
        btnAceptar.setBackground(Color.black);
    }//GEN-LAST:event_btnAceptarMousePressed

    private void btnAceptarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseReleased
        btnAceptar.setBackground(cBolton);
    }//GEN-LAST:event_btnAceptarMouseReleased

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnAceptarActionPerformed

   
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
            java.util.logging.Logger.getLogger(AlertaNotificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlertaNotificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlertaNotificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlertaNotificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AlertaNotificacion dialog = new AlertaNotificacion(new javax.swing.JFrame(), true);
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

    
    public void setLblSubT(String T) {
        this.lblSubT.setText(T);
    }

    public void setLblTtulo(String T) {        
        this.lblTitulo.setText(T);
    }
    
    public void setColorBoton(Color Cboton){
        btnAceptar.setBackground(Cboton);
        this.cBolton=Cboton;
    }
    
    public void reproducirSonido(int tipo){
        // 1 si se compelto
        ///0 si hubo error 
        //2 si solo es una advertencia
        if(tipo==1)
            Sonidos.reproducirSonido("AlertaNotificacionCorrecta.wav");
        else
            if(tipo==0)
                Sonidos.reproducirSonido("AlertaNotificacionError.wav");   
                else
                    Sonidos.reproducirSonido("AlertaNotificacionAdvertencia.wav");   
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblImg;
    public javax.swing.JLabel lblSubT;
    public javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
