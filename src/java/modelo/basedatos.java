/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

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
    
    
     public void addProducto(int id, int stock, String descripcion,
                            String categoria, int precio, String nombre)
    {
       String sql="Insert into productos values(?,?,?,?,?,?)";//nombre de la table
     
        try
        {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario, clave);
            pr=con.prepareStatement(sql);
            pr.setInt(1, id);
            pr.setInt(2, stock);
            pr.setString(3, descripcion);
            pr.setString(4, categoria);
            pr.setInt(5, precio);    
            pr.setString(6, nombre);
            pr.executeUpdate();
        }
        catch(Exception ev)
        {
            sql="update productos set nombre =?, precio=?, categoria=?, descripcio=?, stock=? where id=?";
            try
            {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario, clave);
            pr=con.prepareStatement(sql);
            pr.setString(1, nombre);
            pr.setInt(2, precio);
            pr.setString(3, categoria);
            pr.setString(4, descripcion);
            pr.setInt(5, stock);
            pr.setInt(6, id);
            pr.executeUpdate();
            
            }
            catch(Exception e)
            {}
        }
    }//addProducto
     
    public Vector<producto> showProducto()
    {
        Vector<producto> vecPro=new Vector<producto>();
        String sql="SELECT * FROM productos";
        try{
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next()){
                producto pro=new producto();
                pro.setId_producto(rs.getInt("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setStock(rs.getInt("cantidad"));
                vecPro.add(pro);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                rs.close();
                pr.close();
                con.close();
            }catch(Exception ex){

            }
        }
        return vecPro;
    }//mostrarProductos
        
    
}//basedatos
