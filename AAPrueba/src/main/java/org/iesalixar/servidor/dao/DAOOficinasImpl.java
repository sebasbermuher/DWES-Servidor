package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.iesalixar.servidor.db.PoolDB;
import org.iesalixar.servidor.model.Oficinas;

public class DAOOficinasImpl implements DAOOficinas {

	@Override
	public Oficinas getOficinas(String city) {
		Oficinas oficinas = null;
		Connection con = null;

		try {

			String sql = "select * from offices where city= ?";

			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				oficinas = new Oficinas();

				oficinas.setOfficeCode(rs.getString("officeCode"));
				oficinas.setCity(rs.getString("city"));
				oficinas.setPhone(rs.getString("phone"));
				oficinas.setAddressLine1(rs.getString("addressLine1"));
				oficinas.setAddressLine2(rs.getString("addressLine2"));
				oficinas.setState(rs.getString("state"));
				oficinas.setCountry(rs.getString("country"));
				oficinas.setPostalCode(rs.getString("postalCode"));
				oficinas.setTerritory(rs.getString("territory"));

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}

		return oficinas;
	}

}
