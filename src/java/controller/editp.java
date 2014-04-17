/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.ServiciosBD;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import modelo.producto;

public class editp 
{
  public static void modProducto(producto prod) 
    {
        String sql="Update productos SET stock ='" + prod.getStock() + "'," 
               + " descripcion ='" + prod.getDescripcion() + "' , "+ "precio ='" +
               prod.getPrecio()+ "' , " + "categoria ='" + prod.getCategoria()+"' ,"
               + "nombre = '"+ prod.getNombre() +"',"+"where id ='"+ prod.getId_producto() +"'";
        ServiciosBD.ejecutarUpdate(sql);
        JOptionPane.showMessageDialog(null, "Departamento Actualizado");

    }   
}
