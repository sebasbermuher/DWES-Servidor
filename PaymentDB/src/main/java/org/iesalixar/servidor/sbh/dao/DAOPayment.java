package org.iesalixar.servidor.sbh.dao;

import java.util.List;

import org.iesalixar.servidor.sbh.model.Payment;

public interface DAOPayment {
		
	public List<Payment> getAllPayment();
	public Payment getPayment(int customerNumber,String checkNumber);
	public boolean removePayment(int customerNumber,String checkNumber);
	public boolean updatePayment(Payment payment);
	
	

}
