package org.iesalixar.servidor.sbh;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadProperties
 */
@WebServlet("/LoadProperties")
public class LoadProperties extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadProperties() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<String> listaPropiedades= new ArrayList<String>();
		
		Properties prop = new Properties();
		InputStream is = null;
		
		try {
			
			//is = new FileInputStream("/src/main/resources/bd.properties");
            prop.load(getClass().getClassLoader().getResourceAsStream("bd.properties"));
			//prop.load(is);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Enumeration e = prop.keys(); e.hasMoreElements();) {
			
			String key = (String) e.nextElement();
			
			listaPropiedades.add(prop.getProperty(key));
		}
		
		
		request.setAttribute("propiedades", listaPropiedades);
		request.getRequestDispatcher("propiedades.jsp").forward(request, response);
	}

}