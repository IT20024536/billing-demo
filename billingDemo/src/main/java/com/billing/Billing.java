package com.billing;

public class Billing {
	private int bID;
	private String cID;
	private String name;
	private String phone;
	private String units;
	private String bill;
	private String userName;
	private String password;
	public Billing(int bID, String cID, String name, String phone, String units, String bill, String userName,String password) {
		
		this.bID = bID;
		this.cID = cID;
		this.name = name;
		this.phone = phone;
		this.units = units;
		this.bill = bill;
		this.userName = userName;
		this.password = password;
	}
	public int getbID() {
		return bID;
	}
	
	public String getcID() {
		return cID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getUnits() {
		return units;
	}
		public String getBill() {
		return bill;
	}
	
	public String getUserName() {
		return userName;
	}
		public String getPassword() {
		return password;
	}
	      
	
	
	

}
