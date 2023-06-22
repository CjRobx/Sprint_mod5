package controlador;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdministrativoDAO;
import modelo.Administrativo;

/**
 * Servlet implementation class AdministrativoUpdate
 */
@WebServlet("/AdministrativoUpdate")
public class AdministrativoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministrativoUpdateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Administrativo admin = new Administrativo();
		AdministrativoDAO adminDAO = AdministrativoDAO.getInstancia();
		
		admin.setRut(request.getParameter("rut"));
		admin.setNombres(request.getParameter("nombres"));
		admin.setFechaNacimiento(LocalDate.parse(request.getParameter("fechaNacimiento")));
		admin.setTipoUsuario(request.getParameter("tipoUsuario"));
		admin.setArea(request.getParameter("area"));
		admin.setExperienciaPrevia(request.getParameter("experienciaPrevia"));
		
		adminDAO.update(admin);
		
		request.getRequestDispatcher("/UsuarioRead").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
