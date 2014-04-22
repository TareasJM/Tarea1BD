/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
public class prueba extends HttpServlet {

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
            
            Enumeration<String> parameterNames = request.getParameterNames();

 

        while (parameterNames.hasMoreElements()) {

            String paramName = parameterNames.nextElement();
            JOptionPane.showMessageDialog(null,paramName);


            String[] paramValues = request.getParameterValues(paramName);

            for (int i = 0; i < paramValues.length; i++) {
                String paramValue = paramValues[i];

                JOptionPane.showMessageDialog(null, paramValue);

            }
        
            JOptionPane.showMessageDialog(null,"Datos Ingresados Con Éxito");
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
            producto pro = new producto();
            int np = Integer.parseInt(request.getParameter("np"));
            String cliente = request.getParameter("cliente").toUpperCase();
            String vendedor = request.getParameter("vendedor").toUpperCase();
            for (int i=1;i<=np;i++){
                JOptionPane.showMessageDialog(null,request.getParameter("producto"+i)+"->"+request.getParameter("cantidad"+i));
            }
            //String producto = request.getParameter("producto").toUpperCase();
            //String cantidad = request.getParameter("cantidad").toUpperCase();   
            //pro = pro.getProducto(producto);
            
            //int monto_total = pro.getPrecio()*Integer.parseInt(cantidad);
            //ventas.addVenta(cliente, vendedor, monto_total,dma,hms);
            response.sendRedirect("Views/index.jsp");
            //JOptionPane.showMessageDialog(null,"Datos Ingresados Con Éxito");
 

        }

           
            
            
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