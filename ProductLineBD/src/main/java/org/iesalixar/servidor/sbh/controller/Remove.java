package org.iesalixar.servidor.sbh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.sbh.dao.DAOProductLineImpl;

/**
 * Servlet implementation class Remove
 */

public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Remove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productLine = request.getParameter("productLine");
		
		
		DAOProductLineImpl daoImpl = new DAOProductLineImpl();
		
		if(productLine!=null){
			daoImpl.removeProductLine(productLine);
		}
		
		response.sendRedirect(request.getContextPath());
	}

}
