
<%@page import="modelo.usuario"%>
<%@ page language="java" contentType="text/html charset=UTF-8" %> 
<html>
	<head>
		<link href="../../Resources/css/vendedor.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div id="content">
			<form action="../../ingresarv" method="post">
				Rut: <input type="text" class = "rut" name="rut" placeholder="Rut">
				<br />
				Password: <input type="password" class = "pass" name="pass" placeholder="Password" />
				<br />
				Repetir Pass: <input type="password" class = "rpass" name="rpass" placeholder="Repetir Contraseña">
				<br />
				Nombre: <input type="text" class = "nombre" name ="nombre" placeholder="Nombre" />
				<input type="submit" class = "submits" value="Finalizar" />
			</form>
                    
		</div>
	</body>
</html>