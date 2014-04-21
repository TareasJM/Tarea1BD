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
public class cliente
{
    private String nombre;
    private int rut;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }
    
    private String classfor="oracle.jdbc.driver.OracleDriver";
    private String url="jdbc:oracle:thin:@localhost:1521:XE";
    private String usuario="salinas";
    private String clave="hola";

    private Connection con=null;
    private PreparedStatement pr=null;
    private ResultSet rs=null;
    
    
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
    
}
