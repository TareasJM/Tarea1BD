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
            
               Enumeration<String> parameterNames = request.getParameterNames();

 

        while (parameterNames.hasMoreElements()) {

            String paramName = parameterNames.nextElement();
            JOptionPane.showMessageDialog(null,paramName);


            String[] paramValues = request.getParameterValues(paramName);

            for (int i = 0; i < paramValues.length; i++) {
                String paramValue = paramValues[i];

                JOptionPane.showMessageDialog(null, paramValue);

            }
        }
            //Calendar fecha = new GregorianCalendar();
            //int año = fecha.get(Calendar.YEAR);
            //int mes = fecha.get(Calendar.MONTH);
            //int dia = fecha.get(Calendar.DAY_OF_MONTH);
           // int hora = fecha.get(Calendar.HOUR_OF_DAY);
            //int minuto = fecha.get(Calendar.MINUTE);
           // int segundo = fecha.get(Calendar.SECOND);
            //String dma = Integer.toString(dia)+"/"+Integer.toString(mes)+"/"+Integer.toString(año);
           // String hms = Integer.toString(hora)+":"+Integer.toString(minuto)+":"+Integer.toString(segundo);
            
           // basedatos ventas = new basedatos();
          //  producto pro = new producto();
            //String cliente = request.getParameter("cliente").toUpperCase();
            //String vendedor = request.getParameter("vendedor").toUpperCase();
            //String producto = request.getParameter("producto").toUpperCase();
            //String cantidad = request.getParameter("cantidad").toUpperCase();   
            //pro = pro.getProducto(producto);
            //int monto_total = pro.getPrecio()*Integer.parseInt(cantidad);
            //ventas.addVenta(cliente, vendedor, monto_total,dma,hms);
            //response.sendRedirect("Views/index.jsp");
            //JOptionPane.showMessageDialog(null,"Datos Ingresados Con Éxito");
            
        } finally 
        {            
            out.close();
        }
    

    } 
}
