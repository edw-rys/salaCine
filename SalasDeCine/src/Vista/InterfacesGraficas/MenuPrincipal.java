package Vista.InterfacesGraficas;

import Alertas.notificacionAlertas.AlertaNotificacion;
import Entidades.Sala;
import OtrosOperaciones.DetalleComponentes;
import OtrosOperaciones.EventosJButton;
import Vista.Paneles.BotonesReservacion;
import Vista.Paneles.panelMostrarDatos;
import Vista.Paneles.panelVisualizarReservaciones;
import Vista.Paneles.panelVisualizarSalas;
import com.placeholder.PlaceHolder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import modelo.operacionesDAO.SalaDAO;


/**
 *
 * @author DELL
 */
public class MenuPrincipal extends javax.swing.JFrame{

    static boolean Maximizar = true;
    int xMouse;
    int yMouse;

    public MenuPrincipal() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);//Modificar el estado de extendido
       // mostrarImagenesPeliculas();
        muestraImg();
       //agregarPanelCentrarInicial();
        diseñarBotones();       
        this.setIconImage(DetalleComponentes.getIconImage());
        añadirTextoSombreado();
    }
    
     private void añadirTextoSombreado(){
        new PlaceHolder(txtCodigoSala,"Código de la Sala");       
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
    
    public void muestraImg(){
        
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
    
   
    private void agregarPanelCentrarInicial(){        
        panelMostrarDatos activaPanel=new panelMostrarDatos();
        activaPanel.setPantallaPrincipal(this);
        activaPanel.activaRegistroSalas();
        activaPanel.setSize(panelCentral.getWidth(),panelCentral.getHeight());
        activaPanel.setLocation(0, 0);
        panelCentral.removeAll();

        panelCentral.add(activaPanel,BorderLayout.CENTER);
        panelCentral.revalidate();
        panelCentral.repaint();
    }
       
      private void diseñarBotones() { 
        EventosJButton eventoColorear=new EventosJButton();
        eventoColorear.colorearBotones(btnRegistrar, new Color(51,51,255),new Color(51,11, 252));
        eventoColorear.colorearBotones(btnMostrarSalas, new Color(204,0,0),new Color(118,0,0));
        eventoColorear.colorearBotones(btnMostrarReservaciones, new Color(204,0,0),new Color(118,0,0));
        eventoColorear.colorearBotones(btnReservar, new Color(51,51,255),new Color(51,11, 252));
        eventoColorear.colorearBotones(btnMinimizar, new Color(255,255,255),new Color(220,220,220));
        eventoColorear.colorearBotones(btnMaximizar, new Color(255,255,255),new Color(220,220,220));        
        eventoColorear.colorearBotones(btnCerrar, new Color(255,255,255),new Color(232,17,35));        
        eventoColorear.colorearBotones(btnMostrarReservPorSala, new Color(52,149,19), new Color(24,112,24));        
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBarraBotones = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        btnMaximizar = new javax.swing.JButton();
        btnMinimizar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        panelParteSuperior = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnRegistrar = new javax.swing.JButton();
        btnMostrarSalas = new javax.swing.JButton();
        txtCodigoSala = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnReservar = new javax.swing.JButton();
        btnMostrarReservaciones = new javax.swing.JButton();
        btnMostrarReservPorSala = new javax.swing.JButton();
        panelDatos = new javax.swing.JPanel();
        panelOeste = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FONDO");
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 900));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanelBarraBotones.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBarraBotones.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanelBarraBotonesMouseDragged(evt);
            }
        });
        jPanelBarraBotones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelBarraBotonesMousePressed(evt);
            }
        });

        btnCerrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Exit.png"))); // NOI18N
        btnCerrar.setToolTipText("");
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setOpaque(true);
        btnCerrar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Exit (2).png"))); // NOI18N
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });

        btnMaximizar.setBackground(new java.awt.Color(255, 255, 255));
        btnMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Maximize.png"))); // NOI18N
        btnMaximizar.setContentAreaFilled(false);
        btnMaximizar.setOpaque(true);
        btnMaximizar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Maximize (2).png"))); // NOI18N
        btnMaximizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMaximizarMouseClicked(evt);
            }
        });

        btnMinimizar.setBackground(new java.awt.Color(255, 255, 255));
        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Minimize.png"))); // NOI18N
        btnMinimizar.setContentAreaFilled(false);
        btnMinimizar.setOpaque(true);
        btnMinimizar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Minimize (2).png"))); // NOI18N
        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 20)); // NOI18N
        jLabel3.setText("CINEMA");

        javax.swing.GroupLayout jPanelBarraBotonesLayout = new javax.swing.GroupLayout(jPanelBarraBotones);
        jPanelBarraBotones.setLayout(jPanelBarraBotonesLayout);
        jPanelBarraBotonesLayout.setHorizontalGroup(
            jPanelBarraBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBarraBotonesLayout.createSequentialGroup()
                .addContainerGap(381, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(607, 607, 607)
                .addComponent(btnMinimizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMaximizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar))
        );
        jPanelBarraBotonesLayout.setVerticalGroup(
            jPanelBarraBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBarraBotonesLayout.createSequentialGroup()
                .addGroup(jPanelBarraBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBarraBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCerrar)
                        .addComponent(btnMaximizar)
                        .addComponent(btnMinimizar))
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelBarraBotones);

        panelParteSuperior.setBackground(new java.awt.Color(255, 255, 255));
        panelParteSuperior.setLayout(new javax.swing.BoxLayout(panelParteSuperior, javax.swing.BoxLayout.LINE_AXIS));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(44, 62, 80));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/imagenCine.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 20)); // NOI18N
        jLabel5.setText("LAS  ");

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 20)); // NOI18N
        jLabel8.setText("FRONTERAS");

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 20)); // NOI18N
        jLabel4.setText("SEPARAN");

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 20)); // NOI18N
        jLabel7.setText("EL CINE ");

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 20)); // NOI18N
        jLabel6.setText("NOS UNE...");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelParteSuperior.add(jPanel6);

        jPanel4.setOpaque(false);

        jLabel10.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 20)); // NOI18N
        jLabel10.setText("SALAS");

        lblBuscar.setBackground(new java.awt.Color(153, 102, 0));
        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/iconoBuscar.png"))); // NOI18N
        lblBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarMouseClicked(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(51, 51, 255));
        btnRegistrar.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnMostrarSalas.setBackground(new java.awt.Color(204, 0, 0));
        btnMostrarSalas.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        btnMostrarSalas.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrarSalas.setText("MOSTRAR SALAS");
        btnMostrarSalas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMostrarSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarSalasActionPerformed(evt);
            }
        });

        txtCodigoSala.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        txtCodigoSala.setBorder(null);
        txtCodigoSala.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addGap(123, 123, 123)
                        .addComponent(btnMostrarSalas))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigoSala, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(lblBuscar)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(txtCodigoSala, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBuscar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnMostrarSalas))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        panelParteSuperior.add(jPanel4);

        jLabel17.setText("   ");
        panelParteSuperior.add(jLabel17);

        jLabel15.setText("    ");
        panelParteSuperior.add(jLabel15);

        jPanel5.setOpaque(false);

        jLabel12.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 20)); // NOI18N
        jLabel12.setText("RESERVACIONES");

        btnReservar.setBackground(new java.awt.Color(51, 51, 255));
        btnReservar.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        btnReservar.setForeground(new java.awt.Color(255, 255, 255));
        btnReservar.setText("Reservar");
        btnReservar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        btnMostrarReservaciones.setBackground(new java.awt.Color(255, 0, 0));
        btnMostrarReservaciones.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        btnMostrarReservaciones.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrarReservaciones.setText("Mostrar Reservaciones");
        btnMostrarReservaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMostrarReservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarReservacionesActionPerformed(evt);
            }
        });

        btnMostrarReservPorSala.setBackground(new java.awt.Color(255, 0, 0));
        btnMostrarReservPorSala.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        btnMostrarReservPorSala.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrarReservPorSala.setText("Mostrar Reservaciones por Sala");
        btnMostrarReservPorSala.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMostrarReservPorSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarReservPorSalaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(btnReservar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addComponent(btnMostrarReservaciones)
                .addGap(20, 20, 20))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btnMostrarReservPorSala)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReservar)
                    .addComponent(btnMostrarReservaciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMostrarReservPorSala)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelParteSuperior.add(jPanel5);

        getContentPane().add(panelParteSuperior);

        panelDatos.setLayout(new javax.swing.BoxLayout(panelDatos, javax.swing.BoxLayout.X_AXIS));

        panelOeste.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1.png"))); // NOI18N

        javax.swing.GroupLayout panelOesteLayout = new javax.swing.GroupLayout(panelOeste);
        panelOeste.setLayout(panelOesteLayout);
        panelOesteLayout.setHorizontalGroup(
            panelOesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelOesteLayout.setVerticalGroup(
            panelOesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, Short.MAX_VALUE)
        );

        panelDatos.add(panelOeste);

        panelCentral.setBackground(new java.awt.Color(0, 102, 102));
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

        javax.swing.GroupLayout PanelOperacionesLayout = new javax.swing.GroupLayout(PanelOperaciones);
        PanelOperaciones.setLayout(PanelOperacionesLayout);
        PanelOperacionesLayout.setHorizontalGroup(
            PanelOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1068, Short.MAX_VALUE)
        );
        PanelOperacionesLayout.setVerticalGroup(
            PanelOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 195, Short.MAX_VALUE)
        );

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

        panelDatos.add(panelCentral);

        getContentPane().add(panelDatos);

        setSize(new java.awt.Dimension(1287, 832));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnMaximizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaximizarMouseClicked
        if (Maximizar){
            MenuPrincipal.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            MenuPrincipal.this.setMaximizedBounds(env.getMaximumWindowBounds());
            Maximizar = false;
        }else{
            setExtendedState(JFrame.NORMAL);
            Maximizar = true;
        }
    }//GEN-LAST:event_btnMaximizarMouseClicked

    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    private void jPanelBarraBotonesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelBarraBotonesMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanelBarraBotonesMousePressed

    private void jPanelBarraBotonesMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelBarraBotonesMouseDragged
        if(Maximizar){
            int x = evt.getXOnScreen();
            int y = evt.getYOnScreen();
            this.setLocation(x - xMouse, y - yMouse);
       }
    }//GEN-LAST:event_jPanelBarraBotonesMouseDragged

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        agregarPanelCentrarInicial();                                
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnMostrarSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarSalasActionPerformed
        panelVisualizarSalas Presenta=new panelVisualizarSalas();    
        Presenta.setPresentarInicio(this);
        Presenta.setSize(panelCentral.getWidth() , panelCentral.getHeight());
        Presenta.setLocation(0, 0);
        panelCentral.removeAll();

        panelCentral.add(Presenta,BorderLayout.CENTER);
        panelCentral.revalidate();
        panelCentral.repaint();
    }//GEN-LAST:event_btnMostrarSalasActionPerformed

    private void lblBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMouseClicked
        SalaDAO retornaSala =new SalaDAO();
        Sala visualizar= retornaSala.buscarSala(txtCodigoSala.getText());
        if(visualizar ==null){
            AlertaNotificacion notificar=new AlertaNotificacion(null, true);
            notificar.setLblTtulo("Error");
            notificar.setLblSubT("Por favor digite un código correcto");
            notificar.setColorBoton(Color.RED);
            notificar.agregarImagen(0);
            notificar.colorFondoBoton(new Color(69,0,0));    
            notificar.reproducirSonido(0);
            notificar.setVisible(true);
            return;
        }
        
        DatosSala  presentarDetalles =new DatosSala();
        presentarDetalles.setVisualizarSala(visualizar);
        presentarDetalles.cargarReservaciones();
        presentarDetalles.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_lblBuscarMouseClicked

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        
        BotonesReservacion activaPanel=new BotonesReservacion();
        activaPanel.setTipoDeOpcion(1);
        activaPanel.setPrincipal(this);
        activaPanel.setSize(panelCentral.getWidth(),panelCentral.getHeight());
        activaPanel.setLocation(0, 0);
        panelCentral.removeAll();
        JPanel panelRelleno =new JPanel();
        panelRelleno.setOpaque(false);
        JPanel panelRelleno2 =new JPanel();
        panelRelleno2.setOpaque(false);
       
        panelCentral.add(panelRelleno,BorderLayout.NORTH );
        panelCentral.add(activaPanel,BorderLayout.CENTER);
        
        panelCentral.add(panelRelleno2,BorderLayout.SOUTH );
        panelCentral.revalidate();
        panelCentral.repaint();
    }//GEN-LAST:event_btnReservarActionPerformed

    private void btnMostrarReservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarReservacionesActionPerformed
        panelVisualizarReservaciones Presenta=new panelVisualizarReservaciones();    
        Presenta.setPresentarInicio(this);
        Presenta.setSize(panelCentral.getWidth() , panelCentral.getHeight());
        Presenta.setLocation(0, 0);
        panelCentral.removeAll();

        panelCentral.add(Presenta,BorderLayout.CENTER);
        panelCentral.revalidate();
        panelCentral.repaint();
    }//GEN-LAST:event_btnMostrarReservacionesActionPerformed

    private void btnMostrarReservPorSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarReservPorSalaActionPerformed
        BotonesReservacion activaPanel=new BotonesReservacion();
        activaPanel.setPrincipal(this);
        activaPanel.lblOperacion.setText("Mostrar Reservaciones");
        activaPanel.setSize(panelCentral.getWidth(),panelCentral.getHeight());
        activaPanel.setLocation(0, 0);
        panelCentral.removeAll();
        JPanel panelRelleno =new JPanel();
        panelRelleno.setOpaque(false);
        JPanel panelRelleno2 =new JPanel();
        panelRelleno2.setOpaque(false);
       
        panelCentral.add(panelRelleno,BorderLayout.NORTH );
        panelCentral.add(activaPanel,BorderLayout.CENTER);
        
        panelCentral.add(panelRelleno2,BorderLayout.SOUTH );
        panelCentral.revalidate();
        panelCentral.repaint();
    }//GEN-LAST:event_btnMostrarReservPorSalaActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelOperaciones;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnMaximizar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnMostrarReservPorSala;
    private javax.swing.JButton btnMostrarReservaciones;
    private javax.swing.JButton btnMostrarSalas;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnReservar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelBarraBotones;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblImagen1;
    private javax.swing.JLabel lblImagen2;
    private javax.swing.JLabel lblImagen3;
    private javax.swing.JLabel lblImagen4;
    private javax.swing.JLabel lblImagen5;
    private javax.swing.JLabel lblImagen6;
    private javax.swing.JLabel lblImagen7;
    private javax.swing.JLabel lblImagen8;
    public javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelOeste;
    private javax.swing.JPanel panelParteSuperior;
    private javax.swing.JTextField txtCodigoSala;
    // End of variables declaration//GEN-END:variables

 
    


}
