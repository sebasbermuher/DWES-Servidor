package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Product;

public interface DAOProduct {
//	public Product getProduct(String productCode);
	public Product getProductByCode(String code);
	public ArrayList<Product> getProducts(String productName);
	public ArrayList<Product> getProductSearch(String searchTerm);
}
