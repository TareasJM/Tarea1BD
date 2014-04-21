<%@page import="modelo.venta"%>
<%@ page language="java" contentType="text/html charset=UTF-8" %> 
<html>
	<head>
		<link href="../../Resources/css/venta.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div id="content">
			<form style="text-align:center;"action="../../ingresarVenta" method="POST">
				Cliente: <input type="text" class = "cliente" name="cliente" placeholder="Cliente">
				<br />
				Producto: <input type="text" class = "producto" name="producto" placeholder="Producto" />
				<br />
				Cantidad: <input type="text" class = "cantidad" name="cantidad" placeholder="cantidad"/>	
                                
                                <input type="hidden" class = "cantidad" name="vendedor" value=<%=session.getAttribute("user")%> />				
                                
				<input type="submit" class = "submits" value="Finalizar" />
			</form>
                    
		</div>
	</body>
</html>