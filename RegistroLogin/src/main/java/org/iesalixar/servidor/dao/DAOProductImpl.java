package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.Product;

public class DAOProductImpl implements DAOProduct {

	@Override
	public ArrayList<Product> getProducts(String productName) {
		ArrayList<Product> productList = new ArrayList<Product>();

		Product product;

		try {

			String sql = "select * from products where productName LIKE ? OR productLine LIKE ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);

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
				product.setMsrp(rs.getDouble("MSRP"));

				productList.add(product);

			}

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return productList;

	}

//	@Override
//	public Product getProduct(String productName) {
//		
//		Product product = null;
//
//		try {
//
//			String sql = "select * from products where  productName=?";
//			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
//			statement.setString(1, productName);
//			
//
//			ResultSet rs = statement.executeQuery();
//
//			// Como el campo de búsqueda es la clave solo debería obtener un resultado
//			// si no es así estaremos machacando cada vez el valor de customer y
//			while (rs.next()) {
//
//				product = new Product();
//				product.setProductName(rs.getString("productName"));
//				product.setProductCode(rs.getString("productCode"));
//				product.setProductLine(rs.getString("productLine"));
//				product.setProductScale(rs.getString("productScale"));
//				product.setProductVendor(rs.getString("productVendor"));
//				product.setProductDescription(rs.getString("productDescription"));
//				product.setQuantityInStock(rs.getInt("quantityInStock"));
//				product.setBuyPrice(rs.getDouble("buyPrice"));
//				product.setMsrp(rs.getDouble("MSRP"));
//
//			}
//
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//		} finally {
//			ConexionBD.close();
//		}
//
//		return product;
//
//	}

	@Override
	public ArrayList<Product> getProductSearch(String searchTerm) {

		ArrayList<Product> products = new ArrayList<Product>();
		Product product = null;

		try {

			String sql = "select * from products where  productName LIKE ? OR productLine LIKE ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, "%" + searchTerm + "%");
			statement.setString(2, "%" + searchTerm + "%");

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				product = new Product();
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMsrp(rs.getDouble("MSRP"));

				products.add(product);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			ConexionBD.close();
		}

		return products;
	}

	@Override
	public Product getProductByCode(String code) {
		Product product = null;

		try {

			String sql = "select * from products where  productCode=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, code);

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				product = new Product();
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMsrp(rs.getDouble("MSRP"));

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			ConexionBD.close();
		}

		return product;

	}
}