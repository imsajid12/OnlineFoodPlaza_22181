package com.food.dao;

public interface LoginDao {
	boolean userLogin(String emailId, String password);
	boolean userChangePassword(String emailId, String password);
	boolean adminLogin(String userName, String password);
	boolean adminChangePassword(String userName, String password);
}
