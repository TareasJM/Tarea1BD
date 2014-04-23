/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
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
public class ingresarCompra extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            Calendar fecha = new GregorianCalendar();

            int año = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH);
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            int hora = fecha.get(Calendar.HOUR_OF_DAY);
            int minuto = fecha.get(Calendar.MINUTE);
            int segundo = fecha.get(Calendar.SECOND);
            String dma = Integer.toString(dia)+"/"+Integer.toString(mes)+"/"+Integer.toString(año);
            String hms = Integer.toString(hora)+":"+Integer.toString(minuto)+":"+Integer.toString(segundo);
            
            basedatos producto = new basedatos();
            int np = Integer.parseInt(request.getParameter("np"));
            int monto = 0;
            for (int i=1;i<=np;i++)
            {
                int cantidad = Integer.parseInt(request.getParameter("cantidad"+i));
                int precio = Integer.parseInt(request.getParameter("precio"+i));
                monto += cantidad*precio;
            }
            int id_compra = producto.insertCompra(monto,dma,hms);

            for (int i=1;i<=np;i++)
            {
                int id_producto = Integer.parseInt(request.getParameter("producto"+i));
                int cantidad = Integer.parseInt(request.getParameter("cantidad"+i));
                int precio = Integer.parseInt(request.getParameter("precio"+i));
                producto.insertDCompra(id_compra, id_producto, cantidad, precio);
            }
            
            JOptionPane.showMessageDialog(null,"Datos Ingresados Con Éxito");
            response.sendRedirect("Views/index.jsp");
            
            
        } finally 
        {            
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
