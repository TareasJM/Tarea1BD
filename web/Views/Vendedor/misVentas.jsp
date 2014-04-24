<%@page import="modelo.view_V"%>
<%@page import="modelo.view_C"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="modelo.producto"%>
<%@ page language="java" contentType="text/html charset=UTF-8" %> 
<%
         if(session.getAttribute("userType")==null)
    {
         JOptionPane.showMessageDialog(null,"Se necesita iniciar sesion");
          response.sendRedirect("../Session/login.jsp");
    }
    String userID = (String)session.getAttribute("userID");
 %>
<html>
	<head>
		<link href="../../Resources/css/ventasClientes.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div id="content">
                    <form  with =" 10%" class="tabla1" border="1">
                        <a href ="../index.jsp" sytle type ="text/css" class ="cuatro">Volver</a>
                    </form>
                    <form >
                    <table width="80%" class="tabla3" border="1"> 
                            <tr>
                                <td style="width:250px; text-align:top;"><h2 class ="t1">Venta</h2></td>
                                <td style="width:250px; text-align:top;"><h2 class ="t1">Detalle</h2></td>
                                <td style="width:250px; text-align:top;" ><h2 class ="t1">Producto</h2></td> 
                                <td style="width:250px; text-align:top;"><h2 class ="t1">Usuario</h2></td>
                                <td style="width:250px; text-align:top;"><h2 class ="t1">Cantidad</h2></td>
                            </tr>
                                <%
                                    view_V vc =new view_V();
                                    for(view_V temp: vc.getMisVentas(userID)){
                                %>
                            <tr>                               
                                <td ><p class="uno"><%= temp.getId_venta()%></p></td> 
                                <td ><p class="uno"><%= temp.getId_detalle()%></p></td> 
                                <td ><p class="uno"><%= temp.getProducto()%></p></td> 
                                <td ><p class="uno"><%= temp.getUser()%></p></td> 
                                <td ><p class="uno"><%= temp.getRut()%></p></td>
                            </tr>       
                                
                               <%}%>
                   </table>
                   </form>
                   
		</div>
	</body>
</html>