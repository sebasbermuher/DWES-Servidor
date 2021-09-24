package BDSingleton;

import java.sql.*;

public class ConexionBD {

	public static Connection con=null;
	private static final String conUrl = "jdbc:mariadb://localhost:3336/classicmodels?user=root&password=12345"
			+ "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	public static Connection getConnection() {
		try {

			if (con == null) {
				con = DriverManager.getConnection(ConexionBD.conUrl);

				System.out.println("Conexión realizada correctamente");
			}

		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}return con;
		
	}
	
	public static void close() {
		try {
			if (con != null) con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

}
