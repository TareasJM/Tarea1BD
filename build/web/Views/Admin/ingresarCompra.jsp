<%@page import="modelo.producto"%>
<%@page import="modelo.cliente"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="modelo.compra"%>
<%@ page language="java" contentType="text/html charset=UTF-8" %> 
<%
          if(session.getAttribute("userType")==null)
    {
         JOptionPane.showMessageDialog(null,"Se necesita iniciar sesion");
          response.sendRedirect("../Session/login.jsp");
    }
         
    producto prod = new producto();
    String htmlProductos = "";
    int np = 0;
    for(producto temp: prod.showProducto())
    {
        np++;
        htmlProductos+="<option value= \""+temp.getId_producto()+"\">"+temp.getNombre()+"</option>\n";
    }
    if (htmlProductos.equals("")){
        JOptionPane.showMessageDialog(null,"No existen Productos");
        response.sendRedirect("agregarProductos.jsp");
    }
 %>
<html>
	<head>
		<link href="../../Resources/css/compra.css" rel="stylesheet" type="text/css">
                  <script type=""  src="http://code.jquery.com/jquery-latest.js"></script>
                <SCRIPT type="text/javascript"  language="javascript">
                    var i=2;
                    
                    $(document).ready(function(){
                        if (<%=np%> == 1 ){
                            $( "#botonAdd" ).hide();
                        }
                    });
                    
                    $(document).delegate(".producto", "change", function(){
                        var selected = new Array();
                        $(".producto").each(function(){
                            selected.push($(this).find(':selected').val());
                            $(this).find('option').show();
                        });
                        $(".producto").each(function(){
                            var option = $(this);
                            selected.forEach(function(select)
                            {
                                option.find('option[value=' + select +']').hide();
                            });
                        });

                    });

                    function add() {
                        $('#form').append("Producto "+i+":");
                        $('#form').append($("#producto1").clone().attr("name","producto"+i).attr("id","producto"+i));
                        $('#form').append('<br />');
                        $('#form').append('Cantidad: <input type="text" class = "cantidad" name="cantidad'+i+'" id="cantidad"/>');
                        $('#form').append('<br />');
                        $('#form').append('Precio: <input type="text" class = "precio" name="precio'+i+'" placeholder="Precio"/>');
                        $('#form').append('<br />');
                        $('#form').append($('.submits'));
                        $('#np').attr("value", i);
                        
                        i++;
                        if (i > <%=np%> ){
                            $( "#botonAdd" ).hide();
                        }
                    };
                </SCRIPT>
	</head>
	<body>
		<div id="content">
			<form style="text-align:center;" id="form" action="../../ingresarCompra" method="post">
                               
				Producto: <select  class = "producto" name ="producto1" id="producto1">
                                            <option selected></option>
                                            <%=htmlProductos%>
                                          </select>
				<br />
				Cantidad: <input type="text" class = "cantidad" name="cantidad1" placeholder="Cantidad" />
				<br />
				Precio: <input type="text" class = "precio" name="precio1" placeholder="Precio"/>				
                                <br />
                                <input type="hidden" name ="np" value="1" id="np"/>
				<input type="submit" class = "submits" value="Finalizar" />
			</form>
                        <button id="botonAdd"class="boton" onclick="add()">+Productos</button>
                    
		</div>
	</body>
</html>