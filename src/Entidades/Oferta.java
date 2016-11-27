package Entidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Oferta {
    
    // Conjunto de cursos en la oferta
    private ArrayList<Curso> Cursos;
    
    // Constructores
    public Oferta() {
        this.Cursos = new ArrayList<>();
    }

    public Oferta(ArrayList<Curso> cursos) {
        Cursos = cursos;
    }
    
    // Gets y Sets
    public ArrayList<Curso> getCursos() {
        return Cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        Cursos = cursos;
    }
    
    // Metodo para cargar de archivo la información a la instancia del objeto
    public ArrayList<Curso> cargar() {
        // Lector de archivos de texto
        BufferedReader fi = null;
        // Tokenizador de strings
        StringTokenizer tok;
        // Linea temporal y los 5 atributos de usuario
        String linea, a, b, c, d, e;

        try {
            // Abre el archivo si existe
            fi = new BufferedReader(new FileReader("CFDB.txt"));
            // Obtener primera linea
            linea = fi.readLine();
            // Mientras haya algo que leer...
            while(linea != null && linea != "") {
                // Dividir la linea en tokens
                tok = new StringTokenizer(linea, "/");
                // Obtener los 5 atributos
                a = tok.nextToken();
                b = tok.nextToken();
                c = tok.nextToken();
                d = tok.nextToken();
                e = tok.nextToken();
                Cursos.add(new Curso(a, b, c, d, e));
                linea = fi.readLine();
            }
            fi.close();
        }
        catch(Exception excep) {
            // Si no se pudo leer se regresa nulo
            return Cursos;
        }
        return Cursos;
    }
}
