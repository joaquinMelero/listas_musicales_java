   
package proyectolistasmusicales;

import java.io.Serializable;
import java.util.Objects;


public class Cancion implements Serializable{
    private String titulo;
    private String ruta;
    private int duracion;
    
    public Cancion(String titulo, String ruta, int duracion){
        if(duracion<=0){
            throw new IllegalArgumentException("La duración debe ser positiva");
        }
        
        this.titulo = titulo;
        this.ruta = ruta;
        this.duracion = duracion;
      
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getRuta() {
        return ruta;
    }

    @Override
    public String toString() {
        return "Cancion{" + "titulo=" + titulo + ", ruta=" + ruta + ", duracion=" + duracion + '}';
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if(duracion<=0){
            throw new IllegalArgumentException("La duración debe ser positiva");
        }        
        this.duracion = duracion;
    }

    
}
