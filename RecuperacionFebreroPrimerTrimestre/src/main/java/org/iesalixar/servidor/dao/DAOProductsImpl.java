package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Products;

public class DAOProductsImpl implements DAOProducts {

	@Override
	public ArrayList<Products> getAllProducts() {

		ArrayList<Products> productsrList = new ArrayList<>();
		Connection con = null;

		try {

			String sql = "select * from products";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Products product = new Products();

				product.setProductCode(rs.getString("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMSRP(rs.getDouble("MSRP"));

				productsrList.add(product);
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

		return productsrList;

	}

	@Override
	public ArrayList<Products> getProduct(String categoria) {

		ArrayList<Products> productsList = new ArrayList<>();
		Products product;
		Connection con = null;

		try {

			String sql = "select * from products where productLine=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, categoria);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				product = new Products();

				product.setProductCode(rs.getString("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getNString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMSRP(rs.getDouble("MSRP"));

				productsList.add(product);

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

		return productsList;

	}

	@Override
	public Products getProductByCode(String code) {
		Products product = null;
		Connection con = null;

		try {

			String sql = "select * from products where  productCode=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, code);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				product = new Products();
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getString("productScale"));
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return product;

	}

	@Override
	public boolean insertProduct(Products product) {
		int resultado = 0;
		Connection con = null;

		try {

			String sql = "insert into products values(?,?,?,?,?,?,?,?)";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, product.getProductCode());
			statement.setString(2, product.getProductName());
//			statement.setString(3, product.getProductLine());
			statement.setString(3, product.getProductScale());
			statement.setString(4, product.getProductVendor());
			statement.setString(5, product.getProductDescription());
			statement.setInt(6, product.getQuantityInStock());
			statement.setDouble(7, product.getBuyPrice());
			statement.setDouble(8, product.getMSRP());
			
			resultado = statement.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return (resultado == 0 ? false : true);
	}

}
