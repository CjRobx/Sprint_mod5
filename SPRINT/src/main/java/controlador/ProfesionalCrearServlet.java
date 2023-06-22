package controlador;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProfesionalDAO;
import modelo.Profesional;

/**
 * Servlet implementation class ProfesionalCrearServlet
 */
@WebServlet("/ProfesionalCrear")
public class ProfesionalCrearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfesionalCrearServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		Profesional prof = new Profesional();
		ProfesionalDAO profDAO= ProfesionalDAO.getInstancia();
		
		prof.setRut(request.getParameter("rut") + "-" + request.getParameter("dv"));
		prof.setNombres(request.getParameter("nombre"));
		prof.setFechaNacimiento(LocalDate.parse( request.getParameter("fechaNacimiento")));
		prof.setTitulo(request.getParameter("titulo"));
		prof.setFechaIngreso(LocalDate.parse(request.getParameter("fechaIngreso")));
		
		profDAO.create(prof);
		
		request.getRequestDispatcher("/UsuarioRead").forward(request, response);
	}

}
