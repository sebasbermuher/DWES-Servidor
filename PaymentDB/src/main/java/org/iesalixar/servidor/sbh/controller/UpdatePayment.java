package org.iesalixar.servidor.sbh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.sbh.dao.DAOPaymentImpl;
import org.iesalixar.servidor.sbh.model.Payment;

/**
 * Servlet implementation class AgregarServlet
 */
@WebServlet("/UpdatePayment")
public class UpdatePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePayment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String checkNumber = request.getParameter("checkn");
		int customerNumber = Integer.parseInt(request.getParameter("cn"));
		
		DAOPaymentImpl daoImpl = new DAOPaymentImpl();
		
		Payment payment = daoImpl.getPayment(customerNumber, checkNumber);
		
		request.setAttribute("pago", payment);
		
		request.getRequestDispatcher("WEB-INF/view/update.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String checkNumber = request.getParameter("checkn");
		int customerNumber = Integer.parseInt(request.getParameter("cn"));
		String paymentDate = request.getParameter("paymentDate");
		Double amount  = Double.parseDouble(request.getParameter("amount"));
		
		if (checkNumber!=null && customerNumber!=0 && paymentDate!=null && amount!=0.0) {
			
			Payment payment = new Payment(customerNumber,checkNumber,paymentDate,amount);
			
			DAOPaymentImpl daoImpl = new DAOPaymentImpl();
			
			daoImpl.updatePayment(payment);
		}
		
		response.sendRedirect(request.getContextPath());
	}

}
