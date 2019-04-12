package OtrosOperaciones;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;

/**
 *
 * @author Edw
 */
public class EventosJButton  implements MouseListener,MouseMotionListener {
        private JButton boton;
        DetalleComponentes detallarBoton=new DetalleComponentes();
        
        public  EventosJButton(JButton boton){            
            detallarBoton.detalleBotones(boton);
            this.boton=boton;
        }        
        public  EventosJButton(){}
        
     
    public void colorearBotones(JButton boton, Color colorPrincipal, Color roce){
        EventosJButton eventoColorear=new EventosJButton(boton);
        eventoColorear.reemplazarColorresPorDefecto(colorPrincipal,roce);
        boton.addMouseListener(eventoColorear);
        boton.addMouseMotionListener(eventoColorear);
    }
        
        public void reemplazarColorresPorDefecto( Color c1, Color c2){
            detallarBoton.setearDetalles(boton, c1, c2);
        }
    @Override
    public void mouseClicked(MouseEvent e) {
            
    }

    @Override
    public void mousePressed(MouseEvent e) {
        boton.setBackground(  detallarBoton.colorPressed);
    }

        @Override
        public void mouseReleased(MouseEvent e) {
            boton.setBackground(detallarBoton.colorNormal);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            boton.setBackground(detallarBoton.colorNormal);
        }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
       boton.setBackground(detallarBoton.colorHover);
        
    }
       
    
}
