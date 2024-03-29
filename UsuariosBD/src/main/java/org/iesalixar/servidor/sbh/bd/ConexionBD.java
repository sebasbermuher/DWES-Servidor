package org.iesalixar.servidor.sbh.bd;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;

public class ConexionBD {

	private static Connection connection = null;
	private static String host = null;
	private static String port = null;
	private static String usuario = null;
	private static String password = null;

	public ConexionBD() {
		// TODO Auto-generated constructor stub
	}

	public static Connection getConnection() {
		
		//Obtenemos los datos de la conexión del fichero de propiedades
		//Solo lo hago la primera vez (Etoy dando por supuesto que no cambio 
		//de servidor de BD
		if (host==null && port==null && usuario==null && password ==null) {
		
			try {
				
				Properties prop = new Properties();
				InputStream is = null;
				
				is = ConexionBD.class.getClassLoader().getResourceAsStream("bd.properties");
				prop.load(is);
				
				
				for (Enumeration e = prop.keys(); e.hasMoreElements();) {
					
					String key = (String) e.nextElement();
					
					switch (key) {
						case "server":
							host = prop.getProperty(key);
							break;
						case "port":
							port = prop.getProperty(key);
							break;
						case "user":
							usuario = prop.getProperty(key);
							break;
						case "password":
							password = prop.getProperty(key);
							break;
					}
					
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				
			}
			
		}		
		
		try {
			
			if (connection==null || connection.isClosed()) {				
				
				try {
					Class.forName("org.mariadb.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				String connectionString = "jdbc:mariadb://"+host+":"+port+"/classicmodels?user="+usuario+"&password="+password+
						"&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";				
				connection = DriverManager.getConnection(connectionString);
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return connection;
		
	}

	public static void close() {

		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}