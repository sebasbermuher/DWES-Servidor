package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.db.PoolDB;
import org.iesalixar.servidor.model.Producto;

public class DAOProductImpl implements DAOProduct {

	@Override
	public Producto getProducts(String productCode) {
		Producto product = null;
		Connection con = null;

		try {

			String sql = "select * from products where productCode=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();

			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1, productCode);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				product = new Producto();

				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getNString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMSRP(rs.getDouble("MSRP"));

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

		return product;
	}

	@Override
	public List<Producto> getAllProducts() {

		ArrayList<Producto> productList = new ArrayList<>();
		Producto product;
		Connection con = null;

		try {

			String sql = "select * from products";

			PoolDB pool = new PoolDB();
			con = pool.getConnection();

			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				product = new Producto();

				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getNString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMSRP(rs.getDouble("MSRP"));

				productList.add(product);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return productList;
	}

	@Override
	public int getDetallesNumPedidos(String productCode) {

		Connection con = null;
		int total = 0;

		try {

			String sql = "select count(*) from orderdetails where productCode= ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, productCode);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				total = rs.getInt(1);
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

		return total;
	}

	@Override
	public int getDetallesNumProductasVentas(String productCode) {

		Connection con = null;
		int total = 0;

		try {

			String sql = "select SUM(quantityOrdered) from orderdetails where productCode= ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, productCode);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				total = rs.getInt(1);
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

		return total;
	}

	@Override
	public double getDetallesNumVentas(String productCode) {

		Connection con = null;
		double total = 0;

		try {

			String sql = "select (sum(quantityOrdered)*priceEach) from orderdetails where productCode= ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, productCode);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				total = rs.getDouble(1);
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

		return total;
	}
}
