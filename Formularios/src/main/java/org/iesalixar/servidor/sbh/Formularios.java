package org.iesalixar.servidor.sbh;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Formularios
 */
@WebServlet("/Formularios")
public class Formularios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Formularios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ESTO NO SE HACE AQUI
		//PrintWriter out = response.getWriter();
		//out.println("El campo simple es: " + simple);
		
		String simple = request.getParameter("simple"); //para unico valor
		String checkbox[]= request.getParameterValues("checkbox"); //para varios  valores
		String select[]= request.getParameterValues("select");
		

        request.setAttribute("simple", simple);
        request.setAttribute("checkbox", Arrays.toString(checkbox));
        request.setAttribute("select", Arrays.toString(select));

        request.getRequestDispatcher("Datos.jsp").forward(request, response);
	}

}
