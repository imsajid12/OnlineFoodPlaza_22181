package com.food.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.food.pojo.Food;
import com.food.utility.DBConnection;

public class FoodDaoImplementation implements FoodDao {
	
	Connection con = DBConnection.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	int result;
	String sql;
	Food f;

	@Override
	public boolean addFood(Food f) {
		try {
			sql = "INSERT INTO Food(foodName, foodCategory, foodPrice, foodImage) values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, f.getFoodName());
			ps.setString(2, f.getFoodCategory());
			ps.setDouble(3, f.getFoodPrice());
			ps.setString(4, f.getFoodImage());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean updateFood(Food f) {
		try {
			sql = "UPDATE Food SET foodName = ?, foodCategory = ?, foodPrice = ?, foodImage = ? WHERE foodId = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, f.getFoodName());
			ps.setString(2, f.getFoodCategory());
			ps.setDouble(3, f.getFoodPrice());
			ps.setString(4, f.getFoodImage());
			ps.setInt(5, f.getFoodId());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean deleteFood(int id) {
		try {
			sql = "DELETE FROM Food WHERE foodId = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		if(result > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<Food> showAllFood() {
		List<Food> list = new ArrayList<>();
		
		try {
			sql = "SELECT * FROM Food";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				f = new Food();
				f.setFoodId(rs.getInt(1));
				f.setFoodName(rs.getString(2));
				f.setFoodCategory(rs.getString(3));
				f.setFoodPrice(rs.getDouble(4));
				f.setFoodImage(rs.getString(5));
				
				list.add(f);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*finally {
			try {
				con.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		return list;
	}

	@Override
	public Food searchFoodById(int foodId) {
		try {
			sql = "SELECT * FROM Food WHERE foodId = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, foodId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				f = new Food();
				f.setFoodId(rs.getInt(1));
				f.setFoodName(rs.getString(2));
				f.setFoodCategory(rs.getString(3));
				f.setFoodPrice(rs.getDouble(4));
				f.setFoodImage(rs.getString(5));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public List<Food> searchFoodByName(String foodName) {
		List<Food> list = new ArrayList<>();
		try {
			sql = "SELECT * FROM Food WHERE foodName = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, foodName);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				f = new Food();
				f.setFoodId(rs.getInt(1));
				f.setFoodName(rs.getString(2));
				f.setFoodCategory(rs.getString(3));
				f.setFoodPrice(rs.getDouble(4));
				
				list.add(f);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
