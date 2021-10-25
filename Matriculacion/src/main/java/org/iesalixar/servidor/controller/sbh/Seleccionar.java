package org.iesalixar.servidor.controller.sbh;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Seleccionar
 */
@WebServlet("/Seleccionar")
public class Seleccionar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Seleccionar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Seleccionar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String nombre = request.getParameter("nombre");
        request.setAttribute("nombre", nombre);
        
        String apellidos = request.getParameter("apellidos");
        request.setAttribute("apellido", apellidos);
        
        String email = request.getParameter("email");
        request.setAttribute("email", email);

        String modulos[] = request.getParameterValues("modulos");
        for (int i = 0; i < modulos.length; i++){
            request.setAttribute("modulos", modulos);
        }

        String cursos[] = request.getParameterValues("cursos");
        request.setAttribute("cursos", Arrays.toString(cursos));
        
        Cookie cookie_cursos = new Cookie("cursos", Arrays.toString(cursos));
        response.addCookie(cookie_cursos);
        
        
	}

}
