package com.dbManager.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //setup connection variables 
		String user = "hbstudent";
		String password = "hbstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/candidate_database_manager?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		//get a connection to the database
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to database: " + jdbcUrl);
			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
			out.println("Connection successfull");
			myConn.close();
			
		} catch(Exception e){
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
