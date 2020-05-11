package com.food.dao;

import java.util.List;

import com.food.pojo.Orders;

public interface OrdersDao {

	Orders placeOrder(String customeremail);
	
	Orders placeOrder(String customerEmail, double totalBill);

	List<Orders> showAllOrder();

	List<Orders> showMyOrder(String customeremail);
	
	boolean clearCart(String customerEmail);
}
