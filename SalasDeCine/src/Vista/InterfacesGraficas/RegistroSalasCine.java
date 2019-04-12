package Vista.InterfacesGraficas;

import Alertas.notificacionAlertas.*;
import OtrosOperaciones.DetalleComponentes;
import Entidades.*;
import OtrosOperaciones.EventosJButton;
import javax.swing.JFrame;
import modelo.operacionesDAO.SalaDAO;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

public class RegistroSalasCine extends javax.swing.JFrame {
    private boolean activarBoton =false;
    private int tamañoArreglo=0;
    private String tipo;
    private int id;
    private Sala edicionSala=null;
    private String imagenSala="ninguna";
    
    //Sala a guardar
    private Sala SalaAGuardar=null;
    //
    
    public RegistroSalasCine() {
        initComponents();
        bloquearOpciones();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);//Modificar el estado de extendido
        CargarEventos();
        this.setIconImage(DetalleComponentes.getIconImage());
        this.setTitle("Rgistro de Sala");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panelVentana = new javax.swing.JPanel();
        panelSuperior = new javax.swing.JPanel();
        lblTipoSala = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        panelDatos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        panelEscribeDatos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lblAtributo1 = new javax.swing.JLabel();
        cmbAtributo1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        lblAtributo2 = new javax.swing.JLabel();
        txtAtributo2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        panelImagen = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        btnBuscarImagen = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PanelHorarios = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        panelDiasHoras = new javax.swing.JPanel();
        lblHoraInHoraOut2 = new javax.swing.JLabel();
        lblHoraInHoraOut = new javax.swing.JLabel();
        lblHoraInHoraOut1 = new javax.swing.JLabel();
        OpDiaLunes = new javax.swing.JRadioButton();
        HoraEntradaLunes = new javax.swing.JComboBox<>();
        HoraSalidaLunes = new javax.swing.JComboBox<>();
        OpDiaMartes = new javax.swing.JRadioButton();
        HoraEntradaMartes = new javax.swing.JComboBox<>();
        HoraSalidaMartes = new javax.swing.JComboBox<>();
        OpDiaMiercoles = new javax.swing.JRadioButton();
        HoraEntradaMiercoles = new javax.swing.JComboBox<>();
        HoraSalidaMiercoles = new javax.swing.JComboBox<>();
        OpDiaJueves = new javax.swing.JRadioButton();
        HoraEntradaJueves = new javax.swing.JComboBox<>();
        HoraSalidaJueves = new javax.swing.JComboBox<>();
        OpDiaViernes = new javax.swing.JRadioButton();
        HoraEntradaViernes = new javax.swing.JComboBox<>();
        HoraSalidaViernes = new javax.swing.JComboBox<>();
        OpDiaSabado = new javax.swing.JRadioButton();
        HoraEntradaSbd = new javax.swing.JComboBox<>();
        HoraSalidaSbd = new javax.swing.JComboBox<>();
        OpDiaDomingo = new javax.swing.JRadioButton();
        HoraEntradaDmng = new javax.swing.JComboBox<>();
        HoraSalidaDmng = new javax.swing.JComboBox<>();
        lblErrorFecha = new javax.swing.JLabel();
        lblMensajeErrorHorario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        panelVentana.setBackground(new java.awt.Color(255, 255, 255));
        panelVentana.setLayout(new java.awt.BorderLayout());

        panelSuperior.setBackground(new java.awt.Color(51, 51, 51));

