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
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		
		if (!sesion.isNew()) {
			
			Usuarios usuario = (Usuarios)sesion.getAttribute("usuario");
			
			if (usuario!=null && usuario.getNombre().equals("admin") ) {
				
				request.setAttribute("usuarioBean", usuario);
				
				request.getRequestDispatcher("Admin.jsp").forward(request, response);
				return;
			}
		}
		sesion.invalidate();
		response.sendRedirect(request.getContextPath());

	}

}