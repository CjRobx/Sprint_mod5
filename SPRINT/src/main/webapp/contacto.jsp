<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	if ( request.getSession().getAttribute("usuario") == null ){
		request.getRequestDispatcher("login.jsp").forward(request, response);
	} 
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Contacto</title>

	<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>

<body>
<jsp:include page="/WEB-INF/piezas/NavBar.jsp"/>
    
<!-- <h1>Don't say BlowJobs MJ</h1>  --> 
	<form action="Contacto" method="POST" autocomplete="on">
		<fieldset>
		 <legend>
		 	Contacto
		 </legend>
		 <ul>
			 <li>
				<input type="text" name="nombres"
											placeholder="Juan Perez" required>
			</li>
			<li>
				<input type="email" name="correo"
											placeholder="correo@yahoo.com">
			</li>
			<li>
				<textarea maxlength="100" name="consulta" rows="10" cols="40">
				</textarea>
			</li>
	     </ul>
		    <button type="submit">Enviar</button>
        </fieldset>
    </form>
<jsp:include page="/WEB-INF/piezas/Footer.jsp"/>
</body>
</html>