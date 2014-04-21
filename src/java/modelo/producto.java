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
        String sql="SELECT * FROM productos order by id";
        try
        {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next())
            {
                producto pro =new producto();
                pro.setId_producto(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setStock(rs.getInt("stock"));//nombre en oracle
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
    
    
   public Vector<producto> editProducto()
    {
        Vector<producto> vecPro=new Vector<producto>();
        String sql="SELECT * FROM productos order by id";
        try
        {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next())
            {
                producto pro =new producto();
                pro.setId_producto(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setStock(rs.getInt("stock"));//nombre en oracle
                pro.setCategoria(rs.getString("categoria"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setPrecio(rs.getInt("precio"));
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
    }

    
   

}//producto
