<%@page import="modelo.producto"%>
<%@page import="modelo.cliente"%>
<%@page import="modelo.usuario"%>
<%@page import="modelo.venta"%>
<%@ page language="java" contentType="text/html charset=UTF-8" %> 
<html>
	<head>
		<link href="../../Resources/css/venta.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div id="content">
			<form style="text-align:center;"action="../../ingresarVenta" method="post">
				Cliente: <select  >
                                        <% cliente user = new cliente();
                                           for(cliente temp: user.showCliente())
                                              {
                                               %>
                                               <option class = "cliente" value="<%=temp.getNombre()%>"><%=temp.getNombre()%></option>
                                                       <%} %>       
                                         </select> 
				<br />
				Producto: <select  class = "producto">
                                           <% producto prod = new producto();
                                           for(producto temp: prod.showProducto())
                                              {
                                               %>
                                               <option  value="<%=temp.getNombre()%>"><%=temp.getNombre()%></option>
                                                       <%} %>       
                                         </select> 
				<br />
				Cantidad: <input type="text" class = "cantidad" name="cantidad" placeholder="cantidad"/>				
				<input type="submit" class = "submits" value="Finalizar" />
			</form>
                    
		</div>
	</body>
</html>