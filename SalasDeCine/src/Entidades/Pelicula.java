package Entidades;

public class Pelicula {
   private String nombre;
    private int añoEstreno;
    private int idCategoria;
    private String nombreCategoria;
    private int calificacion;
    private int IdPelicula;
    public String getNombre() {
        return nombre;
    }

    public int getAñoEstreno() {
        return añoEstreno;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    //GETS
    public int getCalificacion() {
        return calificacion;
    }

    public int getIdPelicula() {
        return IdPelicula;
    }
    
    //SETS

    public void setIdPelicula(int IdPelicula) {
        this.IdPelicula = IdPelicula;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAñoEstreno(int añoEstreno) {
        this.añoEstreno = añoEstreno;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Pelicula\n" + "Nombre=" + nombre + ", Año de estreno=" + añoEstreno + ", Categoria=" + nombreCategoria + ", Calificacion=" + calificacion ;
    }

    
}
