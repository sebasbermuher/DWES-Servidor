package org.iesalixar.servidor.sbh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.sbh.model.ReservaFinal;

/**
 * Servlet implementation class Confirmar
 */
@WebServlet("/Confirmar")
public class Confirmar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Confirmar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();

        if (!sesion.isNew() && sesion.getAttribute("LOGEADO")!=null && ((boolean)sesion.getAttribute("LOGEADO"))) {
            ReservaFinal reserva = new ReservaFinal();
            
            reserva.setFecha_incio((String)sesion.getAttribute("fecha_inicio"));
            reserva.setFecha_final((String)sesion.getAttribute("fecha_fin"));
            reserva.setNum_personas((String)sesion.getAttribute("num_personas"));
            reserva.setServicios((String[])sesion.getAttribute("checkbox"));
           
            
            request.setAttribute("reserva", reserva);
            
        	
        	request.getRequestDispatcher("confirmar.jsp").forward(request, response);
            return;
        } 
        sesion.invalidate();
        response.sendRedirect(request.getContextPath());
	}

	
}
