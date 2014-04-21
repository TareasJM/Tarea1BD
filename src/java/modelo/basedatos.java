/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    }//insertV 
    
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
        
        
    }//insertCompra
    
    
    public void insertVenta( String cliente, String producto, int cantidad)
    {
       String sql="Insert into cventas values(?,?,?)";//nombre de la table
     
        try
        {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario, clave);
            pr=con.prepareStatement(sql);
            pr.setString(1, cliente);
            pr.setString(2, producto);
            pr.setInt(3, cantidad);    
            pr.executeUpdate();
        }
        catch(Exception ev)
        {
            sql="update ventas set producto=?, cantidad=? where cliente=?";
            try
            {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario, clave);
            pr=con.prepareStatement(sql);
            pr.setInt(1, cantidad);
            pr.setString(2, producto);
            pr.setString(3, cliente);
            pr.executeUpdate();
            
            }
            catch(Exception e)
            {}
        }
        
        
    }//insertVenta
    
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
            sql="update productos set nombre =?, precio=?, categoria=?, descripcion=?, stock=? where id=?";
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
     
     
     
    public void addUser(String rut, String contraseña, String nombre,
                            String tipo, int comision)
    {
       String sql="Insert into usuarios values(?,?,?,?,?)";//nombre de la table
     
        try
        {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario, clave);
            pr=con.prepareStatement(sql);
            pr.setString(1, rut);
            pr.setString(2, contraseña);
            pr.setString(3, nombre);
            pr.setString(4, tipo);
            pr.setInt(5, comision);    
            pr.executeUpdate();
        }
        catch(Exception ev)
        {
            sql="update usuarios set nombre =?, tipo=?, contraseña=?, comision=?, where rut=?";
            try
            {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario, clave);
            pr=con.prepareStatement(sql);
            pr.setInt(1, comision);
            pr.setString(2, tipo);
            pr.setString(3, nombre);
            pr.setString(4, contraseña);
            pr.setString(5, rut);
            pr.executeUpdate();
            
            }
            catch(Exception e)
            {}
        }
    }//addUser
 
    
    public void addCliente(String rut, String nombre)
    {
       String sql="Insert into clientes values(?,?)";//nombre de la table
     
        try
        {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario, clave);
            pr=con.prepareStatement(sql);
            pr.setString(1, rut);
            pr.setString(2, nombre);   
            pr.executeUpdate();
        }
        catch(Exception ev)
        {
            sql="update clientes set nombre =? where rut=?";
            try
            {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario, clave);
            pr=con.prepareStatement(sql);
            pr.setString(1, nombre);
            pr.setString(2, rut);
            pr.executeUpdate();
            
            }
            catch(Exception e)
            {}
        }
    }//addCliente
 
    
    public Vector<cliente> showCliente()
    {
        Vector<cliente> vecPro=new Vector<cliente>();
        String sql="SELECT * FROM clientes order by rut";
        try{
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next()){
                cliente user = new cliente();
                user.setRut(rs.getInt("rut"));
                user.setNombre(rs.getString("nombre"));
                vecPro.add(user);
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
        
     public void deleteProducto(int id)
      {
       String sql="DELETE FROM productos WHERE id=? ";
        try{
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            pr.setInt(1, id);
           pr.executeUpdate();
        }
        catch(Exception ex)
        {}
        finally
        {
            try
            {
                pr.close();
                con.close();
            }
            catch(Exception ex)
            {}
        }
    }//deleteProducto
     
    public void deleteAllProductos()
      {
       String sql="TRUNCATE TABLE productos"; //elimina todos los elementos de la tabla
        try{
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            pr.executeUpdate();
        }
        catch(Exception ex)
        {}
        finally
        {
            try
            {
                pr.close();
                con.close();
            }
            catch(Exception ex)
            {}
        }
    } //elimiar producto
    
    public void addVenta(String rutC, String rutV, String producto,
                             int cantidad) 
    {
        int id = 0;
        String sql="SELECT ID FROM ventas order by id DESC LIMIT 1 ";
        try
        {
            

            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            id = rs.getInt("id")+1;

        sql="Insert into ventas values(?,?,?,?,?)";//nombre de la table
            
            pr=con.prepareStatement(sql);
            pr.setInt(1, id);   
            pr.setString(2, rutC);
            pr.setString(3, rutV);
            pr.setString(4, producto);
            pr.setInt(5, cantidad);
             
            pr.executeUpdate();
        }
        catch(Exception ev)
        {
            sql="update ventas set id_cliente =?, id_usuario=?, monto_total=?, fecha=?, hora=?, where id_venta=?";
            try
            {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario, clave);
            pr=con.prepareStatement(sql);
            pr.setInt(1, cantidad);
            pr.setString(2, producto);
            pr.setString(3, rutV);
            pr.setString(4, rutC);
            pr.setInt(5, id);
            pr.executeUpdate();
            
            }
            catch(Exception e)
            {}
        }
    }//addVenta
 
    
    
}//basedatos
