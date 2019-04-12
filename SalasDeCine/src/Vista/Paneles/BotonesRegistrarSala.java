package Vista.Paneles;



import Vista.InterfacesGraficas.*;
import OtrosOperaciones.EventosJButton;
import PatronesDiseño.MetodoFabricaSalas;
import java.awt.Color;

/**
 *
 * @author Edw
 */
public class BotonesRegistrarSala extends javax.swing.JPanel {
    private    MenuPrincipal principal ;
   
    
    public BotonesRegistrarSala() {
        initComponents();        
        //DETALLAR BOTONES
        
        EventosJButton eventoColorear=new EventosJButton();         
        eventoColorear.colorearBotones(btnGeneral, new Color(92,126,216), new Color(92,72,253));
        eventoColorear.colorearBotones(btnVip, new Color(240,64,52), new Color(240,33,42));
        eventoColorear.colorearBotones(btnBlackbox, new Color(52,149,19), new Color(24,112,24));
                   
    }

    public void setCoordenadasPantalla(MenuPrincipal principal){
        this.principal=principal;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnGeneral = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnVip = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnBlackbox = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setLayout(new java.awt.GridLayout(3, 7));

        jLabel3.setText(" ");
        add(jLabel3);

        jLabel5.setText(" ");
        add(jLabel5);

        jLabel4.setText(" ");
        add(jLabel4);

        jLabel10.setText(" ");
        add(jLabel10);

        jLabel9.setText(" ");
        add(jLabel9);
        add(jLabel11);
        add(jLabel12);
        add(jLabel17);

        btnGeneral.setForeground(new java.awt.Color(255, 255, 255));
        btnGeneral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/cine .png"))); // NOI18N
        btnGeneral.setText("GENERAL");
        btnGeneral.setContentAreaFilled(false);
        btnGeneral.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneralActionPerformed(evt);
            }
        });
        add(btnGeneral);

        jLabel1.setText("       ");
        add(jLabel1);

        btnVip.setForeground(new java.awt.Color(255, 255, 255));
        btnVip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/canguil.png"))); // NOI18N
        btnVip.setText("VIP");
        btnVip.setContentAreaFilled(false);
        btnVip.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVipActionPerformed(evt);
            }
        });
        add(btnVip);

        jLabel2.setText("       ");
        add(jLabel2);

        btnBlackbox.setForeground(new java.awt.Color(255, 255, 255));
        btnBlackbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/iconoPrograma.png"))); // NOI18N
        btnBlackbox.setText("BLACKBOX");
        btnBlackbox.setContentAreaFilled(false);
        btnBlackbox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBlackbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlackboxActionPerformed(evt);
            }
        });
        add(btnBlackbox);
        add(jLabel13);
        add(jLabel15);

        jLabel6.setText(" ");
        add(jLabel6);

        jLabel7.setText(" ");
        add(jLabel7);

        jLabel8.setText(" ");
        add(jLabel8);
        add(jLabel14);
        add(jLabel16);
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneralActionPerformed
        RegistroSalasCine Presenta=new RegistroSalasCine();
        Presenta.setCodigoSala("general-");
        Presenta.setLabelsPorSala("Promociones activas", "SNACK");
        Presenta.cargarCmb(1);
        Presenta.setTipo("GENERAL"); 
        Presenta.setSalaAGuardar(MetodoFabricaSalas.crearSala(1));
        Presenta.setVisible(true);
        this.setVisible(false);
        
       principal.dispose();
    }//GEN-LAST:event_btnGeneralActionPerformed

    private void btnVipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVipActionPerformed
        RegistroSalasCine Presenta=new RegistroSalasCine();
        Presenta.setLabelsPorSala("Modelo de Gafas 3D", "Servicio Adicional");
        Presenta.cargarCmb(2);
        Presenta.setTipo("VIP");
        Presenta.setSalaAGuardar(MetodoFabricaSalas.crearSala(2));
        Presenta.setCodigoSala("vip-");

        Presenta.setVisible(true);
        this.setVisible(false);
        principal.dispose();
    }//GEN-LAST:event_btnVipActionPerformed

    private void btnBlackboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlackboxActionPerformed
        RegistroSalasCine Presenta=new RegistroSalasCine();
        Presenta.setCodigoSala("blackbox-");
        Presenta.setLabelsPorSala("Modelo Butacas", "Servicio Adicional(GRATIS)");
        Presenta.cargarCmb(3);
        Presenta.setSalaAGuardar(MetodoFabricaSalas.crearSala(2));
        Presenta.setTipo("BLACKBOX");
        Presenta.setVisible(true);

        this.setVisible(false);
        principal.dispose();
    }//GEN-LAST:event_btnBlackboxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBlackbox;
    private javax.swing.JButton btnGeneral;
    private javax.swing.JButton btnVip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
