package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOOrderImpl;
import org.iesalixar.servidor.dao.DAOProductLinesImpl;
import org.iesalixar.servidor.model.Order;

/**
 * Servlet implementation class InicioServlet
 */
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InicioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		DAOOrderImpl daoImpl = new DAOOrderImpl();
		
		ArrayList<Order> order = (ArrayList<Order>) daoImpl.getAllOrders();

		request.setAttribute("order", order);
		
		request.getRequestDispatcher("WEB-INF/view/home.jsp").forward(request, response);
		

	}

	
}
