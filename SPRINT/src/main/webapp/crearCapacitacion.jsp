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
	<title>Capacitación</title>

	<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>

<body>
<jsp:include page="/WEB-INF/piezas/NavBar.jsp"/>
    
	<form action="CapacitacionCreate" method="POST" autocomplete="on">
		<fieldset>
		<legend>Nueva Capacitación</legend>
		<ul>
			<li>RUT Cliente:
				<input type="number" name="rut" placeholder="XXXXXXXX"
				  pattern="[0-9]{6,8}" title="RUN sin puntos ni guion" required>
				-
				<input type="text" name="dv" id="dv" placeholder="k"
								pattern="[\dkK]" title="digito o 'k'" required>
			</li>
			<li>Lugar:
				<input type="text" name="lugar" placeholder="..."
														maxlength="30" required>
			</li>
			<li>Cantidad de Asistentes:
				<input type="number" name="cantAsistentes"
										placeholder="1-1000" max="1000" min="1">
			</li>
			<li>Fecha:
				<input type="date" name="fecha"
									min="2023-07-01" max="2023-12-01" required>
			</li>
			<li>Hora Inicio:
				<input type="time" name="horaInicio" required>
			</li>
			<li>Hora Termino:
				<input type="time" name="horaTermino" required>
			</li>
			
		</ul>
       		<button type="submit">Enviar</button>
		</fieldset>
    </form>

<jsp:include page="/WEB-INF/piezas/Footer.jsp"/>
</body>
</html>