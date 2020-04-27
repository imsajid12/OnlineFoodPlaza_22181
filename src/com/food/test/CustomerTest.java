package com.food.test;

import java.util.List;
import java.util.Scanner;

import com.food.dao.CustomerDao;
import com.food.dao.CustomerDaoImplementation;
import com.food.pojo.Customer;

public class CustomerTest {

	public static void main(String[] args) {
		int customerId, choice;
		String customerName, customerEmail, customerPassword, customerContact, customerAddress;
		char ch;
		boolean flag;
		
		Scanner sc = new Scanner(System.in);
		Customer customer = new Customer();
		CustomerDao customerDao= new CustomerDaoImplementation();
		
		do {
			System.out.println(".........Welcome to Food Plaza");
			System.out.println("1. Add Customer Details");
			System.out.println("2. Update Customer Details");
			System.out.println("3. Delete Customer Details");
			System.out.println("4. Show All Customer");
			System.out.println("5. Search Customer By Name or Id or Email");
			System.out.println("----------Enter Your Choice----------");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("----------Add Customer----------");
				System.out.print("Enter Customer's Name: ");
				customerName = sc.next();
				
				System.out.print("Enter Customer's Email: ");
				customerEmail = sc.next();
				
				System.out.print("Enter Customer's Password: ");
				customerPassword = sc.next();
				
				System.out.print("Enter Customer's Contact Number: ");
				customerContact = sc.next();
				sc.nextLine();
				
				System.out.print("Enter Customer's Address: ");
				customerAddress = sc.nextLine();
				
				customer = new Customer(customerName, customerEmail, customerPassword, customerContact, customerAddress);
				flag = customerDao.addCustomer(customer);
				
				if(flag) {
					System.out.println("Customer Added Successfully");
				}
				else {
					System.out.println("Customer Not Added");
				}
				break;
			case 2:
				System.out.println("----------Update Customer----------");
				System.out.println("Enter Customer's Id: ");
				customerId = sc.nextInt();
				
				System.out.print("Enter Customer's Name: ");
				customerName = sc.next();
				
				System.out.print("Enter Customer's Email: ");
				customerEmail = sc.next();
				
				System.out.print("Enter Customer's Password: ");
				customerPassword = sc.next();
				
				System.out.print("Enter Customer's Contact Number: ");
				customerContact = sc.next();
				sc.nextLine();
				
				System.out.print("Enter Customer's Address: ");
				customerAddress = sc.nextLine();
				
				customer = new Customer(customerId, customerName, customerEmail, customerPassword, customerContact, customerAddress);
				flag = customerDao.updateCustomer(customer);
				
				if(flag) {
					System.out.println("Customer Updated Successfully");
				}
				else {
					System.out.println("Customer Not Updated");
				}
				break;
			case 3:
				System.out.println("----------Delete Customer----------");
				System.out.println("Enter Customer's Id: ");
				customerId = sc.nextInt();
				
				flag = customerDao.deleteCustomer(customerId);
				
				if(flag) {
					System.out.println("Customer Deleted Successfully");
				}
				else {
					System.out.println("Customer Not Deleted");
				}
				break;
			case 4:
				System.out.println("----------Show All Customer----------");
				List<Customer> customerList = customerDao.showAllCustomer();
				
				if(customerList != null) {
					for(Customer tempCustomerList : customerList) {
						System.out.println(tempCustomerList);
					}
				}
				else {
					System.out.println("No Customer Available.");
				}
				break;
			case 5:
				System.out.println("----------Search Customer By Name OR Id OR Email----------");
				System.out.println("1. Search Customer By Name");
				System.out.println("2. Search Customer By Id");
				System.out.println("3. Search Customer By Email");
				System.out.println("Enter your choice");
				choice = sc.nextInt();
				
				switch(choice) {
				case 1:
					System.out.println("----------Search Customer By Name----------");
					
					System.out.print("Enter Customer's Name: ");
					customerName = sc.next();
					
					List<Customer> searchCustomerByNameList = customerDao.searchCustomerByName(customerName);
					
					if(searchCustomerByNameList != null) {
						for(Customer tempSearchCustomerByNameList : searchCustomerByNameList) {
							System.out.println(tempSearchCustomerByNameList);
						}
					}
					else {
						System.out.println("Customer Not Found");
					}
					break;
				case 2:
					System.out.println("----------Search Customer By Id----------");
					
					System.out.print("Enter Customer's Id: ");
					customerId = sc.nextInt();
					
					customer = customerDao.searchCustomerById(customerId);
					
					if(customer != null) {
						System.out.println(customer);
					}
					else {
						System.out.println("Customer Not Found");
					}
					break;
				case 3:
					System.out.println("----------Search Customer By Email----------");
					
					System.out.print("Enter Customer's Email: ");
					customerEmail = sc.next();
					
					customer = customerDao.searchCustomerByEmail(customerEmail);
					
					if(customer != null) {
						System.out.println(customer);
					}
					else {
						System.out.println("Customer Not Found");
					}
					break;	
				default:
					System.out.println("You entered a wrong choice");
				}
					
				
				break;
				default:
					System.out.println("Wrong Choice Entered.");
			}
			
			System.out.println("Do you want to continue? If yes enter y");
			ch = sc.next().charAt(0);
		}while(ch == 'y' || ch == 'Y');
	}

}
