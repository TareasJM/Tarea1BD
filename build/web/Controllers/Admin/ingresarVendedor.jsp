<%@ page language="java" contentType="text/html charset=UTF-8" %> 
<%
   String pass = request.getParameter( "pass" );
   String rpass = request.getParameter( "rpass" );

%>
<html>
	<head>
		<title>blabla</title>
		<link href="../../Resources/css/master.css" rel="stylesheet" type="text/css">
		<link href="../../Resources/css/loginform.css" rel="stylesheet" type="text/css">
	</head>
<body>
	<div id="content">
		<%
		 	if (pass.equals(rpass))
			{
				response.sendRedirect("../../Views/index.jsp");
			}
		 	{
		 		%>
		 			<h2>Error, No coinciden las passwords</h2>
		 		<%
			} 
		%>	
		<a href="../../Views/Admin/ingresarVendedor.jsp">Volver</a>
	</div>
</body>
</html>