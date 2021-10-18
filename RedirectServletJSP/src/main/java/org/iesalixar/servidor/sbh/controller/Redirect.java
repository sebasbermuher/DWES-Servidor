package org.iesalixar.servidor.sbh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.sbh.model.Usuario;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Redirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Redirect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	RequestDispatcher rda = request.getRequestDispatcher("a.jsp");
    	RequestDispatcher rdb = request.getRequestDispatcher("b.jsp");
    	
        if(request.getParameter("destino")!=null) {

            if(request.getParameter("destino").equalsIgnoreCase("A")) {
                //response.sendRedirect("a.jsp");
            	Usuario usuario = new Usuario();
            	usuario.setUsuario("admin");
            	usuario.setPassword("admin");
            	request.setAttribute("usuario", usuario);
            	
            	//rda.forward(request, response);
            	request.getRequestDispatcher("a.jsp").forward(request, response);
            } else {
                //response.sendRedirect("b.jsp");
            	Usuario usuario = new Usuario();
            	usuario.setUsuario("pepe");
            	usuario.setPassword("pepe");
            	request.setAttribute("usuario", usuario);
            	            	
            	//rdb.forward(request, response);
            	request.getRequestDispatcher("b.jsp").forward(request, response);
            }

        } else {
            PrintWriter out = response.getWriter();
            out.println("NO TENGO DESTINO");
            
            //Poner ?destino=a en la barra de navegacion
        }
    }
}
