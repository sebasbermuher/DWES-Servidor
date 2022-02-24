package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.DAOProductsImpl;
import org.iesalixar.servidor.model.Products;

/**
 * Servlet implementation class AddProductServlet
 */
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(AddProductServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

//		DAOProductsImpl daoImpl = new DAOProductsImpl();
//
//		request.setAttribute("products", daoImpl.getAllProducts());

		request.getRequestDispatcher("../WEB-INF/view/admin/addProducts.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productCode = (String) request.getParameter("productCode");
		String productName = (String) request.getParameter("productName");
//		String productLine = (String) request.getParameter("productLine");
		String productScale = (String) request.getParameter("productScale");
		String productVendor = (String) request.getParameter("productScale");
		String productDescription = (String) request.getParameter("productDescription");
		int quantityInStock = Integer.parseInt(request.getParameter("quantityInStock"));
		double buyPrice = Double.parseDouble(request.getParameter("buyPrice"));
		double MSRP = Double.parseDouble(request.getParameter("MSRP"));

		DAOProductsImpl daoProd = new DAOProductsImpl();

		Products product = new Products();

		product.setProductCode(productCode);
		product.setProductName(productName);
//		product.setProductLine(productLine);
		product.setProductScale(productScale);
		product.setProductVendor(productVendor);
		product.setProductDescription(productDescription);
		product.setQuantityInStock(quantityInStock);
		product.setBuyPrice(buyPrice);
		product.setMSRP(MSRP);

		daoProd.insertProduct(product);

		logger.log(Level.INFO, "Producto " + product.getProductName() + " añadido");

		response.sendRedirect(request.getContextPath() + "/Admin/AddProductServlet");

	}

}