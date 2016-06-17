package com.mydomain.service;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.mydomain.dao.UserDao;
import com.mydomain.model.Post;
import com.mydomain.model.SessionObject;

@Path("/session")
public class SessionService {
	
	
	@Context
    HttpServletRequest request;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createSession(SessionObject session){
		System.out.println("============================================================");
		System.out.println("Setting field = " + session.getField() + "value = " + session.getValue()+ "into session object");
		System.out.println("============================================================");
		request.getSession().setAttribute(session.getField(), session.getValue());
	}
	
	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSession(@PathParam("param") String field) {
		String value = (String)request.getSession().getAttribute(field); 
		System.out.println("============================================================");
		System.out.println("getting field = " + field + "value = " + value + "from session object");
		System.out.println("============================================================");
		return value;
	}

}
