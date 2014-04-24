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
    int np = 0;
    for(producto temp: prod.showProducto())
    {
        np++;
        htmlProductos+="<option value= \""+temp.getNombre()+"\">"+temp.getNombre()+"</option>\n";
    }
    
%>
<html>
	<head>
		<link href="../../Resources/css/venta.css" rel="stylesheet" type="text/css">
                <script type=""  src="http://code.jquery.com/jquery-latest.js"></script>
                <SCRIPT type="text/javascript"  language="javascript">
                    var i=2;
                    
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
                        $('#form').append('Cantidad: <input type="text" class = "cantidad" name="cantidad'+i+'" id="cantidad'+i+'"/>');
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
                        var vendedor = $('#vendedor').val();
                        var cliente = $('#cliente').val();
                        var np = $('#np').val();

                        var dataString = "vendedor="+vendedor+"&cliente="+cliente+"&np="+np;
                        for(var j=1;j<=np;j++){
                            dataString = dataString + "&producto"+j+"="+$('#producto'+j).val();
                            dataString = dataString + "&cantidad"+j+"="+$('#cantidad'+j).val();
                        }

                        alert(dataString);

                        $.ajax({
                            type: "POST",
                            url: "../../IV",
                            data: dataString,
                            success: function(response){
                                $('#response').html(response);
                            },
                            error: function(e){
                                alert('Error: ' + e);
                            }
                        });
                    };
                </SCRIPT>
	</head>
	<body>
		<div id="content">
			<form style="text-align:center;" action="../../IV" method="POST" id="form">
				Cliente: <select  class="cliente" name="cliente" id="cliente">
                                            <%=htmlClientes%>
                                         </select> 
				<br />
                                
				Producto: <select  class = "producto" name ="producto1" id="producto1">
                                            <option selected></option>
                                            <%=htmlProductos%>
                                          </select>
				<br />
				Cantidad: <input type="text" class = "cantidad" name="cantidad1" id="cantidad1"/>
                                <br/>
                                <input type="hidden" name ="vendedor" id="vendedor" value="<%=session.getAttribute("userID")%>"/>
                                <input type="hidden" name ="np" value="1" id="np"/>
                                <input type="submit" class = "submits" value="Finalizar" />
			</form>
                        <button id="botonAdd"class="boton" onclick="add()">+Productos</button>
                        <input type="button" value="ajaxSubmit" onclick="doAjaxPost()">
                        <div id="response"></div>
                    
		</div>
	</body>
</html>