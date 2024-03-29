package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOOficinasImpl;
import org.iesalixar.servidor.model.Offices;

/**
 * Servlet implementation class OficinaServlet
 */

public class OficinaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OficinaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOOficinasImpl daoImpl = new DAOOficinasImpl();

        ArrayList<Offices> listaOficinas = (ArrayList) daoImpl.getAllOficinas();
        
        request.setAttribute("oficinas", listaOficinas);

        request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	}

}