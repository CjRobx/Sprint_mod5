package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CapacitacionDAO;
import modelo.Capacitacion;

/**
 * Servlet implementation class ListarCapacitaciones
 */
@WebServlet("/CapacitacionRead")
public class CapacitacionReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapacitacionReadServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CapacitacionDAO capacitacionDAO = CapacitacionDAO.getInstancia();

		List<Capacitacion> capacitaciones = capacitacionDAO.read();

		request.setAttribute("capacitaciones", capacitaciones);
		
		request.getRequestDispatcher("/listaCapacitacion.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
