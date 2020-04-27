package com.food.test;

import java.util.List;
import java.util.Scanner;

import com.food.dao.FoodDao;
import com.food.dao.FoodDaoImplementation;
import com.food.pojo.Food;

public class FoodTest {

	public static void main(String[] args) {
		int foodId, choice, searchChoice;
		String foodName, foodCategory, foodImage=null;
		double foodPrice;
		char ch;
		boolean flag;
		
		Scanner sc = new Scanner(System.in);
		Food f = new Food();
		FoodDao foodDao = new FoodDaoImplementation();
		
		do {
			System.out.println(".........Welcome to Food Plaza");
			System.out.println("1. Add Food");
			System.out.println("2. Update Food");
			System.out.println("3. Delete Food");
			System.out.println("4. Show All Food");
			System.out.println("5. Search Food By Name or Id");
			System.out.println("----------Enter Your Choice----------");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("----------Add Food----------");
				System.out.print("Enter Food Name: ");
				foodName = sc.next();
				
				System.out.print("Enter Food Category: ");
				foodCategory = sc.next();
				
				System.out.print("Enter Food Price: ");
				foodPrice = sc.nextDouble();
				
				f = new Food(foodName, foodCategory, foodPrice, foodImage);
				flag = foodDao.addFood(f);
				
				if(flag) {
					System.out.println("Food added sucessfully..........");
				}
				else {
					System.out.println("Food not added..........");
				}
				break;
			case 2:
				System.out.println("----------Update Existing Food----------");
				System.out.println("Enter Food Id: ");
				foodId = sc.nextInt();
				
				System.out.print("Enter Food Name: ");
				foodName = sc.next();
				
				System.out.print("Enter Food Category: ");
				foodCategory = sc.next();
				
				System.out.print("Enter Food Price: ");
				foodPrice = sc.nextDouble();
				
				f = new Food(foodId, foodName, foodCategory, foodPrice, foodImage);
				
				flag = foodDao.updateFood(f);
				if(flag) {
					System.out.println("Food updated sucessfully..........");
				}
				else {
					System.out.println("Food not updated..........");
				}
				
				System.out.println();
				break;
			case 3:
				System.out.println("----------Delete Food----------");
				System.out.print("Enter Food Id: ");
				foodId = sc.nextInt();
				
				flag = foodDao.deleteFood(foodId);
				
				if(flag) {
					System.out.println("Deleted Successfully");
				}
				else {
					System.out.println("Food Not Deleted");
				}
				break;
			case 4:
				System.out.println("----------Show All Food----------");
				List<Food> list = foodDao.showAllFood();
				
				if(list != null) {
					for(Food tempFoodList : list) {
						System.out.println(tempFoodList);
					}
				}
				else {
					System.out.println("No food available");
				}
				break;
			case 5:
				System.out.println("----------Search Food By Name OR Id----------");
				System.out.println("1. Search By Name");
				System.out.println("2. Search By Id");
				System.out.println("Enter your choice");
				searchChoice = sc.nextInt();
				
				switch(searchChoice) {
				case 1:
					System.out.println("----------Search Food By Name----------");
					System.out.print("Enter Food Name: ");
					foodName = sc.next();
					
					List<Food> searchByNameList = foodDao.searchFoodByName(foodName);
					
					if(searchByNameList != null) {
						for(Food tempSearchByNameList : searchByNameList) {
							System.out.println(tempSearchByNameList);
						}
					} else {
						System.out.println("No such food found");
					}
					
					break;
				case 2:
					System.out.println("----------Search Food By Id----------");
					System.out.print("Enter Food Id: ");
					foodId = sc.nextInt();
					
					//f.setFoodId(foodId);
					f = foodDao.searchFoodById(foodId);
					if(f != null) {
						System.out.println(f);
					}
					else {
						System.out.println("No such food found");
					}
					break;
					default:
						
				}
				
				
				break;
				default:
					System.out.println("Wrong Choice Entered");
			}
			
			System.out.println("Do you want to continue? If yes enter y");
			ch = sc.next().charAt(0);
		}while(ch == 'y' || ch == 'Y');
	}

}
