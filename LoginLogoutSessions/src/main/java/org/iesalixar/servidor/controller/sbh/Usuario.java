package org.iesalixar.servidor.controller.sbh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.model.sbh.Usuarios;

/**
 * Servlet implementation class Usuario
 */
@WebServlet("/Usuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		
		if(!sesion.isNew()) {
			
			Usuarios usuario = (Usuarios)sesion.getAttribute("usuario");
			
			if(usuario!=null && usuario.getNombre().equals("usuario")) {
				request.setAttribute("usuarioBean", usuario);
				request.getRequestDispatcher("Usuario.jsp").forward(request, response);
			}
			
		}
		sesion.invalidate();
		response.sendRedirect(request.getContextPath());
		
		
	}

}
