package Vista.InterfacesGraficas;

import Alertas.notificacionAlertas.AlertaNotificacion;
import Alertas.notificacionAlertas.AlertaOperaciones;
import Entidades.HorarioReservaciones;
import Entidades.Pelicula;
import Entidades.ReservacionesSalas;
import Entidades.Sala;
import OtrosOperaciones.DetalleComponentes;
import OtrosOperaciones.EventosJButton;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import modelo.entidadesDTO.ClienteDAO;
import modelo.operacionesDAO.ReservacionesDAO;
import modelo.operacionesDAO.SalaDAO;


public class HacerReservacion extends javax.swing.JFrame {
    private Sala reservarSala ;
    private boolean activarBoton=false;
    public HacerReservacion() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);//Modificar el estado de extendido
        this.setIconImage(DetalleComponentes.getIconImage());
        
        EventosJButton colorearBotones=new EventosJButton(btnCerrar);
        colorearBotones.colorearBotones(btnCerrar, new Color(212,175,55),  new Color (195,83,2));
        colorearBotones.colorearBotones(btnGuardar, new Color(52,149,19), new Color(24,112,24));
        cargarCategorias();
                
        //Fecha minima
        fechaReservacion.setMinSelectableDate(new Date());
      
    }
    
    public void setReservarSala(Sala sala){
        this.reservarSala=sala;
        cargarDatos();
        
    }
    
    private void cargarDatos (){
        if(reservarSala==null)
            return;
        ReservacionesDAO rdao=new ReservacionesDAO();
        lblCodigoSala.setText(reservarSala.getCodigo());
        lblTipoSala.setText(reservarSala.getTipo());
        
        txtCodigoReservacion.setText("RSV-"+reservarSala.getTipo()+"-"+rdao.agregarIdReservacion());
        
        cmbHoraEntrada.removeAllItems();    cmbHoraEntrada.setEnabled(false);
        cmbHoraSalida.removeAllItems();     cmbHoraSalida.setEnabled(false);
        
    }
    
    private void cargarCategorias(){
        ReservacionesDAO ctg=new ReservacionesDAO();
        ArrayList<String> categoria =ctg.consultarCategoriaPeliculas();
        cmbCategoria.removeAllItems();
        if(categoria!=null){            
            for(String cat:categoria)
                cmbCategoria.addItem(cat);
        }
    }
    private void verficacionNumero(KeyEvent e,String dato){
        char x=e.getKeyChar();
        if(x<'0' || x>'9' )
        {
           e.consume(); // consumir el evento para que no se realice
        }
        if(dato.length()==10)
        {
            e.consume();
        }
    }
    
    private String HabilitarBoton(){
        //verificar datos cliente 
        if(txtNombre.getText().equals("")  || txtApellido.getText().equals("") 
                || txtCedula.getText().equals("") || txtTelefono.getText().equals("")
                || txtDireccion.getText().equals(""))
        {
            activarBoton=false;
            return "Faltan Datos del cliente";
        
        }        
        else{
            if(txtTelefono.getText().length()!=10 || txtCedula.getText().length()!=10){
                activarBoton=false;
            return "Datos Incorrectos: Cédula o Teléfono";
            }else{
                activarBoton=true;
            }
            
        }
        //reservacion
        if(fechaReservacion.getDate()==null)
        {
            activarBoton=false;
            return "Campo de fecha vacía";
        }else
             activarBoton=true;
        //Comprobar choque de horas
        if(cmbHoraEntrada.getSelectedItem()==null || cmbHoraSalida.getSelectedItem()==null){
            activarBoton=false;
            return "Fecha Erronea";
        }else{
            int hE=Integer.parseInt(cmbHoraEntrada.getSelectedItem().toString());
            int hS=Integer.parseInt(cmbHoraSalida.getSelectedItem().toString());
            if(reservarSala.HorasCruzadas( fechaReservacion.getDate() ,hE , hS) )
            {            
                activarBoton=false;
                return "Horas Ya no están disponibles para la reservación";
            }else{
            activarBoton=true;
            }
        }

        //Datos Pelicula
        if(txtNombrePelicula.getText().equals("")){
            activarBoton=false;
            return "Falta Nombre de Película";
        }else{
            activarBoton=true;
        }
        return "";
    }
    
    public void soloLetras(KeyEvent evt){
        char c=evt.getKeyChar();
        if((c<'a' || c>'z')  && (c<'A' || c>'Z'))
            evt.consume();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelDatos = new javax.swing.JPanel();
        panelCliente = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        panelNombre = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        panelApellido = new javax.swing.JPanel();
        txtApellido = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        panelCedula = new javax.swing.JPanel();
        txtCedula = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        panelTelefono = new javax.swing.JPanel();
        txtTelefono = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        panelDireccion = new javax.swing.JPanel();
        txtDireccion = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        panelDatosReservacion = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        panelCodigo = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtCodigoReservacion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        panelFecha = new javax.swing.JPanel();
        lblMensajeDia = new javax.swing.JLabel();
        fechaReservacion = new com.toedter.calendar.JDateChooser();
        jLabel25 = new javax.swing.JLabel();
        panelHorario = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        cmbHoraEntrada = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        cmbHoraSalida = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        lblMensajeCruceHoras = new javax.swing.JLabel();
        panelDatosPelicula = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cmbCalificacion = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtNombrePelicula = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        cmbAño = new javax.swing.JComboBox<>();
        cmbCategoria = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        panelSuperior = new javax.swing.JPanel();
        lblTipoSala = new javax.swing.JLabel();
        lblCodigoSala = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        panelDatos.setOpaque(false);
        panelDatos.setLayout(new javax.swing.BoxLayout(panelDatos, javax.swing.BoxLayout.Y_AXIS));

        panelCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelCliente.setOpaque(false);
        panelCliente.setLayout(new javax.swing.BoxLayout(panelCliente, javax.swing.BoxLayout.Y_AXIS));

        jLabel3.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Datos del CLiente");
        panelCliente.add(jLabel3);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setBackground(new java.awt.Color(51, 255, 102));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jLabel8.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Nombres");
        jPanel5.add(jLabel8);

        jLabel9.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText(" ");
        jPanel5.add(jLabel9);

        jLabel10.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Apellidos");
        jPanel5.add(jLabel10);

        jLabel11.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText(" ");
        jPanel5.add(jLabel11);

        jLabel12.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Cédula");
        jPanel5.add(jLabel12);

        jLabel13.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText(" ");
        jPanel5.add(jLabel13);

        jLabel14.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Telefono");
        jPanel5.add(jLabel14);

        jLabel19.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText(" ");
        jPanel5.add(jLabel19);

        jLabel20.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Direccion");
        jPanel5.add(jLabel20);

        jPanel2.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        panelNombre.setOpaque(false);

        jLabel15.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("*");

        txtNombre.setFont(new java.awt.Font("Myanmar Text", 0, 16)); // NOI18N
        txtNombre.setBorder(null);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panelNombreLayout = new javax.swing.GroupLayout(panelNombre);
        panelNombre.setLayout(panelNombreLayout);
        panelNombreLayout.setHorizontalGroup(
            panelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNombreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelNombreLayout.setVerticalGroup(
            panelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNombreLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel6.add(panelNombre);

        jLabel24.setText(" ");
        jPanel6.add(jLabel24);

        panelApellido.setOpaque(false);

        txtApellido.setFont(new java.awt.Font("Myanmar Text", 0, 16)); // NOI18N
        txtApellido.setBorder(null);
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel16.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("*");

        javax.swing.GroupLayout panelApellidoLayout = new javax.swing.GroupLayout(panelApellido);
        panelApellido.setLayout(panelApellidoLayout);
        panelApellidoLayout.setHorizontalGroup(
            panelApellidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelApellidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelApellidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtApellido)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panelApellidoLayout.setVerticalGroup(
            panelApellidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelApellidoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelApellidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(7, 7, 7)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(panelApellido);

        jLabel35.setText(" ");
        jPanel6.add(jLabel35);

        panelCedula.setOpaque(false);

        txtCedula.setFont(new java.awt.Font("Myanmar Text", 0, 16)); // NOI18N
        txtCedula.setBorder(null);
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel17.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("*");

        javax.swing.GroupLayout panelCedulaLayout = new javax.swing.GroupLayout(panelCedula);
        panelCedula.setLayout(panelCedulaLayout);
        panelCedulaLayout.setHorizontalGroup(
            panelCedulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCedulaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCedulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCedula)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelCedulaLayout.setVerticalGroup(
            panelCedulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCedulaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelCedulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(7, 7, 7)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel6.add(panelCedula);

        jLabel33.setText(" ");
        jPanel6.add(jLabel33);

        panelTelefono.setBackground(new java.awt.Color(204, 0, 153));
        panelTelefono.setOpaque(false);

        txtTelefono.setFont(new java.awt.Font("Myanmar Text", 0, 16)); // NOI18N
        txtTelefono.setBorder(null);
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        jLabel18.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("*");

        javax.swing.GroupLayout panelTelefonoLayout = new javax.swing.GroupLayout(panelTelefono);
        panelTelefono.setLayout(panelTelefonoLayout);
        panelTelefonoLayout.setHorizontalGroup(
            panelTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTelefonoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTelefono)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelTelefonoLayout.setVerticalGroup(
            panelTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTelefonoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(7, 7, 7)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel6.add(panelTelefono);

        jLabel32.setText(" ");
        jPanel6.add(jLabel32);

        panelDireccion.setOpaque(false);

        txtDireccion.setFont(new java.awt.Font("Myanmar Text", 0, 16)); // NOI18N
        txtDireccion.setBorder(null);
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("*");

        javax.swing.GroupLayout panelDireccionLayout = new javax.swing.GroupLayout(panelDireccion);
        panelDireccion.setLayout(panelDireccionLayout);
        panelDireccionLayout.setHorizontalGroup(
            panelDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDireccionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDireccionLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelDireccionLayout.setVerticalGroup(
            panelDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDireccionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel6.add(panelDireccion);

        jPanel2.add(jPanel6);

        panelCliente.add(jPanel2);

        panelDatos.add(panelCliente);

        panelDatosReservacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelDatosReservacion.setOpaque(false);
        panelDatosReservacion.setLayout(new javax.swing.BoxLayout(panelDatosReservacion, javax.swing.BoxLayout.Y_AXIS));

        jLabel7.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Datos de la Reservacion");
        panelDatosReservacion.add(jLabel7);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        panelCodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelCodigo.setOpaque(false);
        panelCodigo.setLayout(new java.awt.GridLayout(4, 2));

        jLabel26.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setText("Codigo");
        panelCodigo.add(jLabel26);

        txtCodigoReservacion.setEditable(false);
        txtCodigoReservacion.setFont(new java.awt.Font("Myanmar Text", 0, 16)); // NOI18N
        txtCodigoReservacion.setBorder(null);
        panelCodigo.add(txtCodigoReservacion);
        panelCodigo.add(jLabel1);

        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        panelCodigo.add(jSeparator10);

        jLabel27.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        jLabel27.setText("Precio  $");
        panelCodigo.add(jLabel27);

        txtPrecio.setEditable(false);
        txtPrecio.setFont(new java.awt.Font("Myanmar Text", 0, 16)); // NOI18N
        txtPrecio.setText("0");
        txtPrecio.setBorder(null);
        panelCodigo.add(txtPrecio);
        panelCodigo.add(jLabel2);

        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        panelCodigo.add(jSeparator11);

        jPanel4.add(panelCodigo);

        lblMensajeDia.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        lblMensajeDia.setText("Seleccione una fecha");

        fechaReservacion.setBackground(new java.awt.Color(255, 255, 255));
        fechaReservacion.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fechaReservacionPropertyChange(evt);
            }
        });
        fechaReservacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fechaReservacionKeyTyped(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel25.setText("Fecha");

        javax.swing.GroupLayout panelFechaLayout = new javax.swing.GroupLayout(panelFecha);
        panelFecha.setLayout(panelFechaLayout);
        panelFechaLayout.setHorizontalGroup(
            panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFechaLayout.createSequentialGroup()
                .addContainerGap(206, Short.MAX_VALUE)
                .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaReservacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelFechaLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel25))
                    .addGroup(panelFechaLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(lblMensajeDia)))
                .addGap(122, 122, 122))
        );
        panelFechaLayout.setVerticalGroup(
            panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFechaLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaReservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lblMensajeDia)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        jPanel4.add(panelFecha);

        panelHorario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelHorario.setOpaque(false);
        panelHorario.setLayout(new javax.swing.BoxLayout(panelHorario, javax.swing.BoxLayout.Y_AXIS));

        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        jPanel8.setLayout(new java.awt.GridLayout(5, 1));

        jLabel36.setText(" ");
        jPanel8.add(jLabel36);

        jLabel22.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Hora de Entrada");
        jPanel8.add(jLabel22);

        jLabel34.setText(" ");
        jPanel8.add(jLabel34);

        jLabel23.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Hora de Salida");
        jPanel8.add(jLabel23);

        jPanel9.add(jPanel8);

        jPanel7.setLayout(new java.awt.GridLayout(5, 1));

        jLabel37.setText(" ");
        jPanel7.add(jLabel37);

        cmbHoraEntrada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        cmbHoraEntrada.setSelectedIndex(7);
        cmbHoraEntrada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbHoraEntradaItemStateChanged(evt);
            }
        });
        jPanel7.add(cmbHoraEntrada);

        jLabel38.setText(" ");
        jPanel7.add(jLabel38);

        cmbHoraSalida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        cmbHoraSalida.setSelectedIndex(7);
        cmbHoraSalida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbHoraSalidaItemStateChanged(evt);
            }
        });
        jPanel7.add(cmbHoraSalida);

        jPanel9.add(jPanel7);

        panelHorario.add(jPanel9);

        lblMensajeCruceHoras.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        lblMensajeCruceHoras.setForeground(new java.awt.Color(153, 0, 0));
        lblMensajeCruceHoras.setText(" ");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 300, Short.MAX_VALUE)
                .addComponent(lblMensajeCruceHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblMensajeCruceHoras)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        panelHorario.add(jPanel10);

        jPanel4.add(panelHorario);

        panelDatosReservacion.add(jPanel4);

        panelDatos.add(panelDatosReservacion);

        panelDatosPelicula.setOpaque(false);
        panelDatosPelicula.setLayout(new javax.swing.BoxLayout(panelDatosPelicula, javax.swing.BoxLayout.Y_AXIS));

        jLabel4.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Datos de la Pelicula");
        panelDatosPelicula.add(jLabel4);

        jPanel3.setOpaque(false);

        cmbCalificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel28.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setText("Nombre");

        jLabel29.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setText("Calificación");

        txtNombrePelicula.setFont(new java.awt.Font("Myanmar Text", 0, 16)); // NOI18N
        txtNombrePelicula.setBorder(null);

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));

        jLabel30.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setText("Año de estreno");

        cmbAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971" }));

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel31.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setText("Categoría");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbAño, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombrePelicula)
                            .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 923, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(278, 278, 278))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtNombrePelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cmbAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)))))
                .addContainerGap())
        );

        panelDatosPelicula.add(jPanel3);

        panelDatos.add(panelDatosPelicula);

        jPanel1.add(panelDatos, java.awt.BorderLayout.CENTER);

        panelSuperior.setBackground(new java.awt.Color(0, 102, 102));
        panelSuperior.setLayout(new java.awt.GridLayout(1, 0));

        lblTipoSala.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        lblTipoSala.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoSala.setText("TipoSala");
        panelSuperior.add(lblTipoSala);

        lblCodigoSala.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        lblCodigoSala.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoSala.setText("CodigoSala");
        panelSuperior.add(lblCodigoSala);

        jLabel5.setText(" ");
        panelSuperior.add(jLabel5);

        jLabel6.setText(" ");
        panelSuperior.add(jLabel6);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/iconoHome.png"))); // NOI18N
        btnCerrar.setText("SALIR");
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        panelSuperior.add(btnCerrar);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/canguil.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelSuperior.add(btnGuardar);

        jPanel1.add(panelSuperior, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
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
        
        this.dispose();
        MenuPrincipal pantallaPincipal=new MenuPrincipal();
        pantallaPincipal.setVisible(true);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        verficacionNumero(evt, txtCedula.getText());        
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        verficacionNumero(evt,txtTelefono.getText());
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //Guardar 
        String mensaje=HabilitarBoton();
        AlertaNotificacion notificar=new AlertaNotificacion(this, true);
        if(!activarBoton)
        {
            notificar.setLblTtulo("Error");
            notificar.setLblSubT(mensaje);
            notificar.setColorBoton(Color.red);
            notificar.agregarImagen(0);
            notificar.colorFondoBoton(new Color(69,0,0));
            notificar.setVisible(true);
            notificar.reproducirSonido(2);
            return;
        }
        
        ReservacionesSalas reservar=new ReservacionesSalas();
        reservar.setCodigo(txtCodigoReservacion.getText());
        reservar.setCostoDeReservacion(Double.parseDouble(txtPrecio.getText()));
        //Seteo cliente
        reservar.setCiCliente(txtCedula.getText());
        reservar.setApellidoCliente(txtApellido.getText());
        reservar.setNombreCliente(txtNombre.getText());
        reservar.setDireccionCliente(txtDireccion.getText());
        reservar.setTelefonoCliente(txtTelefono.getText());
        
        HorarioReservaciones horarioRs=new HorarioReservaciones();
        int h_entrada=Integer.parseInt(cmbHoraEntrada.getSelectedItem().toString());
        int h_salida=Integer.parseInt(cmbHoraSalida.getSelectedItem().toString());
        horarioRs.setHora_entrada(h_entrada);
        horarioRs.setHora_salida(h_salida);
        horarioRs.setFechaReservacion(fechaReservacion.getDate());
        String dia= fechaReservacion.getCalendar().get(Calendar.DAY_OF_MONTH) +"";
        String mes=(fechaReservacion.getCalendar().get(Calendar.MONTH)+1)+"";
        String año=fechaReservacion.getCalendar().get(Calendar.YEAR)+"";
        String fechaReservacion;
         fechaReservacion= año+"-"+mes+"-"+dia;   
        // System.out.println(fechaReservacion);
        horarioRs.setFechaString(fechaReservacion);
        
        reservar.setHorario(horarioRs);
        
        
        //Pelicula
        int calificacion=Integer.parseInt(cmbCalificacion.getSelectedItem().toString());
        int añoEstreno=Integer.parseInt(cmbAño.getSelectedItem().toString());
        Pelicula peli=new Pelicula();
        peli.setNombre(txtNombrePelicula.getText());
        peli.setNombreCategoria(cmbCategoria.getSelectedItem().toString());        
        peli.setIdCategoria((int) cmbCategoria.getSelectedIndex()+1);
        peli.setCalificacion(calificacion);
        peli.setAñoEstreno(añoEstreno);
        reservar.setPeliculas_estreno(peli);
        
        //Asignar datos a cliente DAO
        ClienteDAO cliente=new ClienteDAO();
        cliente.setCiPersona(reservar.getCiCliente());
        cliente.setNombre(reservar.getNombreCliente());
        cliente.setApellidos(reservar.getApellidoCliente());
        cliente.setDireccion(reservar.getDireccionCliente());
        cliente.setTelefono(reservar.getTelefonoCliente());
        
        ReservacionesDAO guardaDatos=new ReservacionesDAO();
        
        //guardar id de la pelicula
        peli.setIdPelicula(guardaDatos.agregarIDPelicula());
        //Guardar cliente
        int guardadoCorrecto=0;
        if(guardaDatos.verificarClienteExistente(cliente.getCiPersona()))
        {guardadoCorrecto=1;
            System.out.println("Cliente existe");
        }else{
            System.out.println("Guardando Cliente");
            guardadoCorrecto= guardaDatos.guardarCliente(cliente);
        }
         
        if(guardadoCorrecto==0)
            System.out.println("Cliente no guardado");
        else{
            guardadoCorrecto=guardaDatos.guardarPelicula(reservar.getPeliculas_estreno());
            if(guardadoCorrecto==0)
            System.out.println("Pelicula no guardada");
            else{
                guardadoCorrecto=guardaDatos.guardarReservacion(reservar, reservarSala);
            if(guardadoCorrecto==0)
              System.out.println("Reservacion no guardada");
            else{                
                System.out.println("Guardado exitoso");
                SalaDAO s=new SalaDAO();
                s.actualizarGanancias(reservar.getCostoDeReservacion()+reservarSala.getGanaciasGeneradasPorReservaciones()
                        , lblCodigoSala.getText());
            }
            }
        }
        
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
        this.dispose();
        MenuPrincipal menu=new MenuPrincipal();
        menu.setVisible(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void fechaReservacionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fechaReservacionPropertyChange
        //Evento selección de un dia
        cmbHoraEntrada.removeAllItems();    
        cmbHoraEntrada.setEnabled(false);
        cmbHoraSalida.removeAllItems();     cmbHoraSalida.setEnabled(false);        
        if( fechaReservacion.getDate()==null)
            return;
        int diaSlect=fechaReservacion.getDate().getDay();
        int mesSelecy=fechaReservacion.getDate().getMonth()+1;
        int añoSelect=fechaReservacion.getDate().getYear()+1900;                
        int i=reservarSala.getHorario().retornaPosicionDia(diaSlect);//verificar la posicion del dia si existe en el horario de la sala
        
        if(i==-1){
            lblMensajeDia.setText("Día no está disponible para esta sala");                    
            return;
        }
        else{
            int horaEntrada= reservarSala.getHorario().getHoraEntradaSeleccionada(i);
             horaSalida=reservarSala.getHorario().getHoraSalidaSeleccionada(i);
            String diaSeleccionado= reservarSala.getHorario().getDiaSeleccionado(i);
            lblMensajeDia.setText("Dia seleccionado "+diaSeleccionado);
            for(int j= horaEntrada ;j<horaSalida;j++)
                cmbHoraEntrada.addItem(j+"");
            for(int j= horaEntrada+1 ;j<=horaSalida;j++)
                cmbHoraSalida.addItem(j+"");
            cmbHoraEntrada.setEnabled(true);
            cmbHoraSalida.setEnabled(true);
        }        
    }//GEN-LAST:event_fechaReservacionPropertyChange
    int horaSalida=0;
    private void cmbHoraEntradaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbHoraEntradaItemStateChanged
        
        lblMensajeCruceHoras.setText("");
        if(cmbHoraEntrada.getSelectedItem()==null || cmbHoraSalida.getSelectedItem()==null)
            return;
        DetalleComponentes.actualizarItems(cmbHoraEntrada , cmbHoraSalida,horaSalida );
        int hE=Integer.parseInt(cmbHoraEntrada.getSelectedItem().toString());
        int hS=Integer.parseInt(cmbHoraSalida.getSelectedItem().toString());
        if(reservarSala.HorasCruzadas( fechaReservacion.getDate() ,hE , hS) )
        {            
            activarBoton=false;
            lblMensajeCruceHoras.setText("Horas no disponibles" );            
        }else{
            lblMensajeCruceHoras.setText("");     
        }
        
    
        
        txtPrecio.setText((hS-hE)*reservarSala.getCostoReservacionPorHora() +"" );
    }//GEN-LAST:event_cmbHoraEntradaItemStateChanged

    private void fechaReservacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaReservacionKeyTyped
        evt.consume();
    }//GEN-LAST:event_fechaReservacionKeyTyped

    private void cmbHoraSalidaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbHoraSalidaItemStateChanged
        if(cmbHoraEntrada.getSelectedItem()==null || cmbHoraSalida.getSelectedItem()==null)
            return;
        
        int hE=Integer.parseInt(cmbHoraEntrada.getSelectedItem().toString());
        int hS=Integer.parseInt(cmbHoraSalida.getSelectedItem().toString());
        if(reservarSala.HorasCruzadas( fechaReservacion.getDate() ,hE , hS) )
        {            
            activarBoton=false;
            lblMensajeCruceHoras.setText("Horas no disponibles" );            
        }else{
            lblMensajeCruceHoras.setText("" );     
        }
        DecimalFormat df = new DecimalFormat("#.00");
        txtPrecio.setText((hS-hE)*reservarSala.getCostoReservacionPorHora() +"" );
    }//GEN-LAST:event_cmbHoraSalidaItemStateChanged

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        soloLetras(evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        soloLetras(evt);
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        char c=evt.getKeyChar();
        if((c<'a' || c>'z')  && (c<'A' || c>'Z') && (c<'0' || c>'9' ))
            evt.consume();
        
    }//GEN-LAST:event_txtDireccionKeyTyped


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
            java.util.logging.Logger.getLogger(HacerReservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HacerReservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HacerReservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HacerReservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HacerReservacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbAño;
    private javax.swing.JComboBox<String> cmbCalificacion;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbHoraEntrada;
    private javax.swing.JComboBox<String> cmbHoraSalida;
    private com.toedter.calendar.JDateChooser fechaReservacion;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblCodigoSala;
    private javax.swing.JLabel lblMensajeCruceHoras;
    private javax.swing.JLabel lblMensajeDia;
    private javax.swing.JLabel lblTipoSala;
    private javax.swing.JPanel panelApellido;
    private javax.swing.JPanel panelCedula;
    private javax.swing.JPanel panelCliente;
    private javax.swing.JPanel panelCodigo;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelDatosPelicula;
    private javax.swing.JPanel panelDatosReservacion;
    private javax.swing.JPanel panelDireccion;
    private javax.swing.JPanel panelFecha;
    private javax.swing.JPanel panelHorario;
    private javax.swing.JPanel panelNombre;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JPanel panelTelefono;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigoReservacion;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombrePelicula;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
