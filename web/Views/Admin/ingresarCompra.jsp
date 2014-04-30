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
                  <script type=""  src="../../Resources/jQuery/jquery-latest.js"></script>
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
                                if (select !="value"){
                                    option.find('option[value=' + select +']').hide();
                                }
                            });
                        });

                    });

                    function add() {
                        $('#form').append("Producto "+i+":");
                        $('#form').append($("#producto1").clone().attr("name","producto"+i).attr("id","producto"+i));
                        $('#form').append('<br />');
                        $('#form').append('Cantidad: <input type="text" class = "cantidad" name="cantidad'+i+'" id="cantidad'+i+'" placeholder="Cantidad"/>');
                        $('#form').append('<br />');
                        $('#form').append('Precio: <input type="text" class = "precio" name="precio'+i+'" id="precio'+i+'" placeholder="Precio"/>');
                        $('#form').append('<br />');
                        $('#form').append($('.submits'));
                        $('#np').attr("value", i);

                        i++;
                        if (i > <%=np%> ){
                            $( "#botonAdd" ).hide();
                        }
                    };

                    function doAjaxPost() {
                        // get the form values
                        var np = $('#np').val();
                        var saltados = 0;
                        var dataString = ""

                        for(var j=1;j<=np;j++){

                            if ($('#producto'+j).val()=="value"){
                                saltados++;
                                continue;
                            }
                            else if($('#cantidad'+j).val() < 1 || $('#cantidad'+j).val() > 9999999 ){
                                alert("Error: cantidad de "+$('#producto'+j).val()+" no permitida");
                                $('#cantidad'+j).css("border", "solid 3px red");
                                return;

                            }
                            else if($('#precio'+j).val() < 1 || $('#precio'+j).val() > 9999999 ){
                                alert("Error: precio de "+$('#producto'+j).val()+" no permitido");
                                $('#precio'+j).css("border", "solid 3px red");
                                return;

                            }

                            dataString = dataString + "producto"+(j-saltados)+"="+$('#producto'+j).val();
                            dataString = dataString + "&cantidad"+(j-saltados)+"="+$('#cantidad'+j).val();
                            dataString = dataString + "&precio"+(j-saltados)+"="+$('#precio'+j).val()+"&";
                        }

                        dataString+="np="+(np-saltados);

                        $.ajax({
                            type: "POST",
                            url: "../../ingresarCompra",
                            data: dataString,
                            success: function(response){
                                if(response.indexOf("Compra")>-1){
                                    alert(response);
                                    window.location.href ="../index.jsp";
                                }else{
                                    alert(response);
                                    window.location.href ="../index.jsp";
                                }
                            },
                            error: function(e){

                            }
                        });
                    };
                </SCRIPT>
	</head>
	<body>  <div id ="toolbar" style="position: fixed">
                 <div style="color:white; font-size: 13px;" id="toolbarUser">Usuario: <%=session.getAttribute("userName")%></div>
         <div style="color:white; font-size: 13px;" id="toolbarType">Cargo: <%=session.getAttribute("userType")%></div>
         <div id="toolbarLogout"><a style="color:white; font-size: 13px; text-decoration: none" href="Session/login.jsp">Cerrar sesión</a> </div>
                </div>
		<div id="content">
			<form style="text-align:center;" id="form" action="../../ingresarCompra" method="post">
                               
				Producto: <select  class = "producto" name ="producto1" id="producto1">
                                            <option value="value" selected>Seleccione un producto</option>
                                            <%=htmlProductos%>
                                          </select>
				<br />
				Cantidad: <input type="text" class = "cantidad" name="cantidad1" id="cantidad1" placeholder="Cantidad" />
				<br />
				Precio: <input type="text" class = "precio" name="precio1" id="precio1" placeholder="Precio"/>
                                <br />
                                <input type="hidden" name ="np" value="1" id="np"/>
				<input type="button" class = "submits" onclick="doAjaxPost()" value="Finalizar" />
			</form>
                        <button id="botonAdd"class="boton" onclick="add()">+Productos</button>
                    
		</div>
	</body>
</html>