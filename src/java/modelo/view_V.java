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
public class view_V {
    
    public int id_venta;
    public int id_detalle;
    public int cantidad;
    public String producto;
    public String user;
    public String rut;

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getUser() {
        return usuario;
    }

    public void setUser(String usuario) {
        this.usuario = usuario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
     
    private String classfor="oracle.jdbc.driver.OracleDriver";
    private String url="jdbc:oracle:thin:@localhost:1521:XE";
    private String usuario="salinas";
    private String clave="hola";

    private Connection con=null;
    private PreparedStatement pr=null;
    private ResultSet rs=null;
    
    
    
     public Vector<view_V> getMisVentas(String ID_USUARIO)
    {
        Vector<view_V> vecPro=new Vector<view_V>();
        String sql="SELECT * FROM VENTAS_VENDEDOR order by ID_VENTA";
        try{
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next()){
                if(ID_USUARIO.equals(rs.getString("RUT")))
                {    
                view_V vc = new view_V();
                vc.setId_venta(rs.getInt("ID_VENTA"));
                vc.setId_detalle(rs.getInt("ID_DETALLE"));
                vc.setProducto(rs.getString("PRODUCTO"));
                vc.setCantidad(rs.getInt("CANTIDAD"));
                vc.setUser(rs.getString("NOMBRE"));
                vc.setRut(rs.getString("RUT"));
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
    }//mostrarMisVentas
    
}
