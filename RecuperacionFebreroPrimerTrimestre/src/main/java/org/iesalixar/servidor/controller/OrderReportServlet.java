package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.DAOOrderImpl;
import org.iesalixar.servidor.model.Order;

/**
 * Servlet implementation class OrderReportServlet
 */
public class OrderReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(OrderReportServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderReportServlet() {
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

		int orderNumber = Integer.parseInt(request.getParameter("on"));

		DAOOrderImpl daoImpl = new DAOOrderImpl();

		Order order = daoImpl.getOrder(orderNumber);

		request.setAttribute("order", order);

		request.getRequestDispatcher("../WEB-INF/view/orderReport.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//
//		
//		 int orderNumber = Integer.parseInt(request.getParameter("orderNumber"));
//		 String orderDate = request.getParameter("orderDate");
//		 String requiredDate = request.getParameter("requiredDate");
//		 String shippedDate = request.getParameter("shippedDate");
//		 String status =request.getParameter("status");
//		 String comments=request.getParameter("comments");
//		 int customerNumber=Integer.parseInt(request.getParameter("customerNumber"));
//		
//		
//
//		if (orderNumber != 0 && orderDate != null && requiredDate != null && shippedDate != null
//				&& status != null && comments != null && customerNumber != 0) {
//
//			Order order = new Order();
//
//			order.setOrderNumber(orderNumber);
//			order.setOrderDate(orderDate);
//			order.setRequiredDate(requiredDate);
//			order.setShippedDate(shippedDate);
//			order.setStatus(status);
//			order.setComments(comments);
//			order.setCustomerNumber(customerNumber);
//	
//			DAOOrderImpl daoImpl = new DAOOrderImpl();
//
//			daoImpl.getOrder(orderNumber);
//			logger.info("Vista realizada");
//
//		}
//
//		response.sendRedirect(request.getContextPath() + "/OrderReportServlet");
	}

}
