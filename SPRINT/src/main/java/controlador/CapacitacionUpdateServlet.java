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
 * Servlet implementation class CapacitacionUpdateServlet
 */
@WebServlet("/CapacitacionUpdate")
public class CapacitacionUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapacitacionUpdateServlet() {
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
// Crear DAO
		CapacitacionDAO capaDAO = CapacitacionDAO.getInstancia();
// Crear Objeto Capacitacion para empaquetar los datos actualizados
		Capacitacion capa = new Capacitacion();
String rut;
		LocalDate fecha;
		LocalTime horaInicio, horaTermino;
		
		rut = request.getParameter("rut") + "-" + request.getParameter("dv");
		fecha = LocalDate.parse(request.getParameter("fecha"));
		horaInicio = LocalTime.parse(request.getParameter("horaInicio"));
		horaTermino = LocalTime.parse(request.getParameter("horaTermino"));
		
		capa.setId( Integer.parseInt(request.getParameter("id")) );
		capa.setRutCliente(rut);
		capa.setLugar(request.getParameter("lugar"));
		capa.setFecha(fecha);
		capa.setCantAsistentes(Integer.parseInt(request.getParameter("cantAsistentes")));
		capa.setHoraInicio(horaInicio);
		capa.setHoraTermino(horaTermino);
		
		capaDAO.update(capa);
		
		request.getRequestDispatcher("/CapacitacionRead").forward(request, response);
	}

}
