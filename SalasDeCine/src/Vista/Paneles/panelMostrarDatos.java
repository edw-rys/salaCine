/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;

import Vista.InterfacesGraficas.MenuPrincipal;
import java.awt.BorderLayout;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;


public class panelMostrarDatos extends javax.swing.JPanel {
    private MenuPrincipal pantallaPrincipal =new MenuPrincipal();
    public panelMostrarDatos() {
        initComponents();
        mostrarImagenesPeliculas();
    }

    public void setPantallaPrincipal(MenuPrincipal pantallaPrincipal) {
        this.pantallaPrincipal = pantallaPrincipal;
        
    }
    
   

    private void colocaImagen(int i[]){
        String rutas[]=new String[8];
        rutas[0]="/Imagenes/15_opt.jpg";
        rutas[1]="/Imagenes/14_opt.jpg";
        rutas[2]="/Imagenes/13_opt.jpg";
        rutas[3]="/Imagenes/12_opt.jpg";
        rutas[4]="/Imagenes/11_opt.jpg";
        rutas[5]="/Imagenes/10_opt.jpg";
        rutas[6]="/Imagenes/9_opt.jpg";
        rutas[7]="/Imagenes/8_opt.jpg";
        
        ImageIcon imag;
        imag=new ImageIcon(getClass().getResource(rutas[i[0]]));
        lblImagen1.setIcon(imag);
        imag=new ImageIcon(getClass().getResource(rutas[i[1]]));
        lblImagen2.setIcon(imag);
        imag=new ImageIcon(getClass().getResource(rutas[i[2]]));
        lblImagen3.setIcon(imag);
        imag=new ImageIcon(getClass().getResource(rutas[i[3]]));
        lblImagen4.setIcon(imag);
        imag=new ImageIcon(getClass().getResource(rutas[i[4]]));
        lblImagen5.setIcon(imag);
        imag=new ImageIcon(getClass().getResource(rutas[i[5]]));
        lblImagen6.setIcon(imag);
        imag=new ImageIcon(getClass().getResource(rutas[i[6]]));
        lblImagen7.setIcon(imag);
        imag=new ImageIcon(getClass().getResource(rutas[i[7]]));
        lblImagen8.setIcon(imag);
    }
    
    public void mostrarImagenesPeliculas(){
        
        TimerTask tarea=new TimerTask (){
            int turnoImagem=0;   
            @Override            
            public void run() {
                               
                switch(turnoImagem){
                    case 0:{
                        int i[]={0,1,2,3,4,5,6,7};
                        turnoImagem=1;
                            colocaImagen(i);
                        break;}
                    case 1:{
                        int i[]={1,2,3,4,5,6,7,0};
                            colocaImagen(i);
                            turnoImagem=2;
                         break;
                    }   
                    case 2:{
                        int i[]={2,3,4,5,6,7,0,1};
                            colocaImagen(i);
                            turnoImagem=3;
                        break;}
                    case 3:{
                        int i[]={3,4,5,6,7,0,1,2};
                            colocaImagen(i);
                            turnoImagem=4;
                        break;}
                    case 4:{
                        int i[]={4,5,6,7,0,1,2,3};
                            colocaImagen(i);
                            turnoImagem=5;
                        break;}
                    case 5:{
                        int i[]={5,6,7,0,1,2,3,4};
                            colocaImagen(i);
                            turnoImagem=6;
                        break;}
                    case 6:{
                        int i[]={6,7,0,1,2,3,4,5};
                            colocaImagen(i);
                            turnoImagem=7;
                        break;}
                    case 7:{
                        int i[]={7,0,1,2,3,4,5,6};
                            colocaImagen(i);
                            turnoImagem=0;
                        break;}
            }
          }
       };
        int velocidad=20;
        int velmil=velocidad*50;
       Timer timer =new Timer();
       timer.scheduleAtFixedRate(tarea, velmil, velmil);
    }
    
     
     public void activaRegistroSalas(){
     BotonesRegistrarSala Presenta=new BotonesRegistrarSala();
        Presenta.setSize(PanelOperaciones.getWidth(),PanelOperaciones.getHeight());
        Presenta.setCoordenadasPantalla(pantallaPrincipal);
        Presenta.setLocation(0, 0);
        PanelOperaciones.removeAll();

        PanelOperaciones.add(Presenta , BorderLayout.CENTER);
        PanelOperaciones.revalidate();
        PanelOperaciones.repaint();
     }
     
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCentral = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblImagen1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblImagen2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblImagen3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblImagen4 = new javax.swing.JLabel();
        PanelOperaciones = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        lblImagen5 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblImagen6 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblImagen7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblImagen8 = new javax.swing.JLabel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        panelCentral.setBackground(new java.awt.Color(153, 0, 153));
        panelCentral.setLayout(new javax.swing.BoxLayout(panelCentral, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        lblImagen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/15_opt.jpg"))); // NOI18N
        jPanel1.add(lblImagen1);

        jLabel9.setText("             ");
        jPanel1.add(jLabel9);

        lblImagen2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/15_opt.jpg"))); // NOI18N
        jPanel1.add(lblImagen2);

        jLabel14.setText("              ");
        jPanel1.add(jLabel14);

        lblImagen3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/15_opt.jpg"))); // NOI18N
        jPanel1.add(lblImagen3);

        jLabel16.setText("              ");
        jPanel1.add(jLabel16);

        lblImagen4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/15_opt.jpg"))); // NOI18N
        jPanel1.add(lblImagen4);

        panelCentral.add(jPanel1);

        PanelOperaciones.setBackground(new java.awt.Color(51, 51, 51));
        PanelOperaciones.setLayout(new java.awt.BorderLayout());
        panelCentral.add(PanelOperaciones);

        jPanel8.setBackground(new java.awt.Color(0, 102, 102));

        lblImagen5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/15_opt.jpg"))); // NOI18N
        jPanel8.add(lblImagen5);

        jLabel18.setText("              ");
        jPanel8.add(jLabel18);

        lblImagen6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/15_opt.jpg"))); // NOI18N
        jPanel8.add(lblImagen6);

        jLabel19.setText("              ");
        jPanel8.add(jLabel19);

        lblImagen7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/15_opt.jpg"))); // NOI18N
        jPanel8.add(lblImagen7);

        jLabel20.setText("              ");
        jPanel8.add(jLabel20);

        lblImagen8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/15_opt.jpg"))); // NOI18N
        jPanel8.add(lblImagen8);

        panelCentral.add(jPanel8);

        add(panelCentral);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelOperaciones;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblImagen1;
    private javax.swing.JLabel lblImagen2;
    private javax.swing.JLabel lblImagen3;
    private javax.swing.JLabel lblImagen4;
    private javax.swing.JLabel lblImagen5;
    private javax.swing.JLabel lblImagen6;
    private javax.swing.JLabel lblImagen7;
    private javax.swing.JLabel lblImagen8;
    private javax.swing.JPanel panelCentral;
    // End of variables declaration//GEN-END:variables
}
