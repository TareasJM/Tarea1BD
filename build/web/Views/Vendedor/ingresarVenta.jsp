<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
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
                                               <option class = "producto" value="<%=temp.getNombre()%>"><%=temp.getNombre()%></option>
                                                       <%} %>       
                                         </select> 
				<br />
				Producto: <input type="text" class = "cantidad" name="producto" placeholder="Producto" />
				<br />
				Cantidad: <input type="text" class = "precio" name="cantidad" placeholder="cantidad"/>				
                                
				<input type="submit" class = "submits" value="Finalizar" />
			</form>
                    
		</div>
	</body>
</html>