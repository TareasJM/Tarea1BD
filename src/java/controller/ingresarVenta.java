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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.basedatos;

/**
 *
 * @author salinas
 */
public class ingresarVenta extends HttpServlet {
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            
            basedatos ventas = new basedatos();
            String cliente = request.getParameter("cliente").toUpperCase();
            String vendedor = request.getParameter("vendedor").toUpperCase();
            String producto = request.getParameter("producto").toUpperCase();
            String cantidad = request.getParameter("cantidad").toUpperCase();           
            ventas.addVenta(cliente, vendedor, producto,Integer.parseInt(cantidad));
            response.sendRedirect("Views/index.jsp");
            JOptionPane.showMessageDialog(null,"Datos Ingresados Con Éxito");
            
        } finally 
        {            
            out.close();
        }
    

    } 
}
