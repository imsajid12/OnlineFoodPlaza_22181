package com.food.test;

import java.util.List;
import java.util.Scanner;

import com.food.dao.CartDao;
import com.food.dao.CartDaoImplementation;
import com.food.pojo.Cart;

public class CartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cartId,foodId, quantity, choice;
		String foodName, foodCategory, customerEmail;
		double foodPrice;
		char ch;
		boolean flag;
		
		Scanner sc = new Scanner(System.in);
		Cart cart = new Cart();
		CartDao cartDao = new CartDaoImplementation();
		
		do {
			System.out.println(".........Welcome to Food Plaza");
			System.out.println("1. Add Food to Cart");
			System.out.println("2. Update Card Details");
			System.out.println("3. Delete Food From Cart By CartId or by Customer Email");
			System.out.println("4. Show All Cart Items");
			System.out.println("5. Search From Cart By CartId or Customer Email");
			System.out.println("----------Enter Your Choice----------");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("----------Add Food to Cart----------");
				System.out.print("Enter Food Id: ");
				foodId = sc.nextInt();
				
				System.out.print("Enter Food Quantity: ");
				quantity = sc.nextInt();
				
				System.out.print("Enter Customer's Email: ");
				customerEmail = sc.next();
				
				cart = new Cart(foodId, quantity, customerEmail);
				flag = cartDao.addToCart(cart);
				
				if(flag) {
					System.out.println("Food Added to Cart");
				}
				else {
					System.out.println("Food Not Added to Cart");
				}
				break;
			case 2:
				System.out.println("----------Update Cart Details----------");
				System.out.print("Enter Cart Id: ");
				cartId = sc.nextInt();
				
				System.out.print("Enter Food Id: ");
				foodId = sc.nextInt();
				
				System.out.print("Enter Customer's Email: ");
				customerEmail = sc.next();
				
				System.out.println("Enter Food Quantity: ");
				quantity = sc.nextInt();
				
				cart = new Cart(cartId, foodId, quantity, customerEmail);
				flag = cartDao.updateCart(cart);
				
				if(flag) {
					System.out.println("Cart Details Successfully Updated");
				}
				else {
					System.out.println("Cart Details Not Updated");
				}
				break;
			case 3:
				System.out.println("----------Delete Food From Cart By CartId or by Customer Email----------");
				System.out.println("1. Delete Food From Cart By CartId");
				System.out.println("2. Delete Food From Cart By Customer Email");
				System.out.println("Enter your choice");
				choice = sc.nextInt();
				
				switch(choice) {
				case 1:
					System.out.println("----------Delete Food From Cart By CartId----------");
					System.out.print("Enter Cart Id: ");
					cartId = sc.nextInt();
					
					flag = cartDao.deleteFromCartById(cartId);
					if(flag) {
						System.out.println("Cart Deleted Successfully");
					}
					else {
						System.out.println("Cart Not Deleted");
					}
					break;
				case 2:
					System.out.println("----------Delete Food From Cart By Customer Email----------");
					System.out.print("Enter Customer's Email: ");
					customerEmail = sc.next();
					
					flag = cartDao.deleteFromCartByCustomerEmail(customerEmail);
					if(flag) {
						System.out.println("Cart Deleted Successfully");
					}
					else {
						System.out.println("Cart Not Deleted");
					}
					break;
					default:
						System.out.println("Wrong Choice Entered");
				}
				break;
			case 4:
				System.out.println("----------Show Cart Items----------");
				List<Cart> cartList = cartDao.showCart();
				
				if(cartList != null) {
					for(Cart tempCartList : cartList) {
						System.out.println(tempCartList);
					}
				}
				else {
					System.out.println("No items available in cart");
				}
				break;
			case 5:
				System.out.println("----------Search From Cart By CartId or Customer Email----------");
				System.out.println("1. Search From Cart By CartId");
				System.out.println("2. Search From Cart By Customer Email");
				choice = sc.nextInt();
				
				switch(choice) {
				case 1:
					System.out.println("----------Search From Cart By CartId----------");
					System.out.print("Enter Cart Id: ");
					cartId = sc.nextInt();
					
					cart = cartDao.searchFromCartById(cartId);
					if(cart != null) {
						System.out.println(cart);
					}
					else {
						System.out.println("Cart Not Found");
					}
					break;
				case 2:
					System.out.println("----------Search From Cart By Customer Email----------");
					System.out.print("Enter Customer's Email: ");
					customerEmail = sc.next();
					
					cart = cartDao.searchFromCartByCustomerEmail(customerEmail);
					if(cart != null) {
						System.out.println(cart);
					}
					else {
						System.out.println("Cart Not Found");
					}
					break;
					default:
					System.out.println("Wrong Choice Entered");
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
