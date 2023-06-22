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
 * Servlet implementation class ProfesionalUpdate
 */
@WebServlet("/ProfesionalUpdate")
public class ProfesionalUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfesionalUpdateServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Profesional prof = new Profesional();
		ProfesionalDAO profDAO= ProfesionalDAO.getInstancia();
		
		prof.setRut(request.getParameter("rut"));
		prof.setNombres(request.getParameter("nombre"));
		prof.setFechaNacimiento(LocalDate.parse( request.getParameter("fechaNacimiento")));
		prof.setTitulo(request.getParameter("titulo"));
		System.out.println(request.getParameter("titulo"));
		prof.setFechaIngreso(LocalDate.parse(request.getParameter("fechaIngreso")));
		
		profDAO.update(prof);
		
		request.getRequestDispatcher("/UsuarioRead").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
