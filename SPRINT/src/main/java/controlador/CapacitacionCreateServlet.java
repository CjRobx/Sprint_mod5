package controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CapacitacionDAO;
import modelo.Capacitacion;

/**
 * Servlet implementation class CrearCapacitacion
 */
@WebServlet("/CapacitacionCreate")
public class CapacitacionCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapacitacionCreateServlet() {
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
		
		CapacitacionDAO capacitacionDAO = CapacitacionDAO.getInstancia();
		
		Capacitacion capacitacion = new Capacitacion();
		
		String rut;
		LocalDate fecha;
		LocalTime horaInicio, horaTermino;
		
		rut = request.getParameter("rut") + "-" + request.getParameter("dv");
		fecha = LocalDate.parse(request.getParameter("fecha"));
		horaInicio = LocalTime.parse(request.getParameter("horaInicio"));
		horaTermino = LocalTime.parse(request.getParameter("horaTermino"));
		
		capacitacion.setRutCliente(rut);
		capacitacion.setLugar(request.getParameter("lugar"));
		capacitacion.setFecha(fecha);
		capacitacion.setCantAsistentes(Integer.parseInt(request.getParameter("cantAsistentes")));
		capacitacion.setHoraInicio(horaInicio);
		capacitacion.setHoraTermino(horaTermino);

		capacitacionDAO.create(capacitacion);
		
		request.getRequestDispatcher("/CapacitacionRead").forward(request, response);
	}

}
