package org.iesalixar.servidor.sbh;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPost
 */
@WebServlet("/LoginPost")
public class LoginPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        
        String user = request.getParameter("user");
        String passw = request.getParameter("passw");
        
        out.println("<html>");
        out.println("<head><title>Login</title><head>");
        out.println("<body>");
        out.println("<h1>Login</h1>");
        
        if (user != null && passw != null) {
            out.println("<p style=\'color : red\'Parametros Incorrectos </p>");
        }

        out.println("<form method=\"post\">");
        out.println("<label for=\"user\">Usuario:</label><input id=\"usuario\" type=\"text\" name=\"usuario\" required><br><br>");
        out.println(
                "<label for=\"password\">Password:</label><input id=\"password\" type=\"password\" name=\"password\" required><br><br>");
        out.println("<button type=\"submit\" name=\"submit\">Enviar</button>");
        out.println("</form>");
        out.println("</body></html>");

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Enumeration paramEnumeration = request.getParameterNames();

        if (!paramEnumeration.hasMoreElements()) {
            out.println("No has introducido usuario y contraseña.");

        } else {
                 String user = request.getParameter("usuario");
                 String passw = request.getParameter("password");

                if ("admin".equals(user) && "admin".equals(passw)) {
                	out.write("<h1>Acceso correcto</h1>");
                } else {
                    out.write("<h1>Parametros incorrectos</h1>" );
                }
                
                String param = (String) paramEnumeration.nextElement();
                out.write("<li>Usuario introducido con el siguiente valor: "+ user + "</li>");
                out.write("<li>Contraseña introducido con el siguiente valor: "+ passw + "</li>");

            }
        }
	}
