package model;

public class Profesion {
    private String id;
    private String nombre;

    public Profesion(String nombre) {
        this.nombre = nombre;
    }

    public Profesion(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Profesion{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
}
