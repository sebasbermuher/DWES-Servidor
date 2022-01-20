package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.DAOCustomerImpl;
import org.iesalixar.servidor.dao.DAOEmployeesImpl;
import org.iesalixar.servidor.model.Customer;
import org.iesalixar.servidor.model.Employees;

/**
 * Servlet implementation class AddCustomerServlet
 */
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Logger logger = Logger.getLogger(AddCustomerServlet.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOEmployeesImpl daoEmp = new DAOEmployeesImpl();
		
		request.setAttribute("employees", daoEmp.getAllEmployees());

		request.getRequestDispatcher("../WEB-INF/view/admin/addCustomer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerNumber = Integer.parseInt(request.getParameter("customerNumber"));
		String customerName = (String) request.getParameter("customerName");
		String contactLastName = (String) request.getParameter("contactLastName");
		String contactFirstName = (String) request.getParameter("contactFirstName");
		String phone = (String) request.getParameter("phone");
		String addressLine1 = (String) request.getParameter("addressLine1");
		String addressLine2 = (String) request.getParameter("addressLine2");
		String city = (String) request.getParameter("city");
		String state = (String) request.getParameter("state");
		String postalCode = (String) request.getParameter("postalCode");
		String country = (String) request.getParameter("country");
		String empleados = (String) request.getParameter("empleados");
		double creditLimit = Double.parseDouble(request.getParameter("creditLimit"));

		DAOCustomerImpl daoCust = new DAOCustomerImpl();
		DAOEmployeesImpl daoEmpl = new DAOEmployeesImpl();
		
		Employees empleado = new Employees();
		empleado = daoEmpl.getEmpleado(empleados);
		
		Customer customer= new Customer();
				
		customer.setCustomerNumber(customerNumber);
		customer.setCustomerName(customerName);
		customer.setContactLastName(contactLastName);
		customer.setContactFirstName(contactFirstName);
		customer.setPhone(phone);
		customer.setAddressLine1(addressLine1);
		customer.setAddressLine2(addressLine2);
		customer.setCity(city);
		customer.setState(state);
		customer.setPostalCode(postalCode);
		customer.setCountry(country);
		customer.setCreditLimit(creditLimit);
		
		daoCust.insertCustomer(customer);
		

		logger.log(Level.INFO, "Customer " + customer.getCustomerName() + " añadido");
		
		response.sendRedirect(request.getContextPath() + "/Admin/AddCustomerServlet");
		
		
	}

}