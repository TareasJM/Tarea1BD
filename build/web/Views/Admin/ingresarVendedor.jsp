
<%@page import="javax.swing.JOptionPane"%>
<%@page import="modelo.usuario"%>
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
		<link href="../../Resources/css/usuarios.css" rel="stylesheet" type="text/css">
	</head>
	<body >
            <div id ="toolbar" style="position: fixed">
                 <div style="color:white; font-size: 13px;" id="toolbarUser">Usuario: <%=session.getAttribute("userName")%></div>
         <div style="color:white; font-size: 13px;" id="toolbarType">Cargo: <%=session.getAttribute("userType")%></div>
         <div id="toolbarLogout"><a style="color:white; font-size: 13px; text-decoration: none" href="Session/login.jsp">Cerrar sesión</a> </div>
             </div>
		<div style="text-align:center;" id="content">
			<form action="../../ingresarUsuario" method="post">
				Rut: <input  type="text" class = "rut" name="rut" placeholder="Rut">
				<br />
				Password: <input type="password" class = "pass" name="pass" placeholder="Password" />
				<br />
                                Repetir Pass: <input type="password" class = "rpass" name="rpass" placeholder="Repetir Contraseña">
				<br />
				Nombre: <input type="text" class = "nombre" name="nombre" placeholder="Nombre">
                                </br>
                                Comisión: <input type="text" class = "comision" name ="comision" placeholder="Comisión" />
				<input type="submit" class = "submits" value="Finalizar" />
                                
			</form>
                    
		</div>
	</body>
</html>