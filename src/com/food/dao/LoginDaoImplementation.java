package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.food.utility.DBConnection;

public class LoginDaoImplementation implements LoginDao {
	int row = 0;
	Connection con = DBConnection.getConnection();
	ResultSet rs;
	PreparedStatement ps;
	boolean flag;
	
	@Override
	public boolean userLogin(String emailId, String password) {
		try {
			ps = con.prepareStatement("SELECT * FROM Customer WHERE customerEmail=? AND customerPassword = ?");
			ps.setString(1,  emailId);
			ps.setString(2,  password);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				flag = true;
			} else {
				flag = false;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean userChangePassword(String emailId, String password) {
		try {
			ps = con.prepareStatement("UPDATE Customer SET customerPassword = ? WHERE customerEmail = ?");
			ps.setString(1, password);
			ps.setString(2, emailId);
			
			row = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(row > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean adminLogin(String userName, String password) {
		try {
			ps = con.prepareStatement("SELECT * FROM Admin WHERE adminUserName=? AND adminPassword = ?");
			ps.setString(1,  userName);
			ps.setString(2,  password);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				flag = true;
			} else {
				flag = false;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean adminChangePassword(String userName, String password) {
		try {
			ps = con.prepareStatement("UPDATE Admin SET adminPassword = ? WHERE adminUserName = ?");
			ps.setString(1, password);
			ps.setString(2, userName);
			
			row = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(row > 0) {
			return true;
		}
		else {
			return false;
		}
	}

}
