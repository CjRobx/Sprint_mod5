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
	<title>Home</title>

	<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>

<body>
<jsp:include page="/WEB-INF/piezas/NavBar.jsp"/>
    <section id="cuerpo">
	    <h1 class="centrar" >Titulo del Home</h1>
	    <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit.
	    Sunt exercitationem, possimus tempora labore dignissimos dolorum aut
	    molestias magnam, temporibus itaque harum nulla aspernatur blanditiis animi
	    optio doloremque earum commodi ratione. Iste dicta necessitatibus minus.
	    Debitis ea minima laborum, saepe voluptate dignissimos magni! At nisi ut
	    rem, corrupti dolorum ipsum dignissimos!
	    </p>
    </section>

<jsp:include page="/WEB-INF/piezas/Footer.jsp"/>
</body>
</html>