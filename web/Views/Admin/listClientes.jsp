<%@page import="javax.swing.JOptionPane"%>
<%@page import="modelo.usuario"%>
<%@page import="modelo.cliente"%>
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
		<link href="../../Resources/css/listaproductos.css" rel="stylesheet" type="text/css">
	</head>
	<body>
            <div id ="toolbar" style="position: fixed">
                 <div style="color:white; font-size: 13px;" id="toolbarUser">Usuario: <%=session.getAttribute("userName")%></div>
         <div style="color:white; font-size: 13px;" id="toolbarType">Cargo: <%=session.getAttribute("userType")%></div>
         <div id="toolbarLogout"><a style="color:white; font-size: 13px; text-decoration: none" href="Session/login.jsp">Cerrar sesión</a> </div>
             </div>
		<div id="content">
                    <form action ="editarProducto.jsp" with =" 10%" class="tabla1" border="1">
                        <p class="dos">Buscar</p>
                        <br>
                        <input href ="editarProducto.jsp" style ="width:125px; margin-top:0px; margin-bottom:10px" type="text" class = "buscar" name="buscar" placeholder="Buscar Producto">
                        </br>
                        <a href ="agregarProductos.jsp" class ="cinco">Agregar Productos</a>
                        </br>
                        <a href ="../index.jsp" sytle type ="text/css" class ="cuatro">Volver</a>
                    </form>
                    <form action="ventasCliente.jsp">
                    <table width="50%" class="tabla3" border="1"> 
                            <tr>
                                <td style="width:250px; text-align:top-center;" ><h2 class ="t1">Nombre</h2></td> 
                            </tr>
                                <%
                                    cliente clien = new cliente();
                                    for(cliente temp: clien.showCliente()){
                                %>
                            <tr>
                                <td ><p text-align="center" class ="uno"><input name ="buscar" type="submit" class="list" value="<%= temp.getNombre()%>"></p></td> 
                            </tr>    
                                
                               <%}%>
                   </table>
                    </form>
                   
		</div>
	</body>
</html>