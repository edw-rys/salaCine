package Vista.Paneles;

import Alertas.notificacionAlertas.AlertaNotificacion;
import Alertas.notificacionAlertas.AlertaOperaciones;
import Entidades.*;
import OtrosOperaciones.DiseñoTabla;
import OtrosOperaciones.EventosJButton;
import Vista.InterfacesGraficas.DatosSala;
import Vista.InterfacesGraficas.MenuPrincipal;
import Vista.InterfacesGraficas.RegistroSalasCine;
import java.awt.Color;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import modelo.operacionesDAO.SalaDAO;

public class panelVisualizarSalas extends javax.swing.JPanel {
    private MenuPrincipal presentarInicio=new MenuPrincipal();
    
    private DiseñoTabla diseñar=new DiseñoTabla();
    private LinkedList <Sala> salas=new LinkedList<>();
    public panelVisualizarSalas() {
        initComponents();
        detalleBotones();
        cargarDatosSalas("");
        tablaSalas.setDefaultRenderer(Object.class, diseñar);
    }
    
    public void detalleBotones(){
        EventosJButton eventoColorear=new EventosJButton();         
        eventoColorear.colorearBotones(btnVisualizar, new Color(92,126,216), new Color(92,72,253));
        eventoColorear.colorearBotones(btnEliminar, new Color(240,64,52), new Color(240,33,42));
        eventoColorear.colorearBotones(btnEditar, new Color(52,149,19), new Color(24,112,24));              
    }
    private void cargarDatosSalas(String criterio){
        SalaDAO cargaSalas =new SalaDAO();
        salas= cargaSalas.cargarSalasCine(criterio);
        DefaultTableModel modelo =new DefaultTableModel(){
            public boolean isCellEditable(int filas, int col){
                if(col==-1){return true;}else return false; 
            }
        };
        String [] columnas={"ID","CODIGO","TIPO","NOMBRE","PRECIO RESERVACION", "TOTAL DIAS RESERVADOS", "NUMERO DE RESERVACIONES", "Ganancias"};
         modelo.setColumnIdentifiers(columnas);
         
         Object [] actual=new Object[8];
         if(salas!=null)
        for (Sala S: salas){
            actual[0]= S.getId();
            actual[1]=S.getCodigo();
            actual[2]= S.getTipo();
            actual[3]=S.getNombre();
            actual[4]=S.getCostoReservacionPorHora();
            actual[5]= S.getHorario().getDias().length;
            actual[6]=S.getNumeroReservaciones();
            actual[7]= S.getGanaciasGeneradasPorReservaciones();            
            modelo.addRow(actual);      
        }
        tablaSalas.setModel(modelo);
        
    }
    
    
    void visualizarSalaSeleccionada(){
        int indice = tablaSalas.getSelectedRow();//Fila seleccionada              
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
        DefaultTableModel modelo = (DefaultTableModel) tablaSalas.getModel();//obtener modelo de datos
        String codigo = (String)modelo.getValueAt(indice, 1);
        
        Sala visualizar=null;
        for(Sala S:salas){
            if(S.getCodigo().equals(codigo)){
                visualizar=S;
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
        DatosSala  presentarDetalles =new DatosSala();
        presentarDetalles.setVisualizarSala(visualizar);
        presentarDetalles.cargarReservaciones();
        presentarDetalles.setVisible(true);
        presentarInicio.dispose();
        
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
        btnEditar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        panelContenido = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSalas = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
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

        jLabel4.setText("CODIGO   ");
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

        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("EDITAR");
        btnEditar.setContentAreaFilled(false);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
        });
        panelBotonesOperaciones.add(btnEditar);

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

        tablaSalas.setBackground(new java.awt.Color(0, 153, 153));
        tablaSalas.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaSalas.setGridColor(new java.awt.Color(51, 51, 51));
        tablaSalas.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tablaSalas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaSalasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaSalas);

