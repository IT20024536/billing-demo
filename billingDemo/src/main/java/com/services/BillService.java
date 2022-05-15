package com.services;
import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;  

@Path("/UserService")
public class BillService {
	
	@GET 
	@Path("/users") 
	@Produces(MediaType.APPLICATION_XML) 
	public String getUsers() {
		return "fjhdada";
		
	}
}
