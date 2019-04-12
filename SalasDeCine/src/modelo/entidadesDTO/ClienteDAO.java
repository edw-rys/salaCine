package modelo.entidadesDTO;

public class ClienteDAO {
    private String ciPersona;
    private String nombre;
    private String telefono;
    private String direccion;
    private String apellidos;
    
    public ClienteDAO(){}

    public void setCiPersona(String ciPersona) {
        this.ciPersona = ciPersona;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCiPersona() {
        return ciPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getApellidos() {
        return apellidos;
    }

    @Override
    public String toString() {
        return "ClienteDAO{" + "ciPersona=" + ciPersona + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", apellidos=" + apellidos + '}';
    }
    
    
    
    
}
