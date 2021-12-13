package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Product;

public class DAOProductImpl implements DAOProduct {

	@Override
	public ArrayList<Product> getProduct(String productName) {
		ArrayList<Product> productList = new ArrayList<Product>();

		Product product;
		Connection con = null;

		try {

			String sql = "select * from products where productCode='Trucks and Buses'";

			PoolDB pool = new PoolDB();

			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1, '%' + productName + '%');
			statement.setString(2, '%' + productName + '%');

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				product = new Product();

				product.setProductCode(rs.getString("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMSRP(rs.getDouble("MSRP"));

				productList.add(product);

			}

			con.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return productList;

	}

}
