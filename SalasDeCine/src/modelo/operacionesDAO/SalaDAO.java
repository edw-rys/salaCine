package modelo.operacionesDAO;

import Entidades.*;
import PatronesDiseño.MetodoFabricaSalas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import modelo.conexion.MiConexion;


public class SalaDAO {
    private MiConexion micon;
   private Connection con;
   private PreparedStatement sentenciaPreparada;
   private ResultSet resultset;
   public SalaDAO(){}//Constructor
   
   
   public int guardar(Sala actual){  
        int res=0;
        micon=new MiConexion();
       //OBTENER CONEXION
        con=micon.getConection();
        String criterio1="",criterio2="";
        if(con==null) return 0;
        int tipoSala=0;
        if(actual instanceof SalaGeneral){
            tipoSala=1;
            SalaGeneral G=(SalaGeneral)actual;
            criterio1 =G.getPromiciones();
            criterio2=G.getX();
        }
        else if(actual instanceof SalaVIP){
            tipoSala=2;
            SalaVIP G=(SalaVIP)actual;
            criterio1 =G.getModeloGafas3D();
            criterio2=G.getServicioAdicionalPaga();
        }
        else if(actual instanceof SalaBlackBox){
            tipoSala=3;
            SalaBlackBox G=(SalaBlackBox)actual;
            criterio1 =G.getTipoAsiento();
            criterio2=G.getServiciAdicionalGratuitos();
        }
        String sql = "insert into sala "
                + "(  codigo , nombre , totalDiasReservados  ,  precioHora , "
                + "IdCategoriaSala, atributo_sala1 ,atributo_sala2,imagen)"   
                + " values (?,?,?,?,?,?,?,?)";       
       try {
           //crear una sentencia preparada
           sentenciaPreparada =con.prepareStatement(sql);
           sentenciaPreparada.setString(1, actual.getCodigo());
           sentenciaPreparada.setString(2, actual.getNombre());           
           sentenciaPreparada.setInt(3, actual.getHorario().getHora_entrada().length);           
           sentenciaPreparada.setDouble(4, actual.getCostoReservacionPorHora());           
           sentenciaPreparada.setInt(5, tipoSala);                      
           sentenciaPreparada.setString(6, criterio1);
           sentenciaPreparada.setString(7, criterio2);
           sentenciaPreparada.setString(8, actual.getImagen());
           
           //ejecuta la sentencia 
           res=sentenciaPreparada.executeUpdate();         
           
           //Guardar Horaario
           String []dias= actual.getHorario().getDias();
           int []entrada= actual.getHorario().getHora_entrada();
           int []salida =actual.getHorario().getHora_salida();
        for(int i=0;i<actual.getHorario().getDias().length;i++){
            int j=registrarDiasSala(dias[i] , entrada[i],salida[i], actual.getId());       
            if(j==0)
                System.out.println("No guardado");
        }
           
       } catch (SQLException ex) {
           System.out.println("no se pudo guardar los datos de la Sala - "+ex.getMessage());
       }finally{
           try{
           con.close();
           }catch(SQLException sqle){
               System.out.println("Error al cerrar conexion");
               System.out.println(sqle.getMessage());
           }
       }       
        return res;
   }
   //1.1. Guarda los dias de la sala que se esta guardando
   public int registrarDiasSala(String dia, int entrada, int salida, int idSala){
       int res=0;            
       if(con==null) return 0;       
       // insertar
        String sql = "insert into horario "
                + "(dia,   hora_entrada,   hora_salida ,  sala_IdSala,estado )"             
                + " values (?,?,?,?,?)";       
       try {
           //crear una sentencia preparada                  
                sentenciaPreparada =con.prepareStatement(sql);           
                sentenciaPreparada.setString(1, dia);
                sentenciaPreparada.setInt(2, entrada);
                sentenciaPreparada.setInt(3, salida);
                sentenciaPreparada.setInt(4,idSala );
                sentenciaPreparada.setInt(5,1);
               res=sentenciaPreparada.executeUpdate();                                 
       } catch (SQLException ex) {
           System.out.println("No se pudo guardar el horario - "+ex.getMessage());
       }
       return res;
   }
   
 
   public Sala buscarSala(String codigoSala){   
       Sala actual=null;
       micon=new MiConexion();
       //OBTENER CONEXION
       con=micon.getConection();
       if(con==null) return null;
       String query = "select * from sala as s ,horario as h where s.codigo='"+codigoSala+"'  and h.sala_IdSala = s.idsala and s.estado =1";
        try {
            sentenciaPreparada = con.prepareStatement(query);
            resultset=sentenciaPreparada.executeQuery();
            if(resultset.next()){   
                int tipoSala =resultset.getInt("IdCategoriaSala");
                //int cod=resultset.getInt("idSala");
                String codigo = resultset.getString("codigo") ;;
                int idSala=resultset.getInt("idsala");
                double precioPorHora=resultset.getDouble("precioHora");
                int numeroDias=resultset.getInt("totalDiasReservados");
                String nombre =resultset.getString("nombre");
                String imagen = resultset.getString("imagen");
                String criterio1=resultset.getString("atributo_sala1");
                String criterio2=resultset.getString("atributo_sala2"); 
                double ganancias=resultset.getDouble("ganancias");
                //Creacion de la sala y asignacion de instancia
                actual=MetodoFabricaSalas.crearSala(tipoSala);
                
                actual.setId(idSala);
                actual.setCodigo(codigo);
                actual.setNombre(nombre);
                actual.setNumeroDiasDisponible(numeroDias);
                actual.setImagen(imagen); 
                actual.setIdTipo(tipoSala);
                actual.setCostoReservacionPorHora(precioPorHora);
                actual.setGanaciasGeneradasPorReservaciones(ganancias);
                
                
                if(actual instanceof SalaGeneral){//General
                    SalaGeneral G= (SalaGeneral) actual;
                    G.setPromiciones(criterio1);
                    G.setX(criterio2);
                    actual.setTipo("GENERAL");
                    actual=G;
                }else{
                    if(actual instanceof SalaVIP){//VIP
                        SalaVIP V= (SalaVIP) actual;
                        V.setModeloGafas3D(criterio1);
                        V.setServicioAdicionalPaga(criterio2);
                        actual.setTipo("VIP");
                        actual=V;
                    }else{//BLACKBOX
                        SalaBlackBox G= (SalaBlackBox) actual;
                        G.setTipoAsiento(criterio1);
                        G.setServiciAdicionalGratuitos(criterio2);
                        actual.setTipo("BLACKBOX");
                        actual=G;
                    }
                }  
                Horario agregarHORARIO=null;
    
            agregarHORARIO=cargarHorario(actual.getId(),actual.getNumeroDiasDisponible());
            actual.setHorario(agregarHORARIO);
            }else
                return null;
            
            
        } catch (SQLException ex) { 
            System.out.println(ex.getMessage());
        }finally{
           try {
               con.close();
           } catch (SQLException ex) {
               System.out.println("Error en consultar id de la sala Error en cerrar conexion");
           }
        }
        ReservacionesDAO reservacion=new ReservacionesDAO();        
            ArrayList<ReservacionesSalas> reservacionesDeLaSala= reservacion.extraerReservaciones(actual.getId());
            actual.setReservacionesDeLaSala(reservacionesDeLaSala);        
       
       return actual;
   }
   
   
   //2. Editar datos de una sala
  public int editar(Sala editarSala){
   
       int res=0;
        micon=new MiConexion();
       //OBTENER CONEXION
        con=micon.getConection();
        String criterio1="",criterio2="";
        if(con==null) return 0;
        int tipoSala=0;
        if(editarSala instanceof SalaGeneral){
            tipoSala=1;
            SalaGeneral G=(SalaGeneral)editarSala;
            criterio1 =G.getPromiciones();
            criterio2=G.getX();
        }
        else if(editarSala instanceof SalaVIP){
            tipoSala=2;
            SalaVIP G=(SalaVIP)editarSala;
            criterio1 =G.getModeloGafas3D();
            criterio2=G.getServicioAdicionalPaga();
        }
        else if(editarSala instanceof SalaBlackBox){
            tipoSala=3;
            SalaBlackBox G=(SalaBlackBox)editarSala;
            criterio1 =G.getTipoAsiento();
            criterio2=G.getServiciAdicionalGratuitos();
        }
       // insertar
       //INSERT INTO `salascine`.`sala` (`idsala`, `nombre`, `toalDiasReservados`, `precioHora`, `IdCategoriaSala`) VALUES ('2', 'E', '1', '2', '2');

        String sql = "update  sala set"
                + "  codigo=? , nombre =?, totalDiasReservados=?  ,  precioHora=? , "
                + "IdCategoriaSala=?, atributo_sala1=? , atributo_sala2=?,imagen=?, "
                + "numero_reservaciones=? where codigo= ?" ;    
       try {
           //crear una sentencia preparada
           sentenciaPreparada =con.prepareStatement(sql);
           sentenciaPreparada.setString(1, editarSala.getCodigo());
           sentenciaPreparada.setString(2, editarSala.getNombre());           
           sentenciaPreparada.setInt(3, editarSala.getHorario().getHora_entrada().length);           
           sentenciaPreparada.setDouble(4, editarSala.getCostoReservacionPorHora());           
           sentenciaPreparada.setInt(5, tipoSala);                      
           sentenciaPreparada.setString(6, criterio1);
           sentenciaPreparada.setString(7, criterio2);
           sentenciaPreparada.setString(8, editarSala.getImagen());
           sentenciaPreparada.setInt(9, editarSala.getNumeroReservaciones());
           sentenciaPreparada.setString(10, editarSala.getCodigo());
           //ejecuta la sentencia 
           res=sentenciaPreparada.executeUpdate();           
            //Actualizar guardar datos a la base de datos
           //executeUpdate ejecuta sentencias de inset, update,delate
           //retorna un entero con el numero de filas afectas
           
           int totalDelete=eliminarDias(editarSala.getId());  //Marcar en 0 los antiguos dias
       //Registrar dias de actividad de la sala
       String []dias= editarSala.getHorario().getDias();
           int []entrada= editarSala.getHorario().getHora_entrada();
           int []salida =editarSala.getHorario().getHora_salida();
        for(int i=0;i<editarSala.getHorario().getDias().length;i++){
            registrarDiasSala(dias[i] , entrada[i],salida[i], editarSala.getId());       
        }
           
       } catch (SQLException ex) {
           System.out.println("no se pudo editar\n"+ex.getMessage());
       }finally{
           try{
           con.close();
           }catch(SQLException sqle){
               System.out.println("Error al cerrar conexion");
               System.out.println(sqle.getMessage());
           }
       }       
       
       return res;
   }
  
