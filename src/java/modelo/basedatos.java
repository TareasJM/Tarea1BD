/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author salinas
 */
public class basedatos 
{

    public basedatos() 
    {
        
    }
    
    private String classfor="oracle.jdbc.driver.OracleDriver";
    private String url="jdbc:oracle:thin:@localhost:1521:XE";
    private String usuario="salinas";
    private String clave="hola";

    private Connection con=null;
    private PreparedStatement pr=null;
    private ResultSet rs=null;
    
    public void insertV(String rut, String pass, String nombre)
    {
       String sql="Insert into vendedores values(?,?,?)";//nombre de la table
     
        try
        {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario, clave);
            pr=con.prepareStatement(sql);
            pr.setString(1, rut);
            pr.setString(2, pass);
            pr.setString(3, nombre);    
            pr.executeUpdate();
        }
        catch(Exception ev)
        {
            sql="update vendedores set nombre=?, pass=? where rut=?";
            try
            {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario, clave);
            pr=con.prepareStatement(sql);
            pr.setString(1, nombre);
            pr.setString(2, pass);
            pr.setString(3, rut);
            pr.executeUpdate();
            }
            catch(Exception e)
            {}
        }
    }    
    public void insertCompra( String producto, int cantidad, int precio)
    {
       String sql="Insert into compras values(?,?,?)";//nombre de la table
     
        try
        {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario, clave);
            pr=con.prepareStatement(sql);
            pr.setString(1, producto);
            pr.setInt(2, cantidad);
            pr.setInt(3, precio);    
            pr.executeUpdate();
        }
        catch(Exception ev)
        {
            sql="update compras set precio=?, cantidad=? where producto=?";
            try
            {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario, clave);
            pr=con.prepareStatement(sql);
            pr.setInt(1, precio);
            pr.setInt(2, cantidad);
            pr.setString(3, producto);
            pr.executeUpdate();
            
            }
            catch(Exception e)
            {}
        }
        
        
    }
    
}
