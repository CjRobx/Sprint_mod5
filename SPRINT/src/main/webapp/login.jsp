<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Logeanding</title>

	<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<h1 class="centrar">☻☺ Bienvenido ☺☻</h1>
<form action="LogIn" method="POST" autocomplete="on" >
	<fieldset>
		<legend>Log In</legend>
	<ul>
		<li>
			<p>Nombre Usuario:</p>
			<input type="text" name="usuario" >
		</li>
		<li>
			<p>Contraseña:</p>
			<input id="password" type="password" name="password">
		</li>
	</ul>
		<button type="submit">Log</button>
	</fieldset>
</form>
<p class="centrar">${mensaje}</p>


<jsp:include page="/WEB-INF/piezas/Footer.jsp"/>

</body>
</html>