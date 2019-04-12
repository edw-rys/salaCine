package modelo.operacionesDAO;

import Entidades.HorarioReservaciones;
import Entidades.Pelicula;
import Entidades.ReservacionesSalas;
import Entidades.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.conexion.MiConexion;
import modelo.entidadesDTO.ClienteDAO;


public class ReservacionesDAO {
   private MiConexion micon;
   private Connection con;
   private PreparedStatement sentenciaPreparada;
   private ResultSet resultset;
   
   public ReservacionesDAO(){}//Constructor
   
                        /*Reservaciones*/
   //Clientes
   public boolean verificarClienteExistente(String ci){
       boolean existe=false;
       micon=new MiConexion();
       //OBTENER CONEXION
       con=micon.getConection();
       if(con==null) return false;
       String query ="select * from cliente where Cedula='"+ci+"'";
       try{
           sentenciaPreparada=con.prepareStatement(query);
           resultset=sentenciaPreparada.executeQuery();
           if(resultset.next()) existe=true;
           else{return false;}
       }catch(SQLException e) {
           System.out.println("Error en buscar cliente - "+e.getMessage());
       }finally{
           try{
           con.close();
           }catch(SQLException sqle){
               System.out.println("Error al cerrar conexion");
               System.out.println(sqle.getMessage());
           }
       }
       return existe;
   }
   
