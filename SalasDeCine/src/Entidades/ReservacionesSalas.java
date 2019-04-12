package Entidades;

import Interfaces.InterfaceDatosSala;

public class ReservacionesSalas  {
//Cliente Atributos
   private String nombreCliente;
   private String apellidoCliente;
   private String ciCliente;    
   private String direccionCliente;
   private String telefonoCliente;
         
   //Sala a la que perenece
   
   //Reservacion Atributos
   private int ID_reservacion;
   private String codigo;
   private HorarioReservaciones horario;
   private double costoDeReservacion;
   //Pelicula Reservacion
   private  Pelicula peliculas_estreno;

    public ReservacionesSalas(String nombreCliente, String ciCliente, String direccionCliente, String telefonoCliente, int ID_reservacion, HorarioReservaciones horario, double costoDeReservacion) {
        this.nombreCliente = nombreCliente;
        this.ciCliente = ciCliente;
        this.direccionCliente = direccionCliente;
        this.telefonoCliente = telefonoCliente;
        this.ID_reservacion = ID_reservacion;
        this.horario = horario;
        this.costoDeReservacion = costoDeReservacion;
        peliculas_estreno=new Pelicula();
    }
   
    
    public ReservacionesSalas (){
        peliculas_estreno=new Pelicula();
    }
   

    public ReservacionesSalas(int codigo_reserva_final) {
        this.ID_reservacion=codigo_reserva_final;
        peliculas_estreno=new Pelicula();
    }
    //Gets        
    public String getCodigo() {
        return codigo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getCiCliente() {
        return ciCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public int getID_reservacion() {
        return ID_reservacion;
    }

    public HorarioReservaciones getHorario() {
        return horario;
    }

    public double getCostoDeReservacion() {
        return costoDeReservacion;
    }

    public Pelicula getPeliculas_estreno() {
        return peliculas_estreno;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }
    
    
    //Sets
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setCiCliente(String ciCliente) {
        this.ciCliente = ciCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    
    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public void setID_reservacion(int ID_reservacion) {
        this.ID_reservacion = ID_reservacion;
    }

    public void setHorario(HorarioReservaciones horario) {
        this.horario = horario;
    }

    public void setCostoDeReservacion(double costoDeReservacion) {
        this.costoDeReservacion = costoDeReservacion;
    }

    public void setPeliculas_estreno(Pelicula peliculas_estreno) {
        this.peliculas_estreno = peliculas_estreno;
    }

   /* @Override
    public String toString() {
        return  "Reservacion\nID: " + ID_reservacion + "\nHorario: " + horario + "\nCosto De Reservacion: " + costoDeReservacion + "\nPelicula: " + peliculas_estreno +"\nCliente\nNombre: " + nombreCliente + "\nApellido: " + apellidoCliente + "\nCedula: " + ciCliente + "\nDireccion: " + direccionCliente + "\nTelefono: " + telefonoCliente ;
    }
    
    */
    
    
}
