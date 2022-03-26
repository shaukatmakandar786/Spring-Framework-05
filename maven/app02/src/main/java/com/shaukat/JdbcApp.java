package com.shaukat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp {

	Connection con;
	Statement st;
	ResultSet rs;
	
	public JdbcApp()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
			st = con.createStatement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void displayEmpDetails()
	{
		try
		{
			rs=st.executeQuery("select * from emp1");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("-------------------------");
			while(rs.next()) {
				
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getFloat(3)+"\t");	
				System.out.println(rs.getString(4));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
