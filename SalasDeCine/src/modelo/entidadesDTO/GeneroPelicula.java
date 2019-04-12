package modelo.entidadesDTO;

public class GeneroPelicula {
    private int ID;
    private String nombre;
    public GeneroPelicula(){}//Constructor
    public GeneroPelicula(int ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    
    
}
