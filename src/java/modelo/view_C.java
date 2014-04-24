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
public class view_C {
 
    public int id_venta;
    public String id_cliente;
    public String id_usuario;
    public String nombre;
    public String producto;
    public int cantidad;

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
       
    private String classfor="oracle.jdbc.driver.OracleDriver";
    private String url="jdbc:oracle:thin:@localhost:1521:XE";
    private String usuario="salinas";
    private String clave="hola";

    private Connection con=null;
    private PreparedStatement pr=null;
    private ResultSet rs=null;
    
    
    
      public Vector<view_C> getVentaCliente(String ID_USUARIO, String ID_CLIENTE)
    {
        Vector<view_C> vecPro=new Vector<view_C>();
        String sql="SELECT * FROM VENTAS_CLIENTE order by ID_VENTA";
        try{
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next()){
                if(ID_USUARIO.equals(rs.getString("ID_USUARIO")) && ID_CLIENTE.equals(rs.getString("NOMBRE")))
                {    
                view_C vc = new view_C();
                vc.setId_venta(rs.getInt("ID_VENTA"));
                vc.setId_cliente(rs.getString("ID_CLIENTE"));
                vc.setId_usuario(rs.getString("ID_USUARIO"));
                vc.setCantidad(rs.getInt("CANTIDAD"));
                vc.setNombre(rs.getString("NOMBRE"));
                vc.setProducto(rs.getString("PRODUCTO"));
                vecPro.add(vc);
                }
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
    }//mostrarVentas
    
    
     
    
}
