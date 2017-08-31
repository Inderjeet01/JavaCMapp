package com.customermanagement.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.ws.Response;

import com.customermanagment.model.Customer;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DatabaseHelper {

	private java.sql.Connection connection;

	/**
	 * This constructor is used to load the mysql driver
	 */
	
	public DatabaseHelper() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	
	/**
	 * Makes connection with mysql database
	 */
	public void openConnection() {
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/customers", "root", "Password-here");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public java.sql.Connection getConnection(){
		return connection;
	}

	
	/**Used to register a customer
	 * 
	 * @param newCustomer is used to register a new customer into mysql database, all details of customer will 
	 * be stored into customerdetails table in database  
	 */
	public void registerCustomer(Customer newCustomer) {
		
		try {
			Customer customer = new Customer();

			java.sql.PreparedStatement preparedStatement = connection
					.prepareStatement("insert into customersdata values(?,?,?,?,?)");
			preparedStatement.setObject(1, newCustomer.getName());
			preparedStatement.setObject(2, newCustomer.getEmail());
			preparedStatement.setObject(3, newCustomer.getPassword());
			preparedStatement.setObject(4, newCustomer.getAddress());
			preparedStatement.setObject(5, newCustomer.getDateofBirth());
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getResultSet();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
