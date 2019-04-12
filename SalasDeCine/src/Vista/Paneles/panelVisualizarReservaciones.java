package Vista.Paneles;

import Alertas.notificacionAlertas.AlertaNotificacion;
import Alertas.notificacionAlertas.AlertaOperaciones;
import Entidades.ReservacionesSalas;
import Entidades.Sala;
import OtrosOperaciones.DiseñoTabla;
import OtrosOperaciones.EventosJButton;
import Vista.InterfacesGraficas.DatosReservaciones;
import Vista.InterfacesGraficas.MenuPrincipal;
import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import modelo.operacionesDAO.ReservacionesDAO;
import modelo.operacionesDAO.SalaDAO;


public class panelVisualizarReservaciones extends javax.swing.JPanel {
    private LinkedList <Sala> listaSalas;
    private ArrayList<ReservacionesSalas > listaReservaciones;
    private MenuPrincipal presentarInicio;
    private DiseñoTabla diseñar=new DiseñoTabla();
    
    public panelVisualizarReservaciones() {
        initComponents();        
        detalleBotones();
        cargarDatosReservaciones();
        tablaReservaciones.setDefaultRenderer(Object.class, diseñar);
    }

    public void detalleBotones(){
        EventosJButton eventoColorear=new EventosJButton();         
        eventoColorear.colorearBotones(btnVisualizar, new Color(92,126,216), new Color(92,72,253));
        eventoColorear.colorearBotones(btnEliminar, new Color(240,64,52), new Color(240,33,42));             
    }
    
    private void cargarDatosReservaciones( ){      
        listaReservaciones=new ArrayList();
        SalaDAO cargaSalas =new SalaDAO();
        if(listaSalas==null)
        listaSalas= cargaSalas.cargarSalasCine("");
        DefaultTableModel modelo =new DefaultTableModel(){
            public boolean isCellEditable(int filas, int col){
                if(col==-1){return true;}else return false; 
            }
        };
        String [] columnas={"Codigo Sala","Codigo Reservacion","Tipo de Sala","fecha","Hora entrada","Hora salida", "Precio","CI Cliente","Pelicula"};
         modelo.setColumnIdentifiers(columnas);
         
    if(listaSalas!=null)
    {   
        Object [] actual=new Object[9];
        for (Sala S: listaSalas){    
            listaReservaciones.addAll(S.getReservacionesDeLaSala());
            for (ReservacionesSalas R: S.getReservacionesDeLaSala()){
                actual[0]=S.getCodigo();
                actual[1]=R.getCodigo();
                actual[2]=S.getTipo();
                actual[3]= R.getHorario().getFechaReservacion();
                actual[4]=R.getHorario().getHora_entrada();
                actual[5]=R.getHorario().getHora_salida();
                actual[6]= R.getCostoDeReservacion();           
                actual[7]= R.getCiCliente();   
                actual[8]=R.getPeliculas_estreno().getNombre();
                modelo.addRow(actual); 
            }
        }                         
    }
        tablaReservaciones.setModel(modelo);
        
    }
    
    private void visualizarReservacion(){
        int indice = tablaReservaciones.getSelectedRow();//Fila seleccionada
        if(indice <0){
            AlertaNotificacion notificar=new AlertaNotificacion(null, true);
            notificar.setLblTtulo("Error");
            notificar.setLblSubT("Por favor, selccione una fila");
            notificar.setColorBoton(Color.RED);
            notificar.agregarImagen(0);
            notificar.colorFondoBoton(new Color(69,0,0));
            notificar.reproducirSonido(0);
            notificar.setVisible(true);
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel) tablaReservaciones.getModel();//obtener modelo de datos
        String codigoReservacion = (String)modelo.getValueAt(indice, 1);//Id de la sala
        String datosSala= (String)modelo.getValueAt(indice, 0);//Datos de la sala
        
        ReservacionesSalas visualizar=null;
        for (ReservacionesSalas R: listaReservaciones){
            if(R.getCodigo().equals(codigoReservacion)){
                visualizar=R;
                break;
            }
        }
        if(visualizar == null){
            AlertaNotificacion notificar=new AlertaNotificacion(null, true);
            notificar.setLblTtulo("Error");
            notificar.setLblSubT("Error Cargar Datos");
            notificar.setColorBoton(Color.RED);
            notificar.agregarImagen(0);
            notificar.colorFondoBoton(new Color(69,0,0));
            notificar.reproducirSonido(0);
            notificar.setVisible(true);
            return;
        }
        DatosReservaciones  presentarDetalles =new DatosReservaciones();
        presentarDetalles.setVerReservacion(visualizar);
        presentarDetalles.setLblDatosSala(datosSala);
        presentarDetalles.agregarPanelCentral();
        presentarDetalles.setVisible(true);
        presentarInicio.dispose();
    }
    
    
    
