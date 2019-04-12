
package Vista.InterfacesGraficas;

import OtrosOperaciones.DetalleComponentes;
import OtrosOperaciones.FadeEffect;
import OtrosOperaciones.Sonidos;
import com.sun.awt.AWTUtilities;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author Edw
 */
public class LogoInicio extends javax.swing.JFrame implements Runnable {

    private Thread tiempo = null;
    public LogoInicio() {
        initComponents();
         
        Sonidos.reproducirSonido("InicioPrograma.wav");//Reproductir sonido al iniciar el programa
        AWTUtilities.setWindowOpaque(this, false);//Hacer dondo del jframe opaco
        this.setLocationRelativeTo(null);//Centrar Jframe        
        FadeEffect.fadeInFrame(this, 50, 0.1f);//Llamar método estático del efecto 
        tiempo = new Thread(this);//
        tiempo.start();
        this.setIconImage(DetalleComponentes.getIconImage());       
    }
    
   public void run() {
        try {
            Thread.sleep(4000);            
            FadeEffect.fadeOutFrameSplash(this, 50, 0.1f);            
        } catch (InterruptedException ex) {
           
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/ImfGif/barraDeCarga.gif"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 390, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/IniciarImagen.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LogoInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogoInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogoInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogoInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LogoInicio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(LogoInicio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(LogoInicio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(LogoInicio.class.getName()).log(Level.SEVERE, null, ex);
                }
                new LogoInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
