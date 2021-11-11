package org.iesalixar.servidor.sbh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Reserva
 */
@WebServlet("/Reserva")
public class Reserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reserva() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        if (!sesion.isNew() && sesion.getAttribute("LOGEADO")!=null && ((boolean)sesion.getAttribute("LOGEADO"))) {
            request.getRequestDispatcher("reserva.jsp").forward(request, response);
            return;
        } 
        sesion.invalidate();
        response.sendRedirect(request.getContextPath());
    }

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();

        if (!sesion.isNew() && sesion.getAttribute("LOGEADO")!=null && ((boolean)sesion.getAttribute("LOGEADO"))) {

            if ( request.getParameter("reserva")!=null && request.getParameter("reserva").equals("RESERVAR")) {

                if (request.getParameter("fecha_inicio")!=null && request.getParameter("fecha_fin")!=null
                        && request.getParameter("num_personas")!=null) {
                	
                    sesion.setAttribute("fecha_inicio", (request.getParameter("fecha_inicio")));
                    sesion.setAttribute("fecha_fin", (request.getParameter("fecha_fin")));
                    sesion.setAttribute("num_personas", (request.getParameter("num_personas")));
                    sesion.setAttribute("checkbox", request.getParameterValues("checkbox"));
                              

                }

                response.sendRedirect(request.getContextPath()+"/Confirmar");
                return;

            } else {
                response.sendRedirect(request.getContextPath()+"/Reserva");
                return;

            }

        }

    }
}