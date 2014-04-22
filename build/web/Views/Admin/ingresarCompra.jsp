<%@page import="javax.swing.JOptionPane"%>
<%@page import="modelo.compra"%>
<%@ page language="java" contentType="text/html charset=UTF-8" %> 
<%
          if(session.getAttribute("userType")==null)
    {
         JOptionPane.showMessageDialog(null,"Se necesita iniciar sesion");
          response.sendRedirect("../Session/login.jsp");
    }
 %>
<html>
	<head>
		<link href="../../Resources/css/compra.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div id="content">
			<form style="text-align:center;"action="../../ingresarCompra" method="post">
				Producto: <input type="text" class = "producto" name="producto" placeholder="Producto">
				<br />
				Cantidad: <input type="text" class = "cantidad" name="cantidad" placeholder="Cantidad" />
				<br />
				Precio: <input type="text" class = "precio" name="precio" placeholder="Precio"/>				
				<input type="submit" class = "submits" value="Finalizar" />
			</form>
                    
		</div>
	</body>
</html>