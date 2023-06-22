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
	<div>
			<h2 class="centrar">Tipo de Usuario</h2>
		<ul>
			<li class="seleccion">
			<div>
				<input type="radio" id="administrativo" name="tipoUsuario">
				<label for="administrativo">Administrativo</label>
			</div>
			<div>
				<input type="radio" id="profesional" name="tipoUsuario">
				<label for="profesional">Profesional</label>
			</div>
			<div>
				<input type="radio" id="cliente" name="tipoUsuario">
				<label for="cliente">Cliente</label>
			</div>
			</li>
		</ul>
	</div>
<!-- Formulario Base, uso de pruebas -->
	<form id="Usuario" class="oculto" action="UsuarioCrear" method="POST" autocomplete="on">
		<fieldset>
		<legend>Nuevo Usuario</legend>
		 <ul>
			 <li>RUT:
				<input type="text" name="rut" placeholder="XXXXXXXX" required
						  pattern="[0-9]{6,8}" title="RUN sin puntos ni guion">
				-
				<input type="text" name="dv" id="dv" placeholder="k"
								pattern="[\dkK]" title="digito o 'k'" required>
			</li>
			<li>Nombres:
				<input type="text" name="nombres" placeholder="Carlos Julio"
													pattern="[\w+ ]+" required>
			</li>
			<li>Fecha Nacimiento:
				<input type="date" name="fechaNacimiento"
												max="2005-06-01" required>
			</li>
		</ul>
       		<button type="submit">Enviar</button>
		</fieldset>
    </form>
<!-- Formulario Usuario Administrativo -->
    <form id="Administrativo" class="oculto" action="AdministrativoCrear" method="POST" autocomplete="on">
        <fieldset>
            <legend>Nuevo Administrativo</legend>
                <ul>
                <li>RUT:
                    <input type="text" name="rut" placeholder="XXXXXXXX" required
                        pattern="[0-9]{6,8}" title="RUN sin puntos ni guion">
                    -
                    <input type="text" name="dv" id="dv" placeholder="k"
                                pattern="[\dkK]" title="digito o 'k'" required>
                </li>
                <li>Nombres:
                    <input type="text" name="nombres" placeholder="Carlos Julio"
                                                    pattern="[\w+ ]+" required>
                </li>
                <li>Fecha Nacimiento:
                    <input type="date" name="fechaNacimiento"
                                                    max="2005-06-01" required>
                </li>
                <li>Area:
                    <input type="text" name="area" maxlength="20" pattern="[\w+ ]+" required>
                </li>
                <li>Experiencia Previa:
                    <input type="text" maxlength="50" name="experienciaPrevia" pattern="[\w\d+ ]+" required>
                </li>
                </ul>
            <button type="submit">Enviar</button>
        </fieldset>
    </form>
<!-- Formulario Usuario Profesional -->
    <form id="Profesional" class="oculto" action="ProfesionalCrear" method="POST" autocomplete="on">
        <fieldset>
            <legend>Nuevo Profesional</legend>
                <ul>
                <li>RUT:
                    <input type="text" name="rut" placeholder="XXXXXXXX" required
                        pattern="[0-9]{6,8}" title="RUN sin puntos ni guion">
                    -
                    <input type="text" name="dv" id="dv" placeholder="k"
                                pattern="[\dkK]" title="digito o 'k'" required>
                </li>
                <li>Nombre:
                    <input type="text" name="nombre" placeholder="Carlos Julio" pattern="[\w+ ]+" required>
                </li>
                <li>Fecha Nacimiento:
                    <input type="date" name="fechaNacimiento"
                                                    max="2005-06-01" required>
                </li>
                <li>Titulo:
                    <input type="text" name="titulo" maxlength="30" pattern="[\w+ ]+" required>
                </li>
                <li>Fecha Ingreso:
                    <input type="date" name="fechaIngreso"
                                                    max="2023-07-01" required>
                </li>
                </ul>
            <button type="submit">Enviar</button>
        </fieldset>		
    </form>
<!-- Formulario Usuario Cliente -->
    <form id="Cliente" class="oculto" action="ClienteCrear" method="POST" autocomplete="on">
		<fieldset>
		<legend>Nuevo Cliente</legend>
		 <ul>
			 <li>RUT:
				<input type="text" name="rut" placeholder="XXXXXXXX" required
						  pattern="[0-9]{6,8}" title="RUN sin puntos ni guion">
				-
				<input type="text" name="dv" id="dv" placeholder="k"
								pattern="[\dkK]" title="digito o 'k'" required>
			</li>
			<li>Nombres:
				<input type="text" name="nombres" placeholder="Carlos Julio"
													pattern="[\w+ ]+" required>
			</li>
			<li>Apellidos:
				<input type="text" name="apellidos"
					placeholder="Gonzalez Gonzalez" pattern="[\w+ ]+" required>
			</li>
			<li>Fecha Nacimiento:
				<input type="date" name="fechaNacimiento"
												max="2005-06-01" required>
			</li>
			<li>Celular: +(56)
				<input type="tel" name="telefono" placeholder="912345678"
							pattern="[0-9]{9}" title="solo numeros" required>
			</li>
			<li>Sistema de Salud:
                <input type="radio" id="isapre" name="sistemaSalud"
														value="Isapre" required>
                <label for="isapre">Isapre</label>
                <input type="radio" id="fonasa" name="sistemaSalud"
																value="Fonasa">
                <label for="fonasa">Fonasa</label>
			</li>
			<li>AFP:
				<!-- debería ser una [combobox] -->
				<select name="afp" id="afp" required>
					<option selected disabled>-- Seleccione --</option>
					<option value="Capital">Capital</option>
					<option value="Cuprum">Cuprum</option>
					<option value="Habitat">Habitat</option>
					<option value="Modelo">Modelo</option>
					<option value="Plan Vital">Plan Vital</option>
					<option value="Provida">Provida</option>
					<option value="Uno">Uno</option>
					<option value="Futuro">Futuro</option>
					<option value="Summa">Summa</option>
					<option value="Aporta">Aporta</option>
					<option value="Magister">Magister</option>
				</select>
			</li>
			<li>Dirección:
				<input type="text" name="direccion"
							placeholder="Los Azufres #123" pattern="[\w+ ]+ #\d+$"
														maxlength="30" required>
			</li>
			<li>Comuna:
				<!-- debería ser una [combobox] -->
				<input type="text" name="comuna" placeholder="Santiago" pattern="[\w+ ]+"
										maxlength="45" required>
			</li>
		</ul>
       		<button type="submit">Enviar</button>
		</fieldset>
    </form>
<jsp:include page="/WEB-INF/piezas/Footer.jsp"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script> <%@include file="/WEB-INF/js/formulario.js"%> </script>
</body>
</html>