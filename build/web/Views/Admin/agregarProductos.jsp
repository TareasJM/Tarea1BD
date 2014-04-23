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
	<head>
		<link href="../../Resources/css/producto.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div id="content">
                        
			<form style ="text-align:center;"action="../../addProducto" method="POST">
				
				Nombre: <input type="text" class = "nombre" name = "nombre" placeholder="Nombre" />
				<br />
				Descripción: <input type="text" class = "descripcion" name="descripcion" placeholder="Descripcion">
				<br />
				Categoría: <input type="text" class = "categoria" name = "categoria" placeholder="Categoria" />
				<br />
				Cantidad: <input type="text" class = "cantidad" name="cantidad" placeholder="Cantidad">
				<br />
				Precio: <input type="text" class = "precio" name = "precio" placeholder="Precio" />
				<input type="submit" class = "submits" value="Finalizar" />
			</form>
		</div>
	</body>
</html>