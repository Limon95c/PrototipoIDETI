package Entidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Usuario {
    
    // Atributos
    private int clave;
    private String nombreUsuario;
    private String nombreReal;
    private String contrasenia;
    private String correo;

    // Metodos constructores
    public Usuario() {
        clave = -1;
        nombreUsuario = "";
        nombreReal = "";
        contrasenia = "";
        correo = "";
    }

    public Usuario(int clave, String nombreUsuario, String nombreReal, String contrasenia, String correo) {
        this.clave = clave;
        this.nombreUsuario = nombreUsuario;
        this.nombreReal = nombreReal;
        this.contrasenia = contrasenia;
        this.correo = correo;
    }

    // Metodos adicionales

    // Obtener usuario en base a su nombreDeUsuario
    public Usuario getUsuario(String user) {
        // Lector de archivos de texto
        BufferedReader fi;
        // Tokenizador de strings
        StringTokenizer tok;
        // Linea temporal y los 5 atributos de usuario
        String linea, b, c, d, e;
        int a;
        // Objeto a regresar
        Usuario res = null;

        try {
            // Abre el archivo si existe
            fi = new BufferedReader(new FileReader("UFDB.txt"));
            // Obtener primera linea
            linea = fi.readLine();
            // Mientras haya algo que leer...
            while(linea != null && linea != "") {
                // Dividir la linea en tokens
                tok = new StringTokenizer(linea, "/");
                // Obtener los 5 atributos
                a = Integer.parseInt(tok.nextToken());
                b = tok.nextToken();
                c = tok.nextToken();
                d = tok.nextToken();
                e = tok.nextToken();
                // Comprarar usuario, si coincide regresar el usuario
                if(b.equals(user)) {
                    res = new Usuario(a, b, c, d, e);
                }
                linea = fi.readLine();
            }
            fi.close();
            return res;
        }
        catch(Exception excep) {
            System.out.println("Error al recibir usuario");
        }
        return res;
    }

    // Determinar si un nombre de usuario y contraseña pueden inicar sesion
    public boolean inicioDeSesionExitosa(String user, String contra) {
        // Lector de archivos de texto
        BufferedReader fi = null;
        // Tokenizador de strings
        StringTokenizer tok;
        // Linea temporal y los 5 atributos de usuario
        String linea, b, c, d, e;
        int a;
        // Objeto a regresar
        boolean res = false;

        try {
            // Abre el archivo si existe
            fi = new BufferedReader(new FileReader("UFDB.txt"));
            // Obtener primera linea
            linea = fi.readLine();
            // Mientras haya algo que leer...
            while(linea != null && linea != "") {
                // Dividir la linea en tokens
                tok = new StringTokenizer(linea, "/");
                // Obtener los 5 atributos
                a = Integer.parseInt(tok.nextToken());
                b = tok.nextToken();
                c = tok.nextToken();
                d = tok.nextToken();
                e = tok.nextToken();
                // Comprarar usuario y contrasenia, si coincide regresar true
                if(b.equals(user) && d.equals(contra)) {
                    res = true;
                }
                linea = fi.readLine();
            }
            fi.close();
        }
        catch(Exception excep) {
            // Si no se pudo leer se regresa nulo
            return res;
        }
        return res;
    }
    
    // Crear un nuevo usuario
    public void nuevo(String nombreUsuario, String nombreReal, String contrasenia, String correo) {
        PrintWriter fo;
        BufferedReader fi;
        ArrayList<String> lineas = new ArrayList<>();
        String dato;

        int i = 0;
        try {
            fi = new BufferedReader(new FileReader("UFDB.txt"));
            dato = fi.readLine();
            while(dato != null) {
                lineas.add(dato);
                i++;
                dato = fi.readLine();
            }
            fi.close();
            fo = new PrintWriter("UFDB.txt");
            for(int x = 0; x < i; x++) {
                fo.println(x + lineas.get(x).substring(lineas.get(x).indexOf("/")));
            }
            fo.println(i + "/" + nombreUsuario + "/" + nombreReal + "/" + contrasenia + "/" + correo);
            fo.close();
        } catch(Exception excep) {
            System.out.println("Problema de almacenamiento clase usuario");
        }
    }

    // Getters y Setters

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
