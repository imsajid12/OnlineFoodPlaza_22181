package com.food.dao;

import java.util.List;

import com.food.pojo.Orders;

public interface OrdersDao {

	Orders placeOrder(String customeremail);

	List<Orders> showAllOrder();

	List<Orders> showMyOrder(String customeremail);
}
