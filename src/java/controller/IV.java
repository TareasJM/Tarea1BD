/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.basedatos;
import modelo.producto;

/**
 *
 * @author salinas
 */
public class IV extends HttpServlet {

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
        String resumenVenta = "Venta realizada con exito.\n\n";
       
        try
        {
            basedatos pro = new basedatos();
       
            Map dicStock = pro.getStocks();
       
            Map <String, Integer>dicCantidad = new HashMap<String, Integer>();
       
            int montoTotal = 0;

            Calendar fecha = new GregorianCalendar();
       
            int año = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH)+1;
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            int hora = fecha.get(Calendar.HOUR_OF_DAY);
            int minuto = fecha.get(Calendar.MINUTE);
            int segundo = fecha.get(Calendar.SECOND);
            String dma = dia+"/"+mes+"/"+año;
            String hms = hora+":"+(minuto < 10 ? "0"+minuto : minuto)+":"+(segundo < 10 ? "0"+segundo : segundo);
            
            basedatos ventas = new basedatos();
            int np = Integer.parseInt(request.getParameter("np"));
            String[] cliente = request.getParameter("cliente").toUpperCase().split("!");
            String[] vendedor = request.getParameter("vendedor").toUpperCase().split("!");
            producto producto = new producto();
            String pasanStock = "";
            resumenVenta+= "Cliente:\n\t"+cliente[0]+" "+cliente[1]+"\n\n";
            resumenVenta+= "Vendedor:\n\t "+vendedor[0]+" "+vendedor[1]+"\n\n\n";

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
                    pasanStock+=i+"-";
                }

                dicStock.remove(nombre);
                dicStock.put(nombre, n);

                resumenVenta+=nombre+":\t\t\t\t"+cantidad+"x$"+producto.getPrecio()+"\n";
                
            }

            if (!pasanStock.equals("")){
                out.println(pasanStock);
                return;
            }

            int id_venta = ventas.addVenta(cliente[1], vendedor[1], montoTotal,dma,hms);

            for ( String key : dicCantidad.keySet() ) {
                producto = producto.getProducto(key);
                ventas.addDVenta(id_venta, producto.getId_producto(), dicCantidad.get(key));
            }

            resumenVenta+="TOTAL:\t\t\t  $"+montoTotal+"\n\n";
            resumenVenta+="Fecha: "+dma+" Hora: "+hms;
            
            //int monto_total = pro.getPrecio()*Integer.parseInt(cantidad);
            //response.sendRedirect("Views/index.jsp");
            out.println(resumenVenta);
            out.close();
            return;
            
        } finally{            
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
