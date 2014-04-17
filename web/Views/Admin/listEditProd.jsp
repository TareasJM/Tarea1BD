<%@page import="modelo.producto"%>
<%@ page language="java" contentType="text/html charset=UTF-8" %> 
<html>
	<head>
		<link href="../../Resources/css/listaproductos.css" rel="stylesheet" type="text/css">
	</head>
	<body>
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
                    <table width="50%" class="tabla3" border="1"> 
                            <tr>
                                <td style="width:250px; text-align:top-center;" ><h2 class ="t1">Nombre</h2></td> 
                            </tr>
                                <%
                                    producto prod =new producto();
                                    for(producto temp: prod.showProducto()){
                                %>
                            <tr>
                                <td ><a href ="editarProducto.jsp"  class="list"><p text-align="center" class ="uno" name="nombre"><%= temp.getNombre()%></p></a></td> 
                            </tr>    
                                
                               <%}%>
                   </table>
                   
                   
		</div>
	</body>
</html>