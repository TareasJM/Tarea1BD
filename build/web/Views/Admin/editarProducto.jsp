<%@page import="javax.swing.JOptionPane"%>
<%@page import="modelo.producto"%>
<%

          if(session.getAttribute("userType")==null)
    {
         JOptionPane.showMessageDialog(null,"Se necesita iniciar sesion");
          response.sendRedirect("../Session/login.jsp");
    }

String name = request.getParameter( "buscar" ).toUpperCase();

%>
<%@ page language="java" contentType="text/html charset=UTF-8" %> 
<html>
	<head>
		<link href="../../Resources/css/editar.css" rel="stylesheet" type="text/css">
	</head>
	<body>  
             <div id ="toolbar" style="position: fixed">
                 <div style="color:white" id="toolbarUser">Usuario: <%=session.getAttribute("userName")%></div>
                 <div style="color:white" id="toolbarType">Cargo: <%=session.getAttribute("userType")%></div>
                 <div id="toolbarLogout"><a style="color:white; text-decoration: none" href="Session/login.jsp">Cerrar sesión</a> </div>
             </div>
		<div id="content">
                    <form with =" 10%" class="tabla1" border="1">
                        <p class="dos">Buscar</p>
                        <br>
                        <input action ="editarProducto.jsp" style ="width:125px; margin-top:0px; margin-bottom:10px" type="text" class = "buscar" name="buscar" placeholder="Buscar Producto">
                        </br>
                        <a href ="administrarProductos.jsp" sytle type ="text/css" class ="cuatro">Volver</a>
                    </form> 
                            <%
                                    producto prod =new producto();
                                    for(producto temp: prod.showProducto())
                            {
                            
                             if(name.equals(temp.getNombre()))
                             {
                                
                                %>
                            <form  style="text-align: center" action="../../editProductos" method="POST">
                            Código: <input type="text" class = "codigo" name="id" value ="<%=temp.getId_producto()%>" readonly/>
                            <br />
                            Nombre: <input type="text" class = "nombre" name = "nombre" value ="<%=temp.getNombre()%>" readonly/>
                            <br />
                            Descripcion: <input type="text" class = "descripcion" name="descripcion"  value="<%=temp.getDescripcion()%>"/>
                            <br />
                            Categoría: <input type="text" class = "categoria" name = "categoria" value ="<%=temp.getCategoria()%>" />
                            <br />
                            Cantidad: <input type="text" class = "cantidad" name="cantidad" value ="<%=temp.getStock()%>" readonly/>
                            <br />
                            Precio: <input type="text" class = "precio" name = "precio" value ="<%=temp.getPrecio()%>" />
                            <input  type="submit" class = "submits" value="Guardar Cambios" />    
                            </form>

                          <%}
                      
                          
                            }%>
		</div>
	</body>
</html>