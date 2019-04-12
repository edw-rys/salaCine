package Vista.Paneles;

import Entidades.ReservacionesSalas;

public class panelMostrarReservacion extends javax.swing.JPanel {

    public panelMostrarReservacion() {
        initComponents();
    }

    public void cargarDatosReservacion(ReservacionesSalas visualizar){
        //Datos reservacion
        txtCodigoReservacion.setText("   "+visualizar.getCodigo());
        txtFecha.setText("   "+ visualizar.getHorario().getFechaReservacion().toString());
        txtEntrada.setText("   "+visualizar.getHorario().getHora_entrada());
        txtSalida.setText("   "+visualizar.getHorario().getHora_salida());
        txtCosto.setText("  "+ visualizar.getCostoDeReservacion());
        //Datos Cliente
        txtCedula.setText("  "+visualizar.getCiCliente());
        txtNombreApellido.setText("  "+visualizar.getNombreCliente()+" "+visualizar.getApellidoCliente());
        txtDireccion.setText("   "+visualizar.getDireccionCliente());
        txtTelefono.setText("   "+visualizar.getTelefonoCliente());
        //Datos de la Película
        txtNombrePelicula.setText("   "+visualizar.getPeliculas_estreno().getNombre());
        txtCategoria.setText("   "+visualizar.getPeliculas_estreno().getNombreCategoria());
        txtCalificacion.setText("   "+visualizar.getPeliculas_estreno().getCalificacion());
        txtAño.setText("   "+visualizar.getPeliculas_estreno().getAñoEstreno());        
  }
    
