<%@page import="modelo.usuario"%>
<%@ page language="java" contentType="text/html charset=UTF-8" %> 
<html>
	<head>
		<link href="../../Resources/css/master.css" rel="stylesheet" type="text/css">
		<link href="../../Resources/css/login.css" rel="stylesheet" type="text/css">
	</head>
	<body style="text-align:center;">
		<div id="content">
			<%
				if (session.getAttribute("Error") != null) 
				{
					%>
						<div id="error">
							<%=session.getAttribute("Error")%>	
						</div>
					<%	
				}
			%>
			<form action="../../Controllers/Session/loginform.jsp" class = "login" method="POST">
	
                                Usuario:  <input type="text" class = "usuario" name="user" placeholder="Usuario">
				<br />
				Password: <input type="password" class = "pass" name="pass" placeholder="Password" />
				<input type="submit" class = "submits" value="Submit" />
			</form>
		</div>
	</body>
</html>