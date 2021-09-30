package BDSingleton;

import java.sql.*;
import java.util.*;
import Models.Payment;

public class ClassicModels_DAO{
	
	public static List<Payment> getPayment(){
		Connection con = ConexionBD.getConnection();
		ArrayList<Payment> lista_Payments = new ArrayList<Payment>();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from payments");

			while (rs.next()) {
				Payment p = new Payment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
				lista_Payments.add(p);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return lista_Payments;
	}
}
