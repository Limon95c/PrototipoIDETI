package Entidades;

public class Administrador extends Usuario{
    
    // Atributos especializados para administradores
    private String empresa;
    
    // Constructores
    public Administrador() {
        this.empresa = "";
    }

    public Administrador(int clave, String nombreUsuario, String nombreReal, String contrasenia, String correo, String empresa) {
        super(clave, nombreUsuario, nombreReal, contrasenia, correo);
        this.empresa = empresa;
    }
    
    // Gets y Sets
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
