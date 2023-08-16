
package com.itla.db;


public class Contacto {
    private int id;
    private String nombre; 
    private String apellido;
    private String empresa;
    private String correo;
    private String telefono;

    public Contacto(){
        
    }

    public Contacto(int id, String nombre, String apellido, String empresa, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.empresa = empresa;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Contacto(String nombre, String apellido, String empresa, String correo, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.empresa = empresa;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    

}
