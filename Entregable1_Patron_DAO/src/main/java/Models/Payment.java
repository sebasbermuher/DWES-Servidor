package Models;

public class Payment {
	private final Integer customerNumber;
	private final String checkNumber;
	private final String paymentDate;
	private final double amount;
	
	
	public Payment(Integer customerNumber, String checkNumber, String paymentDate, double amount) {
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}


	public Integer getCustomerNumber() {
		return customerNumber;
	}


	public String getCheckNumber() {
		return checkNumber;
	}


	public String getPaymentDate() {
		return paymentDate;
	}


	public double getAmount() {
		return amount;
	}


	@Override
	public String toString() {
		return "Payment [customerNumber=" + customerNumber + ", checkNumber=" + checkNumber + ", paymentDate="
				+ paymentDate + ", amount=" + amount + "]";
	}
	
	
}
