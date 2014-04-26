<%@page import="javax.swing.JOptionPane"%>
<%@page import="modelo.producto"%>
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
                 <div style="color:white" id="toolbarUser">Usuario: <%=session.getAttribute("userName")%></div>
                 <div style="color:white" id="toolbarType">Cargo: <%=session.getAttribute("userType")%></div>
                 <div id="toolbarLogout"><a style="color:white; text-decoration: none" href="Session/login.jsp">Cerrar sesión</a> </div>
             </div>
		<div id="content">
                    <form action ="editarProducto.jsp" with =" 10%" class="tabla1" border="1">
                        <p class="dos">Buscar</p>
                        <br>
                        <input href ="editarProducto.jsp" style ="width:125px; margin-top:0px; margin-bottom:10px" type="text" class = "buscar" name="buscar" placeholder="Buscar Producto">
                        </br>
                        <a href ="listEditProd.jsp" class ="tres">Editar Productos</a>
                        </br>
                        <a href ="agregarProductos.jsp" class ="cinco">Agregar Productos</a>
                        </br>
                        <a href ="../../deleteAllProductos" class ="seis">Delete Productos</a>
                        </br>
                        <a href ="../index.jsp" sytle type ="text/css" class ="cuatro">Volver</a>
                    </form>
                    <table width="89%" class="tabla2" border="1"> 
                            <tr>
                                
                                <td style="width:250px; text-align:top;"><h2 class ="t1">Código</h2></td> 
                                <td style="width:250px; text-align:top;" ><h2 class ="t1">Producto</h2></td> 
                                <td style="width:250px; text-align:top;"><h2 class ="t1">Cantidad</h2></td>
                            </tr>
                                <%
                                    producto prod =new producto();
                                    for(producto temp: prod.showProducto()){
                                %>
                            <tr>
                                <td ><p class="uno"><%= temp.getId_producto()%></p></td> 
                                <td ><p class="uno"><%= temp.getNombre()%></p></td> 
                                <td ><p class="uno"><%= temp.getStock()%></p></td>
                            </tr>    
                                
                               <%}%>
                   </table>
                   
                   
		</div>
	</body>
</html>