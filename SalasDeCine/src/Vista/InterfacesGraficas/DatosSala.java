package Vista.InterfacesGraficas;

import Entidades.ReservacionesSalas;
import Entidades.Sala;
import Entidades.SalaBlackBox;
import Entidades.SalaGeneral;
import Entidades.SalaVIP;
import Interfaces.InterfaceDatosSala;
import OtrosOperaciones.DetalleComponentes;
import OtrosOperaciones.DiseñoTabla;
import OtrosOperaciones.EventosJButton;
import Vista.Paneles.PanelDatosMinimosReservacion;
import Vista.Paneles.panelMostrarReservacion;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;


public class DatosSala extends javax.swing.JFrame implements  InterfaceDatosSala{

    private Sala visualizarSala;
    DiseñoTabla diseñar=new DiseñoTabla();
    public DatosSala() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);//Modificar el estado de extendido
        if(visualizarSala !=null)
        {
            cargarDatosSala();
        }       
        diseñarBoton();
        
       tablaHorario.setDefaultRenderer(Object.class, diseñar);
        this.setIconImage(DetalleComponentes.getIconImage());
    }

    private void diseñarBoton(){
        EventosJButton colorearBotones=new EventosJButton(btnCerrar);
        colorearBotones.colorearBotones(btnCerrar, new Color(240,94,43),  new Color (240,65,34));        
    }
    public void cargarDatosSala(){
        String espacios="               ";
        //setea en labels y JTextField los datos principales de la sala :V      
        this.setTitle( "Sala "+visualizarSala.getTipo() );
        lblTipoSala.setText("Sala "+visualizarSala.getTipo());
        txtCodigo.setText(espacios+visualizarSala.getCodigo()+"");           
        txtNombre.setText(espacios+visualizarSala.getNombre());
        txtPrecio.setText(espacios+visualizarSala.getCostoReservacionPorHora()+"");        
        txtCantidadReservaciones.setText(espacios+visualizarSala.getNumeroReservaciones()+"");
        txtCantidadDias.setText(espacios+ visualizarSala.getHorario().getDias().length+"");
        
        //Cargar campos propios 
        String at1="",at2="",frase1="",frase2="";
        if(visualizarSala instanceof SalaGeneral){
            SalaGeneral G=(SalaGeneral) visualizarSala;
            at1=G.getPromiciones();
            at2=G.getX();
            frase1="Promociones activa";
                frase2="SNACKS";
        }else{
            if(visualizarSala instanceof SalaVIP){
                SalaVIP V=(SalaVIP) visualizarSala;
                at1=V.getModeloGafas3D();
                at2=V.getServicioAdicionalPaga();
                frase1="Modelo Gafas 3D";
                frase2="Servicio Adicional";
            }else{
                SalaBlackBox BX=(SalaBlackBox) visualizarSala;
                at1=BX.getTipoAsiento();
                at2=BX.getServiciAdicionalGratuitos();
                frase1="Modelo Butacas";
                frase2="Servicio Adicional(GRATIS)";
            }
        }
        this.lblAtributo1.setText(frase1);
        this.lblAtributo2.setText(frase2);
        txtAtributo1.setText(espacios+at1);
        txtAtributo2.setText(espacios+at2);
        //Fin seteo
        //cargar Horario
        //Recolecta los datos del horario en arreglos
        String dias[] =visualizarSala.getHorario().getDias();
        int entrada[]= visualizarSala.getHorario().getHora_entrada();
        int salida []= visualizarSala.getHorario().getHora_salida();
        //Fin recoleccion de datos
        
        
        int totalDias=visualizarSala.getHorario().getDias().length;
        DefaultTableModel modelo =new DefaultTableModel();
        String [] columnas={"DIA","Hora Entrada","Hora Salida"};
         modelo.setColumnIdentifiers(columnas);
         Object [] horarioDES=new Object[3];
         
        for(int i=0;i<totalDias;i++){
            horarioDES[0]=dias[i]  ;
            horarioDES[1]= entrada [i]+":00";
            horarioDES[2]= salida[i]+":00";
            modelo.addRow(horarioDES);
        }
        tablaHorario.setModel(modelo);        
        //Imagen       
        if(!visualizarSala.getImagen().equals("ninguna"))
            rsscalelabel.RSScaleLabel.setScaleLabel(lblImagen, visualizarSala.getImagen());
        else{
            rsscalelabel.RSScaleLabel.setScaleLabel(lblImagen, "src/Vista/Imagenes/imagenDefault.png");                    
        }
        
        
    }
 
    public void cargarReservaciones(){
        txtGananciasTotales.setText( "               "+visualizarSala.getGanaciasGeneradasPorReservaciones()+"");
        if(visualizarSala.reservacionesVacias())
            return;
        else{
            for(ReservacionesSalas R:visualizarSala.getReservacionesDeLaSala() ){
                cargarDatosReservaciones(R);
            }
        }
    }
    int o=0;
    public void cargarDatosReservaciones(ReservacionesSalas visualizar){
        o++;        
        panelMostrarReservacion reservacion=new panelMostrarReservacion(); 
        reservacion.cargarDatosReservacion(visualizar);
        reservacion.setNumeroReservacion(o);        
        panelDatosReservaciones.add(reservacion);              
    }
    
    
    public void cargarDatosMinimosReservacion(){
        if(visualizarSala.reservacionesVacias())
            return;
        else{
            for(ReservacionesSalas R:visualizarSala.getReservacionesDeLaSala() ){
                PanelDatosMinimosReservacion mostrar =new PanelDatosMinimosReservacion();
                o++;  
                mostrar.cargarDatos(R, o);               
                panelDatosReservaciones.add(mostrar); 
            }
        }
        
        
    }
    
    public void setAtributos (String uno, String dos){
        lblAtributo1.setText(uno);
        lblAtributo2.setText(dos);
    }
  
    public void setVisualizarSala(Sala visualizarSala) {
        this.visualizarSala = visualizarSala;
        cargarDatosSala();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelContenedor = new javax.swing.JPanel();
        panelSuperior = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        lblTipoSala = new javax.swing.JLabel();
        panelCentral = new javax.swing.JPanel();
        panelDatosSala = new javax.swing.JPanel();
        panelSalaReferencias = new javax.swing.JPanel();
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
        txtAtributo1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        lblAtributo2 = new javax.swing.JLabel();
        txtAtributo2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txtCantidadDias = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtCantidadReservaciones = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        txtGananciasTotales = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        panelFechaImg = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaHorario = new javax.swing.JTable();
        lblImagen = new javax.swing.JLabel();
        lblFraseImg = new javax.swing.JLabel();
        panelDatosReservaciones = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setAutoscrolls(true);

        panelContenedor.setBackground(new java.awt.Color(255, 255, 255));
        panelContenedor.setOpaque(false);
        panelContenedor.setLayout(new java.awt.BorderLayout());

        panelSuperior.setBackground(new java.awt.Color(142, 0, 0));

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/canguil.png"))); // NOI18N
        btnCerrar.setText("SALIR");
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        lblTipoSala.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        lblTipoSala.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoSala.setText("jLabel1");

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTipoSala)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 668, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTipoSala)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelContenedor.add(panelSuperior, java.awt.BorderLayout.PAGE_START);

        panelCentral.setOpaque(false);
        panelCentral.setLayout(new javax.swing.BoxLayout(panelCentral, javax.swing.BoxLayout.PAGE_AXIS));

        panelDatosSala.setOpaque(false);
        panelDatosSala.setLayout(new javax.swing.BoxLayout(panelDatosSala, javax.swing.BoxLayout.LINE_AXIS));

        panelSalaReferencias.setOpaque(false);
        panelSalaReferencias.setLayout(new java.awt.GridLayout(17, 2));

        jLabel2.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Codigo de la Sala: ");
        panelSalaReferencias.add(jLabel2);

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(255, 255, 255));
        txtCodigo.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtCodigo.setBorder(null);
        panelSalaReferencias.add(txtCodigo);

        jLabel5.setText(" ");
        panelSalaReferencias.add(jLabel5);
        panelSalaReferencias.add(jSeparator1);

        jLabel3.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Nombre ");
        panelSalaReferencias.add(jLabel3);

        txtNombre.setEditable(false);
        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtNombre.setBorder(null);
        panelSalaReferencias.add(txtNombre);

        jLabel10.setText(" ");
        panelSalaReferencias.add(jLabel10);
        panelSalaReferencias.add(jSeparator2);

        jLabel4.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Precio para Reservar");
        panelSalaReferencias.add(jLabel4);

        txtPrecio.setEditable(false);
        txtPrecio.setBackground(new java.awt.Color(255, 255, 255));
        txtPrecio.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtPrecio.setBorder(null);
        panelSalaReferencias.add(txtPrecio);

        jLabel11.setText(" ");
        panelSalaReferencias.add(jLabel11);
        panelSalaReferencias.add(jSeparator3);

        lblAtributo1.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        lblAtributo1.setForeground(new java.awt.Color(51, 51, 51));
        lblAtributo1.setText("atributo1");
        panelSalaReferencias.add(lblAtributo1);

        txtAtributo1.setEditable(false);
        txtAtributo1.setBackground(new java.awt.Color(255, 255, 255));
        txtAtributo1.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtAtributo1.setBorder(null);
        panelSalaReferencias.add(txtAtributo1);

        jLabel12.setText(" ");
        panelSalaReferencias.add(jLabel12);
        panelSalaReferencias.add(jSeparator4);

        lblAtributo2.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        lblAtributo2.setForeground(new java.awt.Color(51, 51, 51));
        lblAtributo2.setText("atributo2");
        panelSalaReferencias.add(lblAtributo2);

        txtAtributo2.setEditable(false);
        txtAtributo2.setBackground(new java.awt.Color(255, 255, 255));
        txtAtributo2.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtAtributo2.setBorder(null);
        panelSalaReferencias.add(txtAtributo2);

        jLabel13.setText(" ");
        panelSalaReferencias.add(jLabel13);
        panelSalaReferencias.add(jSeparator5);

        jLabel7.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Cantidad Dias disponible");
        panelSalaReferencias.add(jLabel7);

        txtCantidadDias.setEditable(false);
        txtCantidadDias.setBackground(new java.awt.Color(255, 255, 255));
        txtCantidadDias.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtCantidadDias.setBorder(null);
        panelSalaReferencias.add(txtCantidadDias);

        jLabel14.setText(" ");
        panelSalaReferencias.add(jLabel14);
        panelSalaReferencias.add(jSeparator6);

        jLabel8.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("CantidadReservaciones");
        panelSalaReferencias.add(jLabel8);

        txtCantidadReservaciones.setEditable(false);
        txtCantidadReservaciones.setBackground(new java.awt.Color(255, 255, 255));
        txtCantidadReservaciones.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtCantidadReservaciones.setBorder(null);
        panelSalaReferencias.add(txtCantidadReservaciones);

        jLabel15.setText(" ");
        panelSalaReferencias.add(jLabel15);
        panelSalaReferencias.add(jSeparator7);

        jLabel9.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Ganancias Totales");
        panelSalaReferencias.add(jLabel9);

        txtGananciasTotales.setEditable(false);
        txtGananciasTotales.setBackground(new java.awt.Color(255, 255, 255));
        txtGananciasTotales.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        txtGananciasTotales.setBorder(null);
        panelSalaReferencias.add(txtGananciasTotales);

        jLabel16.setText(" ");
        panelSalaReferencias.add(jLabel16);
        panelSalaReferencias.add(jSeparator8);

        panelDatosSala.add(panelSalaReferencias);

        panelFechaImg.setOpaque(false);

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));

        jLabel18.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 0, 0));
        jLabel18.setText("HORARIO");
        jPanel8.add(jLabel18);

        tablaHorario.setBackground(new java.awt.Color(51, 0, 0));
        tablaHorario.setFont(new java.awt.Font("Myanmar Text", 0, 12)); // NOI18N
        tablaHorario.setForeground(new java.awt.Color(255, 255, 255));
        tablaHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tablaHorario.setCellSelectionEnabled(true);
        tablaHorario.setEnabled(false);
        tablaHorario.setGridColor(new java.awt.Color(255, 255, 255));
        tablaHorario.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tablaHorario.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(tablaHorario);

        lblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lblFraseImg.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        lblFraseImg.setText("Imagen de la Sala");

        javax.swing.GroupLayout panelFechaImgLayout = new javax.swing.GroupLayout(panelFechaImg);
        panelFechaImg.setLayout(panelFechaImgLayout);
        panelFechaImgLayout.setHorizontalGroup(
            panelFechaImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFechaImgLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelFechaImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFechaImgLayout.createSequentialGroup()
                        .addComponent(lblFraseImg)
                        .addGap(181, 181, 181))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFechaImgLayout.createSequentialGroup()
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFechaImgLayout.createSequentialGroup()
                .addGap(0, 91, Short.MAX_VALUE)
                .addGroup(panelFechaImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFechaImgLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(173, 173, 173))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFechaImgLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        panelFechaImgLayout.setVerticalGroup(
            panelFechaImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFechaImgLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFraseImg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelDatosSala.add(panelFechaImg);

        panelCentral.add(panelDatosSala);

        panelDatosReservaciones.setLayout(new javax.swing.BoxLayout(panelDatosReservaciones, javax.swing.BoxLayout.Y_AXIS));
        panelCentral.add(panelDatosReservaciones);

        panelContenedor.add(panelCentral, java.awt.BorderLayout.CENTER);

        jScrollPane1.setViewportView(panelContenedor);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
        MenuPrincipal pantallaPincipal=new MenuPrincipal();
        pantallaPincipal.setVisible(true);
    }//GEN-LAST:event_btnCerrarActionPerformed

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
            java.util.logging.Logger.getLogger(DatosSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatosSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatosSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatosSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatosSala().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lblAtributo1;
    private javax.swing.JLabel lblAtributo2;
    private javax.swing.JLabel lblFraseImg;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblTipoSala;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelDatosReservaciones;
    private javax.swing.JPanel panelDatosSala;
    private javax.swing.JPanel panelFechaImg;
    private javax.swing.JPanel panelSalaReferencias;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JTable tablaHorario;
    private javax.swing.JTextField txtAtributo1;
    private javax.swing.JTextField txtAtributo2;
    private javax.swing.JTextField txtCantidadDias;
    private javax.swing.JTextField txtCantidadReservaciones;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtGananciasTotales;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
