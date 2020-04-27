package com.food.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	static Connection dbConnect = null;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			dbConnect = DriverManager.getConnection("jdbc:mysql://localhost:3306/FoodPlaza_22181", "root", "root1219");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dbConnect;
	}
}
