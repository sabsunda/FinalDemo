package com.mydomain.service;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/signup")
public class SignupService {
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public boolean startSignup() {		
		return true;
	}
		
}

