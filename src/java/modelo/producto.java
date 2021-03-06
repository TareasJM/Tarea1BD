/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;


import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.sql.*;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author jose
 */
public class producto
{
    private int id_producto;
    private int stock;
    private int precio;
    private String descripcion;
    private String categoria;
    private String nombre;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    private String classfor="oracle.jdbc.driver.OracleDriver";
    private String url="jdbc:oracle:thin:@localhost:1521:XE";
    private String usuario="salinas";
    private String clave="hola";

    private Connection con=null;
    private PreparedStatement pr=null;
    private ResultSet rs=null;
    
    
    public Vector<producto> showProducto()
    {
        Vector<producto> vecPro=new Vector<producto>();
        String sql="SELECT * FROM productos order by id_producto";
        try
        {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next())
            {
                producto pro =new producto();
                pro.setId_producto(rs.getInt("id_producto"));
                pro.setNombre(rs.getString("producto"));
                pro.setStock(rs.getInt("stock"));
                pro.setCategoria(rs.getString("categoria"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setPrecio(rs.getInt("precio"));//nombre en oracle
                vecPro.add(pro);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }finally
        {
            try
            {
                rs.close();
                pr.close();
                con.close();
            }
            catch(Exception ex)
            {

            }
        }
        return vecPro;
    }//mostrarProductos
    
    
   public void editProducto(int id,int cantidad,String nombre,String descripcion,
           String categoria, int precio)
    {
        String sql="UPDATE productos set producto ='"+nombre+"', stock='"+cantidad +"', categoria='"
                + categoria +"', descripcion='"+descripcion+"', precio='"+precio+"' where id_producto ='"+id+"'";
                
        try
        {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            pr.executeUpdate();
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }finally
        {
            try
            {
                rs.close();
                pr.close();
                con.close();
            }
            catch(Exception ex)
            {

            }
        }
        
    }//editProducto
   
    
   public void buyProducto(int id,int cantidad,int precio)
    {   
        producto pro = new producto();
        pro = pro.getProductoByID(id);
        int newCantidad = cantidad + pro.getStock();
        String sql="UPDATE productos set stock ='"+newCantidad+"', precio ='"+precio+"'"
                + " where id_producto ='"+id+"'";
                
        try
        {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            pr.executeUpdate();
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }finally
        {
            try
            {
                rs.close();
                pr.close();
                con.close();
            }
            catch(Exception ex)
            {

            }
        }
        
    }//buyProducto
   
    public void editStockProducto(int newStock)
            
    {   
        String sql="UPDATE productos set stock='"+newStock +"' where id_producto ='"+this.id_producto+"'";
                
        try
        {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            pr.executeUpdate();
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }finally
        {
            try
            {
                rs.close();
                pr.close();
                con.close();
            }
            catch(Exception ex)
            {

            }
        }
        
    }//editStockProducto
   
    public producto getProducto(String nombre)
    {
        producto pro = new producto();
        String sql="SELECT * FROM productos where producto = '"+nombre+"'";
        try{
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next())
            {
                pro.setId_producto(rs.getInt("id_producto"));
                pro.setStock(rs.getInt("stock"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setCategoria(rs.getString("categoria"));
                pro.setPrecio(rs.getInt("precio"));
                pro.setNombre(rs.getString("producto"));
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
        return pro;
    }//getProductoNombre
    
     public producto getProductoByID(int id)
    {
        producto pro = new producto();
        String sql="SELECT * FROM productos where id_producto = '"+id+"'";
        try{
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next())
            {
                pro.setId_producto(rs.getInt("id_producto"));
                pro.setStock(rs.getInt("stock"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setCategoria(rs.getString("categoria"));
                pro.setPrecio(rs.getInt("precio"));
                pro.setNombre(rs.getString("producto"));
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
        return pro;
    }//getProductoId

    
   

}//producto
