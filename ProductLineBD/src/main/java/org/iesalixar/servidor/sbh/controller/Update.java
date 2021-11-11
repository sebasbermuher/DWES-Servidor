package org.iesalixar.servidor.sbh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.sbh.dao.DAOProductLineImpl;
import org.iesalixar.servidor.sbh.model.ProductLine;

/**
 * Servlet implementation class Update
 */

public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productLine = request.getParameter("productLine");
				
		DAOProductLineImpl daoImpl = new DAOProductLineImpl();
		
		ProductLine listaProductLine = daoImpl.getProductLine(productLine);
		
		request.setAttribute("listadoProductos", listaProductLine);
		
		request.getRequestDispatcher("WEB-INF/view/update.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String productLine = request.getParameter("productLine");
		String textDescription = request.getParameter("textDescription");
		String htmlDescription = request.getParameter("htmlDescription");
		
		
		if (productLine!=null && textDescription!=null && htmlDescription!=null) {
			
			ProductLine listadoProductos = new ProductLine(productLine,textDescription,htmlDescription);
			
			DAOProductLineImpl daoImpl = new DAOProductLineImpl();
			
			daoImpl.updateProductLine(listadoProductos);
		}
		
		response.sendRedirect(request.getContextPath());
	}

}
