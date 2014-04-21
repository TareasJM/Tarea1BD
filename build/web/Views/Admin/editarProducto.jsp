<%@page import="modelo.producto"%>
<%
String name = request.getParameter( "buscar" ).toUpperCase();
%>
<%@ page language="java" contentType="text/html charset=UTF-8" %> 
<html>
	<head>
		<link href="../../Resources/css/editar.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div id="content">
                    <form with =" 10%" class="tabla1" border="1">
                        <p class="dos">Buscar</p>
                        <br>
                        <input action ="editarProducto.jsp" style ="width:125px; margin-top:0px; margin-bottom:10px" type="text" class = "buscar" name="buscar" placeholder="Buscar Producto">
                        </br>
                        <a href ="administrarProductos.jsp" sytle type ="text/css" class ="cuatro">Volver</a>
                    </form> 
                    <form  action="../../editProducto" method="POST">
                            <%
                                    producto prod =new producto();
                                    for(producto temp: prod.editProducto())
                            {
                            
                             if(name.equals(temp.getNombre()))
                             {
                                name = "";
                                %>
                            Código: <input type="text" class = "codigo" name="id" value ="<%=temp.getId_producto()%>"disabled>
                            <br />
                            Nombre: <input type="text" class = "nombre" name = "nombre" value ="<%=temp.getNombre()%>" disabled/>
                            <br />
                            Descripcion: <input type="text" class = "descripcion" name="descripcion"  value="<%=temp.getDescripcion()%>"/>
                            <br />
                            Categoría: <input type="text" class = "categoria" name = "categoria" value ="<%=temp.getCategoria()%>" />
                            <br />
                            Cantidad: <input type="text" class = "cantidad" name="cantidad" value ="<%=temp.getStock()%>"disabled/>
                            <br />
                            Precio: <input type="text" class = "precio" name = "precio" value ="<%=temp.getPrecio()%>" />
                            

                          <%}
                      
                          
                            }%>
                            <input  type="submit" class = "submits" value="Guardar Cambios" />    
                   
                    </form>
		</div>
	</body>
</html>