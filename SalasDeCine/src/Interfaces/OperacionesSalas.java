package Interfaces;

import Entidades.Sala;
import java.util.Date;

/**
 *
 * @author DELL
 */
public interface OperacionesSalas {    
    boolean HorasCruzadas(Date fecha, int hora_in,int hora_out);        
}
