/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import modelo.basedatos;
import modelo.producto;

/**
 *
 * @author salinas
 */
public class editProductos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try 
        {
            
          
            
           // basedatos pro=new basedatos();
            producto pro = new producto();
            String id = request.getParameter("id").toUpperCase();
            //pro.deleteProducto(Integer.parseInt(id));          
            String cantidad = request.getParameter("cantidad").toUpperCase();  
            String descripcion = request.getParameter("descripcion").toUpperCase();
            String categoria = request.getParameter("categoria").toUpperCase();
            String precio = request.getParameter("precio").toUpperCase();
            String nombre = request.getParameter("nombre").toUpperCase();        
            //pro.addProducto(Integer.parseInt(id), Integer.parseInt(cantidad),
            //descripcion, categoria, Integer.parseInt(precio),nombre);
            pro.editProducto(Integer.parseInt(id), Integer.parseInt(cantidad),
                    nombre, descripcion, categoria, Integer.parseInt(precio));
            JOptionPane.showMessageDialog(null,"Datos Cambiados Con Éxito");
            response.sendRedirect("Views/index.jsp");

            
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
