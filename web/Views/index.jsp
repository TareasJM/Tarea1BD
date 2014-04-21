
<%@page import="modelo.usuario"%>
<%@ page language="java" contentType="text/html charset=UTF-8" %> 
<html> 
 <head> 
	 <title>Pagina Inicio Pepe's</title> 
	 <link href="../Resources/css/master.css" rel="stylesheet" type="text/css">
	 <link href="../Resources/css/index.css" rel="stylesheet" type="text/css">
         <% String administrador = "administrador";
            String vendedor = "vendedor";
         %>
 </head> 
 <body > 
 	<div id="content">
 		<div id="optionsMenu" style="height: 40%;">
			<%
				if (session.getAttribute("userType") == null || session.getAttribute("userType").equals("none") || session.getAttribute("userType").equals(""))
			 	{
                                        session.removeAttribute("Error");
			 		%>

				 		<h1 style="text-align:center; ">Bienvenido a Pepe's Works</h1>
			 			<a  href="Session/login.jsp"><p style="text-align:center;">Iniciar Sesión </p></a><br>
                                                <a  href="Session/ingresarUsuario.jsp"><p style="text-align:center;">Ingresar Usuario</p></a><br>
			 		<%
				} 
                                
                                
                                    usuario user = new usuario();
                                    for(usuario temp: user.showUsers())
                                {
                                
                                  if (session.getAttribute("userType").equals("administrador") || administrador.equals(temp.getTipoFromUser(temp.getRut())))
                                    {       

                                            %>
                                                    <h2 style="text-align:center;">Bienvenido Administrador</h2>
                                                    <h3 style="text-align:center;">Controles</h3>
                                                    <ul>
                                                            <li> <a href="Admin/ingresarVendedor.jsp"> Ingresar Vendedor </a> </li>
                                                            <li> <a href="Admin/ingresarCliente.jsp"> Ingresar Cliente </a> </li>
                                                            <li> <a href="Admin/administrarProductos.jsp"> Administrar Productos </a> </li>
                                                            <li> <a href="Admin/ingresarCompra.jsp"> Ingresar Comprar </a> </li>
                                                            <li> <a href="Admin/ingresarVenta.jsp"> Ingresar Venta </a> </li>
                                                            <li> <a href="Admin/listClientes.jsp"> Ver Ventas a Cliente </a> </li>
                                                            <li> <a href="Admin/agregarProductos.jsp"> Agregar Productos </a> </li>
                                                            <li> <a href="../Controllers/Session/logout.jsp">Cerrar Sesión </a> </li>

                                                    </ul>

                                            <%
                                    }
                                    else if (session.getAttribute("userType").equals("administrador") || vendedor.equals(temp.getTipoFromUser(temp.getRut())))
                                    {       

                                            %>
                                                    <h2 style="text-align:center;">Bienvenido Vendedor</h2>
                                                    <h3 style="text-align:center;">Controles</h3>
                                                    <ul>
                                                            <li> <a href="Vendedor/ingresarCliente.jsp"> Ingresar Cliente </a> </li>
                                                            <li> <a href="Vendedor/ingresarVenta.jsp"> Ingresar Venta </a> </li>
                                                            <li> <a href="Vendedor/ventasCliente.jsp"> Ver Ventas a Cliente </a> </li>
                                                            <li> <a href="Vendedor/misVentas.jsp"> Mis Ventas</a> </li>
                                                            <li> <a href="../Controllers/Session/logout.jsp">Cerrar Sesión </a> </li>
                                                    </ul>
                                            <%
                                    }
                                    else
                                    {
                                        session.getAttribute("userType");
                                    }
                             }
			%>
                      
 	</div>
 </body> 
</html> 
