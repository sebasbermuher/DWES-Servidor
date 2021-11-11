package org.iesalixar.servidor.sbh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.sbh.dao.DAOProductLineImpl;
import org.iesalixar.servidor.sbh.model.ProductLine;

/**
 * Servlet implementation class Insert
 */

public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoria = request.getParameter("producto");
		String texto = request.getParameter("textDescription");
		String html = request.getParameter("htmlDescription");
		
		if(categoria!=null && texto!=null && html!=null) {
			
			DAOProductLineImpl daoImpl = new DAOProductLineImpl();
			
			if(daoImpl.getProductLine(categoria)==null) {
				ProductLine pl = new ProductLine(categoria,texto,html);
				daoImpl.createProductLine(pl);
				response.sendRedirect(request.getContextPath());
			}else {
				request.setAttribute("error", "Categoria ya exitente");
				request.setAttribute("producto", categoria);
				request.setAttribute("texto", texto);
				request.setAttribute("html", html);
				doGet(request,response);
			}
			
			
			
		}
		
	}

}
