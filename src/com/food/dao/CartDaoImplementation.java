package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.pojo.Cart;
import com.food.utility.DBConnection;

public class CartDaoImplementation implements CartDao{
	Connection con = DBConnection.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	int result;
	String sql;
	Cart cart;
	
	@Override
	public boolean addToCart(Cart cart) {
		try {
			sql = "INSERT INTO Cart(foodId, quantity, customerEmail) values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cart.getFoodId());
			ps.setInt(2, cart.getQuantity());
			ps.setString(3, cart.getCustomerEmail());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			sql = "UPDATE Cart SET foodId = ?, customerEmail = ?, quantity = ? WHERE cartId = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cart.getFoodId());
			ps.setString(2, cart.getCustomerEmail());
			ps.setInt(3, cart.getQuantity());
			ps.setInt(4, cart.getCartId());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteFromCartById(int cartId) {
		try {
			sql = "DELETE FROM Cart WHERE cartId = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cartId);
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteFromCartByCustomerEmail(String customerEmail) {
		try {
			sql = "DELETE FROM Cart WHERE customerEmail = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, customerEmail);
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public List<Cart> showCart() {
		List<Cart> list = new ArrayList<>(); 
		try {
			sql = "SELECT * FROM Cart INNER JOIN Food ON Food.foodId = Cart.foodId";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cart = new Cart();
				cart.setCartId(rs.getInt("cartId"));
				cart.setFoodId(rs.getInt("foodId"));
				cart.setQuantity(rs.getInt("quantity"));
				cart.setFoodName(rs.getString("foodName"));
				cart.setFoodCategory(rs.getString("foodCategory"));
				cart.setCustomerEmail(rs.getString("customerEmail"));
				
				//Multiplying food quantity with (price of per food)
				cart.setFoodPrice(rs.getDouble("foodPrice") * cart.getQuantity());
				
				list.add(cart);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Cart searchFromCartById(int cartId) {
		try {
			sql = "SELECT * FROM Cart INNER JOIN Food ON Food.foodId = Cart.foodId WHERE cartId = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cartId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cart = new Cart();
				cart.setCartId(rs.getInt("cartId"));
				cart.setFoodId(rs.getInt("foodId"));
				cart.setQuantity(rs.getInt("quantity"));
				cart.setFoodName(rs.getString("foodName"));
				cart.setFoodCategory(rs.getString("foodCategory"));
				cart.setCustomerEmail(rs.getString("customerEmail"));
				
				//Multiplying food quantity with (price of per food)
				cart.setFoodPrice(rs.getDouble("foodPrice") * cart.getQuantity());
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cart;
	}

	@Override
	public List<Cart> searchFromCartByCustomerEmail(String customerEmail) {
		List<Cart> list = new ArrayList<>();
		try {
			sql = "SELECT * FROM Cart INNER JOIN Food ON Food.foodId = Cart.foodId WHERE customerEmail = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, customerEmail);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cart = new Cart();
				cart.setCartId(rs.getInt("cartId"));
				cart.setFoodId(rs.getInt("foodId"));
				cart.setQuantity(rs.getInt("quantity"));
				cart.setFoodName(rs.getString("foodName"));
				cart.setFoodCategory(rs.getString("foodCategory"));
				cart.setCustomerEmail(rs.getString("customerEmail"));
				
				//Multiplying food quantity with (price of per food)
				cart.setFoodPrice(rs.getDouble("foodPrice") * cart.getQuantity());
				
				list.add(cart);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
