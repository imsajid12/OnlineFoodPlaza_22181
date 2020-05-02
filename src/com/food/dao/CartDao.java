package com.food.dao;

import java.util.List;

import com.food.pojo.Cart;

public interface CartDao {
	boolean addToCart(Cart cart);
	boolean updateCart(Cart cart);
	boolean deleteFromCartById(int cartId);
	boolean deleteFromCartByCustomerEmail(String customerEmail);
	
	List<Cart> showCart();
	Cart searchFromCartById(int cartId);
	List<Cart> searchFromCartByCustomerEmail(String customerEmail);
}
