<%
	String user = request.getParameter( "user" );
	
	if (user.equals("administrador") || user.equals("vendedor"))
	{
                session.setAttribute( "userType", user );
                session.setAttribute( "Error", null );
		response.sendRedirect("../../Views/index.jsp");
	}
	else
 	{
		session.setAttribute( "Error", "Datos invalidos, vuelva a intentarlo" );
                session.setAttribute("userType", "none");
		response.sendRedirect("../../Views/Session/login.jsp");
 	} 
%>