    private void minimizarBúsquedaDatos(String codigo){
        DefaultTableModel modelo =new DefaultTableModel(){
            public boolean isCellEditable(int filas, int col){
                if(col==-1){return true;}else return false; 
            }
        };
        String [] columnas={"Codigo Sala","Codigo ReservacionO","Tipo de Sala","fecha","Hora entrada","Hora salida", "Precio","CI Cliente","Pelicula"};
        modelo.setColumnIdentifiers(columnas);
        if(listaSalas!=null)
        {   
            Object [] actual=new Object[10];
            for (Sala S: listaSalas){                        
                for (ReservacionesSalas R: S.getReservacionesDeLaSala()){
                    
                    if(similar(codigo, R.getCodigo()))
                    {
                        actual[0]=S.getCodigo();
                        actual[1]=R.getCodigo();
                        actual[2]=S.getTipo();
                        actual[3]= R.getHorario().getFechaReservacion();
                        actual[4]=R.getHorario().getHora_entrada();
                        actual[5]=R.getHorario().getHora_salida();
                        actual[6]= R.getCostoDeReservacion();           
                        actual[7]= R.getCiCliente();   
                        actual[8]=R.getPeliculas_estreno().getNombre();
                        modelo.addRow(actual); 
                    }
                }
            }                         
        }
        tablaReservaciones.setModel(modelo);
    }

