package modelo;

import java.io.Serializable;

public class Error implements Serializable{
    private int codigo;
    private String descripcion;

    public Error(int code, String description) {
        this.codigo = code;
        this.descripcion = description;
    }

    public int getCode() {
        return codigo;
    }

    public void setCode(int code) {
        this.codigo = code;
    }

    public String getDescription() {
        return descripcion;
    }

    public void setDescription(String description) {
        this.descripcion = description;
    }
    
    
}
