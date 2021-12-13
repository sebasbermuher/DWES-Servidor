package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.OrderDetail;
import org.iesalixar.servidor.model.Product;

public class DAOOrderDetailsImpl implements DAOOrderDetails {

	@Override
	public ArrayList<OrderDetail> getDetailsFromOrder(int orderNumber) {
		ArrayList<OrderDetail> orderdetails = new ArrayList<OrderDetail>();

		OrderDetail od = null;
		Product product = null;
		try {

			String sql = "select * from orderdetails where orderNumber = ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);

			statement.setInt(1, orderNumber);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				od = new OrderDetail();

				od.setOrderLineNumber(rs.getInt("orderLineNumber"));
				od.setPriceEach(rs.getDouble("priceEach"));
				od.setQuantityOrdered(rs.getInt("quantityOrdered"));

				String productCode = rs.getString("productCode");

				DAOProductImpl daoProduct = new DAOProductImpl();

				product = daoProduct.getProductByCode(productCode);

				od.setProduct(product);

				orderdetails.add(od);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			ConexionBD.close();
		}

		return orderdetails;

	}

}