    public void setNumeroReservacion(int numero){
        lblNumeroReservacion.setText("Reservación #"+numero);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSuperior = new javax.swing.JPanel();
        lblNumeroReservacion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelCentro = new javax.swing.JPanel();
        fila1 = new javax.swing.JPanel();
        panelContenedorInfoR = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        panelDatosReservacion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoReservacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtEntrada = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lblAtributo1 = new javax.swing.JLabel();
        txtSalida = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        lblAtributo2 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        panelContenedorInfoCliente = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        panelDatosCliente = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        txtNombreApellido = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        lblAtributo3 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        fila2 = new javax.swing.JPanel();
        panelContenedorInfoPelicula = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        panelDatosPelicula = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtNombrePelicula = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        txtCalificacion = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        lblAtributo4 = new javax.swing.JLabel();
        txtAño = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        panelSuperior.setBackground(new java.awt.Color(0, 102, 0));

        lblNumeroReservacion.setFont(new java.awt.Font("Pristina", 0, 36)); // NOI18N
        lblNumeroReservacion.setText("Resrvación #N ");
        panelSuperior.add(lblNumeroReservacion);

        jLabel1.setText("                                            ");
        panelSuperior.add(jLabel1);

        add(panelSuperior);

        panelCentro.setOpaque(false);
        panelCentro.setLayout(new java.awt.GridLayout(2, 1));

        fila1.setOpaque(false);
        fila1.setLayout(new java.awt.GridLayout(1, 2));

        panelContenedorInfoR.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), null, null));
        panelContenedorInfoR.setOpaque(false);
        panelContenedorInfoR.setLayout(new javax.swing.BoxLayout(panelContenedorInfoR, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setBackground(new java.awt.Color(255, 108, 39));
        jPanel5.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Poor Richard", 0, 29)); // NOI18N
        jLabel6.setText("Datos de la Reservación");
        jPanel5.add(jLabel6);

        panelContenedorInfoR.add(jPanel5);

        panelDatosReservacion.setOpaque(false);
        panelDatosReservacion.setLayout(new java.awt.GridLayout(10, 2));

        jLabel2.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("       Codigo de Reservacion: ");
        panelDatosReservacion.add(jLabel2);

        txtCodigoReservacion.setEditable(false);
        txtCodigoReservacion.setBackground(new java.awt.Color(255, 255, 255));
        txtCodigoReservacion.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtCodigoReservacion.setBorder(null);
        panelDatosReservacion.add(txtCodigoReservacion);

        jLabel5.setText(" ");
        panelDatosReservacion.add(jLabel5);
        panelDatosReservacion.add(jSeparator1);

        jLabel3.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("       Fecha:");
        panelDatosReservacion.add(jLabel3);

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        txtFecha.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtFecha.setBorder(null);
        panelDatosReservacion.add(txtFecha);

        jLabel10.setText(" ");
        panelDatosReservacion.add(jLabel10);
        panelDatosReservacion.add(jSeparator2);

        jLabel4.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("       Hora de Entrada:");
        panelDatosReservacion.add(jLabel4);

        txtEntrada.setEditable(false);
        txtEntrada.setBackground(new java.awt.Color(255, 255, 255));
        txtEntrada.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtEntrada.setBorder(null);
        panelDatosReservacion.add(txtEntrada);

        jLabel11.setText(" ");
        panelDatosReservacion.add(jLabel11);
        panelDatosReservacion.add(jSeparator3);

        lblAtributo1.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        lblAtributo1.setForeground(new java.awt.Color(51, 51, 51));
        lblAtributo1.setText("       Hora de Salida:");
        panelDatosReservacion.add(lblAtributo1);

        txtSalida.setEditable(false);
        txtSalida.setBackground(new java.awt.Color(255, 255, 255));
        txtSalida.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtSalida.setBorder(null);
        panelDatosReservacion.add(txtSalida);

        jLabel12.setText(" ");
        panelDatosReservacion.add(jLabel12);
        panelDatosReservacion.add(jSeparator4);

        lblAtributo2.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        lblAtributo2.setForeground(new java.awt.Color(51, 51, 51));
        lblAtributo2.setText("       Costo de Reservación:");
        panelDatosReservacion.add(lblAtributo2);

        txtCosto.setEditable(false);
        txtCosto.setBackground(new java.awt.Color(255, 255, 255));
        txtCosto.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtCosto.setBorder(null);
        panelDatosReservacion.add(txtCosto);

        jLabel15.setText(" ");
        panelDatosReservacion.add(jLabel15);
        panelDatosReservacion.add(jSeparator7);

        panelContenedorInfoR.add(panelDatosReservacion);

        fila1.add(panelContenedorInfoR);

        panelContenedorInfoCliente.setOpaque(false);
        panelContenedorInfoCliente.setLayout(new javax.swing.BoxLayout(panelContenedorInfoCliente, javax.swing.BoxLayout.Y_AXIS));

        jPanel6.setBackground(new java.awt.Color(255, 108, 39));
        jPanel6.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Poor Richard", 0, 29)); // NOI18N
        jLabel7.setText("Datos del Cliente");
        jPanel6.add(jLabel7);

        panelContenedorInfoCliente.add(jPanel6);

        panelDatosCliente.setOpaque(false);
        panelDatosCliente.setLayout(new java.awt.GridLayout(9, 2));

        jLabel8.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("               Cedula");
        panelDatosCliente.add(jLabel8);

        txtCedula.setEditable(false);
        txtCedula.setBackground(new java.awt.Color(255, 255, 255));
        txtCedula.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtCedula.setBorder(null);
        panelDatosCliente.add(txtCedula);

        jLabel9.setText(" ");
        panelDatosCliente.add(jLabel9);
        panelDatosCliente.add(jSeparator5);

        jLabel13.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("               Apellidos y Nombres");
        panelDatosCliente.add(jLabel13);

        txtNombreApellido.setEditable(false);
        txtNombreApellido.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreApellido.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtNombreApellido.setBorder(null);
        panelDatosCliente.add(txtNombreApellido);

        jLabel14.setText(" ");
        panelDatosCliente.add(jLabel14);
        panelDatosCliente.add(jSeparator6);

        jLabel17.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("               Teléfono:");
        panelDatosCliente.add(jLabel17);

        txtTelefono.setEditable(false);
        txtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtTelefono.setBorder(null);
        panelDatosCliente.add(txtTelefono);

        jLabel18.setText(" ");
        panelDatosCliente.add(jLabel18);
        panelDatosCliente.add(jSeparator8);

        lblAtributo3.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        lblAtributo3.setForeground(new java.awt.Color(51, 51, 51));
        lblAtributo3.setText("                Dirección");
        panelDatosCliente.add(lblAtributo3);

        txtDireccion.setEditable(false);
        txtDireccion.setBackground(new java.awt.Color(255, 255, 255));
        txtDireccion.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtDireccion.setBorder(null);
        panelDatosCliente.add(txtDireccion);

        jLabel19.setText(" ");
        panelDatosCliente.add(jLabel19);
        panelDatosCliente.add(jSeparator9);

        panelContenedorInfoCliente.add(panelDatosCliente);

        fila1.add(panelContenedorInfoCliente);

        panelCentro.add(fila1);

        fila2.setOpaque(false);
        fila2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelContenedorInfoPelicula.setOpaque(false);
        panelContenedorInfoPelicula.setLayout(new javax.swing.BoxLayout(panelContenedorInfoPelicula, javax.swing.BoxLayout.Y_AXIS));

        jPanel7.setBackground(new java.awt.Color(0, 102, 0));

        jLabel28.setFont(new java.awt.Font("Poor Richard", 0, 29)); // NOI18N
        jLabel28.setText("Película");
        jPanel7.add(jLabel28);

        panelContenedorInfoPelicula.add(jPanel7);

        panelDatosPelicula.setOpaque(false);
        panelDatosPelicula.setLayout(new java.awt.GridLayout(9, 2));

        jLabel20.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Nombre");
        panelDatosPelicula.add(jLabel20);

        txtNombrePelicula.setEditable(false);
        txtNombrePelicula.setBackground(new java.awt.Color(255, 255, 255));
        txtNombrePelicula.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtNombrePelicula.setBorder(null);
        panelDatosPelicula.add(txtNombrePelicula);

        jLabel22.setText(" ");
        panelDatosPelicula.add(jLabel22);
        panelDatosPelicula.add(jSeparator10);

        jLabel23.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Categoría");
        panelDatosPelicula.add(jLabel23);

        txtCategoria.setEditable(false);
        txtCategoria.setBackground(new java.awt.Color(255, 255, 255));
        txtCategoria.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtCategoria.setBorder(null);
        panelDatosPelicula.add(txtCategoria);

        jLabel24.setText(" ");
        panelDatosPelicula.add(jLabel24);
        panelDatosPelicula.add(jSeparator11);

        jLabel25.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("Calificación");
        panelDatosPelicula.add(jLabel25);

        txtCalificacion.setEditable(false);
        txtCalificacion.setBackground(new java.awt.Color(255, 255, 255));
        txtCalificacion.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtCalificacion.setBorder(null);
        panelDatosPelicula.add(txtCalificacion);

        jLabel26.setText(" ");
        panelDatosPelicula.add(jLabel26);
        panelDatosPelicula.add(jSeparator12);

        lblAtributo4.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        lblAtributo4.setForeground(new java.awt.Color(51, 51, 51));
        lblAtributo4.setText("Año de estreno");
        panelDatosPelicula.add(lblAtributo4);

        txtAño.setEditable(false);
        txtAño.setBackground(new java.awt.Color(255, 255, 255));
        txtAño.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtAño.setBorder(null);
        panelDatosPelicula.add(txtAño);

        jLabel27.setText(" ");
        panelDatosPelicula.add(jLabel27);
        panelDatosPelicula.add(jSeparator13);

        panelContenedorInfoPelicula.add(panelDatosPelicula);

        fila2.add(panelContenedorInfoPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 5, 570, -1));

        panelCentro.add(fila2);

        add(panelCentro);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel fila1;
    private javax.swing.JPanel fila2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblAtributo1;
    private javax.swing.JLabel lblAtributo2;
    private javax.swing.JLabel lblAtributo3;
    private javax.swing.JLabel lblAtributo4;
    private javax.swing.JLabel lblNumeroReservacion;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelContenedorInfoCliente;
    private javax.swing.JPanel panelContenedorInfoPelicula;
    private javax.swing.JPanel panelContenedorInfoR;
    private javax.swing.JPanel panelDatosCliente;
    private javax.swing.JPanel panelDatosPelicula;
    private javax.swing.JPanel panelDatosReservacion;
    public javax.swing.JPanel panelSuperior;
    private javax.swing.JTextField txtAño;
    private javax.swing.JTextField txtCalificacion;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigoReservacion;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombreApellido;
    private javax.swing.JTextField txtNombrePelicula;
    private javax.swing.JTextField txtSalida;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
