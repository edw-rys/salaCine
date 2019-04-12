
package Entidades;
import Interfaces.OperacionesSalas;
import java.util.ArrayList;
import java.util.Date;

public abstract class Sala  implements OperacionesSalas{
    protected double CostoReservacionPorHora=0;
    protected double GanaciasGeneradasPorReservaciones=0;
    
    private int numeroDiasDisponible=0;
    protected int NumeroReservaciones=0;
    protected int id;  //
    private String codigo;
    protected String nombre;
    protected Horario horario;
    protected String tipo;//VIP GENERAL O ESPECIAL
    protected int idTipo;//VIP GENERAL O ESPECIAL
    private String imagen="ninguna";

    protected ArrayList <ReservacionesSalas>  reservacionesDeLaSala;//SE  CREA LA COLECCION PARA arrays de las reservaciones de la salas actual
    
    //Inicializacion del  constructor
    public Sala(String codigo,String nombre, Horario horario,String tipo) {
        this.codigo = codigo;
       this.nombre=nombre;
        this.horario = horario;
        this.tipo=tipo;
        reservacionesDeLaSala=new ArrayList <ReservacionesSalas> ();//Se instancia el arraylistt de reservaciones
    }
    
    public Sala (){
    }
    
//Caso desmarcar dia
 public boolean horarioNoPermiteCambioDia(int dia ){
     Date hoy=new Date();
     if(reservacionesVacias())//No hay reservaciones
         return true;
     for(ReservacionesSalas R:reservacionesDeLaSala){
         Date fechaR=R.getHorario().getFechaReservacion();
         if(fechaR.compareTo(hoy)>0){//Si la fecha todavia no ha pasdo
             if(dia == fechaR.getDay()){//Si es el mismo dia
                 return false;//Si se esta desmarcando un dia de una reservacion hecha, retorna falso
             }
         }
     }
     return true;//En caso de que no haya reservaciones dicho dia se retorna verdad
 }
 //Caso editar dias
public boolean horarioNoPermiteCambioHoras( int dia,int horaIn, int horaOut){
     Date hoy=new Date();
     if(reservacionesVacias())//No hay reservaciones
         return true;
     for(ReservacionesSalas R:reservacionesDeLaSala){
         Date fechaR=R.getHorario().getFechaReservacion();
         if(fechaR.compareTo(hoy)>0){//Si la fecha todavia no ha pasdo
             if(dia == fechaR.getDay()){//Si es el mismo dia de cualquier fecha
                 int inR=R.getHorario().getHora_entrada();
                 int outR=R.getHorario().getHora_salida();
                 if(inR < horaIn)//Si la hora de entrada de la sala es cambiada a otra del cual se ingrese más tarde que una que ya este hecha en una reservacion
                     return false;//retorna false
                 if(outR > horaOut)
                     return false;
             }
         }
     }
     return true;
 }

  public boolean HorasCruzadas(Date fecha, int hora_in,int hora_out){

       for(ReservacionesSalas recorrer : reservacionesDeLaSala){
           //Compara fechas
            if(fecha.getYear() == recorrer.getHorario().getFechaReservacion().getYear()){                  
                if(fecha.getMonth()== recorrer.getHorario().getFechaReservacion().getMonth()){                   
                    if(fecha.getDate()== recorrer.getHorario().getFechaReservacion().getDate()){ 
                        //Fechas iguales                        
                        for(int i=recorrer.getHorario().getHora_entrada();i<recorrer.getHorario().getHora_salida();i++){                    
                            for(int j=hora_in;j<hora_out;j++){
                                if(i==j){                              
                                    return true;//Choque de horas
                                }
                            }
                        }
                    }
                }
            }
       }
       return false;
   }
       

   public boolean reservacionesVacias(){
       return reservacionesDeLaSala.isEmpty();//Retorna verdad si esta vacia la lista
   }
   
   
   //Metodo para calcular las ganancias de la sala
     public abstract void GenerarGanancias(int cantidadHoras);
   
   //GETS
    public String getCodigo() {
        return codigo;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
    
    public String getTipo() {
        return tipo;
    }

    public double getCostoReservacionPorHora() {
        return CostoReservacionPorHora;
    }

    public double getGanaciasGeneradasPorReservaciones() {
        return GanaciasGeneradasPorReservaciones;
    }

    public ArrayList<ReservacionesSalas> getReservacionesDeLaSala() {
        return reservacionesDeLaSala;
    }

 
    

    public String getNombre() {
        return nombre;
    }

    public int getNumeroReservaciones() {
        return reservacionesDeLaSala.size();
    }

    public int getId() {
        return id;
    }

    public String getImagen() {
        return imagen;
    }

    public int getNumeroDiasDisponible() {
        return numeroDiasDisponible;
    }

   
    
    
    //Setter

    
    
    public void setId(int id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdTipo() {
        return idTipo;
    }   

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCostoReservacionPorHora(double CostoReservacionPorHora) {
        this.CostoReservacionPorHora = CostoReservacionPorHora;
    }

    public void setNumeroReservaciones(int NumeroReservaciones) {
        this.NumeroReservaciones = NumeroReservaciones;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setNumeroDiasDisponible(int numeroDiasDisponible) {
        this.numeroDiasDisponible = numeroDiasDisponible;
    }

    public void setReservacionesDeLaSala(ArrayList<ReservacionesSalas> reservacionesDeLaSala) {
        this.reservacionesDeLaSala = reservacionesDeLaSala;
    }

    public void setGanaciasGeneradasPorReservaciones(double GanaciasGeneradasPorReservaciones) {
        this.GanaciasGeneradasPorReservaciones = GanaciasGeneradasPorReservaciones;
    }
    
    
    //Sobreescritura de toString

    @Override
    public String toString() {
        return "Sala\n" + "codigo= " + codigo +"\ttipo=" + tipo + "\n"+ horario.toString();
    }
    
}
