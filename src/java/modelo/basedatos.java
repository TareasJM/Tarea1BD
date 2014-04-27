/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;

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
    
    public int insertCompra(int monto, String fecha, String hora)
    {
        int id_compra = 0;
        String sql="SELECT ID_COMPRA FROM COMPRAS order by ID_COMPRA DESC";
        try{
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            if (rs.next() == false)
            {
                id_compra = 1;

            }
            else
            {
                id_compra = rs.getInt("ID_COMPRA")+1;
            }
            sql="Insert into COMPRAS values(?,?,?,?)";//nombre de la table
            
            pr=con.prepareStatement(sql);
            pr.setInt(1, id_compra);
            pr.setInt(2, monto);
            pr.setString(3, fecha);
            pr.setString(4, hora);
            pr.executeUpdate();
        }
        catch(Exception ev)
        {
        }

        return id_compra;
        
    }//insertCompra
    
public int insertDCompra(int id_compra, int id_producto, int cantidad, int precio)
    {
        int id_detalle = 0;
        String sql="SELECT ID_DETALLE FROM DCOMPRAS order by ID_DETALLE DESC";
        try{
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            if (rs.next() == false)
            {
                id_detalle = 1;
            }
            else
            {
                id_detalle = rs.getInt("ID_DETALLE")+1;
            }
            sql="Insert into DCOMPRAS values(?,?,?,?,?)";//nombre de la table
            JOptionPane.showMessageDialog(null,"sql "+id_detalle+" "+id_compra+" "+id_producto+" "+cantidad+" "+precio);

            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario, clave);
            pr=con.prepareStatement(sql);
            pr.setInt(1, id_detalle);
            pr.setInt(2, id_compra);
            pr.setInt(3, id_producto);
            pr.setInt(4, cantidad);
            pr.setInt(5, precio);
            pr.executeUpdate();
        }
        catch(Exception ev)
        {
        }

        return id_compra;

    }//insertDCompra

     public void addProducto(int stock, String descripcion,
                            String categoria, int precio, String nombre)
    {  
       String sql="SELECT id_producto FROM productos order by id_producto DESC";
       
       int id_producto = 0;
        try
        {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            if (rs.next() == false)
            {
                id_producto = 1;
            }
            else
            {
                id_producto = rs.getInt("id_producto")+1;
            }
            
            sql="Insert into productos values(?,?,?,?,?,?)";//nombre de la table
            pr=con.prepareStatement(sql);
            pr.setInt(1, id_producto);
            pr.setInt(2, stock);
            pr.setString(3, descripcion);
            pr.setString(4, categoria);
            pr.setInt(5, precio);    
            pr.setString(6, nombre);
            pr.executeUpdate();
        }
        catch(Exception ev)
        {
            sql="update productos set producto =?, precio=?, categoria=?, descripcion=?, stock=? where id_producto=?";
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
            pr.setInt(6, id_producto);
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
            sql="update clientes set nombrec =? where rut=?";
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
                user.setNombre(rs.getString("nombrec"));
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
    
     public Map getStocks()
    {
        Map<String,Integer> dic = new HashMap<String,Integer>();
        String sql="SELECT * FROM productos order by id_producto";
        try{
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next()){
                
                dic.put(rs.getString("producto"),(Integer)rs.getInt("stock"));

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
        return dic;
    }//DICCIONARIO PRODUCTOS
    
    
    
     public void deleteProducto(int id)
      {
       String sql="DELETE FROM productos WHERE id_producto=? ";
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
    
  
    
    public int addVenta(String rutC, String rutV,
                             int monto, String fecha, String hora) 
    {
        int id = 0;
        String sql="SELECT id_venta FROM ventas order by id_venta DESC";
        try
        {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            if (rs.next() == false)
            {
                JOptionPane.showMessageDialog(null,"falseVenta");
                id = 1;
            }
            else
            {
                id = rs.getInt("id_venta")+1;
            }
                   

            sql="Insert into VENTAS values(?,?,?,?,?,?)";//nombre de la table
            pr=con.prepareStatement(sql);      
            pr.setInt(1, id);   
            pr.setString(2, rutC);
            pr.setString(3, rutV);
            pr.setInt(4, monto);
            pr.setString(5, fecha);
            pr.setString(6, hora);
            pr.executeUpdate();
        }
        catch(Exception ev)
        {
            sql="UPDATE VENTAS order by id_venta ASC";
            try
            {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario, clave);
            pr=con.prepareStatement(sql);
            pr.executeUpdate();
            JOptionPane.showMessageDialog(null,"UPDATE VENTAS");
            }
            catch(Exception e)
            {}
        }
        return id;
    }//addVenta
 
    
    public void addDVenta(int id_venta, int id_producto, int cantidad)
    {
        int id_detalle=0;
        String sql="SELECT id_detalle FROM dventa order by id_detalle DESC";
        try
        {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            if (rs.next() == false)
            {
                id_detalle = 1;
            }
            else
            {
                id_detalle = rs.getInt("id_detalle")+1;
            }

            sql="INSERT INTO DVENTA VALUES(?,?,?,?)";//nombre de la table

            pr=con.prepareStatement(sql);
            pr.setInt(1, id_detalle);
            pr.setInt(2, id_venta);
            pr.setInt(3, id_producto);
            pr.setInt(4, cantidad);
            pr.executeUpdate();

        }
        catch(Exception ev)
        {
            sql="update dventa set id_venta2 =?, id_detalle=?, cantidad=? where id_producto2=?";
            try
            {
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario, clave);
            pr=con.prepareStatement(sql);
            pr.setInt(1, cantidad);
            pr.setInt(2, id_producto);
            pr.setInt(3, id_venta);
            pr.setInt(4, id_detalle);
            pr.executeUpdate();

            }
            catch(Exception e)
            {}
        }
    }//addDVENTA
    
    
    public void deleteAll()
      {
       String[] tablas= {"DVENTA","DCOMPRAS","VENTAS","COMPRAS","PRODUCTOS","CLIENTES"};
       String[] tablas2= {"ID_DETALLE","ID_COMPRA","ID_CLIENTE","ID_COMPRA","ID_PRODUCTO","ID_CLIENTE"};
       for(int i = 0; i<6; i++){
   
           String sql="DELETE FROM " +tablas[i] +" "+ tablas2[i]; //elimina todos los elementos de la tabla
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
        }
      }//ELIMINA TODO
 
    public void insertAll()
      {
       String[] tablas= {"DVENTA","DCOMPRAS","VENTAS","COMPRAS","PRODUCTOS"};
       String[] tablas2= {"ID_DETALLE","ID_COMPRA","ID_CLIENTE","ID_COMPRA","ID_PRODUCTO"};
       for(int i = 0; i<5; i++){
   
           String sql="DELETE FROM " +tablas[i] +" "+ tablas2[i]; //elimina todos los elementos de la tabla
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
        }
      }//AGREGA PRODUCTOS Y CLIENTES
    
}//basedatos
