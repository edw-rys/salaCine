package modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MiConexion {
	private  Connection conection;
	
        //Parametros de conexion
	final String cadenaConexion="jdbc:mysql://localhost/salascine";
	final String User="root";
	final String password="";

	//constructor para la clase
	public MiConexion(){
		this.conection=null;
	}
	//metodo para obtener la conexion
	public Connection getConection(){
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class mysql no encontrada");
		}
		
		try {
			this.conection= DriverManager.getConnection(cadenaConexion,this.User,this.password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			System.out.println("error en conexion");                        
		}                
		return this.conection;
	}
        
}