  public void actualizarGanancias(double money, String codigo){
       micon=new MiConexion();       
       con=micon.getConection();
       int res=0;
       if(con==null) return;
       String sql="update sala set ganancias =? where codigo =?";
       try{
           sentenciaPreparada=con.prepareStatement(sql);
           sentenciaPreparada.setDouble(1, money);
           sentenciaPreparada.setString(2, codigo);
           res=sentenciaPreparada.executeUpdate();
           
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
       if(res==0)
           System.out.println("No se guardó las ganacias");
  }
  
  //elimiminacion
  private int eliminarDias(int idSala){
      int res=0;
       if(con==null) return 0;
       System.out.println(idSala);
        String elimina="update horario set estado=0 WHERE sala_IdSala='"+idSala+"'";             
       int totalEliminados=0;
        try {            
                sentenciaPreparada=con.prepareStatement(elimina);
                res= sentenciaPreparada.executeUpdate();
                totalEliminados+=res;
                System.out.println(res);           
        } catch (SQLException ex) {
            System.out.println("Error al eliminar - "+ex.getMessage()); 
        }
      return totalEliminados;
  }
   
  //3.2 Eliminar sala por código
  public int eliminarSala(String codigoSala){      
       micon=new MiConexion();
       //OBTENER CONEXION
       int res=0;
       con=micon.getConection();
       if(con==null) return 0;
       String sql = "update  sala set estado=0  where codigo ='"+codigoSala+"'"; 
       try {  
            sentenciaPreparada=con.prepareStatement(sql);             
             res=sentenciaPreparada.executeUpdate(); //Actualizar base de datos             
        } catch (SQLException ex) {
            System.out.println("error en la busqueda del codigo");
        }finally{
          try {
              con.close();
          } catch (SQLException ex) {
              System.out.println("Error en cerrar conexion -- Eliminacion de sala");
          }
        }
        return res;
  }
  
  
   public Horario cargarHorario(int id , int numeroDias){       
   
        if(con==null) return null;
        String []dias=new String[numeroDias];
        int []entrada= new int[numeroDias];
        int []salida =new int[numeroDias];
        String query = "select * from horario where sala_IdSala='"+id+"' and estado =1";
        
        try {
            sentenciaPreparada = con.prepareStatement(query);
            resultset=sentenciaPreparada.executeQuery();
            
            if(resultset==null)
                return null;
            int i=0;
            while(resultset.next()){
                dias[i]=resultset.getString("dia");
                entrada[i]=resultset.getInt("hora_entrada");
                salida[i]=resultset.getInt("hora_salida");   
                i++;
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en cargar Horario - "+ex.getMessage());
        }
        
        Horario horarioGenerado=new Horario(dias,entrada, salida);
        return horarioGenerado;
   }
  
   public LinkedList <Sala> cargarSalasCine(String criterio){
       
       micon=new MiConexion();
       //OBTENER CONEXION
       con=micon.getConection();
       if(con==null) return null;
       LinkedList <Sala> listaSalas=new LinkedList<>();
      // String query = "select * from sala as s ,horario as h where s.estado=1  and h. =s.idsala and h.estado=1";
       String query = "select * from sala where estado=1";
        try {
            
            if(criterio.equals("")){
                sentenciaPreparada = con.prepareStatement(query);
            }else{ // si hay criterio de busqueda
              query = query + " and codigo like concat('%',?,'%')";           
                sentenciaPreparada = con.prepareStatement(query);          
                sentenciaPreparada.setString(1, criterio );           
            }
            resultset=sentenciaPreparada.executeQuery();
            while(resultset.next()){
               
                int tipoSala =resultset.getInt("IdCategoriaSala");
                //int cod=resultset.getInt("idSala");
                String codigo = resultset.getString("codigo") ;;
                int idSala=resultset.getInt("idsala");
                double precioPorHora=resultset.getDouble("precioHora");
                int numeroDias=resultset.getInt("totalDiasReservados");
                String nombre =resultset.getString("nombre");
                String imagen = resultset.getString("imagen");
                String criterio1=resultset.getString("atributo_sala1");
                String criterio2=resultset.getString("atributo_sala2"); 
                double ganancias=resultset.getDouble("ganancias");
                
                Sala actual=MetodoFabricaSalas.crearSala(tipoSala);
                actual.setId(idSala);
                actual.setCodigo(codigo);
                actual.setNombre(nombre);
                actual.setIdTipo(tipoSala);
                actual.setNumeroDiasDisponible(numeroDias);
                actual.setImagen(imagen); 
                actual.setCostoReservacionPorHora(precioPorHora);
                actual.setGanaciasGeneradasPorReservaciones(ganancias);
                
                
                if(actual instanceof SalaGeneral){//General
                    SalaGeneral G= (SalaGeneral) actual;
                    G.setPromiciones(criterio1);
                    G.setX(criterio2);
                    actual.setTipo("GENERAL");
                    actual=G;
                }else{
                    if(actual instanceof SalaVIP){//VIP
                        SalaVIP V= (SalaVIP) actual;
                        V.setModeloGafas3D(criterio1);
                        V.setServicioAdicionalPaga(criterio2);
                        actual.setTipo("VIP");
                        actual=V;
                    }else{//BLACKBOX
                        SalaBlackBox G= (SalaBlackBox) actual;
                        G.setTipoAsiento(criterio1);
                        G.setServiciAdicionalGratuitos(criterio2);
                        actual.setTipo("BLACKBOX");
                        actual=G;
                    }
                }    
                listaSalas.add(actual);
            }
            
            Horario agregarHORARIO=null;
        for(Sala S:listaSalas){
            agregarHORARIO=cargarHorario(S.getId(),S.getNumeroDiasDisponible());
            S.setHorario(agregarHORARIO);
        }        
        } catch (SQLException ex) { 
            System.out.println(ex.getMessage());
        }finally{
           try {
               con.close();
           } catch (SQLException ex) {
               System.out.println("Error en consultar todas las salas\n Error en cerrar conexion\n"+ex.getMessage());               
           }
        }
        ReservacionesDAO reservacion=new ReservacionesDAO();
        for(Sala S:listaSalas){
            ArrayList<ReservacionesSalas> reservacionesDeLaSala= reservacion.extraerReservaciones(S.getId());
            S.setReservacionesDeLaSala(reservacionesDeLaSala);
        }
       return listaSalas;
   }

  
  public int agregarIdSala(){
      micon=new MiConexion();
      con=micon.getConection(); 
      if(con==null) return 0;
      int resultado=0;
      String query = "SELECT MAX(idsala) FROM sala";
        try {
            sentenciaPreparada = con.prepareStatement(query);
            resultset=sentenciaPreparada.executeQuery();
            if(resultset.next()){
                resultado=resultset.getInt(1);
            }
            
        } catch (SQLException ex) {
            
        }finally{
          try {
              con.close();
          } catch (SQLException ex) {              
          }
        }
      return resultado +1;
  }
  
  public ArrayList <String> listaCaracteristicasAdicionales(int tipoSala){//1. general 2. vip, 3 blackbox
      micon=new MiConexion();
      con=micon.getConection(); 
      if(con==null) return null;
      ArrayList<String> lista=new ArrayList();
        String query = "select * from cmb_tipos_por_sala where referencia_tipo_sala = ?";
        try {
            sentenciaPreparada = con.prepareStatement(query);
            sentenciaPreparada.setInt(1, tipoSala);            
            resultset=sentenciaPreparada.executeQuery();
            if(resultset==null)
                return null;    
            while(resultset.next() ){                
                String tipo =resultset.getString("detalle");
                lista.add(tipo);
            }
        } catch (SQLException ex) {
            System.out.println("Error en cargar lista de caracteristicas adicionales de la tabla\n"+ex.getMessage());
        }finally{
          try {
              con.close();
          } catch (SQLException ex) {              
          }
        }                      
      return lista;
  }
}
