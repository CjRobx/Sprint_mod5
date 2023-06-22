package controlador;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import modelo.Cliente;

/**
 * Servlet implementation class CrearCliente
 */
@WebServlet("/ClienteCrear")
public class ClienteCrearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteCrearServlet() {
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
		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = ClienteDAO.getInstancia();
				
		cliente.setRut(request.getParameter("rut") + "-" + request.getParameter("dv"));
		cliente.setNombres(request.getParameter("nombres"));
		cliente.setFechaNacimiento(LocalDate.parse( request.getParameter("fechaNacimiento")));
		cliente.setApellidos(request.getParameter("apellidos"));
		cliente.setTelefono(request.getParameter("telefono"));
		cliente.setSistemaSalud(request.getParameter("sistemaSalud"));
		cliente.setAfp(request.getParameter("afp"));
		cliente.setDireccion(request.getParameter("direccion"));
		cliente.setComuna(request.getParameter("comuna"));
		
		clienteDAO.create(cliente);
		
		request.getRequestDispatcher("/UsuarioRead").forward(request, response);
	}

}
