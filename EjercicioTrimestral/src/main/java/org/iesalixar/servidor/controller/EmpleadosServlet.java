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
 * Servlet implementation class EmpleadosServlet
 */
@WebServlet("/EmpleadosServlet")
public class EmpleadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOEmployeeImpl daoEmployeeImpl = new DAOEmployeeImpl();

		ArrayList<Employee> listaEmployee = (ArrayList) daoEmployeeImpl.getAllEmployee();

		request.setAttribute("listaEmpleados", listaEmployee);
		request.getRequestDispatcher("../WEB-INF/view/admin/empleados.jsp").forward(request, response);
		
		
	}

}
