<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="modelo.producto"%>
<%@page import="modelo.cliente"%>
<%@page import="modelo.usuario"%>
<%@page import="modelo.venta"%>
<%@ page language="java" contentType="text/html charset=UTF-8" %>
<%  
          if(session.getAttribute("userType")==null)
    {
         JOptionPane.showMessageDialog(null,"Se necesita iniciar sesion");
          response.sendRedirect("../Session/login.jsp");
    }
    cliente user = new cliente();
    producto prod = new producto();
    String htmlClientes = "";
    for(cliente temp: user.showCliente())
    {
        htmlClientes+= "<option class = \"cliente\" value=\"" + temp.getRut() + "\">"+ temp.getNombre() +"</option>\n";
    }
    String htmlProductos = "";
    for(producto temp: prod.showProducto())
    {
        htmlProductos+="<option  value= \""+temp.getNombre()+"\">"+temp.getNombre()+"</option>\n";
    }
    
%>
<html>
	<head>
		<link href="../../Resources/css/venta.css" rel="stylesheet" type="text/css">
                <script type=""  src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
                <SCRIPT type="text/javascript"  language="javascript">
                    var i=2;
                    function add() {
                        $('#form').append("Producto "+i+":");
                        $('#form').append($("#producto1").clone().attr("name","producto"+i));
                        $('#form').append('<br />');
                        $('#form').append('Cantidad: <input type="text" class = "cantidad" name="cantidad'+i+'" id="cantidad"/>');
                        $('#form').append('<br />');
                        $('#form').append($('.submits'));
                        $('#np').attr("value", i);
                        
                        i++;
                    }
                </SCRIPT>
	</head>
	<body>
		<div id="content">
			<form style="text-align:center;" action="../../prueba" method="POST" id="form">
				Cliente: <select  class="cliente" name="cliente">
                                            <%=htmlClientes%>
                                         </select> 
				<br />
                                
				Producto: <select  class = "producto" name ="producto1" id="producto1">
                                            <%=htmlProductos%>
                                          </select>
				<br />
				Cantidad: <input type="text" class = "cantidad" name="cantidad1" id="cantidad1"/>
                                <br/>
                                <input type="hidden" name ="vendedor" value="<%=session.getAttribute("userID")%>"/>
                                <input type="hidden" name ="np" value="1" id="np"/>
                                <input type="submit" class = "submits" value="Finalizar" />
			</form>
                        <button class="boton" onclick="add()">+Productos</button>
                    
		</div>
	</body>
</html>