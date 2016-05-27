package com.mydomain.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.mydomain.dao.UserDao;
import com.mydomain.model.User;

@Path("/user")
public class UserService {
	
	public UserDao userDao = new UserDao(); 
	
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}

	@GET
	@Path("/{param}")
	@Produces({MediaType.APPLICATION_JSON})
	public User getUser(@PathParam("param") String name) {
		return userDao.getUser(name);
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<User> getUsers() {
		return userDao.getUsers();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createUser(User u){
		userDao.createUser(u);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateUser(User u){
		userDao.updateUser(u);
	}
}