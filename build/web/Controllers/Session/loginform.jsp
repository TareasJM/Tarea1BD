<%
	String user = request.getParameter( "user" );
	
	if (user.equals("administrador"))
	{
		response.sendRedirect("../../Views/index.jsp");
		session.setAttribute( "Error", null );
	}
	else if (user.equals("vendedor"))
	{
		response.sendRedirect("../../Views/index.jsp");
		session.setAttribute( "Error", null );
	}
	else
 	{
		session.setAttribute( "Error", "Datos invalidos, vuelva a intentarlo" );
		response.sendRedirect("../../Views/login.jsp");
 	} 

	session.setAttribute( "userType", user );
%>