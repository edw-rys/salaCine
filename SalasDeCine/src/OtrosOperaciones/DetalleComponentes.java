package OtrosOperaciones;

import Interfaces.InterfaceDetalle;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class DetalleComponentes implements  InterfaceDetalle{
    //atributos

            //Color Botones
//Se define objetos de tipo Color, 3 objetos en este caso 
            public  Color colorNormal = new Color(0, 139, 139);//colorNormal =color cuando el boton no realiza ningun evento
            public  Color colorPressed = new Color(0, 0, 0);   //colorPressed  = cuando el boton es presionado
            public  Color colorHover = new Color(0, 102, 102); //colorHover = cuando el mouse pasa encima del boton
            //Texto Botones
		//En el color de la letra es opcional si se quiere cambiar el color de la letra en algun evento del boton
            public static Color colorTextNormal = new Color(255, 255, 255);
            public static Color colorTextPressed = new Color(255, 255, 255);
            public static Color colorTextHover = new Color(255, 255, 255);
            
    //detallar boton al inicio
//Este metodo permitira retocar el boton al iniciar la aplicacion
    public  void detalleBotones(JButton  boton){  
        boton.setFont(new Font("Tahoma", Font.BOLD, 14));	//se define el tipo de fuente del txt en el boton
        boton.setBackground(colorNormal );	//Se colorea el contorno del boton
        boton.setContentAreaFilled(false);	//Se elimina el contorno blanco que se genera automaticamente al ubicar el boton
        boton.setOpaque(true);	//Se vuelve opaco el boton
        boton.setForeground(colorTextNormal);	//Color de texto cambia al definido(blanco)// OJO-> PUEDE SER  OPCIONAL ESTA LINEA
    }
 
    
    // JComboBox ingresar datos nuevamente
    public static void actualizarItems(JComboBox primero,JComboBox actualizar, int horaMax){
        int item=0;
    if( Integer.parseInt(primero.getSelectedItem().toString()) < Integer.parseInt(actualizar.getSelectedItem().toString()) )
              item=Integer.parseInt(actualizar.getSelectedItem().toString());
        actualizar.removeAllItems();
        for(int i=Integer.parseInt(primero.getSelectedItem().toString())+1 ;i<=horaMax; i++){
            actualizar.addItem(i);
        }
        if(item!=0)            
           actualizar.setSelectedItem(item);
    }
    
    
    
    public  void setearDetalles(JButton  boton , Color colorBtn, Color mover ){  
        boton.setFont(new Font("Tahoma", Font.BOLD, 14));	//se define el tipo de fuente del txt en el boton
        colorNormal=colorBtn;
        colorHover=mover;
        boton.setBackground(colorBtn );	//Se colorea el contorno del boton
        boton.setContentAreaFilled(false);	//Se elimina el contorno blanco que se genera automaticamente al ubicar el boton
        boton.setOpaque(true);	//Se vuelve opaco el boton
        
    }
    
    //Validaciones
    public static boolean campoNumeroCelular(String cel){
        return cel.length()==10;
    }                   
    
    //Inserccion del icono a las interfaces gráficas
    public static Image getIconImage(){
            Image icono= Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Vista/Imagenes/iconoPrograma.png"));
          return icono   ;  
    }
    
    
    
    
    
}
