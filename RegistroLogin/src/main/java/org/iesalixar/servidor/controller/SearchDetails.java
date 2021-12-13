package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOProductImpl;

/**
 * Servlet implementation class SearchDetails
 */
public class SearchDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String productName = request.getParameter("productName");
//
//        DAOProductImpl dao = new DAOProductImpl();
//
//        request.setAttribute("productos", dao.getProduct(productName));
//
//        request.getRequestDispatcher("WEB-INF/view/searchDetails.jsp").forward(request, response);
		String productName = request.getParameter("productName");

		DAOProductImpl dao = new DAOProductImpl();

		request.setAttribute("productos", dao.getProducts(productName));

		request.getRequestDispatcher("WEB-INF/view/searchdetails.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	
//			String productName = request.getParameter("productName");
//
//	        DAOProductImpl dao = new DAOProductImpl();
//
//	        request.setAttribute("productos", dao.getProduct(productName));
//
//	        doGet(request,response);
//	        return;
		
		String productName = request.getParameter("productName");
		

		DAOProductImpl dao = new DAOProductImpl();

		request.setAttribute("productos", dao.getProducts(productName));
		

		doGet(request, response);
		return;

	}

}
