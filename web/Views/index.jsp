<%@ page language="java" contentType="text/html charset=UTF-8" %> 
<html> 
 <head> 
	 <meta charset="UTF-8">
	 <title>Pagina Inicio Pepe's</title> 
	 <link href="../Resources/css/master.css" rel="stylesheet" type="text/css">
	 <link href="../Resources/css/index.css" rel="stylesheet" type="text/css">
 </head> 
 <body> 
 	<div id="content">
 		<div id="optionsMenu">
			<%
				if (session.getAttribute("userType") == null || session.getAttribute("userType").equals("none"))
			 	{
			 		%>
				 		<h1>Bienvenido a Pepe's Works</h1>
			 			<a href="Session/login.jsp">Iniciar Sesión </a><br>
			 		<%
				} 
			 	else if (session.getAttribute("userType").equals("administrador"))
				{
					%>
			 			<h2>Bienvenido Administrador</h2>
			 			<h3>Controles</h3>
			 			<ul>
			 				<li> <a href="Admin/ingresarVendedor.jsp"> Ingresar Vendedor </a> </li>
			 				<li> <a href="Admin/ingresarCliente.jsp"> Ingresar Cliente </a> </li>
			 				<li> <a href="Admin/administrarProductos.jsp"> Administrar Productos </a> </li>
			 				<li> <a href="Admin/ingresarCompra.jsp"> Ingresar Comprar </a> </li>
			 				<li> <a href="Admin/ingresarVenta.jsp"> Ingresar tador </a> </li>
			 				<li> <a href="Admin/ventasCliente.jsp"> Ver Ventas a Cliente </a> </li>
			 				<li> <a href="Admin/agregarProductos.jsp"> Agregar Productos </a> </li>
							<li> <a href="../Controllers/Session/logout.jsp">Cerrar Sesión </a> </li>

			 			</ul>
			 		<%
				}
				else if (session.getAttribute("userType").equals("vendedor"))
				{
					%>
			 			<h2>Bienvenido Vendedor</h2>
			 			<h3>Controles</h3>
			 			<ul>
			 				<li> <a href="Vendedor/ingresarCliente.jsp"> Ingresar Cliente </a> </li>
			 				<li> <a href="Vendedor/ingresarVenta.jsp"> Ingresar Venta </a> </li>
			 				<li> <a href="Vendedor/ventasCliente.jsp"> Ver Ventas a Cliente </a> </li>
			 				<li> <a href="Vendedor/misVentas.jsp"> Mis Ventas</a> </li>
							<li> <a href="../Controllers/Session/logout.jsp">Cerrar Sesión </a> </li>
			 			</ul>
			 		<%
				}
			%>
 		</div>
 	</div>
 </body> 
</html> 
