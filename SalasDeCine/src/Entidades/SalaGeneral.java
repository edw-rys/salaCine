package Entidades;

public class SalaGeneral extends Sala {
    
    private String promiciones;
    private String x;
    public SalaGeneral(String codigo,String nombre,Horario horario) {
        super(codigo, nombre,horario,"GENERAL");
    }
    public SalaGeneral(){super();}
    

     
    
       public void GenerarGanancias(int cantidadHoras){
         GanaciasGeneradasPorReservaciones+=CostoReservacionPorHora*cantidadHoras;
     }

       
    public void setPromiciones(String promiciones) {
        this.promiciones = promiciones;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getPromiciones() {
        return promiciones;
    }

    public String getX() {
        return x;
    }

    @Override
    public String toString() {
        return super.toString()+"SalaGeneral--> Promiciones=" + promiciones + ", Snack =" + x ;
    }
   
     
    
}
