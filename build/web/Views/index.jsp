
<%@page import="modelo.usuario"%>
<%@ page language="java" contentType="text/html charset=UTF-8" %> 
<html> 
 <head> 
	 <title>Pagina Inicio Pepe's</title> 
	 <link href="../Resources/css/master.css" rel="stylesheet" type="text/css">
	 <link href="../Resources/css/index.css" rel="stylesheet" type="text/css">

 </head> 
 <body > 
     <div id ="toolbar" style="position: fixed">
         <div style="color:white" id="toolbarUser">Usuario: <%=session.getAttribute("userName")%></div>
         <div style="color:white" id="toolbarType">Cargo: <%=session.getAttribute("userType")%></div>
         <div id="toolbarLogout"><a style="color:white; text-decoration: none" href="Session/login.jsp">Cerrar sesión</a> </div>
     </div>
 	<div id="content">
 		<div id="optionsMenu" style="height: 40%;">
			<% 
                            
				if (session.getAttribute("userType") == null || session.getAttribute("userType").equals("none") || session.getAttribute("userType").equals(""))
			 	{
                                        session.removeAttribute("Error");
			 		%>

				 		<h1 style="text-align:center; ">Bienvenido a Pepe's Works</h1>
			 			<a  href="Session/login.jsp"><p style="text-align:center;">Iniciar Sesión </p></a><br>
                                                
			 		<%
				} 
                                                          
                                else if ( session.getAttribute("userType").equals("ADMINISTRADOR"))
                                {       

                                            %>
                                                    <h2 style="text-align:center;">Bienvenido <%=session.getAttribute("userName")%></h2>
                                                    <h3 style="text-align:center;">Controles Administrador</h3>
                                                    <ul>    

                                                            <li> <a href="Admin/ingresarVendedor.jsp"> Ingresar Vendedor </a> </li>
                                                            <li> <a href="Admin/ingresarCliente.jsp"> Ingresar Cliente </a> </li>
                                                            <li> <a href="Admin/agregarProductos.jsp"> Agregar Productos </a> </li>
                                                            <li> <a href="Admin/administrarProductos.jsp"> Administrar Productos </a> </li>
                                                            <li> <a href="Admin/ingresarCompra.jsp"> Ingresar Compra </a> </li>
                                                            <li> <a href="Admin/ingresarVenta.jsp"> Ingresar Venta </a> </li>
                                                            <li> <a href="Vendedor/misVentas.jsp"> Mis Ventas</a> </li>
                                                            <li> <a href="Admin/listClientes.jsp"> Ver Ventas a Cliente </a> </li>
                                                            <li> <a href="../Freezer"> Freezer </a> </li>
                                                            <li> <a href="../Controllers/Session/logout.jsp">Cerrar Sesión </a> </li>
                                                            
                                                            
                                                    </ul>

                                            <%
                                    }
                                
                                    else if ( session.getAttribute("userType").equals("VENDEDOR"))
                                    
                                    {       

                                            %>
                                            <h2 style="text-align:center;">Bienvenido <%=session.getAttribute("userName")%> </h2>
                                                    <h3 style="text-align:center;">Controles Vendedor</h3>
                                                    <ul>
                                                            <li> <a href="Admin/ingresarCliente.jsp"> Ingresar Cliente </a> </li>
                                                            <li> <a href="Admin/ingresarVenta.jsp"> Ingresar Venta </a> </li>
                                                            <li> <a href="Admin/ventasCliente.jsp"> Ver Ventas a Cliente </a> </li>
                                                            <li> <a href="Vendedor/misVentas.jsp"> Mis Ventas</a> </li>
                                                            <li> <a href="../Controllers/Session/logout.jsp">Cerrar Sesión </a> </li>
                                                    </ul>
                                            <%
                                    }
            
                                    else
                                    {
                                        session.getAttribute("userType");
                                    }
                             
			%>
                      
 	</div>
 </body> 
</html> 
