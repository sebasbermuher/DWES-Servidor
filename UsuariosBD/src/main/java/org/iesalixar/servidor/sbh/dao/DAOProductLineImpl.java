//package org.iesalixar.servidor.sbh.dao;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.iesalixar.servidor.sbh.bd.ConexionBD;
//import org.iesalixar.servidor.sbh.model.ProductLine;
//
//public class DAOProductLineImpl implements DAOProductLine {
//
//	@Override
//	public List<ProductLine> getAllProductLine() {
//		ArrayList<ProductLine> ProductLineList = new ArrayList<>();
//
//		try {
//
//			String sql = "select * from productlines";
//			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
//
//			ResultSet rs = statement.executeQuery();
//
//			while (rs.next()) {
//
//				ProductLine productLine = new ProductLine();
//
//				productLine.setProductLine(rs.getString("productLine"));
//				productLine.setTextDescription(rs.getString("textDescription"));
//				productLine.setHtmlDescription(rs.getString("htmlDescription"));
//
//
//				ProductLineList.add(productLine);
//
//			}
//
//			ConexionBD.close();
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//		}
//
//		return ProductLineList;
//	}
//
//	@Override
//	public ProductLine getProductLine(String productLine) {
//
//		ProductLine productLine1 = null;
//
//		try {
//
//			String sql = "select * from productlines where productLine = ?";
//			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
//			statement.setString(1, productLine);
//
//			ResultSet rs = statement.executeQuery();
//
//			
//			while (rs.next()) {
//
//				productLine1 = new ProductLine();
//
//				productLine1.setProductLine(rs.getString("productLine"));
//				productLine1.setTextDescription(rs.getString("textDescription"));
//				productLine1.setHtmlDescription(rs.getString("htmlDescription"));
//				
//
//			}
//
//			ConexionBD.close();
//
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//		}
//
//		return productLine1;
//	}
//
//	@Override
//	public boolean removeProductLine(String productLine) {
//
//		int resultado=0;
//		
//		try {
//
//			String sql = "delete from productlines where productLine = ?";
//			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
//			statement.setString(1, productLine);
//
//			resultado = statement.executeUpdate();
//
//			ConexionBD.close();
//
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//		}
//
//		return (resultado==0?false:true);
//
//	}
//
//	@Override
//	public boolean updateProductLine(ProductLine productLine) {
//		
//		int resultado=0;
//		
//		try {
//
//			String sql = "update productlines set textDescription = ?, htmlDescription = ? where productLine = ?";
//			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
//			statement.setString(1, productLine.getTextDescription());
//			statement.setString(2, productLine.getHtmlDescription());
//			statement.setString(3, productLine.getProductLine());
//			
//
//
//			resultado = statement.executeUpdate();
//
//			ConexionBD.close();
//
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//		}
//
//		return (resultado==0?false:true);
//	
//	}
//	
//	@Override
//	public boolean createProductLine(ProductLine productLine) {
//		
//		int resultado=0;
//		
//		try {
//			String sql = "insert into productlines values (?, ?, ?, null)";
//            PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
//            statement.setString(2, productLine.getTextDescription());
//            statement.setString(3, productLine.getHtmlDescription());
//            statement.setString(1, productLine.getProductLine());
//			
//
//
//			resultado = statement.executeUpdate();
//
//			ConexionBD.close();
//
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//		}
//
//		return (resultado==0?false:true);
//	
//	}
//
//	
//
//}
