package org.iesalixar.servidor.sbh.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.sbh.dao.DAOProductLineImpl;
import org.iesalixar.servidor.sbh.model.ProductLine;

/**
 * Servlet implementation class ListadoProductos
 */

public class ListadoProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOProductLineImpl daoImpl = new DAOProductLineImpl();
		
		ArrayList<ProductLine> listadoProductLine = (ArrayList)daoImpl.getAllProductLine();
		
		request.setAttribute("listadoProductos", listadoProductLine);
		
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
		
	}

	

}
