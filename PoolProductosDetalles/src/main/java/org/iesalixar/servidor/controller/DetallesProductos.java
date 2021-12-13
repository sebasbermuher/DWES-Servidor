package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOProductImpl;

/**
 * Servlet implementation class DetallesProductos
 */
@WebServlet("/DetallesProductos")
public class DetallesProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetallesProductos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOProductImpl dao = new DAOProductImpl();

		request.setAttribute("pro", dao.getProducts(request.getParameter("codigo")));

		request.setAttribute("detallesNumPedidos", dao.getDetallesNumPedidos(request.getParameter("codigo")));
		request.setAttribute("detallesNumProductosVentas",
				dao.getDetallesNumProductasVentas(request.getParameter("codigo")));
		request.setAttribute("detallesNumVentas", dao.getDetallesNumVentas(request.getParameter("codigo")));

		request.getRequestDispatcher("WEB-INF/view/detalles.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
