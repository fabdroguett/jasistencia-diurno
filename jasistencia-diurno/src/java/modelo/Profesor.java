package modelo;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public Profesor(String rut, String clave) {
        this.rut = rut;
        this.clave = clave;
        errores=new ArrayList<Error>();
    }
    private int edad;
    private String sexo;
    private String clave;
    private List<Error> errores;

    public Profesor(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, int edad, String sexo, String clave) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edad = edad;
        this.sexo = sexo;
        this.clave = clave;
        errores=new ArrayList<Error>();
    }

    public Profesor(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, int edad, String sexo) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edad = edad;
        this.sexo = sexo;
        errores=new ArrayList<Error>();
    }
    
    

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexoFormatiado() {
        if(sexo.equalsIgnoreCase("m")){
            return "Masculino";
        }else{
            return "Femenino";
        }
    }
    
    public String getSexo(){
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Profesor{" + "rut=" + rut + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", edad=" + edad + ", sexo=" + sexo + ", clave=" + clave + '}';
    }
    
    public List<Error> getErrors() {
        return errores;
    }

    public void setErrors(List<Error> errors) {
        this.errores = errors;
    }
  public void addError(Error error){
        errores.add(error);
    }
    
    public boolean errorExiste(){
        return !errores.isEmpty();
    }
}
