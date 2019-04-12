package Vista.Paneles;

import Entidades.Sala;
import OtrosOperaciones.EventosJButton;
import PatronesDiseño.FacadeSala;
import Vista.InterfacesGraficas.MenuPrincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import modelo.operacionesDAO.SalaDAO;


public class BotonesReservacion extends javax.swing.JPanel {
    private MenuPrincipal principal ;
    private int tipoDeOpcion;//Indica si es para hacer una reservacion --> 1
    //O para mostrar la lista de rservaciones segun un tipo de sala --> 2
    
    public BotonesReservacion() {
        initComponents();        
        //DETALLAR BOTONES
        
        EventosJButton eventoColorear=new EventosJButton();         
        eventoColorear.colorearBotones(btnGeneral, new Color(92,126,216), new Color(92,72,253));
        eventoColorear.colorearBotones(btnVip, new Color(240,64,52), new Color(240,33,42));
        eventoColorear.colorearBotones(btnBlackbox, new Color(52,149,19), new Color(24,112,24));
                   
    }

    public void setTipoDeOpcion(int tipoDeOpcion) {
        this.tipoDeOpcion = tipoDeOpcion;
    }

    
    
    public void setPrincipal(MenuPrincipal principal) {
        this.principal = principal;
    }
    

    
    private void cargarNuevoPanel(int tipo){//Agregará el nuevo panel a la pantalla principal, recibe le tipo de sala en numero
        //1. General   2.VIP  3.blackbox
        LinkedList<Sala> mostrarSalas=FacadeSala.retornaSalasAReservar(tipo);      
        
        panelSalasAReservar Presenta=new panelSalasAReservar();    
        Presenta.setListaSalas(mostrarSalas);
        Presenta.cargarDatosSalas();
        Presenta.setPantallaInicio(principal);
        Presenta.setSize(principal.panelCentral.getWidth() , principal.panelCentral.getHeight());
        Presenta.setLocation(0, 0);
        principal.panelCentral.removeAll();

        principal.panelCentral.add(Presenta,BorderLayout.CENTER);
        principal.panelCentral.revalidate();
        principal.panelCentral.repaint();
    }
   
    private void cargarPanelReservacionesPorTipoSala(int tipo){
        
        panelVisualizarReservaciones Presenta=new panelVisualizarReservaciones();    
        Presenta.setPresentarInicio(principal);
        Presenta.setListaSalas(FacadeSala.retornaSalasAReservar(tipo));
        Presenta.setSize(principal.panelCentral.getWidth() , principal.panelCentral.getHeight());
        Presenta.setLocation(0, 0);
        principal.panelCentral.removeAll();

        principal.panelCentral.add(Presenta,BorderLayout.CENTER);
        principal.panelCentral.revalidate();
        principal.panelCentral.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTipoSala = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        btnGeneral = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        btnVip = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        btnBlackbox = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblOperacion = new javax.swing.JLabel();

        jLabel19.setText("jLabel19");

        setBackground(new java.awt.Color(51, 51, 51));
        setLayout(new java.awt.GridLayout(3, 1));

        jPanel1.setOpaque(false);

        lblTipoSala.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        lblTipoSala.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoSala.setText("Seleccione el tipo de sala");
        jPanel1.add(lblTipoSala);

        add(jPanel1);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jLabel22.setText(" ");
        jPanel2.add(jLabel22);

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
        jPanel2.add(btnGeneral);

        jLabel18.setText(" ");
        jPanel2.add(jLabel18);

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
        jPanel2.add(btnVip);

        jLabel20.setText(" ");
        jPanel2.add(jLabel20);

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
        jPanel2.add(btnBlackbox);

        jLabel21.setText(" ");
        jPanel2.add(jLabel21);

        add(jPanel2);

        jPanel3.setOpaque(false);

        lblOperacion.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        lblOperacion.setForeground(new java.awt.Color(255, 255, 255));
        lblOperacion.setText("Reservar");
        jPanel3.add(lblOperacion);

        add(jPanel3);
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneralActionPerformed
        if(tipoDeOpcion==1)
            cargarNuevoPanel(1);
        else
            cargarPanelReservacionesPorTipoSala(1);
    }//GEN-LAST:event_btnGeneralActionPerformed

    private void btnVipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVipActionPerformed
        if(tipoDeOpcion==1)
            cargarNuevoPanel(2);
        else
            cargarPanelReservacionesPorTipoSala(2);
    }//GEN-LAST:event_btnVipActionPerformed

    private void btnBlackboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlackboxActionPerformed
        if(tipoDeOpcion==1)
            cargarNuevoPanel(3);
        else
            cargarPanelReservacionesPorTipoSala(3);
    }//GEN-LAST:event_btnBlackboxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBlackbox;
    private javax.swing.JButton btnGeneral;
    private javax.swing.JButton btnVip;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel lblOperacion;
    private javax.swing.JLabel lblTipoSala;
    // End of variables declaration//GEN-END:variables
}
