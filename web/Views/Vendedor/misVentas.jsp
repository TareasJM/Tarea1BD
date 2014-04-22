<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html charset=UTF-8" %>
<%  
           if(session.getAttribute("userType")==null)
    {
         JOptionPane.showMessageDialog(null,"Se necesita iniciar sesion");
          response.sendRedirect("../Session/login.jsp");
    }
 %>
<html>
	mis ventas
</html>