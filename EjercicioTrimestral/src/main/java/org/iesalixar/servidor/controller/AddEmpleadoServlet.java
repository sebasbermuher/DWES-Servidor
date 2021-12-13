package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOEmployeeImpl;
import org.iesalixar.servidor.model.Employee;

/**
 * Servlet implementation class AddEmpleadoServlet
 */
@WebServlet("/AddEmpleadoServlet")
public class AddEmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEmpleadoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOEmployeeImpl dao = new DAOEmployeeImpl();

		ArrayList<Employee> listaEmpleados = (ArrayList) dao.getAllEmployee();

		request.setAttribute("employees", listaEmpleados);

		request.getRequestDispatcher("/WEB-INF/view/admin/addempleados.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int employeeNumber = Integer.parseInt(request.getParameter("employeeNumber"));
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String extension = request.getParameter("extension");
		String jobTitle = request.getParameter("jobTitle");

		if (employeeNumber != 0 && lastName != null && firstName != null && extension != null && jobTitle != null) {
			Employee employee = new Employee(employeeNumber, lastName, firstName, extension, jobTitle);
			DAOEmployeeImpl daoPaymentImpl = new DAOEmployeeImpl();
			daoPaymentImpl.insertEmployee(employee);
		}

	}

}
