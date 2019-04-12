package Entidades;

public class SalaVIP extends Sala{
    
    private String modeloGafas3D;
    private String servicioAdicionalPaga;
   
    public SalaVIP(String codigo,String nombre,Horario horario) {
        super(codigo, nombre,horario,"VIP");
    }
    public SalaVIP (){super();}
 
     
     
     public void GenerarGanancias(int cantidadHoras){
         GanaciasGeneradasPorReservaciones+=CostoReservacionPorHora*cantidadHoras;
     }

    public String getModeloGafas3D() {
        return modeloGafas3D;
    }

    public String getServicioAdicionalPaga() {
        return servicioAdicionalPaga;
    }

    public void setModeloGafas3D(String modeloGafas3D) {
        this.modeloGafas3D = modeloGafas3D;
    }

    public void setServicioAdicionalPaga(String servicioAdicionalPaga) {
        this.servicioAdicionalPaga = servicioAdicionalPaga;
    }
     
    @Override
    public String toString() {
        return "SalaVIP -->  Modelo de gafas 3D=" + modeloGafas3D + ", Servicio Adicional de Paga=" + servicioAdicionalPaga ;
    }
     
    
}
