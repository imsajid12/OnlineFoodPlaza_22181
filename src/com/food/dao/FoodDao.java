package com.food.dao;

import java.util.List;

import com.food.pojo.Food;

public interface FoodDao {
	
	boolean addFood(Food f);
	boolean updateFood(Food f);
	boolean deleteFood(int id);
	
	List<Food> showAllFood();
	Food searchFoodById(int foodId);
	List<Food> searchFoodByName(String foodName);

}
