<%@page import="javax.swing.JOptionPane"%>
<%@page import="modelo.usuario"%>
<%
	String user = request.getParameter( "user" ).toUpperCase();
        String pass = request.getParameter("pass").toUpperCase();
        usuario u = new usuario();
        u = u.getUser(user);

          //  {
                if ((u.getTipo().equals("ADMINISTRADOR") || u.getTipo().equals("VENDEDOR")) && u.getPass().equals(pass))
                {
                     
                        session.setAttribute( "userType", u.getTipo() );
                        session.setAttribute( "Error", null );
                        response.sendRedirect("../../Views/index.jsp");
                      
                }
                
            //}
        
        else
                {       
                       
                        session.setAttribute( "Error", "Datos invalidos, vuelva a intentarlo" );
                        session.setAttribute("userType", "none");
                        response.sendRedirect("../../Views/Session/login.jsp");
                }
        //}
%>