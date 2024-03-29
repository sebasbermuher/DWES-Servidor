package org.iesalixar.servidor.sbh.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.sbh.bd.ConexionBD;
import org.iesalixar.servidor.sbh.model.Payment;

public class DAOPaymentImpl implements DAOPayment {

	@Override
	public List<Payment> getAllPayment() {
		ArrayList<Payment> paymentsList = new ArrayList<>();

		try {

			String sql = "select * from payments";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Payment payment = new Payment();

				payment.setCustomerNumber(rs.getInt("customerNumber"));
				payment.setCheckNumber(rs.getString("checkNumber"));
				payment.setPaymentDate(rs.getString("paymentDate"));
				payment.setAmount(rs.getDouble("amount"));

				paymentsList.add(payment);

			}

			ConexionBD.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return paymentsList;
	}

	@Override
	public Payment getPayment(int customerNumber, String checkNumber) {

		Payment payment = null;

		try {

			String sql = "select * from payments where customerNumber = ? and checkNumber = ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setInt(1, customerNumber);
			statement.setString(2, checkNumber);

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				payment = new Payment();

				payment.setCustomerNumber(rs.getInt("customerNumber"));
				payment.setCheckNumber(rs.getString("checkNumber"));
				payment.setPaymentDate(rs.getString("paymentDate"));
				payment.setAmount(rs.getDouble("amount"));

			}

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return payment;
	}

	@Override
	public boolean removePayment(int customerNumber, String checkNumber) {

		int resultado=0;
		
		try {

			String sql = "delete from payments where customerNumber = ? and checkNumber = ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setInt(1, customerNumber);
			statement.setString(2, checkNumber);

			resultado = statement.executeUpdate();

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado==0?false:true);

	}

	@Override
	public boolean updatePayment(Payment payment) {
		
		int resultado=0;
		
		try {

			String sql = "update payments set paymentDate= ?, amount=? where customerNumber = ? and checkNumber = ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setInt(1, payment.getCustomerNumber());
			statement.setString(2, payment.getCheckNumber());
			statement.setString(3,payment.getPaymentDate());
			statement.setDouble(4, payment.getAmount());


			resultado = statement.executeUpdate();

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado==0?false:true);
	
	}

	

}
