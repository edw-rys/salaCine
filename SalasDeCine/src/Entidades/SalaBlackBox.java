package Entidades;

public class SalaBlackBox extends Sala{
    
    private String TipoAsiento="";
    private String serviciAdicionalGratuitos="";
    public SalaBlackBox(String codigo,String nombre,Horario horario) {
        super(codigo, nombre,horario,"BLACKBOX");
    }

  

    public SalaBlackBox(){super();}
    
    
     public void GenerarGanancias(int cantidadHoras){
         GanaciasGeneradasPorReservaciones+=CostoReservacionPorHora*cantidadHoras;
     }
    
    public String getTipoAsiento() {
        return TipoAsiento;
    }

    public String getServiciAdicionalGratuitos() {
        return serviciAdicionalGratuitos;
    }

    public void setTipoAsiento(String TipoAsiento) {
        this.TipoAsiento = TipoAsiento;
    }

    public void setServiciAdicionalGratuitos(String serviciAdicionalGratuitos) {
        this.serviciAdicionalGratuitos = serviciAdicionalGratuitos;
    }
    
    
    @Override
    public String toString(){
         String complemento=super.toString();//Guarda los datos de la sals
                 
         return complemento+"\n***SERVICIOS ADICIONALES**\n*Tipo de Asiento: "+this.TipoAsiento+"\n*Servicios adicionales: "+this.serviciAdicionalGratuitos+"\n";
     }

    
}
