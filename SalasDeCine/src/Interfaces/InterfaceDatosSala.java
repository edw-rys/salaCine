package Interfaces;

import Entidades.ReservacionesSalas;

/**
 *
 * @author DELL
 */
public interface InterfaceDatosSala {
    void cargarReservaciones();
    void cargarDatosReservaciones(ReservacionesSalas visualizar);
    void cargarDatosMinimosReservacion();
    
}
