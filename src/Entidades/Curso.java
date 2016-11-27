package Entidades;

public class Curso {
    
    // Atributos
    private String clave;
    private String nombre;
    private String fechaInicio;
    private String nivel;
    private String duracion;

    // Constructores
    public Curso() {
        this.clave = "-1";
        this.nombre = "";
        this.fechaInicio = "1-Ene-2000";
        this.nivel = "Principiante";
        this.duracion = "";
    }

    public Curso(String clave, String nombre, String fechaInicio, String nivel, String duracion) {
        this.clave = clave;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.nivel = nivel;
        this.duracion = duracion;
    }
    
    // Gets y Sets
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}
