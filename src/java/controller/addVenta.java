/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.basedatos;
import modelo.producto;

/**
 *
 * @author salinas
 */
public class addVenta extends HttpServlet {
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        try {
            
            basedatos pro = new basedatos();
            Map dicStock = pro.getStocks();
            Map <String, Integer>dicCantidad = new HashMap<String, Integer>();
            int montoTotal = 0;

            Calendar fecha = new GregorianCalendar();
             
            int año = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH);
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            int hora = fecha.get(Calendar.HOUR_OF_DAY);
            int minuto = fecha.get(Calendar.MINUTE);
            int segundo = fecha.get(Calendar.SECOND);
            String dma = Integer.toString(dia)+"/"+Integer.toString(mes)+"/"+Integer.toString(año);
            String hms = Integer.toString(hora)+":"+Integer.toString(minuto)+":"+Integer.toString(segundo);
            
            basedatos ventas = new basedatos();
            int np = Integer.parseInt(request.getParameter("np"));
            String cliente = request.getParameter("cliente").toUpperCase();
            String vendedor = request.getParameter("vendedor").toUpperCase();
            producto producto = new producto();
            
            for (int i=1;i<=np;i++)
            {
                String nombre = request.getParameter("producto"+i);
                int cantidad = Integer.parseInt(request.getParameter("cantidad"+i));
                producto = producto.getProducto(nombre);
                int precio = cantidad*producto.getPrecio();
                montoTotal += precio;
                dicCantidad.put(nombre, cantidad);
                Integer n = (Integer)dicStock.get(nombre);

                n = n - (Integer)cantidad;

                if (n<0) {
                    JOptionPane.showMessageDialog(null,nombre + "no alcanza");
                    response.sendRedirect("Views/Admin/ingresarVenta.jsp");
                    return;
                }

                dicStock.remove(nombre);
                dicStock.put(nombre, n);

            }
            
                       
            //String producto = request.getParameter("producto").toUpperCase();
            //String cantidad = request.getParameter("cantidad").toUpperCase();   
            //pro = pro.getProducto(producto);
            int id_venta = ventas.addVenta(cliente, vendedor, montoTotal,dma,hms);
            
            for ( String key : dicCantidad.keySet() ) {
                producto = producto.getProducto(key);
                ventas.addDVenta(id_venta, producto.getId_producto(), dicCantidad.get(key));
            }

            JOptionPane.showMessageDialog(null,"Venta OK, monto total: "+montoTotal);
            
            //int monto_total = pro.getPrecio()*Integer.parseInt(cantidad);
            response.sendRedirect("Views/index.jsp");
            
        } finally 
        {            
            out.close();
        }
    

    } 
}
