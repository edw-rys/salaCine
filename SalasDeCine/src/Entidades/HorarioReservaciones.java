package Entidades;

import java.util.Date;

public class HorarioReservaciones {

    private int hora_entrada;
    private int hora_salida;
    private Date fechaReservacion;
    private String fechaString;
    public HorarioReservaciones (){}
    public HorarioReservaciones(int hora_entrada, int hora_salida, Date fechaReservacion) {
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.fechaReservacion = fechaReservacion;        
    }
    //Sets
    public void setHora_entrada(int hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public void setHora_salida(int hora_salida) {
        this.hora_salida = hora_salida;
    }

    public void setFechaReservacion(Date fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }

    public void setFechaString(String fechaString) {
        this.fechaString = fechaString;
    }

    
    //Gets
    public int getHora_entrada() {
        return hora_entrada;
    }

    public int getHora_salida() {
        return hora_salida;
    }

    public Date getFechaReservacion() {
        return fechaReservacion;
    }

    public String getFechaString() {
        return fechaString;
    }
    
    
    
    public String toString(){
        return "Fecha-> "+fechaReservacion+"\tEntrada: "+hora_entrada+":00 - "+hora_salida+":00";
    }


}
