package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.food.pojo.Orders;
import com.food.utility.DBConnection;

public class OrdersDaoImplementation implements OrdersDao {

	Connection con = DBConnection.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	int result;
	String sql, orderDate;
	Orders o;
	double totalPrice;

	@Override
	public Orders placeOrder(String customerEmail) {

		try {
			Date d = new Date();
			orderDate = d.toString();

			sql = "select sum(f.foodPrice * ca.quantity) from Cart ca inner join Food f on f.foodId=ca.foodId where customerEmail=?";

			ps = con.prepareStatement(sql);

			ps.setString(1, customerEmail);

			rs = ps.executeQuery();

			while (rs.next()) {

				totalPrice = rs.getDouble(1);
			}

			sql = "insert into Orders(totalPrice,customerEmail,orderStatus,orderDate)values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setDouble(1, totalPrice);
			ps.setString(2, customerEmail);
			ps.setString(3, "Processing---");
			ps.setString(4, orderDate);

			result = ps.executeUpdate();

			new CartDaoImplementation().deleteFromCartByCustomerEmail(customerEmail);

			sql = "select * from Orders";
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				o = new Orders();
				o.setOrderId(rs.getInt(1));
				o.setTotalPrice(rs.getDouble(2));
				o.setCustomerEmail(rs.getString(3));
				o.setOrderStatus(rs.getString(4));
				o.setOrderDate(rs.getString(5));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public List<Orders> showAllOrder() {

		List<Orders> list = new ArrayList<>();
		try {

			sql = "select * from Orders";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				o = new Orders();
				o.setOrderId(rs.getInt(1));
				o.setTotalPrice(rs.getDouble(2));
				o.setCustomerEmail(rs.getString(3));
				o.setOrderStatus(rs.getString(4));
				o.setOrderDate(rs.getString(5));
				list.add(o);

			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Orders> showMyOrder(String customerEmail) {
		List<Orders> list = new ArrayList<>();
		try {

			sql = "select * from Orders where customerEmail=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, customerEmail);
			rs = ps.executeQuery();

			while (rs.next()) {

				o = new Orders();
				o.setOrderId(rs.getInt(1));
				o.setTotalPrice(rs.getDouble(2));
				o.setCustomerEmail(rs.getString(3));
				o.setOrderStatus(rs.getString(4));
				o.setOrderDate(rs.getString(5));
				list.add(o);

				return list;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public int placeOrder(String customerEmail, double totalBill) {
		double totalBills = 0;
		String date = new Date().toString();
		try {
			ps = con.prepareStatement("INSERT INTO Orders(customerEmail, totalPrice, orderStatus, orderDate) values(?,?,?,?)");
			ps.setString(1, customerEmail);
			ps.setDouble(2, totalBill);
			ps.setString(3, "processing");
			ps.setString(4, date);
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean clearCart(String customerEmail) {
		try {
			ps = con.prepareStatement("DELETE FROM Cart WHERE cutomerEmail = ?");
			ps.setString(1, customerEmail);
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result > 0)
			return true;
		else
			return false;
	}

}
