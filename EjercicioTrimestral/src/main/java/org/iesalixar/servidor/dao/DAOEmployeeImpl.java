package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Employee;

public class DAOEmployeeImpl implements DAOEmployee {

	@Override
	public List<Employee> getAllEmployee() {
		ArrayList<Employee> employeeList = new ArrayList<>();
		Employee employee;
		Connection con = null;

		try {
			String sql = "select * from employees";

			PoolDB pool = new PoolDB();

			con = pool.getConnection();

			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				employee = new Employee();

				employee.setEmployeeNumber(rs.getInt("employeeNumber"));
				employee.setLastName(rs.getString("lastName"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setJobTitle(rs.getString("jobTitle"));

				employeeList.add(employee);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return employeeList;
	}

	@Override
	public boolean insertEmployee(Employee listadoEmployee) {
		int resultado = 0;
		Connection con = null;

		try {
			String sql = "insert into productlines values (?, ?, ?, ?, ?)";

			PoolDB pool = new PoolDB();

			con = pool.getConnection();

			PreparedStatement statement = con.prepareStatement(sql);


			statement.setInt(1, listadoEmployee.getEmployeeNumber());
			statement.setString(2, listadoEmployee.getLastName());
			statement.setString(3, listadoEmployee.getFirstName());
			statement.setString(4, listadoEmployee.getExtension());
			statement.setString(5, listadoEmployee.getJobTitle());



			resultado = statement.executeUpdate();

		} catch (

		SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return (resultado == 0 ? false : true);

	}

}