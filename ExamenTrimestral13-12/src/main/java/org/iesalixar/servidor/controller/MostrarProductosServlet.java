package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOProductsImpl;

/**
 * Servlet implementation class MostrarProductosServlet
 */
@WebServlet("/MostrarProductosServlet")
public class MostrarProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarProductosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String categoria = (String) request.getParameter("cat");
		
		DAOProductsImpl dao = new DAOProductsImpl();
		
		request.setAttribute("categoria", categoria);
		System.out.println(categoria);
		request.setAttribute("productos", dao.getProduct(categoria));
		

		request.getRequestDispatcher("WEB-INF/view/mostrarProductos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