    public void setListaSalas(LinkedList<Sala> listaSalas) {
        this.listaSalas = listaSalas;
        cargarDatosReservaciones();
    }
    
    
    
    
    private boolean similar(String txt, String cod){
        try{
        for(int i=0;i<txt.length();i++){
            if(txt.charAt(i)!= cod.charAt(i))
                return false;
        }
        }catch(NullPointerException ex){return false;}
        return true;
    }
    public void setPresentarInicio(MenuPrincipal presentarInicio) {
        this.presentarInicio = presentarInicio;
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBotones = new javax.swing.JPanel();
        panelCampoTexto = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelBotonesOperaciones = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnVisualizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        panelContenido = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReservaciones = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        panelBotones.setBackground(new java.awt.Color(51, 51, 51));
        panelBotones.setLayout(new java.awt.GridLayout(1, 0));

        panelCampoTexto.setBackground(new java.awt.Color(255, 255, 255));
        panelCampoTexto.setLayout(new java.awt.BorderLayout());

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        panelCampoTexto.add(txtBuscar, java.awt.BorderLayout.CENTER);

        jLabel1.setText("   ");
        panelCampoTexto.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jLabel2.setText("               ");
        panelCampoTexto.add(jLabel2, java.awt.BorderLayout.PAGE_END);

        jLabel3.setText("                                    ");
        panelCampoTexto.add(jLabel3, java.awt.BorderLayout.LINE_END);

        jLabel4.setText("Codigo   ");
        panelCampoTexto.add(jLabel4, java.awt.BorderLayout.LINE_START);

        panelBotones.add(panelCampoTexto);

        panelBotonesOperaciones.setOpaque(false);

        jLabel6.setText("   ");
        panelBotonesOperaciones.add(jLabel6);

        btnVisualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnVisualizar.setText("VISUALIZAR");
        btnVisualizar.setContentAreaFilled(false);
        btnVisualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVisualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVisualizarMouseClicked(evt);
            }
        });
        panelBotonesOperaciones.add(btnVisualizar);

        jLabel5.setText("          ");
        panelBotonesOperaciones.add(jLabel5);

        jLabel7.setText("          ");
        panelBotonesOperaciones.add(jLabel7);

        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        panelBotonesOperaciones.add(btnEliminar);

        jLabel8.setText("   ");
        panelBotonesOperaciones.add(jLabel8);

        panelBotones.add(panelBotonesOperaciones);

        add(panelBotones, java.awt.BorderLayout.PAGE_START);

        panelContenido.setBackground(new java.awt.Color(255, 255, 255));
        panelContenido.setLayout(new javax.swing.BoxLayout(panelContenido, javax.swing.BoxLayout.LINE_AXIS));

        tablaReservaciones.setBackground(new java.awt.Color(0, 153, 153));
        tablaReservaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaReservaciones.setToolTipText("");
        tablaReservaciones.setGridColor(new java.awt.Color(51, 51, 51));
        tablaReservaciones.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tablaReservaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaReservacionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaReservaciones);

        panelContenido.add(jScrollPane1);

        add(panelContenido, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        minimizarBúsquedaDatos(txtBuscar.getText().toUpperCase());
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnVisualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVisualizarMouseClicked
        visualizarReservacion();
    }//GEN-LAST:event_btnVisualizarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        int indice = tablaReservaciones.getSelectedRow();//Fila seleccionada        
        AlertaNotificacion notificar=new AlertaNotificacion(null, true);
        if(indice <0){
            notificar.setLblTtulo("Error");
            notificar.setLblSubT("Por favor, selccione una fila");
            notificar.setColorBoton(Color.red);
            notificar.agregarImagen(0);
            notificar.reproducirSonido(2);
            notificar.colorFondoBoton(new Color(69,0,0));
            notificar.setVisible(true);
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) tablaReservaciones.getModel();//obtener modelo de datos
        String codigo = (String)modelo.getValueAt(indice, 1);

        ReservacionesSalas eliminar=null;
        for (ReservacionesSalas R: listaReservaciones){
            if(R.getCodigo().equals(codigo)){
                eliminar=R;
                break;
            }
        }

        
        // Opcion de verificacion para la eliminacion
        AlertaOperaciones operacionAceptar=new AlertaOperaciones(null,true);
        operacionAceptar.setLblTtulo("¿ESTAS SEGURO?");
        operacionAceptar.setLblSubT("Se eliminará la Reservación Seleccionada");
        operacionAceptar.setVisible(true);
        //Verificar boton presionado
        if(!operacionAceptar.isAceptar())//Si la respuesta es no, se cancela la operacion
        return;
        //caso contrario sigue con la operacion

        ReservacionesDAO eliminacion=new ReservacionesDAO();
        int res=eliminacion.eliminarReservacion(eliminar.getCodigo());
        if(res>0){
            notificar.setLblTtulo("Corecto");
            notificar.setLblSubT("La sala ha sido eliminada correctamente");
            notificar.setColorBoton(Color.cyan);
            notificar.agregarImagen(1);
            notificar.colorFondoBoton(new Color(0,102,102));
            notificar.reproducirSonido(1);
        }else{
            notificar.setLblTtulo("Error");
            notificar.setLblSubT("No pudo eliminar la sala");
            notificar.setColorBoton(Color.red);
            notificar.reproducirSonido(0);
            notificar.agregarImagen(0);
            notificar.colorFondoBoton(new Color(69,0,0));
        }
        notificar.setVisible(true);
        cargarDatosReservaciones();
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void tablaReservacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaReservacionesMouseClicked
        if(evt.getClickCount()==2){
            visualizarReservacion();
        }
    }//GEN-LAST:event_tablaReservacionesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelBotonesOperaciones;
    private javax.swing.JPanel panelCampoTexto;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JTable tablaReservaciones;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
