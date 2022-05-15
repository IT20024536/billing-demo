package com.billing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class MySQLDBConnection {
	Connection con = null;
	Statement stmt = null;
	
	public void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test2", "root", "");
            
            stmt = con.createStatement();
            
            stmt.executeUpdate("insert into user_tab (name, email, password) values('Thisun', 'jayamaduthisun@gmail.com', 1)");
            
            stmt.close();
            
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(MySQLDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        	System.out.println(ex);
        }
    }
	
	public boolean validateUser(String username, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
            
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test2", "root", "");
            
//            stmt = con.createStatement();
//            
//            stmt.executeUpdate("insert into user_tab (username, password) values("+ 'username' + "," + password + ")");
//            java.sql.PreparedStatement stmt= con.prepareStatement("insert into user_tab (username, password) values(?,?)");  
//            stmt.setString(1, username);
//            stmt.setString(2, password);  
//              
//            int i=stmt.executeUpdate();  
//            System.out.println(i+" records inserted");  
            
            java.sql.PreparedStatement stmt = con.prepareStatement("select * from user_tab where username = ? and password = ?"); 
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();  
            
            while(rs.next()){  
            	System.out.println(rs.getString(2)+" "+rs.getString(3)); 
            	stmt.close();
                con.close();
            	return true;
            }  
            
            stmt.close();
            con.close();
        	return false;
            
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println(ex);
		}
		return false;
	}
	
	public void billInsert(String name, String phone, float units, float bill) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
            
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test2", "root", "");
            
            java.sql.PreparedStatement stmt = con.prepareStatement("insert into bills (name, phone, units, bill) values (?, ?, ?, ?)");
            
            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.setFloat(3, units);
            stmt.setFloat(4, bill);
            
            int i = stmt.executeUpdate();
            
            stmt.close();
            con.close();
		}
		catch (Exception ex) {
			throw ex;
		}
	}
	
	public void billUpdate(String name, String phone, int id) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
            
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test2", "root", "");
            
            java.sql.PreparedStatement stmt = con.prepareStatement("update bills set name = ?, phone = ? where bid = ?");
            
            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.setInt(3, id);
            
            int i = stmt.executeUpdate();
            
            stmt.close();
            con.close();
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	public void billDelete(int id) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
            
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test2", "root", "");
            
            java.sql.PreparedStatement stmt = con.prepareStatement("delete from bills where bid = ?");
            
            stmt.setInt(1, id);
            
            int i = stmt.executeUpdate();
            
            System.out.print(i);
            
            stmt.close();
            con.close();
		}
		catch(Exception ex) {
			throw ex;
		}
	}
}
