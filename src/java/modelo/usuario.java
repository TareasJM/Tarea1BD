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
import javax.swing.JOptionPane;

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

    public String getClassfor() {
        return classfor;
    }

    public void setClassfor(String classfor) {
        this.classfor = classfor;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public PreparedStatement getPr() {
        return pr;
    }

    public void setPr(PreparedStatement pr) {
        this.pr = pr;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

       
    private String classfor="oracle.jdbc.driver.OracleDriver";
    private String url="jdbc:oracle:thin:@localhost:1521:XE";
    private String usuario="salinas";
    private String clave="hola";

    private Connection con=null;
    private PreparedStatement pr=null;
    private ResultSet rs=null;
        
    public Vector<usuario> mostrarVendedores()
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
    
    public Vector<usuario> showUsers()
    {
        Vector<usuario> vecPro=new Vector<usuario>();
        String sql="SELECT * FROM usuarios";
        try{
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next()){
                usuario pro = new usuario();
                pro.setRut(rs.getString("rut"));
                pro.setPass(rs.getString("contraseña"));
                pro.setNombre(rs.getString("nombre"));
                pro.setTipo(rs.getString("tipo"));
                pro.setComision(rs.getInt("comision"));
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
    }//mostrar usuarios
    
     public usuario getUser(String nombre)
    {
        usuario user = new usuario();
        String sql="SELECT * FROM usuarios where nombre = '"+nombre+"'";
        try{
            Class.forName(classfor);
            con=DriverManager.getConnection(url, usuario,clave);
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next())
            {
                user.setRut(rs.getString("rut"));
                user.setPass(rs.getString("contraseña"));
                user.setNombre(rs.getString("nombre"));
                user.setTipo(rs.getString("tipo"));
                user.setComision(rs.getInt("comision"));
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
        return user;
    }//getUser
        

     
        
}
