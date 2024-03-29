package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOProductImpl;
import org.iesalixar.servidor.model.Productos;

/**
 * Servlet implementation class AdministradorIncioServlet
 */
public class AdministradorInicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdministradorInicioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOProductImpl daoProductImpl = new DAOProductImpl();

		ArrayList<Productos> lista_productos = (ArrayList) daoProductImpl.getAllProducts();
		

		request.setAttribute("productos", lista_productos);

		request.getRequestDispatcher("../WEB-INF/view/admin/index.jsp").forward(request, response);

	}
}
