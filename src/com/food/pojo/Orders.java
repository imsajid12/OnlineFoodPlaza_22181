package com.food.pojo;

public class Orders {

	private int orderId;
	private double totalPrice;
	private String customerEmail, orderStatus, orderDate;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(double totalPrice, String customerEmail, String orderStatus, String orderDate) {
		super();
		this.totalPrice = totalPrice;
		this.customerEmail = customerEmail;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
	}

	public Orders(int orderid, double totalPrice, String customerEmail, String orderStatus, String orderDate) {
		super();
		this.orderId = orderid;
		this.totalPrice = totalPrice;
		this.customerEmail = customerEmail;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Orders [orderid=" + orderId + ", totalprice=" + totalPrice + ", customeremail=" + customerEmail
				+ ", orderstatus=" + orderStatus + ", orderdate=" + orderDate + "]";
	}

}
