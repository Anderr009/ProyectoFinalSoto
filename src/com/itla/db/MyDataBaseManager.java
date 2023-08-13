package com.itla.db;

import java.sql.*;

public class MyDataBaseManager {
    private String url = "jdbc:mysql://localhost/itla";
    private String username = "root";
    private String password = "";
    public Connection con;
    private Statement stmnt;

    public Connection conectar() {
        try {
            con = DriverManager.getConnection(url, username, password);
            stmnt = con.createStatement();
            System.out.println("Conectado");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
    public void desconectar(){
        try {
            if(con != null){
                con.close();
            }
            System.out.println("Desconectado");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void insertarContacto(Contacto contacto){
        conectar();
        String sql = "INSERT INTO contactos(NOMBRE, APELLIDO, EMPRESA, CORREO,TELEFONO) "
                + "VALUES('" + contacto.getNombre() + "', "
                + "'" + contacto.getApellido() + "', "
                + "'" + contacto.getEmpresa() + "', "
                + "'" + contacto.getCorreo() + "', "
                + contacto.getTelefono() + ")";
                
        try{
            stmnt.executeUpdate(sql);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        
        desconectar();
    }
    
    public static void main(String[] args) {
        MyDataBaseManager db = new MyDataBaseManager();
        
        Contacto miContacto = new Contacto(
                    "Jhon",
                    "Medina",
                    "BHD",
                    "ifjiejfgmail.com",
                    829396450
                    
        );
        
        db.insertarContacto(miContacto);
        
    }
}
