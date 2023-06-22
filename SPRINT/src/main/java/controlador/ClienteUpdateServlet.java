package controlador;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cliente;
import dao.ClienteDAO;

/**
 * Servlet implementation class ClienteUpdateServlet
 */
@WebServlet("/ClienteUpdate")
public class ClienteUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = ClienteDAO.getInstancia();
		
		cliente.setRut(request.getParameter("rut"));
		cliente.setNombres(request.getParameter("nombres"));
		cliente.setFechaNacimiento(LocalDate.parse( request.getParameter("fechaNacimiento")));
		cliente.setApellidos(request.getParameter("apellidos"));
		cliente.setTelefono(request.getParameter("telefono"));
		cliente.setSistemaSalud(request.getParameter("sistemaSalud"));
		cliente.setAfp(request.getParameter("afp"));
		cliente.setDireccion(request.getParameter("direccion"));
		cliente.setComuna(request.getParameter("comuna"));
		
		clienteDAO.update(cliente);
		request.getRequestDispatcher("/UsuarioRead").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
