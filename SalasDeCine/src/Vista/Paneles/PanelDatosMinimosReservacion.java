package Vista.Paneles;

import Entidades.ReservacionesSalas;

public class PanelDatosMinimosReservacion extends javax.swing.JPanel {

    public PanelDatosMinimosReservacion() {
        initComponents();
    }

    public void cargarDatos(ReservacionesSalas R,int numR){
        lblNumeroR.setText("Reservación #"+numR);
        txtCliente.setText( "   "+R.getCiCliente());
        txtCodigo.setText("   "+R.getCodigo());
        txtPelicula.setText("   "+R.getPeliculas_estreno().getNombre());
        txtFecha.setText("   "+R.getHorario().getFechaReservacion().toString());
        txtHorario.setText("   "+R.getHorario().getHora_entrada()+":00 - "+
                R.getHorario().getHora_salida()+":00");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblNumeroR = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtPelicula = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        txrFecha = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        txtHorario = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(51, 102, 0));

        lblNumeroR.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        lblNumeroR.setForeground(new java.awt.Color(255, 255, 255));
        lblNumeroR.setText("Reservación #");
        jPanel1.add(lblNumeroR);

        add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.GridLayout(6, 2));

        jLabel2.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Codigo Reservación    ");
        jPanel5.add(jLabel2);

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(255, 255, 255));
        txtCodigo.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtCodigo.setBorder(null);
        jPanel5.add(txtCodigo);

        jLabel1.setText(" ");
        jPanel5.add(jLabel1);
        jPanel5.add(jSeparator1);

        jLabel3.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Cliente");
        jPanel5.add(jLabel3);

        txtCliente.setEditable(false);
        txtCliente.setBackground(new java.awt.Color(255, 255, 255));
        txtCliente.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtCliente.setBorder(null);
        jPanel5.add(txtCliente);

        jLabel5.setText(" ");
        jPanel5.add(jLabel5);
        jPanel5.add(jSeparator2);

        jLabel4.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Pelicula");
        jPanel5.add(jLabel4);

        txtPelicula.setEditable(false);
        txtPelicula.setBackground(new java.awt.Color(255, 255, 255));
        txtPelicula.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtPelicula.setBorder(null);
        jPanel5.add(txtPelicula);

        jLabel6.setText(" ");
        jPanel5.add(jLabel6);
        jPanel5.add(jSeparator3);

        jPanel2.add(jPanel5);

        jSeparator6.setForeground(new java.awt.Color(0, 102, 0));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator6);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridLayout(4, 1));

        txrFecha.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txrFecha.setForeground(new java.awt.Color(51, 51, 51));
        txrFecha.setText("Fecha                                ");
        jPanel3.add(txrFecha);

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        txtFecha.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtFecha.setBorder(null);
        jPanel3.add(txtFecha);

        jLabel8.setText(" ");
        jPanel3.add(jLabel8);
        jPanel3.add(jSeparator4);

        jLabel9.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Horario");
        jPanel3.add(jLabel9);

        txtHorario.setEditable(false);
        txtHorario.setBackground(new java.awt.Color(255, 255, 255));
        txtHorario.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtHorario.setBorder(null);
        jPanel3.add(txtHorario);

        jLabel10.setText(" ");
        jPanel3.add(jLabel10);
        jPanel3.add(jSeparator5);

        jPanel2.add(jPanel3);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lblNumeroR;
    private javax.swing.JLabel txrFecha;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHorario;
    private javax.swing.JTextField txtPelicula;
    // End of variables declaration//GEN-END:variables
}
