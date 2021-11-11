package org.iesalixar.servidor.sbh.model;

import java.io.Serializable;

public class Payment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int customerNumber;
	private String checkNumber;
	private String paymentDate;
	private Double amount;
	
	public Payment() {
	}
	
	
	
	public Payment(int customerNumber, String checkNumber, String paymentDate, Double amount) {
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}



	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}


}
