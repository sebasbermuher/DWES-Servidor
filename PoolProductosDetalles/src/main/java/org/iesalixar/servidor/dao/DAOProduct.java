package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Producto;

public interface DAOProduct {
	public Producto getProducts(String productName);
	public List<Producto> getAllProducts();
	public int getDetallesNumPedidos(String productCode);
	public int getDetallesNumProductasVentas(String productCode);
	public double getDetallesNumVentas(String productCode);
}