package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.pojo.Customer;
import com.food.utility.DBConnection;

public class CustomerDaoImplementation implements CustomerDao {
	Connection con = DBConnection.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	int result;
	String sql;
	Customer customer;

	@Override
	public boolean addCustomer(Customer c) {
		
		try {
			sql = "INSERT INTO Customer(customerName, customerEmail, customerPassword, customerContact, customerAddress) values"
					+ "(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, c.getCustomerName());
			ps.setString(2, c.getCustomerEmail());
			ps.setString(3, c.getCustomerPassword());
			ps.setString(4, c.getCustomerContact());
			ps.setString(5, c.getCustomerAddress());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result > 0) {
			return true;
		}else
			return false;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		try {
			sql = "UPDATE Customer SET customerName=?, customerEmail=?, customerPassword=?, customerContact=?, customerAddress=? WHERE customerId = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, c.getCustomerName());
			ps.setString(2, c.getCustomerEmail());
			ps.setString(3, c.getCustomerPassword());
			ps.setString(4, c.getCustomerContact());
			ps.setString(5, c.getCustomerAddress());
			ps.setInt(6, c.getCustomerId());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result > 0) {
			return true;
		}else
			return false;
	}

	@Override
	public boolean deleteCustomer(int custId) {
		try {
			sql = "DELETE FROM Customer WHERE customerId = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, custId);
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result > 0) {
			return true;
		}else
			return false;
	}

	@Override
	public List<Customer> showAllCustomer() {
		List<Customer> list = new ArrayList<>();
		
		try {
			sql = "SELECT * FROM Customer";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				customer = new Customer();
				customer.setCustomerId(rs.getInt(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerEmail(rs.getString(3));
				customer.setCustomerPassword(rs.getString(4));
				customer.setCustomerContact(rs.getString(5));
				customer.setCustomerAddress(rs.getString(6));
				
				list.add(customer);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Customer> searchCustomerByName(String custName) {
		List<Customer> list = new ArrayList<>();
		
		try {
			sql = "SELECT * FROM Customer WHERE customerName = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, custName);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				customer = new Customer();
				customer.setCustomerId(rs.getInt(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerEmail(rs.getString(3));
				customer.setCustomerPassword(rs.getString(4));
				customer.setCustomerContact(rs.getString(5));
				customer.setCustomerAddress(rs.getString(6));
				
				list.add(customer);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Customer searchCustomerById(int custId) {
		try {
			sql = "SELECT * FROM Customer WHERE customerId = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, custId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				customer = new Customer();
				customer.setCustomerId(rs.getInt(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerEmail(rs.getString(3));
				customer.setCustomerPassword(rs.getString(4));
				customer.setCustomerContact(rs.getString(5));
				customer.setCustomerAddress(rs.getString(6));
				
				//return customer;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public Customer searchCustomerByEmail(String custEmail) {
		try {
			sql = "SELECT * FROM Customer WHERE customerEmail = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, custEmail);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				customer = new Customer();
				customer.setCustomerId(rs.getInt(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerEmail(rs.getString(3));
				customer.setCustomerPassword(rs.getString(4));
				customer.setCustomerContact(rs.getString(5));
				customer.setCustomerAddress(rs.getString(6));
				
				//return customer;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;

	}


}
