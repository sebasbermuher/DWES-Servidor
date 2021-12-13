package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.ProductLine;

public class DAOProductLineImpl implements DAOProductLine{

	@Override
	public List<ProductLine> getAllProductLine() {
		ArrayList <ProductLine> productlineList = new ArrayList<>();
		ProductLine productline;
        Connection con = null;

        try {
            String sql = "select * from productlines";
            
            PoolDB pool = new PoolDB();

			con = pool.getConnection();
			
            PreparedStatement statement = con.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            
           

            while (rs.next()) {

            	productline = new ProductLine();

            	productline.setProductLine(rs.getString("productLine"));          
                
            	productlineList.add(productline);

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

        return productlineList;
	}

}
