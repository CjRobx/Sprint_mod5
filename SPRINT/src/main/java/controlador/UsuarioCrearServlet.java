package controlador;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import modelo.Usuario;

/**
 * Servlet implementation class crearUsuario
 */
@WebServlet("/UsuarioCreate")
public class UsuarioCrearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioCrearServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);		
		Usuario usuario = new Usuario();
		
		String rut, nombres;
		LocalDate fechaNacimiento;
	
		rut = request.getParameter("rut") + "-" + request.getParameter("dv");
		nombres = request.getParameter("nombres");
		fechaNacimiento = LocalDate.parse( request.getParameter("fechaNacimiento"));
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstancia();
		
		usuario.setRut(rut);
		usuario.setNombres(nombres);
		usuario.setFechaNacimiento(fechaNacimiento);

		usuarioDAO.create(usuario);
		
		request.getRequestDispatcher("/UsuarioRead").forward(request, response);
	}

}
