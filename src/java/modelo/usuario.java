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
 * @author jose
 */
public class usuario
{
    private String nombre;
    private String tipo;
    private String rut;
    private String pass;
    private int comision;

    

    public int getComision() {
        return comision;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPass() {
        return pass;
    }

    public String getRut() {
        return rut;
    }

    public String getTipo() {
        return tipo;
    }

    private String classfor="oracle.jdbc.driver.OracleDriver";
    private String url="jdbc:oracle:thin:@localhost:1521:XE";
    private String usuario="salinas";
    private String clave="hola";

    private Connection con=null;
    private PreparedStatement pr=null;
    private ResultSet rs=null;
        
    public Vector<usuario> mostrar()
    {
        Vector<usuario> vecPro=new Vector<usuario>();
        String sql="SELECT * FROM vendedores";
        try{
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next()){
                usuario pro=new usuario();
                pro.setRut(rs.getString("rut"));
                pro.setNombre(rs.getString("nombre"));
                pro.setPass(rs.getString("pass"));
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
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
