<%@page import="modelo.producto"%>
<%@ page language="java" contentType="text/html charset=UTF-8" %> 
<html>
	<head>
		<link href="../../Resources/css/listaproductos.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div id="content">
                    <form with =" 10%" class="tabla1" border="1">
                        <p class="dos">Buscar</p>
                        <br>
                        <input style ="width:125px; margin-top:0px; margin-bottom:10px" type="text" class = "buscar" name="buscar" placeholder="Buscar Producto">
                        </br>
                        <a href ="#" class ="tres">Editar Productos</a>
                        </br>
                        <a href ="Views/wellcome.jsp" sytle type ="text/css" class ="cuatro">Volver</a>//arreglar esto
                    </form>
                    <table width="90%" class="tabla2" border="1"> 
                            <tr>
                                
                                <td style="width:250px; text-align:top;"><p class ="t1">Codigo</p></td> 
                                <td style="width:250px; text-align:top;" ><p class ="t1">Nombre</p></td> 
                                <td style="width:250px; text-align:top;"><p class ="t1">Cantidad</p></td>
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