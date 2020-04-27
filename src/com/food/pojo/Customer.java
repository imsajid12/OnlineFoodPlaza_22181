package com.food.pojo;

public class Customer {

	private int customerId;
	private String customerName, customerEmail, customerPassword, customerContact, customerAddress;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String customerName, String customerEmail, String customerPassword, String customerContact,
			String customerAddress) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerContact = customerContact;
		this.customerAddress = customerAddress;
	}

	public Customer(int customerId, String customerName, String customerEmail, String customerPassword,
			String customerContact, String customerAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerContact = customerContact;
		this.customerAddress = customerAddress;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerPassword=" + customerPassword + ", customerContact=" + customerContact
				+ ", customerAddress=" + customerAddress + "]";
	}
	
	
}
