package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOProduct;
import org.iesalixar.servidor.dao.DAOProductImpl;
import org.iesalixar.servidor.model.Producto;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DAOProduct dao = new DAOProductImpl();
		List<Producto> productos = dao.getAllProducts();
		request.setAttribute("productos", productos);
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	}

}
