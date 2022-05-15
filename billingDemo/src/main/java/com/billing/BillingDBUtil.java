package com.billing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BillingDBUtil {
	
	public static List<Billing> validate(String userName, String password){
		
		ArrayList<Billing> bil = new ArrayList<>();
		
		String url = "jdbc:mysql://localhost:3306/billing";
		String user = "root";
		String pass = "mana1998";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			
			String sql = "select * from billing where username='"+userName+"' and password='"+password+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int bid = rs.getInt(1);
				String cid = rs.getString(2);
				String name = rs.getString(3);
				String phone = rs.getNString(4);
				String units = rs.getString(5);
				String bill = rs.getString(6);
				String userU = rs.getString(7);
				String passU = rs.getString(8);
				
				Billing b = new Billing(bid,cid,name,phone,units,bill,userU,passU);
				bil.add(b);
				
				
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return bil;
		
	}

}