   public int guardarCliente (ClienteDAO cliente){
       int res=0;
       micon=new MiConexion();
       //OBTENER CONEXION
       con=micon.getConection();
       if(con==null) return 0;
       
        String sql = "insert into cliente "
                + "(Cedula,   nombre,   apellido , direccion, telefono)"             
                + " values (?,?,?,?,?)";       
       try {
           //crear una sentencia preparada
           sentenciaPreparada =con.prepareStatement(sql);
           sentenciaPreparada.setString(1, cliente.getCiPersona());
           sentenciaPreparada.setString(2, cliente.getNombre());
           sentenciaPreparada.setString(3, cliente.getApellidos());
           sentenciaPreparada.setString(4, cliente.getDireccion());
           sentenciaPreparada.setString(5, cliente.getTelefono()); 
            //ejecuta la sentencia 
           res=sentenciaPreparada.executeUpdate();
       } catch (SQLException ex) {
           System.out.println("No se pudo guardar cliente - "+ex.getMessage());
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
   
   //Pelicula
   
     public int guardarPelicula (Pelicula peliculaEstreno){
       int res=0;
       micon=new MiConexion();
       //OBTENER CONEXION
       con=micon.getConection();
       if(con==null) return 0;
       
        String sql = "insert into pelicula "
                + "(nombre,   anio_estreno,   calificacion , IdCategoria)"             
                + " values (?,?,?,?)";       
       try {
           //crear una sentencia preparada
           sentenciaPreparada =con.prepareStatement(sql);
           sentenciaPreparada.setString(1, peliculaEstreno.getNombre());
           sentenciaPreparada.setInt(2, peliculaEstreno.getAñoEstreno());
           sentenciaPreparada.setInt(3, peliculaEstreno.getCalificacion());
           sentenciaPreparada.setInt(4, peliculaEstreno.getIdCategoria());
           
            //ejecuta la sentencia 
           res=sentenciaPreparada.executeUpdate();
            //Actualizar guardar datos a la base de datos
           //executeUpdate ejecuta sentencias de inset, update,delate
           //retorna un entero con el numero de filas afectas
       } catch (SQLException ex) {
           System.out.println("No se pudo guardar Pelicula - "+ex.getMessage());
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
   
     
   //Categoria Pelicula
   public ArrayList<String> consultarCategoriaPeliculas(){
      ArrayList<String> lista =null;
     
      micon=new MiConexion();
       //OBTENER CONEXION
       con=micon.getConection();
       if(con==null) return null;
       
       // consultar
  String query = "select * from categoriapelicula ";
  
   // preparar la sentencia
    try {
              sentenciaPreparada = con.prepareStatement(query);
         	
        //Ejecutar la sentencia
        resultset=sentenciaPreparada.executeQuery();//Sentecia para buscar a la base de datos
        if(resultset !=null){
            lista=new ArrayList();
            String tipo;
                    //recorrer el resulset
            while(resultset.next()){//mientras haya un siguiente registro 
                //registro por leer
                tipo=resultset.getString("nombre");
                lista.add(tipo);
            }
        }else{
            return null;
        }
    } catch (SQLException ex) {      
        System.out.println("Error en consultar categoria de pelicula\n"+ex.getMessage());
        
    }finally{
          try {
              con.close();
          } catch (SQLException ex) {
              System.out.println("Error en consultar categoria de pelicula: cerrar conexion\n"+ex.getMessage());
          }
        
    }
      return lista;
               
  }
     
   //Reservacion operaciones
     
     //guardado
     
     
   public int guardarReservacion(ReservacionesSalas R,Sala S){              
       int res=0;
       micon=new MiConexion();
       //OBTENER CONEXION
       con=micon.getConection();
       if(con==null) return 0;
       
        String sql = "insert into reservaciones "
                + "(   codigo_reservacion, fecha, hora_entrada , hora_salida , precio_reservacion "
                + "   ,  IdSala , IdPelicula  , CedulaCliente)"             
                + " values (?,?,?,?,?,?,?,?)";       
       try {
           //crear una sentencia preparada
           sentenciaPreparada =con.prepareStatement(sql);
           sentenciaPreparada.setString(1 , R.getCodigo());
           System.out.println(R.getHorario().getFechaString());
           sentenciaPreparada.setString(2,  R.getHorario().getFechaString());                     
           sentenciaPreparada.setInt(3, R.getHorario().getHora_entrada());      
           sentenciaPreparada.setInt(4, R.getHorario().getHora_salida());  
           sentenciaPreparada.setDouble(5, R.getCostoDeReservacion()); 
           sentenciaPreparada.setInt(6, S.getId()); 
           sentenciaPreparada.setInt(7, R.getPeliculas_estreno().getIdPelicula()); 
           sentenciaPreparada.setString(8, R.getCiCliente());
           //ejecuta la sentencia 
           res=sentenciaPreparada.executeUpdate();
            //Actualizar guardar datos a la base de datos
           //executeUpdate ejecuta sentencias de inset, update,delate
           //retorna un entero con el numero de filas afectas
       } catch (SQLException ex) {
           System.out.println("no se pudo guardar Reservacion - "+ex.getMessage());
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
   
   //consulta
   
   public ClienteDAO consultarCliente(String ci){
       
       micon=new MiConexion();
       //OBTENER CONEXION
       con=micon.getConection();
       if(con==null) return null;
       String query = "select *from cliente where Cedula='"+ci+"'";
       ClienteDAO persona=new ClienteDAO();
       try{
            sentenciaPreparada=con.prepareStatement(query);
            resultset=sentenciaPreparada.executeQuery();
            if(resultset.next()){
                persona.setCiPersona(resultset.getString("Cedula"));
                persona.setDireccion(resultset.getString("direccion"));
                persona.setNombre(resultset.getString("nombre"));
                persona.setApellidos(resultset.getString("apellido"));
                persona.setTelefono(resultset.getString("telefono"));
            }
       }catch(SQLException e){System.out.println("Error en buscar cliente - "+e.getMessage());}
       finally{
          try {
              con.close();
          } catch (SQLException ex) {
              System.out.println("Error en consultar Reservacion: cerrar conexion\n"+ex.getMessage());
          }        
    }
                
                
        return persona;
   }
   
   public ArrayList <ReservacionesSalas> extraerReservaciones(int idaSala){
       ArrayList <ReservacionesSalas> reservacionesSala =null;
       micon=new MiConexion();
       //OBTENER CONEXION
       con=micon.getConection();
       if(con==null) return null;
       
       String query = "select * from reservaciones as reserva, "
               + "pelicula as peli_estreno,"
               + " categoriapelicula as ctg "
              +"where reserva.IdSala = '"+idaSala+"' "
               + "and  reserva.IdPelicula=peli_estreno.idpelicula "
               + "and ctg.idCategoriaPelicula = peli_estreno.IdCategoria"
               + " and reserva.estado=1";      
       try {                                 
           sentenciaPreparada = con.prepareStatement(query);         	
        //Ejecutar la sentencia
        resultset=sentenciaPreparada.executeQuery();//Sentecia para buscar a la base de datos
        if(resultset !=null){//Resultados no estan nulos
            reservacionesSala =new ArrayList();
            String tipo;
                    //recorrer el resulset                    
            while(resultset.next()){//mientras haya un siguiente registro 
                //registro por leer
                //Horario
                HorarioReservaciones horario=new HorarioReservaciones();
                horario.setFechaReservacion( resultset.getDate("reserva.fecha"));
                horario.setHora_entrada(resultset.getInt("reserva.hora_entrada"));
                horario.setHora_salida(resultset.getInt("reserva.hora_salida"));
                //Datos del horario recolectados
                
                //Entidad Pelicula DAO
                Pelicula peliDAO =new Pelicula();
                peliDAO.setIdPelicula(resultset.getInt("peli_estreno.idpelicula" ));
                peliDAO.setNombre(resultset.getString("peli_estreno.nombre"));
                peliDAO.setAñoEstreno(resultset.getInt("peli_estreno.anio_estreno"));
                peliDAO.setCalificacion(resultset.getInt("peli_estreno.calificacion"));
                peliDAO.setNombreCategoria(resultset.getString("ctg.nombre"));
                peliDAO.setIdCategoria(resultset.getInt("ctg.idCategoriaPelicula"));
                
                //Datos de la reservaciom
                ReservacionesSalas actualizar =new ReservacionesSalas();
                
                actualizar.setID_reservacion(resultset.getInt("reserva.idreservaciones")); 
                actualizar.setCodigo(resultset.getString("reserva.codigo_reservacion"));
                actualizar.setHorario(horario);
                actualizar.setCostoDeReservacion( resultset.getDouble("reserva.precio_reservacion")); 
                actualizar.setCiCliente(resultset.getString("reserva.CedulaCliente")); 
                actualizar.setPeliculas_estreno(peliDAO);               

                reservacionesSala.add(actualizar);
            }
        }else{
            return null;
        }
    } catch (SQLException ex) {      
        System.out.println("Error en consultar Reservacion\n"+ex.getMessage());
        
    }finally{
          try {
              con.close();
          } catch (SQLException ex) {
              System.out.println("Error en consultar Reservacion: cerrar conexion\n"+ex.getMessage());
          }
        
    }
       for(ReservacionesSalas actualizar:reservacionesSala){
            ClienteDAO persona=consultarCliente(actualizar.getCiCliente());
            actualizar.setCiCliente(persona.getCiPersona()); 
            actualizar.setDireccionCliente( persona.getDireccion());
            actualizar.setApellidoCliente(persona.getApellidos());
            actualizar.setTelefonoCliente(persona.getTelefono());
            actualizar.setNombreCliente(persona.getNombre());           
       }
       
       
       return reservacionesSala;
   }
     
     //eliminacion
   public int eliminarReservacion(String codigo) {
        int res=0;
        micon=new MiConexion();
        con=micon.getConection(); 
        if(con==null) return 0;
        String sql="update reservaciones set estado=0 where codigo_reservacion=?";
        try{
            sentenciaPreparada=con.prepareStatement(sql);
            sentenciaPreparada.setString(1, codigo);
            res=sentenciaPreparada.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error en eliminar resevacion - "+e.getMessage());
        }
        return res;
    }
   
   
   
   
   
   
    
   //IDS GENERADOS
   
   public int agregarIdReservacion(){
      micon=new MiConexion();
      con=micon.getConection(); 
      if(con==null) return 0;
      int resultado=0;
      String query = "SELECT MAX(idreservaciones) FROM reservaciones";
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
   
   
   public int agregarIDPelicula(){
       int id=0;
       micon=new MiConexion();
      con=micon.getConection(); 
      if(con==null) return 0;
     
      String query = "SELECT MAX(idpelicula) FROM pelicula";
        try {
            sentenciaPreparada = con.prepareStatement(query);
            resultset=sentenciaPreparada.executeQuery();
            if(resultset.next()){
                id=resultset.getInt(1);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en consultar ultimo id de pelicula - "+ex.getMessage());
        }finally{
          try {
              con.close();
          } catch (SQLException ex) {              
          }
        }
       System.out.println(id+1);
       return id+1;
   }
   
   
   
    
}
