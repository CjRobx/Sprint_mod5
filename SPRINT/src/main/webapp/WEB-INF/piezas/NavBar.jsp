<header>
   <!-- MENU -->
    <nav id="menu">
    <!-- Secciones -->
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/index.jsp">Inicio</a>
            </li>
            <li class="subMenu">Usuarios
	            <ul>
		            <li>
		                <a href="${pageContext.request.contextPath}/crearUsuario.jsp">Nuevo Usuario</a>
		            </li>
		            <li>
		                <a href="${pageContext.request.contextPath}/UsuarioRead">Lista Usuarios</a>
		            </li>
		        </ul>
	        </li>
	        <li class="subMenu">Capacitacion
	        	<ul>       
		            <li>
		                <a href="${pageContext.request.contextPath}/crearCapacitacion.jsp">Nueva Capacitacion</a>
		            </li>
		            <li>
		                <a href="${pageContext.request.contextPath}/CapacitacionRead">Lista Capacitaciones</a>
		            </li>
		    	</ul>
		    </li>
            <li>
                <a href="${pageContext.request.contextPath}/contacto.jsp">Contacto</a>
            </li>
            <li>
                <a href="LogOut">Log Out</a>
            </li>
        </ul>
    </nav>
</header>