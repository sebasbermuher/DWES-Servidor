package org.iesalixar.servidor.sbh.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String PASSWORD_REGEX =
	        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";
	 
	    private static final Pattern PASSWORD_PATTERN =
	            Pattern.compile(PASSWORD_REGEX);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("inicio.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("registrarse")!=null && request.getParameter("registrarse").equals("REGISTRARSE")) {
			HttpSession sesion = request.getSession();
			String password = request.getParameter("password");
			String confirmar_password = request.getParameter("confirmar_password");
			
			if (password.equals(confirmar_password)) {
			sesion.setAttribute("LOGEADO", true);
			
			String user = request.getParameter("user");
			sesion.setAttribute("user", user);
			
		
			response.sendRedirect(request.getContextPath()+"/Reserva");
			
			return;
			
			}
			
		}
		
		response.sendRedirect(request.getContextPath());
	}

}