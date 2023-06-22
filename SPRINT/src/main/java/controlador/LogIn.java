package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		if ( valido(request, response) ) {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("usuario", request.getParameter("usuario"));
			request.getRequestDispatcher("/contacto.jsp").forward(request, response);
		}
		else {
			request.setAttribute("mensaje", "Usuario o Contraseña Incorrecto");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	
	private boolean valido (HttpServletRequest request, HttpServletResponse response) {
		String usuario, password;
		usuario = request.getParameter("usuario");
		password = request.getParameter("password");
		return ( usuario.equals("admin") && password.equals("1234") );
	}

}