        lblTipoSala.setFont(new java.awt.Font("Myanmar Text", 1, 24)); // NOI18N
        lblTipoSala.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoSala.setText("Tipo de Sala");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/cine .png"))); // NOI18N

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/fondoCine.jpg"))); // NOI18N
        jLabel20.setText("jLabel20");

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblTipoSala, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(lblTipoSala, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        panelVentana.add(panelSuperior, java.awt.BorderLayout.NORTH);

        panelDatos.setLayout(new javax.swing.BoxLayout(panelDatos, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        panelEscribeDatos.setOpaque(false);
        panelEscribeDatos.setLayout(new java.awt.GridLayout(11, 2));

        jLabel2.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Codigo de la Sala: ");
        panelEscribeDatos.add(jLabel2);

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Myanmar Text", 0, 16)); // NOI18N
        txtCodigo.setBorder(null);
        panelEscribeDatos.add(txtCodigo);

        jLabel5.setText(" ");
        panelEscribeDatos.add(jLabel5);
        panelEscribeDatos.add(jSeparator1);

        jLabel3.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Nombre                                      *");
        panelEscribeDatos.add(jLabel3);

        txtNombre.setFont(new java.awt.Font("Myanmar Text", 0, 16)); // NOI18N
        txtNombre.setBorder(null);
        panelEscribeDatos.add(txtNombre);

        jLabel10.setText(" ");
        panelEscribeDatos.add(jLabel10);
        panelEscribeDatos.add(jSeparator2);

        jLabel4.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Precio para Reservar               *");
        panelEscribeDatos.add(jLabel4);

        txtPrecio.setFont(new java.awt.Font("Myanmar Text", 0, 16)); // NOI18N
        txtPrecio.setBorder(null);
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });
        panelEscribeDatos.add(txtPrecio);

        jLabel11.setText(" ");
        panelEscribeDatos.add(jLabel11);
        panelEscribeDatos.add(jSeparator3);

        lblAtributo1.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        lblAtributo1.setForeground(new java.awt.Color(51, 51, 51));
        lblAtributo1.setText("atributo1");
        panelEscribeDatos.add(lblAtributo1);

        panelEscribeDatos.add(cmbAtributo1);

        jLabel12.setText(" ");
        panelEscribeDatos.add(jLabel12);
        panelEscribeDatos.add(jSeparator4);

        lblAtributo2.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        lblAtributo2.setForeground(new java.awt.Color(51, 51, 51));
        lblAtributo2.setText("atributo2");
        panelEscribeDatos.add(lblAtributo2);

        txtAtributo2.setFont(new java.awt.Font("Myanmar Text", 0, 16)); // NOI18N
        txtAtributo2.setBorder(null);
        panelEscribeDatos.add(txtAtributo2);

        jLabel13.setText(" ");
        panelEscribeDatos.add(jLabel13);
        panelEscribeDatos.add(jSeparator6);

        jLabel16.setText(" ");
        panelEscribeDatos.add(jLabel16);

        jPanel1.add(panelEscribeDatos);

        panelImagen.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Imagen de la Sala");
        jPanel4.add(jLabel6);

        panelImagen.add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jLabel19.setText("  ");
        jPanel6.add(jLabel19);

        btnBuscarImagen.setText("Buscar imagen");
        btnBuscarImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarImagenMouseClicked(evt);
            }
        });
        jPanel6.add(btnBuscarImagen);

        jLabel14.setText("  ");
        jPanel6.add(jLabel14);

        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        jLabel15.setText("             ");
        jPanel3.add(jLabel15, java.awt.BorderLayout.PAGE_END);

        jLabel17.setText("                               ");
        jPanel3.add(jLabel17, java.awt.BorderLayout.LINE_END);

        jLabel18.setText("                                        ");
        jPanel3.add(jLabel18, java.awt.BorderLayout.LINE_START);

        panelImagen.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jLabel9.setText("             ");
        jPanel2.add(jLabel9);

        lblImagen.setText("    Haga clic en el botón \"Buscar Imagen\" para agregar una imagen");
        lblImagen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        lblImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImagenMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5);

        jLabel1.setText("            ");
        jPanel2.add(jLabel1);

        panelImagen.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.add(panelImagen);

        panelDatos.add(jPanel1);

        PanelHorarios.setBackground(new java.awt.Color(51, 51, 51));

        jLabel8.setFont(new java.awt.Font("MV Boli", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 204));
        jLabel8.setText("Horario   *");

        btnCancelar.setBackground(new java.awt.Color(0, 102, 102));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/iconoHome.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/iconoSave.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerifyInputWhenFocusTarget(false);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        panelDiasHoras.setBackground(new java.awt.Color(0, 102, 102));
        panelDiasHoras.setLayout(new java.awt.GridLayout(9, 3, 0, 2));

        lblHoraInHoraOut2.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        lblHoraInHoraOut2.setForeground(new java.awt.Color(0, 0, 102));
        lblHoraInHoraOut2.setText("       Días");
        panelDiasHoras.add(lblHoraInHoraOut2);

        lblHoraInHoraOut.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        lblHoraInHoraOut.setForeground(new java.awt.Color(0, 0, 102));
        lblHoraInHoraOut.setText("Hora de entrada");
        panelDiasHoras.add(lblHoraInHoraOut);

        lblHoraInHoraOut1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        lblHoraInHoraOut1.setForeground(new java.awt.Color(0, 0, 102));
        lblHoraInHoraOut1.setText("   Hora de salida");
        panelDiasHoras.add(lblHoraInHoraOut1);

        OpDiaLunes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        OpDiaLunes.setForeground(new java.awt.Color(0, 204, 204));
        OpDiaLunes.setText("LUNES");
        OpDiaLunes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OpDiaLunes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpDiaLunesActionPerformed(evt);
            }
        });
        panelDiasHoras.add(OpDiaLunes);

        HoraEntradaLunes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        HoraEntradaLunes.setSelectedIndex(7);
        HoraEntradaLunes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                HoraEntradaLunesItemStateChanged(evt);
            }
        });
        panelDiasHoras.add(HoraEntradaLunes);

        HoraSalidaLunes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        HoraSalidaLunes.setSelectedIndex(1);
        HoraSalidaLunes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                HoraSalidaLunesItemStateChanged(evt);
            }
        });
        panelDiasHoras.add(HoraSalidaLunes);

        OpDiaMartes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        OpDiaMartes.setForeground(new java.awt.Color(0, 204, 204));
        OpDiaMartes.setText("MARTES");
        OpDiaMartes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OpDiaMartes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpDiaMartesActionPerformed(evt);
            }
        });
        panelDiasHoras.add(OpDiaMartes);

        HoraEntradaMartes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        HoraEntradaMartes.setSelectedIndex(7);
        HoraEntradaMartes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                HoraEntradaMartesItemStateChanged(evt);
            }
        });
        panelDiasHoras.add(HoraEntradaMartes);

        HoraSalidaMartes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        HoraSalidaMartes.setSelectedIndex(9);
        HoraSalidaMartes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                HoraSalidaMartesItemStateChanged(evt);
            }
        });
        panelDiasHoras.add(HoraSalidaMartes);

        OpDiaMiercoles.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        OpDiaMiercoles.setForeground(new java.awt.Color(0, 204, 204));
        OpDiaMiercoles.setText("MIERCOLES");
        OpDiaMiercoles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OpDiaMiercoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpDiaMiercolesActionPerformed(evt);
            }
        });
        panelDiasHoras.add(OpDiaMiercoles);

        HoraEntradaMiercoles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        HoraEntradaMiercoles.setSelectedIndex(7);
        HoraEntradaMiercoles.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                HoraEntradaMiercolesItemStateChanged(evt);
            }
        });
        panelDiasHoras.add(HoraEntradaMiercoles);

        HoraSalidaMiercoles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        HoraSalidaMiercoles.setSelectedIndex(9);
        HoraSalidaMiercoles.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                HoraSalidaMiercolesItemStateChanged(evt);
            }
        });
        panelDiasHoras.add(HoraSalidaMiercoles);

        OpDiaJueves.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        OpDiaJueves.setForeground(new java.awt.Color(0, 204, 204));
        OpDiaJueves.setText("JUEVES");
        OpDiaJueves.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OpDiaJueves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpDiaJuevesActionPerformed(evt);
            }
        });
        panelDiasHoras.add(OpDiaJueves);

        HoraEntradaJueves.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        HoraEntradaJueves.setSelectedIndex(7);
        HoraEntradaJueves.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                HoraEntradaJuevesItemStateChanged(evt);
            }
        });
        panelDiasHoras.add(HoraEntradaJueves);

        HoraSalidaJueves.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        HoraSalidaJueves.setSelectedIndex(9);
        HoraSalidaJueves.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                HoraSalidaJuevesItemStateChanged(evt);
            }
        });
        panelDiasHoras.add(HoraSalidaJueves);

        OpDiaViernes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        OpDiaViernes.setForeground(new java.awt.Color(0, 204, 204));
        OpDiaViernes.setText("VIERNES");
        OpDiaViernes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OpDiaViernes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpDiaViernesActionPerformed(evt);
            }
        });
        panelDiasHoras.add(OpDiaViernes);

        HoraEntradaViernes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        HoraEntradaViernes.setSelectedIndex(7);
        HoraEntradaViernes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                HoraEntradaViernesItemStateChanged(evt);
            }
        });
        panelDiasHoras.add(HoraEntradaViernes);

        HoraSalidaViernes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        HoraSalidaViernes.setSelectedIndex(9);
        HoraSalidaViernes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                HoraSalidaViernesItemStateChanged(evt);
            }
        });
        panelDiasHoras.add(HoraSalidaViernes);

        OpDiaSabado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        OpDiaSabado.setForeground(new java.awt.Color(0, 204, 204));
        OpDiaSabado.setText("SABADO");
        OpDiaSabado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OpDiaSabado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpDiaSabadoActionPerformed(evt);
            }
        });
        panelDiasHoras.add(OpDiaSabado);

        HoraEntradaSbd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        HoraEntradaSbd.setSelectedIndex(7);
        HoraEntradaSbd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                HoraEntradaSbdItemStateChanged(evt);
            }
        });
        panelDiasHoras.add(HoraEntradaSbd);

        HoraSalidaSbd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        HoraSalidaSbd.setSelectedIndex(9);
        HoraSalidaSbd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                HoraSalidaSbdItemStateChanged(evt);
            }
        });
        panelDiasHoras.add(HoraSalidaSbd);

        OpDiaDomingo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        OpDiaDomingo.setForeground(new java.awt.Color(0, 204, 204));
        OpDiaDomingo.setText("DOMINGO");
        OpDiaDomingo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OpDiaDomingo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpDiaDomingoActionPerformed(evt);
            }
        });
        panelDiasHoras.add(OpDiaDomingo);

        HoraEntradaDmng.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        HoraEntradaDmng.setSelectedIndex(7);
        HoraEntradaDmng.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                HoraEntradaDmngItemStateChanged(evt);
            }
        });
        panelDiasHoras.add(HoraEntradaDmng);

        HoraSalidaDmng.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        HoraSalidaDmng.setSelectedIndex(9);
        HoraSalidaDmng.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                HoraSalidaDmngItemStateChanged(evt);
            }
        });
        panelDiasHoras.add(HoraSalidaDmng);

        lblErrorFecha.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        lblErrorFecha.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorFecha.setOpaque(true);

        lblMensajeErrorHorario.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        lblMensajeErrorHorario.setForeground(new java.awt.Color(153, 0, 0));
        lblMensajeErrorHorario.setOpaque(true);

        javax.swing.GroupLayout PanelHorariosLayout = new javax.swing.GroupLayout(PanelHorarios);
        PanelHorarios.setLayout(PanelHorariosLayout);
        PanelHorariosLayout.setHorizontalGroup(
            PanelHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHorariosLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel8)
                .addGap(114, 114, 114)
                .addComponent(panelDiasHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(PanelHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelHorariosLayout.createSequentialGroup()
                        .addGap(0, 267, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnGuardar))
                    .addGroup(PanelHorariosLayout.createSequentialGroup()
                        .addGroup(PanelHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblErrorFecha)
                            .addGroup(PanelHorariosLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(lblMensajeErrorHorario)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelHorariosLayout.setVerticalGroup(
            PanelHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHorariosLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelHorariosLayout.createSequentialGroup()
                .addGroup(PanelHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHorariosLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelDiasHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelHorariosLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblErrorFecha)
                        .addGap(31, 31, 31)
                        .addGroup(PanelHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addComponent(lblMensajeErrorHorario)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        panelDatos.add(PanelHorarios);

        panelVentana.add(panelDatos, java.awt.BorderLayout.CENTER);

        jScrollPane1.setViewportView(panelVentana);

        getContentPane().add(jScrollPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void OpDiaLunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpDiaLunesActionPerformed
        if(OpDiaLunes.isSelected())
        {
            HoraEntradaLunes.enable();
            HoraSalidaLunes.enable();
            tamañoArreglo++;
        }
        else{
            HoraEntradaLunes.disable();
            HoraSalidaLunes.disable();
            tamañoArreglo--;
        }
        HabilitarOpciones();
        if(edicionSala == null )
            return;
        if(!OpDiaLunes.isSelected()){
            if( edicionSala.horarioNoPermiteCambioDia(1)){
            activarBoton=true;
            lblErrorFecha.setText("");
        }else{
            activarBoton=false;
            lblErrorFecha.setText("No se puede desmarcar este dia - Una reservación se ha hecho este día");
        }
        }else
            lblErrorFecha.setText("");
              
    }//GEN-LAST:event_OpDiaLunesActionPerformed

    private void HoraEntradaLunesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_HoraEntradaLunesItemStateChanged
        DetalleComponentes.actualizarItems(HoraEntradaLunes, HoraSalidaLunes,24);
        if(edicionSala==null)
            return;
        evitarCambioHorarioNopermitido(1,HoraEntradaLunes , HoraSalidaLunes);
    }//GEN-LAST:event_HoraEntradaLunesItemStateChanged

    private void OpDiaMartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpDiaMartesActionPerformed
        if(OpDiaMartes.isSelected())
        {
            HoraEntradaMartes.enable();
            HoraSalidaMartes.enable();
            tamañoArreglo++;
        }
        else{
            HoraEntradaMartes.disable();
            HoraSalidaMartes.disable();
            tamañoArreglo--;
        }
        HabilitarOpciones();
        if(edicionSala == null )
            return;
        if(!OpDiaMartes.isSelected()){
            if( edicionSala.horarioNoPermiteCambioDia(2)){
                activarBoton=true;
                lblErrorFecha.setText("");
        }else{
                System.out.println("dc");
            activarBoton=false;
            lblErrorFecha.setText("No se puede desmarcar este dia - Una reservación se ha hecho este día");
        }
        }else
            lblErrorFecha.setText("");
        
    }//GEN-LAST:event_OpDiaMartesActionPerformed

    private void HoraEntradaMartesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_HoraEntradaMartesItemStateChanged
        DetalleComponentes.actualizarItems(HoraEntradaMartes, HoraSalidaMartes,24);
        if(edicionSala==null)
            return;
        evitarCambioHorarioNopermitido(2, HoraEntradaMartes, HoraSalidaMartes);
    }//GEN-LAST:event_HoraEntradaMartesItemStateChanged

    private void OpDiaMiercolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpDiaMiercolesActionPerformed
        if(OpDiaMiercoles.isSelected())
        {
            HoraEntradaMiercoles.enable();
            HoraSalidaMiercoles.enable();
            tamañoArreglo++;
        }
        else{
            HoraEntradaMiercoles.disable();
            HoraSalidaMiercoles.disable();
            tamañoArreglo--;
        }
        HabilitarOpciones();
        if(edicionSala == null )
            return;
        if(!OpDiaMiercoles.isSelected()){
            if( edicionSala.horarioNoPermiteCambioDia(3)){
            activarBoton=true;
            lblErrorFecha.setText("");
        }else{
            activarBoton=false;
            lblErrorFecha.setText("No se puede desmarcar este dia - Una reservación se ha hecho este día");
        }
        }else
            lblErrorFecha.setText("");
    }//GEN-LAST:event_OpDiaMiercolesActionPerformed

    private void HoraEntradaMiercolesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_HoraEntradaMiercolesItemStateChanged
        DetalleComponentes.actualizarItems(HoraEntradaMiercoles, HoraSalidaMiercoles,24);
        if(edicionSala==null)
            return;
        evitarCambioHorarioNopermitido(3,HoraEntradaMiercoles, HoraSalidaMiercoles);
    }//GEN-LAST:event_HoraEntradaMiercolesItemStateChanged

    private void OpDiaJuevesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpDiaJuevesActionPerformed
        if(OpDiaJueves.isSelected())
        {
            HoraEntradaJueves.enable();
            HoraSalidaJueves.enable();
            tamañoArreglo++;
        }
        else{
            HoraEntradaJueves.disable();
            HoraSalidaJueves.disable();
            tamañoArreglo--;
        }
        HabilitarOpciones();
        if(edicionSala == null )
            return;
        if(!OpDiaJueves.isSelected()){
            if( edicionSala.horarioNoPermiteCambioDia(4)){
            activarBoton=true;
            lblErrorFecha.setText("");
        }else{
            activarBoton=false;
            lblErrorFecha.setText("No se puede desmarcar este dia - Una reservación se ha hecho este día");
        }
        }else
            lblErrorFecha.setText("");
    }//GEN-LAST:event_OpDiaJuevesActionPerformed

    private void HoraEntradaJuevesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_HoraEntradaJuevesItemStateChanged
        DetalleComponentes.actualizarItems(HoraEntradaJueves, HoraSalidaJueves,24);
        if(edicionSala==null)
            return;
        evitarCambioHorarioNopermitido(4,HoraEntradaJueves,HoraSalidaJueves);
    }//GEN-LAST:event_HoraEntradaJuevesItemStateChanged

    private void OpDiaViernesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpDiaViernesActionPerformed

        if(OpDiaViernes.isSelected())
        {
            HoraEntradaViernes.enable();
            HoraSalidaViernes.enable();
            tamañoArreglo++;
        }
        else{
            HoraEntradaViernes.disable();
            HoraSalidaViernes.disable();
            tamañoArreglo--;
        }
        HabilitarOpciones();
        if(edicionSala == null )
            return;
        if(!OpDiaViernes.isSelected()){
            if( edicionSala.horarioNoPermiteCambioDia(5)){
            activarBoton=true;
            lblErrorFecha.setText("");
        }else{
            activarBoton=false;
            lblErrorFecha.setText("No se puede desmarcar este dia - Una reservación se ha hecho este día");
        }
        }else
            lblErrorFecha.setText("");
    }//GEN-LAST:event_OpDiaViernesActionPerformed

    private void HoraEntradaViernesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_HoraEntradaViernesItemStateChanged
        DetalleComponentes.actualizarItems(HoraEntradaViernes, HoraSalidaViernes,24);
        if(edicionSala==null)
            return;
        evitarCambioHorarioNopermitido(5, HoraEntradaViernes,HoraSalidaViernes);
    }//GEN-LAST:event_HoraEntradaViernesItemStateChanged

    private void OpDiaSabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpDiaSabadoActionPerformed
        if(OpDiaSabado.isSelected())
        {
            HoraEntradaSbd.enable();
            HoraSalidaSbd.enable();
            tamañoArreglo++;
        }
        else{
            HoraEntradaSbd.disable();
            HoraSalidaSbd.disable();
            tamañoArreglo--;
        }
        HabilitarOpciones();
        if(edicionSala == null )
            return;
        if(!OpDiaSabado.isSelected()){
            if( edicionSala.horarioNoPermiteCambioDia(6)){
            activarBoton=true;
            lblErrorFecha.setText("");
        }else{
            activarBoton=false;
            lblErrorFecha.setText("No se puede desmarcar este dia - Una reservación se ha hecho este día");
        }
        }else
            lblErrorFecha.setText("");
    }//GEN-LAST:event_OpDiaSabadoActionPerformed

    private void HoraEntradaSbdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_HoraEntradaSbdItemStateChanged
        DetalleComponentes.actualizarItems(HoraEntradaSbd, HoraSalidaSbd,24);
        if(edicionSala==null)
            return;
        evitarCambioHorarioNopermitido(6,HoraEntradaSbd, HoraSalidaSbd);
    }//GEN-LAST:event_HoraEntradaSbdItemStateChanged

    private void OpDiaDomingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpDiaDomingoActionPerformed
        if(OpDiaDomingo.isSelected())
        {
            HoraEntradaDmng.enable();
            HoraSalidaDmng.enable();
            tamañoArreglo++;
        }
        else{
            HoraEntradaDmng.disable();
            HoraSalidaDmng.disable();
            tamañoArreglo--;
        }
        HabilitarOpciones();
        if(edicionSala == null )
            return;
        if(!OpDiaDomingo.isSelected()){
            if( edicionSala.horarioNoPermiteCambioDia(0)){
            activarBoton=true;
            lblErrorFecha.setText("");
        }else{
            activarBoton=false;
            lblErrorFecha.setText("No se puede desmarcar este dia - Una reservación se ha hecho este día");
        }
        }else
            lblErrorFecha.setText("");
    }//GEN-LAST:event_OpDiaDomingoActionPerformed

    private void HoraEntradaDmngItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_HoraEntradaDmngItemStateChanged
        DetalleComponentes.actualizarItems(HoraEntradaDmng, HoraSalidaDmng,24);
        if(edicionSala==null)
            return;
        evitarCambioHorarioNopermitido(0,HoraEntradaDmng,HoraSalidaDmng);
    }//GEN-LAST:event_HoraEntradaDmngItemStateChanged

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        HabilitarOpciones();
        AlertaNotificacion notificar=new AlertaNotificacion(this, true);
        if(!activarBoton)
        {
            notificar.setLblTtulo("Error");
            notificar.setLblSubT("Hay campos vacíos o datos erroneos");
            notificar.setColorBoton(Color.red);
            notificar.agregarImagen(0);
            notificar.colorFondoBoton(new Color(69,0,0));
            notificar.setVisible(true);
            notificar.reproducirSonido(2);
            return;
        }
        //verificar codigo ya guardado en la base de datos
        
        
        SalaDAO verificarCOD=new SalaDAO();
        

        int i=tamañoArreglo;
        Horario horarioSala=new Horario(diasSeleccionados(i), HorasEntrada(i), HorasSalida(i));
        //Sala actual=null;        
        if(edicionSala!=null){
            SalaAGuardar=edicionSala;
            
            if( SalaAGuardar instanceof SalaGeneral ){
                SalaGeneral actualizarSala=(SalaGeneral ) SalaAGuardar;
                actualizarSala.setPromiciones((String)cmbAtributo1.getSelectedItem());
                actualizarSala.setX(txtAtributo2.getText());
                SalaAGuardar=actualizarSala;            
            }else{
                if(SalaAGuardar instanceof SalaVIP ){
                    SalaVIP actualizarSala=(SalaVIP ) SalaAGuardar;                    
                    actualizarSala.setModeloGafas3D((String)cmbAtributo1.getSelectedItem());
                    actualizarSala.setServicioAdicionalPaga(txtAtributo2.getText());
                    SalaAGuardar=actualizarSala;                        
                }else{
                    SalaBlackBox actualizarSala=( SalaBlackBox ) SalaAGuardar;
                    actualizarSala.setTipoAsiento((String)cmbAtributo1.getSelectedItem());
                    actualizarSala.setServiciAdicionalGratuitos(txtAtributo2.getText());
                    SalaAGuardar=actualizarSala;                        
                }
            }            
        }else{
            if( SalaAGuardar instanceof SalaGeneral ){
                SalaGeneral actualizarSala=new SalaGeneral();
                actualizarSala.setPromiciones((String)cmbAtributo1.getSelectedItem());
                actualizarSala.setX(txtAtributo2.getText());
                SalaAGuardar=actualizarSala;            
            }else{
                if(SalaAGuardar instanceof SalaVIP ){
                    SalaVIP actualizarSala=new SalaVIP();
                    actualizarSala.setModeloGafas3D((String)cmbAtributo1.getSelectedItem());
                    actualizarSala.setServicioAdicionalPaga(txtAtributo2.getText());
                    SalaAGuardar=actualizarSala;    
                    
                }else{
                    SalaBlackBox actualizarSala=new SalaBlackBox();
                    actualizarSala.setTipoAsiento((String)cmbAtributo1.getSelectedItem());
                    actualizarSala.setServiciAdicionalGratuitos(txtAtributo2.getText());
                    SalaAGuardar=actualizarSala;    
                    
                }
            }
            SalaAGuardar.setId(id);
            SalaAGuardar.setCodigo( txtCodigo.getText());
        }
        SalaAGuardar.setNombre(txtNombre.getText());
        SalaAGuardar.setHorario(horarioSala);
        SalaAGuardar.setCostoReservacionPorHora(Double.parseDouble(txtPrecio.getText()));
        SalaAGuardar.setImagen(imagenSala);
        System.out.println("Dirección de la imagen-> "+SalaAGuardar.getImagen());
        int guardadoCorrecto=0;
        if(edicionSala ==null)
            guardadoCorrecto=verificarCOD.guardar(SalaAGuardar);
        else
            guardadoCorrecto= verificarCOD.editar(SalaAGuardar);
        if(guardadoCorrecto>0)
        {
            notificar.setLblTtulo("Correcto");
            notificar.setLblSubT("Datos Guardados Exitosamente");
            notificar.setColorBoton(Color.cyan);
            notificar.agregarImagen(1);
            notificar.colorFondoBoton(new Color(0,102,102));
            notificar.reproducirSonido(1);
        }
        else{
            notificar.setLblTtulo("Error");
            notificar.setLblSubT("No se pudo guardar información");
            notificar.setColorBoton(Color.red);
            notificar.agregarImagen(0);
            notificar.colorFondoBoton(new Color(69,0,0));
        }
        notificar.setVisible(true);
        this.setVisible(false);
        MenuPrincipal Sala=new MenuPrincipal();
        Sala.setVisible(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if(activarBoton)
        {
            AlertaOperaciones c=new AlertaOperaciones(this,true);
            c.setLblTtulo("¿ESTAS SEGURO?");
            c.setLblSubT("Se perderán los datos ingresados");            
            c.setVisible(true);
            //Verificar boton presionado
            if(!c.isAceptar())
            return;
        }
        this.setVisible(false);
        MenuPrincipal Sala=new MenuPrincipal();
        Sala.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarImagenMouseClicked
        //Buscar imagen
        seleccionarImagen();
    }//GEN-LAST:event_btnBuscarImagenMouseClicked

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        char caracter= evt.getKeyChar();  
        if (((caracter < '0') || (caracter > '9')) 
            && (caracter != java.awt.event.KeyEvent.VK_BACK_SPACE)
            && (caracter != '.' || txtPrecio.getText().contains(".")) ) {
                evt.consume();
        }
        txtPrecio.setForeground(Color.black);
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void lblImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenMouseClicked
        seleccionarImagen();
    }//GEN-LAST:event_lblImagenMouseClicked

    private void HoraSalidaLunesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_HoraSalidaLunesItemStateChanged
        if(edicionSala==null)
            return;
        evitarCambioHorarioNopermitido(1,HoraEntradaLunes, HoraSalidaLunes);
    }//GEN-LAST:event_HoraSalidaLunesItemStateChanged

    private void HoraSalidaMartesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_HoraSalidaMartesItemStateChanged
        if(edicionSala==null)
            return;
        evitarCambioHorarioNopermitido(2,HoraEntradaMartes, HoraSalidaMartes);
    }//GEN-LAST:event_HoraSalidaMartesItemStateChanged

    private void HoraSalidaMiercolesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_HoraSalidaMiercolesItemStateChanged
        if(edicionSala==null)
            return;
        evitarCambioHorarioNopermitido(3, HoraEntradaMiercoles, HoraSalidaMiercoles);
    }//GEN-LAST:event_HoraSalidaMiercolesItemStateChanged

    private void HoraSalidaJuevesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_HoraSalidaJuevesItemStateChanged
        if(edicionSala==null)
            return;
        evitarCambioHorarioNopermitido(4, HoraEntradaJueves, HoraSalidaJueves);
    }//GEN-LAST:event_HoraSalidaJuevesItemStateChanged

    private void HoraSalidaViernesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_HoraSalidaViernesItemStateChanged
        if(edicionSala==null)
            return;
        evitarCambioHorarioNopermitido(5,HoraEntradaViernes , HoraSalidaViernes);
    }//GEN-LAST:event_HoraSalidaViernesItemStateChanged

    private void HoraSalidaSbdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_HoraSalidaSbdItemStateChanged
        if(edicionSala==null)
            return;
        evitarCambioHorarioNopermitido(6,HoraEntradaSbd , HoraSalidaSbd);
    }//GEN-LAST:event_HoraSalidaSbdItemStateChanged

    private void HoraSalidaDmngItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_HoraSalidaDmngItemStateChanged
        if(edicionSala==null)
            return;
        evitarCambioHorarioNopermitido(0,HoraEntradaDmng, HoraSalidaDmng);
    }//GEN-LAST:event_HoraSalidaDmngItemStateChanged

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
            java.util.logging.Logger.getLogger(RegistroSalasCine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroSalasCine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroSalasCine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroSalasCine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(RegistroSalasCine.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(RegistroSalasCine.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(RegistroSalasCine.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(RegistroSalasCine.class.getName()).log(Level.SEVERE, null, ex);
                }
                new RegistroSalasCine().setVisible(true);
            }
        });
    }

    //Habilita y desabilita opciones
    
    private void HabilitarOpciones(){
        if(tamañoArreglo==0)
        {
            activarBoton =false;            
        }else{
            activarBoton =true;            
        }
       
       if(txtPrecio.getText().length()==0 ){
            activarBoton =false;            
        }else{
           if(txtPrecio.getText().charAt(0)=='.')
           {
               activarBoton = false;
               txtPrecio.setForeground(Color.red);
           }
               
       }
       if(txtCodigo.getText().length()==0 ){
            activarBoton =false;            
        }
       if(txtNombre.getText().length()==0 ){
            activarBoton =false;            
        }
       
       //Caso de edicion
       //Verificar dias ya registrados con una reservacion que no se ha cumplido para evitar cambiar horario
       if(edicionSala ==null)
           return;
       if(!OpDiaLunes.isSelected())
           if(!edicionSala.horarioNoPermiteCambioDia(1)){
               activarBoton=false;
               return;
           }
             
       if(!OpDiaMartes.isSelected())
           if(!edicionSala.horarioNoPermiteCambioDia(2)){
               activarBoton=false;
               return;
           }
       if(!OpDiaMiercoles.isSelected())
           if(!edicionSala.horarioNoPermiteCambioDia(3)){
               activarBoton=false;
               return;
           }
       if(!OpDiaJueves.isSelected())
           if(!edicionSala.horarioNoPermiteCambioDia(4)){
               activarBoton=false;
               return;
           }
       if(!OpDiaViernes.isSelected())
           if(!edicionSala.horarioNoPermiteCambioDia(5)){
               activarBoton=false;
               return;
           }
       if(!OpDiaSabado.isSelected())
           if(!edicionSala.horarioNoPermiteCambioDia(6)){
               activarBoton=false;
               return;
           }
       if(!OpDiaDomingo.isSelected())
           if(!edicionSala.horarioNoPermiteCambioDia(0)){
               activarBoton=false;
               return;
           }
        if(!evitarCambioHorarioNopermitido(1, HoraEntradaLunes , HoraSalidaLunes))
            return;
        if(!evitarCambioHorarioNopermitido(2, HoraEntradaMartes , HoraSalidaMartes))
            return;
       
        if(!evitarCambioHorarioNopermitido(3, HoraEntradaMiercoles , HoraSalidaMiercoles))
           return;
        if(!evitarCambioHorarioNopermitido(4, HoraEntradaJueves , HoraSalidaJueves))
           return;
        if(!evitarCambioHorarioNopermitido(5, HoraEntradaViernes , HoraSalidaViernes))
           return;
        if(!evitarCambioHorarioNopermitido(6, HoraEntradaSbd , HoraSalidaSbd))
           return ;
        evitarCambioHorarioNopermitido(0, HoraEntradaDmng , HoraSalidaDmng);
       
    }
    
    private void bloquearOpciones(){
       
        //Lunes
        HoraEntradaLunes.disable();//
        HoraSalidaLunes.disable();
        DetalleComponentes.actualizarItems(HoraEntradaLunes, HoraSalidaLunes,24);
        //Martes
        HoraEntradaMartes.disable();
        HoraSalidaMartes.disable();
        DetalleComponentes.actualizarItems(HoraEntradaMartes, HoraSalidaMartes,24);
        //Miercoles
        HoraEntradaMiercoles.disable();
        HoraSalidaMiercoles.disable();
        DetalleComponentes.actualizarItems(HoraEntradaMiercoles, HoraSalidaMiercoles,24);
        //Jueves
        HoraEntradaJueves.disable();
        HoraSalidaJueves.disable();
        DetalleComponentes.actualizarItems(HoraEntradaJueves, HoraSalidaJueves,24);
        //Viernes
        HoraEntradaViernes.disable();
        HoraSalidaViernes.disable();
        DetalleComponentes.actualizarItems(HoraEntradaViernes, HoraSalidaViernes,24);
        //Sabado
        HoraEntradaSbd.disable();
        HoraSalidaSbd.disable();
        DetalleComponentes.actualizarItems(HoraEntradaSbd, HoraSalidaSbd,24);
        //Domingo
        HoraEntradaDmng.disable();
        HoraSalidaDmng.disable();
        DetalleComponentes.actualizarItems(HoraEntradaDmng, HoraSalidaDmng,24);
    }
    
    
    //Recoleccion datos dias seleccionados
    
    private String[] diasSeleccionados(int j){
        String []dias=new String[j];
        int i=0;         
        if(OpDiaLunes.isSelected() )
        {
            dias[i]=OpDiaLunes.getText();
            i++;
           
        }
        if(OpDiaMartes.isSelected() )
        {
            dias[i]=OpDiaMartes.getText();
            i++;
        }
        if(OpDiaMiercoles.isSelected() )
        {
            dias[i]=OpDiaMiercoles.getText();
            i++;
        }
        if(OpDiaJueves.isSelected() )
        {
            dias[i]=OpDiaJueves.getText();
            i++;
        }
        if(OpDiaViernes.isSelected() )
        {
            dias[i]=OpDiaViernes.getText();
            i++;
        }
        if(OpDiaSabado.isSelected() )
        {
            dias[i]=OpDiaSabado.getText();
            i++;
        }
        if(OpDiaDomingo.isSelected() )
        {
            dias[i]=OpDiaDomingo.getText();
            i++;
        }
         
        return dias;
    } 
    

    private int[] HorasEntrada(int j){
        int []horaEntrada=new int[j];   
        int i=0;     
        if(OpDiaLunes.isSelected() )
        {
            horaEntrada[i]=Integer.parseInt((String) HoraEntradaLunes.getSelectedItem());
            i++;
        }
        if(OpDiaMartes.isSelected() )
        {
            horaEntrada[i]=Integer.parseInt((String) HoraEntradaMartes.getSelectedItem());
            i++;
        }
        
        if(OpDiaMiercoles.isSelected() )
        {
            horaEntrada[i]=Integer.parseInt((String) HoraEntradaMiercoles.getSelectedItem());
            i++;
        }
       
        if(OpDiaJueves.isSelected() )
        {
            horaEntrada[i]=Integer.parseInt((String) HoraEntradaJueves.getSelectedItem());
            i++;
        }
        
        if(OpDiaViernes.isSelected() )
        {
            horaEntrada[i]=Integer.parseInt((String) HoraEntradaViernes.getSelectedItem());
            i++;
        }
        
        if(OpDiaSabado.isSelected() )
        {
            horaEntrada[i]=Integer.parseInt((String) HoraEntradaSbd.getSelectedItem());
            i++;
        }
        if(OpDiaDomingo.isSelected() )
        {
            horaEntrada[i]=Integer.parseInt((String) HoraEntradaDmng.getSelectedItem());
            i++;
        }
        
        return horaEntrada;
    } 
    private int[] HorasSalida(int j){
        int []horaSalida=new int[j];
        int i=0;
        if(OpDiaLunes.isSelected() )
        {            
            horaSalida[i]=Integer.parseInt((String) HoraSalidaLunes.getSelectedItem().toString());
            i++;
        }

        if(OpDiaMartes.isSelected() )
        {
            horaSalida[i]=Integer.parseInt((String) HoraSalidaMartes.getSelectedItem().toString());
            i++;
        }

        if(OpDiaMiercoles.isSelected() )
        {
            horaSalida[i]=Integer.parseInt((String) HoraSalidaMiercoles.getSelectedItem().toString());
            i++;
        }

        if(OpDiaJueves.isSelected() )
        {
            horaSalida[i]=Integer.parseInt((String) HoraSalidaJueves.getSelectedItem().toString());
            i++;
        }

        if(OpDiaViernes.isSelected() )
        {
            horaSalida[i]=Integer.parseInt((String) HoraSalidaViernes.getSelectedItem().toString());
            i++;
        }

        if(OpDiaSabado.isSelected() )
        {
            horaSalida[i]=Integer.parseInt((String) HoraSalidaSbd.getSelectedItem().toString());
            i++;
        }

        if(OpDiaDomingo.isSelected() )
        {
            horaSalida[i]=Integer.parseInt((String) HoraSalidaDmng.getSelectedItem().toString());
            i++;
        }
        return horaSalida;
    } 
    ////
    private void CargarEventos() {                      
        EventosJButton eventoGuardar=new EventosJButton(btnGuardar);
        btnGuardar.addMouseListener(eventoGuardar);
        btnGuardar.addMouseMotionListener(eventoGuardar);
        EventosJButton eventoCancelar=new EventosJButton(btnCancelar);
        btnCancelar.addMouseListener(eventoCancelar);
        btnCancelar.addMouseMotionListener(eventoCancelar);
        EventosJButton eventoBuscar=new EventosJButton(btnBuscarImagen);
        btnBuscarImagen.addMouseListener(eventoBuscar);
        btnBuscarImagen.addMouseMotionListener(eventoBuscar);
    }
    
    public void cargarCmb(int tipoSala) {
        SalaDAO cargarDetalles=new SalaDAO();
        ArrayList<String> lista =cargarDetalles.listaCaracteristicasAdicionales(tipoSala);
        if(lista !=null)
        for(String list:lista){
            cmbAtributo1.addItem(list);
        }
    }
    
    //Seteos
    
    public void setCodigoSala(String tipe){
        SalaDAO code=new SalaDAO();
        txtCodigo.setEditable(false);
        id= code.agregarIdSala();
        txtCodigo.setText(tipe+id);
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
        lblTipoSala.setText("Sala "+tipo);
    }
    
    public void setLabelsPorSala(String l1, String l2){
        lblAtributo1.setText(l1);
        lblAtributo2.setText(l2);
    }

    public void setEdicionSala(Sala edicionSala) {
        this.edicionSala = edicionSala;
        cargarDatos();
    }
    
    
    public void cargarDatos(){
        activarBoton=true;
        tipo=edicionSala.getTipo();
        this.setTitle("Edicion Datos");
        btnGuardar.setText("Editar");
        lblTipoSala.setText("Sala "+edicionSala.getTipo());
        txtCodigo.setText(edicionSala.getCodigo());
        txtNombre.setText(edicionSala.getNombre());
        txtPrecio.setText(edicionSala.getCostoReservacionPorHora()+"");
        
        if(edicionSala instanceof SalaGeneral){
            SalaGeneral G=(SalaGeneral)edicionSala;
            cmbAtributo1.setSelectedItem(G.getPromiciones());
            txtAtributo2.setText(G.getX());
        }else{
            if(edicionSala instanceof SalaVIP){
                SalaVIP G=(SalaVIP)edicionSala;
                cmbAtributo1.setSelectedItem(G.getModeloGafas3D());
                txtAtributo2.setText(G.getServicioAdicionalPaga());
            }else{
                if(edicionSala instanceof SalaBlackBox){
                    SalaBlackBox G=(SalaBlackBox)edicionSala;
                    cmbAtributo1.setSelectedItem(G.getTipoAsiento());
                    txtAtributo2.setText(G.getServiciAdicionalGratuitos());
                }
            }            
        }
        if(!edicionSala.getImagen().equals("ninguna"))
            rsscalelabel.RSScaleLabel.setScaleLabel(lblImagen, edicionSala.getImagen());
        llenarHorario();
    }
    
    private void chekHorario(JRadioButton check, JComboBox comboE, JComboBox comboS, String dia, int entrada, int salida){
        if(dia.equals(  check.getText())){
                check.setSelected(true);
                comboE.setEnabled(true);
                comboS.setEnabled(true);
                comboE.setSelectedItem(entrada+"");
                comboS.setSelectedItem( salida);                      
            }
    }
    
    private void llenarHorario(){
        String dias[]=edicionSala.getHorario().getDias();
        int entrada[]=edicionSala.getHorario().getHora_entrada();
        int salida []=edicionSala.getHorario().getHora_salida();
        tamañoArreglo=edicionSala.getHorario().getDias().length;
        for(int i=0;i<tamañoArreglo;i++){
           chekHorario(OpDiaLunes, HoraEntradaLunes,HoraSalidaLunes ,dias[i], entrada[i],salida[i] );
           chekHorario(OpDiaMartes, HoraEntradaMartes,HoraSalidaMartes ,dias[i], entrada[i],salida[i] );
           chekHorario(OpDiaMiercoles, HoraEntradaMiercoles,HoraSalidaMiercoles ,dias[i], entrada[i],salida[i] );
           chekHorario(OpDiaJueves, HoraEntradaJueves,HoraSalidaJueves ,dias[i], entrada[i],salida[i] );
           chekHorario(OpDiaViernes, HoraEntradaViernes,HoraSalidaViernes ,dias[i], entrada[i],salida[i] );
           chekHorario(OpDiaSabado, HoraEntradaSbd,HoraSalidaSbd ,dias[i], entrada[i],salida[i] );
           chekHorario(OpDiaDomingo, HoraEntradaDmng,HoraSalidaDmng ,dias[i], entrada[i],salida[i] );
        }
    }
    
    
    private void seleccionarImagen(){
        JFileChooser choser=new JFileChooser();
        FileNameExtensionFilter filtro =new FileNameExtensionFilter("*.PNG","png","*.JPG","jpg","*.JPEG","jpeg");
        choser.setFileFilter(filtro);   
        choser.showOpenDialog(this);
        File fichero=choser.getSelectedFile();
        if(fichero!=null)
        {
            imagenSala=fichero.getAbsolutePath(); 
            rsscalelabel.RSScaleLabel.setScaleLabel(lblImagen, choser.getSelectedFile().toString());
        }
    }
    
    
    public void setSalaAGuardar(Sala X){
         SalaAGuardar=X;
    }
    
    
    ///En caso de edicion de la sala 
    
    public boolean evitarCambioHorarioNopermitido(int dia, JComboBox entrada, JComboBox salida){
        int entrada_hora=0;
        int salida_hora=0;
        try{
            entrada_hora=Integer.parseInt(entrada.getSelectedItem().toString());
            salida_hora=Integer.parseInt(salida.getSelectedItem().toString());
        }catch(Exception ex){}        
        if(edicionSala.horarioNoPermiteCambioHoras(dia, entrada_hora, salida_hora)){
            activarBoton=true;
            lblErrorFecha.setText("");
            lblMensajeErrorHorario.setText("");
        }else{
            activarBoton=false;
            lblErrorFecha.setText("Cambio no permitido");
            lblMensajeErrorHorario.setText("Una reservación ocupará dichas horas, elimine o espere a que pase la fecha de la reservación");
        }
        return activarBoton;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> HoraEntradaDmng;
    private javax.swing.JComboBox<String> HoraEntradaJueves;
    private javax.swing.JComboBox<String> HoraEntradaLunes;
    private javax.swing.JComboBox<String> HoraEntradaMartes;
    private javax.swing.JComboBox<String> HoraEntradaMiercoles;
    private javax.swing.JComboBox<String> HoraEntradaSbd;
    private javax.swing.JComboBox<String> HoraEntradaViernes;
    private javax.swing.JComboBox<String> HoraSalidaDmng;
    private javax.swing.JComboBox<String> HoraSalidaJueves;
    private javax.swing.JComboBox<String> HoraSalidaLunes;
    private javax.swing.JComboBox<String> HoraSalidaMartes;
    private javax.swing.JComboBox<String> HoraSalidaMiercoles;
    private javax.swing.JComboBox<String> HoraSalidaSbd;
    private javax.swing.JComboBox<String> HoraSalidaViernes;
    private javax.swing.JRadioButton OpDiaDomingo;
    private javax.swing.JRadioButton OpDiaJueves;
    private javax.swing.JRadioButton OpDiaLunes;
    private javax.swing.JRadioButton OpDiaMartes;
    private javax.swing.JRadioButton OpDiaMiercoles;
    private javax.swing.JRadioButton OpDiaSabado;
    private javax.swing.JRadioButton OpDiaViernes;
    private javax.swing.JPanel PanelHorarios;
    private javax.swing.JButton btnBuscarImagen;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbAtributo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lblAtributo1;
    private javax.swing.JLabel lblAtributo2;
    private javax.swing.JLabel lblErrorFecha;
    private javax.swing.JLabel lblHoraInHoraOut;
    private javax.swing.JLabel lblHoraInHoraOut1;
    private javax.swing.JLabel lblHoraInHoraOut2;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblMensajeErrorHorario;
    private javax.swing.JLabel lblTipoSala;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelDiasHoras;
    private javax.swing.JPanel panelEscribeDatos;
    private javax.swing.JPanel panelImagen;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JPanel panelVentana;
    private javax.swing.JTextField txtAtributo2;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

    

    
}
