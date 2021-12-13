package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.dao.DAOUsuarioImpl;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.utils.PasswordHashGenerator;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Comprobamos si tenemos los datos de la petición del formulario
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		if (usuario!=null && password!=null) {
			//Check credentials
			DAOUsuarioImpl daoUsuarioImpl = new DAOUsuarioImpl();
			Usuario user = daoUsuarioImpl.getUsuario(usuario);
			
			if(PasswordHashGenerator.checkPassword(password, user.getPassword())) {
				
				HttpSession sesion = request.getSession();
				
				sesion.setAttribute("usuario", user.getUsuario());
				sesion.setAttribute("email", user.getEmail());
				sesion.setAttribute("role", user.getRole());
				
				
				// response.sendRedirect(request.getContextPath()+"/Admin/");
				
					if("admin".equals(user.getRole())) {
						response.sendRedirect("Admin/");
					}else {
						response.sendRedirect("Search");
					}
					
				}else {
				request.setAttribute("error","Credenciales invalidas");
				doGet(request,response);
				return;
				
				}
				
				
			}else {
				request.setAttribute("error", "login invalido");
				doGet(request,response);
				return;
			}
			
		}
	}


