package Vista.Paneles;

import Alertas.notificacionAlertas.AlertaNotificacion;
import Entidades.Sala;
import OtrosOperaciones.DiseñoTabla;
import OtrosOperaciones.EventosJButton;
import Vista.InterfacesGraficas.DatosSala;
import Vista.InterfacesGraficas.HacerReservacion;
import Vista.InterfacesGraficas.MenuPrincipal;
import java.awt.Color;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;



public class panelSalasAReservar extends javax.swing.JPanel {
    private MenuPrincipal pantallaInicio;
    private LinkedList<Sala> listaSalas ;
    private DiseñoTabla diseñar=new DiseñoTabla();
    public panelSalasAReservar() {
        initComponents();
        tablaSalas.setDefaultRenderer(Object.class, diseñar);
        EventosJButton eventoColorear=new EventosJButton();         
        eventoColorear.colorearBotones(btnVisualizar, new Color(92,126,216), new Color(92,72,253));
        eventoColorear.colorearBotones(btnReservar, new Color(240,64,52), new Color(240,33,42));
    }

    public void setPantallaInicio(MenuPrincipal pantallaInicio) {
       this.pantallaInicio = pantallaInicio;
    }

    
    public void setListaSalas(LinkedList<Sala> listaSalas){
        this.listaSalas=listaSalas;
    }
    
    public void cargarDatosSalas( ){       
        DefaultTableModel modelo =new DefaultTableModel(){
            public boolean isCellEditable(int filas, int col){
                if(col==-1){return true;}else return false; 
            }
        };
        String [] columnas={"ID","CODIGO","TIPO","NOMBRE","PRECIO RESERVACION", "TOTAL DIAS DISPONIBLES PARA RESERVAR"};
         modelo.setColumnIdentifiers(columnas);
         
         Object [] actual=new Object[6];
         if(listaSalas!=null)
        for (Sala S: listaSalas){            
            actual[0]= S.getId();
            actual[1]=S.getCodigo();
            actual[2]= S.getTipo();
            actual[3]=S.getNombre();
            actual[4]=S.getCostoReservacionPorHora();
            actual[5]= S.getHorario().getDias().length;          
            modelo.addRow(actual);      
        }
        tablaSalas.setModel(modelo);
    }
    
    private void hacerReservacion(){
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
        String idSala = (String)modelo.getValueAt(indice, 1);

        Sala hacerReservacion=null;
        for(Sala S:listaSalas){
            if(S.getCodigo().equals(idSala)){
                hacerReservacion=S;
                break;
            }
        }
        if(hacerReservacion == null){
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
        
        //LLAMAR a la interfaz gráfica para hacer la reservaicion
        HacerReservacion reservarS= new HacerReservacion();
       pantallaInicio.dispose();
       reservarS.setReservarSala(hacerReservacion);
       reservarS.setVisible(true);
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBotones = new javax.swing.JPanel();
        panelCampoTexto = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelBotonesOperaciones = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnVisualizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnReservar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelContenido = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSalas = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        panelBotones.setBackground(new java.awt.Color(51, 51, 51));
        panelBotones.setLayout(new java.awt.GridLayout(1, 0));

        panelCampoTexto.setBackground(new java.awt.Color(255, 255, 255));
        panelCampoTexto.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("   ");
        panelCampoTexto.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jLabel2.setText("               ");
        panelCampoTexto.add(jLabel2, java.awt.BorderLayout.PAGE_END);

        jLabel3.setText("                                    ");
        panelCampoTexto.add(jLabel3, java.awt.BorderLayout.LINE_END);

        panelBotones.add(panelCampoTexto);

        panelBotonesOperaciones.setOpaque(false);

        jLabel6.setText("   ");
        panelBotonesOperaciones.add(jLabel6);

        btnVisualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnVisualizar.setText("VISUALIZAR");
        btnVisualizar.setContentAreaFilled(false);
        btnVisualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVisualizarMouseClicked(evt);
            }
        });
        panelBotonesOperaciones.add(btnVisualizar);

        jLabel5.setText("          ");
        panelBotonesOperaciones.add(jLabel5);

        btnReservar.setForeground(new java.awt.Color(255, 255, 255));
        btnReservar.setText("RESERVAR");
        btnReservar.setContentAreaFilled(false);
        btnReservar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReservarMouseClicked(evt);
            }
        });
        panelBotonesOperaciones.add(btnReservar);

        jLabel7.setText("          ");
        panelBotonesOperaciones.add(jLabel7);

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

    private void btnVisualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVisualizarMouseClicked
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
        String idSala = (String)modelo.getValueAt(indice, 1);

        Sala visualizar=null;
        for(Sala S:listaSalas){
            if(S.getCodigo().equals(idSala)){
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
        presentarDetalles.cargarDatosMinimosReservacion();
        presentarDetalles.setVisible(true);
        pantallaInicio.dispose();

    }//GEN-LAST:event_btnVisualizarMouseClicked

    private void btnReservarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservarMouseClicked
        hacerReservacion();
    }//GEN-LAST:event_btnReservarMouseClicked

    private void tablaSalasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSalasMouseClicked
        if(evt.getClickCount()==2)
            hacerReservacion();
    }//GEN-LAST:event_tablaSalasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReservar;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    // End of variables declaration//GEN-END:variables
}
