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
            System.out.println(ex);
        }
    }
  public boolean editarContacto(Contacto contacto,int id) {
    conectar();
    String sql = "UPDATE contactos SET "
            + "NOMBRE = '" + contacto.getNombre() + "', "
            + "APELLIDOS = '" + contacto.getApellido() + "', "
            + "EMPRESA = '" + contacto.getEmpresa() + "', "
            + "CORREO = '" + contacto.getCorreo() + "', "
            + "TELEFONO = '" + contacto.getTelefono() + "' "
            + "WHERE ID = " + id;

    try {
        stmnt.executeUpdate(sql);
        return true;
    } catch (SQLException ex) {
        System.out.println(ex);
    } finally {
        desconectar();
    }

    return false;
}


    
    
    public Contacto getContactoById(int id){
    conectar();
    String sql = "SELECT * FROM contactos WHERE Id = " + id;

    try {
        ResultSet resultSet = stmnt.executeQuery(sql);
        if (resultSet.next()) {
            String nombre = resultSet.getString("NOMBRE");
            String apellido = resultSet.getString("APELLIDOS");
            String empresa = resultSet.getString("EMPRESA");
            String correo = resultSet.getString("CORREO");
            String telefono = resultSet.getString("TELEFONO");
            
            Contacto contactoEncontrado = new Contacto(id, nombre, apellido, empresa, correo,telefono );
            return contactoEncontrado;
        }
    } catch (SQLException ex) {
        System.out.println(ex);
    }

    desconectar();
    return null;
    }
    
    public boolean eliminarContactoPorId(int id) {
    conectar();
    String sql = "DELETE FROM contactos WHERE ID = " + id;

    try {
        stmnt.executeUpdate(sql);
        return true;
    } catch (SQLException ex) {
        System.out.println(ex);
    }

    desconectar();
    return false;
}
    public void insertarContacto(Contacto contacto){
        conectar();
        String sql = "INSERT INTO contactos(NOMBRE, APELLIDOS, EMPRESA, CORREO,TELEFONO) "
                + "VALUES('" + contacto.getNombre() + "', "
                + "'" + contacto.getApellido() + "', "
                + "'" + contacto.getEmpresa() + "', "
                + "'" + contacto.getCorreo() + "', "
                + contacto.getTelefono() + ")";
                
        try{
            stmnt.executeUpdate(sql);
        }
        catch (SQLException ex){
            System.out.println(ex);
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
                    "829396450"
                    
        );
        
        db.insertarContacto(miContacto);
        
    }
}
