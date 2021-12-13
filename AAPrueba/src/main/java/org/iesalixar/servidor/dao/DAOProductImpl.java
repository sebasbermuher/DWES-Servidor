package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.db.PoolDB;
import org.iesalixar.servidor.model.Productos;

public class DAOProductImpl implements DAOProductos {

	@Override
	public List<Productos> getAllProducts() {
		ArrayList<Productos> productList = new ArrayList<>();
		Productos product;
		Connection con = null;

		try {

			String sql = "select * from products";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				product = new Productos();

				product.setProductName(rs.getString("productCode"));
				product.setProductCode(rs.getString("productName"));
				product.setProductLine(rs.getString("productLine"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				productList.add(product);

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

		return productList;
	}
}