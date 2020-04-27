package com.food.test;

import java.util.List;
import java.util.Scanner;

import com.food.dao.OrdersDao;
import com.food.dao.OrdersDaoImplementation;
import com.food.pojo.Orders;

public class OrdersTest {

	public static void main(String[] args) {

		int orderId, choice;
		double totalPrice;
		String customerEmail, orderStatus, orderDate;
		char ch;
		boolean flag;

		Scanner scan = new Scanner(System.in);

		Orders o = new Orders();
		OrdersDao od = new OrdersDaoImplementation();

		do {

			System.out.println("-------Orders------");
			System.out.println("1. Place Order");
			System.out.println("2. Show all Order");
			System.out.println("3. Show My Order");

			System.out.println("--------Enter Your Choice--------");
			choice = scan.nextInt();

			switch (choice) {

			case 1:
				System.out.println("-------------Place Order------------");
				System.out.println("Enter Customer Email");
				customerEmail = scan.next();
				o.setCustomerEmail(customerEmail);
				o = od.placeOrder(customerEmail);

				if (o != null) {
					System.out.println("Order placed Successfull");

				} else {
					System.out.println("Order not placed");
				}
				break;

			case 2:
				System.out.println("Show all order");
				List<Orders> list = od.showAllOrder();

				if (list != null) {
					for (Orders o1 : list) {
						System.out.println(o1);
					}
				} else {
					System.out.println("No orders available");
				}

				break;

			case 3:
				System.out.println("Show all order");

				System.out.println("Enter Customer Email");
				customerEmail = scan.next();
				List<Orders> list1 = od.showMyOrder(customerEmail);

				if (list1 != null) {
					for (Orders o1 : list1) {
						System.out.println(o1);
					}
				} else {
					System.out.println("No orders available");
				}

				break;

			default:
				System.out.println("Wrong Choice Entered");

			}
			System.out.println("Do you want to continue? If yes enter y");
			ch = scan.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');

	}

}
