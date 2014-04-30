<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html charset=UTF-8" %> 
<%
          if(session.getAttribute("userType")==null)
    {
         JOptionPane.showMessageDialog(null,"Se necesita iniciar sesion");
          response.sendRedirect("../Session/login.jsp");
    }
 %>
<html>
	<head>
		<link href="../../Resources/css/producto.css" rel="stylesheet" type="text/css">
                <script type=""   src="../../Resources/jQuery/jquery-latest.js"></script>
                <SCRIPT type="text/javascript"  language="javascript">
                 
                    function doAjaxPost() {
                        // get the form values
                        
                            if( ($('.cantidad').val() < 1 || $('.cantidad').val() > 9999999) && ($('.precio').val() < 1 || $('.precio').val() > 9999999 )){
                            alert("Error: cantidad y precio de "+$('.nombre').val()+" no permitida");
                            $('.cantidad').css("border", "solid 3px red");
                            $('.precio').css("border", "solid 3px red");
                            return;

                            }
                        
                            else if($('.cantidad').val() < 1 || $('.cantidad').val() > 9999999 ){
                            alert("Error: cantidad de "+$('.nombre').val()+" no permitida");
                            $('.cantidad').css("border", "solid 3px red");
                            return;

                            }
                            
                            else if($('.precio').val() < 1 || $('.precio').val() > 9999999 ){
                            alert("Error: precio de "+$('.nombre').val()+" no permitido");
                            $('.precio').css("border", "solid 3px red");
                            return;

                            }
          
                        $.ajax({
                            type: "POST",
                            url: "../../addProducto",
                            data: dataString,
                            success: function(response){
                                    alert(response);
                                    window.location.href ="../index.jsp";
                            }
                        });
                    };
                </SCRIPT>
	</head>
	<body>  
            <div id ="toolbar" style="position: fixed">
                 <div style="color:white; font-size: 13px;" id="toolbarUser">Usuario: <%=session.getAttribute("userName")%></div>
         <div style="color:white; font-size: 13px;" id="toolbarType">Cargo: <%=session.getAttribute("userType")%></div>
         <div id="toolbarLogout"><a style="color:white; font-size: 13px; text-decoration: none" href="Session/login.jsp">Cerrar sesión</a> </div>
             </div>
		<div id="content">
                        
			<form style ="text-align:center;"action="../../addProducto" method="POST">
				
				Nombre: <input type="text" class = "nombre" name = "nombre" placeholder="Nombre" />
				<br />
				Descripción: <input type="text" class = "descripcion" name="descripcion" placeholder="Descripcion">
				<br />
				Categoría: <input type="text" class = "categoria" name = "categoria" placeholder="Categoria" />
				<br />
				Cantidad: <input type="text" class = "cantidad"  name="cantidad" placeholder="Cantidad">
				<br />
				Precio: <input type="text" class = "precio" name = "precio" placeholder="Precio" />
				<input type="button" class = "submits" onclick="doAjaxPost()" value="Finalizar" />
			</form>
		</div>
	</body>
</html>