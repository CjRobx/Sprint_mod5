/**
 * @author Sanson
 * Redireccion al detalle del usuario según el tipo de Usuario
 */

package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Administrativo;
import modelo.Cliente;
import modelo.Profesional;
import dao.AdministrativoDAO;
import dao.ClienteDAO;
import dao.ProfesionalDAO;
/**
 * Servlet implementation class UsuarioDetalleServlet
 */
@WebServlet("/UsuarioDetalle")
public class UsuarioDetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioDetalleServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
// En el GET porque llega por URL
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// hacer llamado al DAO.buscarPorID que corresponda
		switch ( request.getParameter("tipo") ){
			case "Administrativo" :
				request.setAttribute("admin", daoAdmin(request, response));
				request.getRequestDispatcher("/detalleAdministrativo.jsp").forward(request, response);
				break;
			case "Profesional":
				request.setAttribute("profesional", daoProfesional(request, response));
				request.getRequestDispatcher("/detalleProfesional.jsp").forward(request, response);
				break;
			case "Cliente":
				request.setAttribute("cliente", daoCliente(request, response));
				request.getRequestDispatcher("/detalleCliente.jsp").forward(request, response);
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
//_______________SE DEBEN CREA LOS METODOS PARA LEER POR ID EN CADA DAO______________________
	private Administrativo daoAdmin(HttpServletRequest request, HttpServletResponse response) {
		AdministrativoDAO adminDAO = AdministrativoDAO.getInstancia();
		return adminDAO.readPorRUT(request.getParameter("rut"));
		
	}
	
	private Profesional daoProfesional(HttpServletRequest request, HttpServletResponse response) {
		ProfesionalDAO profeDAO = ProfesionalDAO.getInstancia();
		return profeDAO.readPorRUT(request.getParameter("rut"));
	}
	
	private Cliente daoCliente(HttpServletRequest request, HttpServletResponse response) {
		ClienteDAO clienteDAO = ClienteDAO.getInstancia();
		return clienteDAO.readPorRUT(request.getParameter("rut"));
	}
	
	
}
