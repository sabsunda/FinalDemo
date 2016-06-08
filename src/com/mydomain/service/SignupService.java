package com.mydomain.service;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.mydomain.dao.UserDao;
import com.mydomain.model.User;



@Path("/signup")
public class SignupService {
	
	@Context
    HttpServletRequest request;
	public UserDao userDao = new UserDao();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public User getSignedUser() {		
		System.out.println("user = " + (String)request.getSession().getAttribute("user"));
		return userDao.getUser((String)request.getSession().getAttribute("user"));
		
	}
	
	@GET
	@Path("/{param}")
	public void signout(@PathParam("param") String name) {
		request.getSession().setAttribute("user", null);
	}

		
}

