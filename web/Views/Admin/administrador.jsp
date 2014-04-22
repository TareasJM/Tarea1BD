<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html" %> 
 <%       if(session.getAttribute("userType")==null)
    {
         JOptionPane.showMessageDialog(null,"Se necesita iniciar sesion");
          response.sendRedirect("../Session/login.jsp");
    }
 %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta charset="UTF-8">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	</head>
	<body>
		<form action="../Controllers/loginform.jsp"  method="POST">
			Vendedor:  <input type="text" name="vendedor" placeholder="Vendedor">
			<br />
			Cliente: <input type="text" name="cliente" placeholder="Cliente" />
			<br />
			<a href="Hola">Administrar Producots</a>
			<br />
			Compra: <input type="text" name="compra" placeholder="Compra" />
			<br />
			Venta: <input type="text" name="venta" placeholder="Venta" />
			<a href="Hola2">Ventas a Clientes</a>
		</form>
	</body>
</html>