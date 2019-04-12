
package Entidades;

public class Horario {
    //identificador de dia de la semana en numero
    private int numeroDia[];
    //datos de la fecha
    private int hora_entrada[];    
    private int hora_salida[];
    private String dias[];
    public Horario(String dias[] , int hora_entrada[],int hora_salida[]) {
        this.hora_entrada = hora_entrada;
        this.hora_salida= hora_salida;
        this.dias=dias;
        numeroDia=new int [dias.length];
        enumerarDia();
    }

    private void enumerarDia(){
        for(int  i=0;i<numeroDia.length;i++){
            numeroDia[i]=diaNumero(dias[i] );   
        }
        
    }
    
    public int retornaPosicionDia(int dia){
        int i=0;
        for(i=0;i<numeroDia.length;i++){
            if(numeroDia[i]==dia)
                return i;//retorna posicion del dia
        }
        return -1;//No encontró dia
    }
    
    @Override
    public String toString() {
        String horariosxd="";
        for(int i=0;i<dias.length;i++){
            horariosxd+= dias[i]+" E: "+hora_entrada[i]+" S: "+hora_salida[i]+"\n";
        }
        return "Horario\n"+horariosxd;
    }
  
    
    

    public int[] getHora_entrada() {
        return hora_entrada;
    }

    public int[] getHora_salida() {
        return hora_salida;
    }

    //Metodos gets
    public String[] getDias() {
        return dias;
    }
    
    
    //Metodos setter

    public void setHora_entrada(int[] hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public void setHora_salida(int[] hora_salida) {
        this.hora_salida = hora_salida;
    }

    public void setDias(String[] dias) {
        this.dias = dias;
    }


    
    private int diaNumero(String nombre){
        switch(nombre){
            case "LUNES": return 1;
            case "MARTES": return 2;
            case "MIERCOLES": return 3;
            case "JUEVES": return 4;
            case "VIERNES": return 5;
            case "SABADO": return 6;
            case "DOMINGO": return 0;
            
            default :return -1;
        }
    }
    
    
    //Metodos horaentrada y horaSalida 1 especifico
    public String getDiaSeleccionado (int i){        
        return dias[i];
    }
    public int getHoraEntradaSeleccionada (int i){        
        return hora_entrada[i];
    }
    
    public int getHoraSalidaSeleccionada (int i){        
        return hora_salida[i];
    }
    
}