        panelContenido.add(jScrollPane1);

        add(panelContenido, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        cargarDatosSalas(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnVisualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVisualizarMouseClicked
        visualizarSalaSeleccionada();
    }//GEN-LAST:event_btnVisualizarMouseClicked

    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseClicked
        int indice = tablaSalas.getSelectedRow();//Fila seleccionada        
        if(indice <0){
            AlertaNotificacion notificar=new AlertaNotificacion(null, true);
            notificar.setLblTtulo("Error");
            notificar.setLblSubT("Por favor, selccione una fila");
            notificar.setColorBoton(Color.red);
            notificar.agregarImagen(0);
            notificar.colorFondoBoton(new Color(69,0,0));
            notificar.reproducirSonido(2);
            notificar.setVisible(true);
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel) tablaSalas.getModel();//obtener modelo de datos
        String codigo = (String)modelo.getValueAt(indice, 1);
        
        Sala editar=null;
        for(Sala S:salas){
            if(S.getCodigo().equals(codigo)){
                editar=S;
                break;
            }
        }
        RegistroSalasCine Presenta=new RegistroSalasCine();
        int tip=1;
        if(editar instanceof SalaGeneral){
            Presenta.setLabelsPorSala("Promociones activas", "X");
            tip=1;
        }
        else if(editar instanceof SalaVIP){
            Presenta.setLabelsPorSala("Modelo Gafas 3D", "Servicio Adicional");
            tip=2;
        }
        else {
            Presenta.setLabelsPorSala("Modelo Butacas", "Servicio Adicional(GRATIS)");
            tip=3;
        }
        Presenta.cargarCmb(tip);
        Presenta.setEdicionSala(editar);
        
        
        Presenta.setVisible(true);        
        this.setVisible(false);
        //principal.setVisible(false);
        presentarInicio.dispose();
        //cargarDatosSalas("");
    }//GEN-LAST:event_btnEditarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        int indice = tablaSalas.getSelectedRow();//Fila seleccionada
        System.out.println(indice);
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
        
        DefaultTableModel modelo = (DefaultTableModel) tablaSalas.getModel();//obtener modelo de datos
        String codigo = (String)modelo.getValueAt(indice, 1);
        
        Sala eliminar=null;
        for(Sala S:salas){
            if(S.getCodigo().equals(codigo)){
                eliminar=S;
                break;
            }
        }
                
        if(!eliminar.reservacionesVacias())
         {            
            notificar.setLblTtulo("Error");
            notificar.setLblSubT("No se puede eliminar una sala con reservaciones");
            notificar.setColorBoton(Color.red);
            notificar.agregarImagen(0);
            notificar.colorFondoBoton(new Color(69,0,0)); 
            notificar.reproducirSonido(2);
            notificar.setVisible(true);
            return;
        }
        // Opcion de verificacion para la eliminacion
        AlertaOperaciones operacionAceptar=new AlertaOperaciones(null,true);
            operacionAceptar.setLblTtulo("¿ESTAS SEGURO?");
            operacionAceptar.setLblSubT("Se eliminará la sala Seleccionada");
            operacionAceptar.setVisible(true);                
        //Verificar boton presionado
            if(!operacionAceptar.isAceptar())//Si la respuesta es no, se cancela la operacion
                return;
            //caso contrario sigue con la operacion
            
            SalaDAO eliminacion=new SalaDAO();
            int res=eliminacion.eliminarSala(eliminar.getCodigo());
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
            cargarDatosSalas("");
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void tablaSalasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSalasMouseClicked
        if(evt.getClickCount()==2){
            visualizarSalaSeleccionada();
        }
    }//GEN-LAST:event_tablaSalasMouseClicked

    public void setPresentarInicio(MenuPrincipal presentarInicio) {
        this.presentarInicio = presentarInicio;
        
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
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
    private javax.swing.JTable tablaSalas;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
