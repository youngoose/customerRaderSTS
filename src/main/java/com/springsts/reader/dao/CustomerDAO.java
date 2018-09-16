package com.springsts.reader.dao;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import com.opencsv.CSVReader;
import com.springsts.reader.customer.Customer;

public class CustomerDAO {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "eddy";
	private String pw = "jo";

	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; 
	
	private String file_path = new File("D:\\eclipse_workspace\\customerReaderSTS\\src\\main\\java\\com\\springsts\\reader\\file\\customer.csv").getAbsolutePath();
	ArrayList<Customer> customerList = new ArrayList<Customer>();


	public CustomerDAO() {
		try {
			Class.forName(driver);
			this.insertToSQL();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void insertToSQL() {
		
		System.out.println("* * * * * * * * * * * * * *");
		System.out.println("* SQL Database connected! *");
		System.out.println("* * * * * * * * * * * * * *\n");
		System.out.println("=========================================");
		
		try {
				
			con = DriverManager.getConnection(url, id, pw);
			String query = "INSERT INTO CUSTOMER VALUES(CUSTOMER_SEQ.NEXTVAL, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(query);
			
			ArrayList<Customer> customerListToSQL = getCustomerListFromCSV();
			
			for(int i = 0; i < customerListToSQL.size(); i++) {
//				pstmt.setInt(1, customerListToSQL.get(i).getOrderId());
				pstmt.setString(1, customerListToSQL.get(i).getCustomerName());
				pstmt.setString(2, customerListToSQL.get(i).getDeliveryNumber());
				pstmt.setString(3, customerListToSQL.get(i).getProduct());
				pstmt.setString(4, customerListToSQL.get(i).getPrice());
				
				pstmt.executeUpdate();
				System.out.println("Insert data success: " + (i+1));
			}
				
		} catch (Exception e) {
			e.printStackTrace();		
		
		} finally {
			try {
				if(pstmt != null) pstmt.close();
//				if(con != null) con.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}		
	}
	
	
	public ArrayList<Customer> getCustomerListFromCSV() {
		
		CSVReader reader = null;
		
		try {	
			reader = new CSVReader(new FileReader(file_path), ',', '"', 1);
			String[] customerDetail;
			
			
			while ((customerDetail = reader.readNext()) != null) {
				Customer customers = new Customer(Integer.parseInt(customerDetail[0]), customerDetail[1], customerDetail[2], customerDetail[3], customerDetail[4]); 
				customerList.add(customers);
			}
			
			for(Customer c : customerList) {
				System.out.println("Order ID: " + c.getOrderId());
				System.out.println("Customer Name: " + c.getCustomerName());
				System.out.println("Delivery Number: " + c.getDeliveryNumber());
				System.out.println("Product: " + c.getProduct());
				System.out.println("Price: $" + c.getPrice());
				System.out.println("=========================================");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	// insert order method
	
	
	
}

