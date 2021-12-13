//package org.iesalixar.servidor.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.iesalixar.servidor.db.PoolDB;
//import org.iesalixar.servidor.model.Usuario;
//
//public class DAOEmployeeImpl implements DAOUsuario {
//
//	@Override
//	public Usuario getUsuario(String nombre) {
//
//		Usuario usuario = null;
//		Connection con = null;
//
//		try {
//
//			String sql = "select * from usuarios where usuario= ?";
//
//			PoolDB pool = new PoolDB();
//			con = pool.getConnection();
//			PreparedStatement statement = con.prepareStatement(sql);
//
//			ResultSet rs = statement.executeQuery();
//
//			while (rs.next()) {
//
//				usuario = new Usuario();
//
//				usuario.setUsuario(rs.getString("usuario"));
//				usuario.setPassword(rs.getString("password"));
//				usuario.setEmail(rs.getString("email"));
//				usuario.setRole(rs.getString("role"));
//				usuario.setFirstName(rs.getString("firstName"));
//				usuario.setLastName(rs.getString("lastName"));
//
//			}
//
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//		} finally {
//			try {
//				con.close();
//			} catch (SQLException ex) {
//				System.out.println(ex.getMessage());
//			}
//		}
//
//		return usuario;
//
//	}
//	
//	@Override
//	public boolean registerUsuario(Usuario usuario) {
//
//		int resultado = 0;
//		Connection con = null;
//
//		try {
//
//			String sql = "insert into usuarios values(?,?,?,?,?,?)";
//			PoolDB pool = new PoolDB();
//			con = pool.getConnection();
//			PreparedStatement statement = con.prepareStatement(sql);
//
//			statement.setString(1, usuario.getUsuario());
//			statement.setString(3, usuario.getPassword());
//			statement.setString(2, usuario.getEmail());
//			statement.setString(4, usuario.getRole());
//			statement.setString(4, usuario.getFirstName());
//			statement.setString(5, usuario.getLastName());
//
//			resultado = statement.executeUpdate();
//
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//		} finally {
//			try {
//				con.close();
//			} catch (SQLException ex) {
//				System.out.println(ex.getMessage());
//			}
//		}
//
//		return (resultado == 0 ? false : true);
//
//	}
//
//}