<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="modelo.Usuario" %>

<%
	if ( request.getSession().getAttribute("usuario") == null ){
		request.getRequestDispatcher("login.jsp").forward(request, response);
	} 
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Registro de Usuarios</title>
	
	<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>

<body>
<jsp:include page="/WEB-INF/piezas/NavBar.jsp"/>

	<div class="">
        <h1 class="centrar">Listado de Usuarios</h1>
        <table class="tabla">
            <thead>
                <tr>
                    <th>Rut</th>
                    <th>Nombres</th>
                    <th>Fecha de Nacimiento</th>
                    <th>Tipo Usuario</th>
                </tr>
            </thead>
            <tbody>
                <% List<Usuario> lista = (List<Usuario>) request.getAttribute("usuarios"); %>
                <% if (lista != null) { %>
	                <% for ( Usuario usuario : lista ){ %>
	                    <tr>
	                        <td><%= usuario.getRut() %></td>
	                        <td><%= usuario.getNombres() %></td>
	                        <td><%= usuario.getFechaNacimiento() %></td>
	                        <td>
<!-- Comprobacion en Servlet y redireccion a una vista personalizada -->
<!-- usaremos un JSP para mostrar en detalle la informacion del Usuario basado e el campo de la tabla "TipoCliente" -->
	                            <a href="UsuarioDetalle?rut=<%=usuario.getRut()%>&tipo=<%=usuario.getTipoUsuario()%>"><%=usuario.getTipoUsuario()%></a> <!-- Envío a Servlet -->
	                    <!-- definir el atributo y el metodo -->
	                        </td>
	                    </tr>
	                <% } %>
                <% } %>
            </tbody>
        </table>
    </div>

<jsp:include page="/WEB-INF/piezas/Footer.jsp"/>
</body>
</html>