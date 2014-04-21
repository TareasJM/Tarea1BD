<%@ page language="java" contentType="text/html charset=UTF-8" %> 
<html>
	<head>
		<link href="../../Resources/css/vendedor.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div id="content">
			<form style ="text-align:center;"action="../../Controllers/Admin/ingresarVendedor.jsp" method="POST">
				Rut: <input type="text" class = "rut" name="rut" placeholder="Rut">
				<br />
				Nombre: <input type="text" class = "nombre" placeholder="Nombre" />
				<input type="submit" class = "submits" value="Finalizar" />
			</form>
		</div>
	</body>
</html>