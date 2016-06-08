package com.mydomain.model;

import java.io.IOException;
import java.util.Base64;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import com.mydomain.dao.UserDao;

public class BasicAuthentication {
	public UserDao userDao = new UserDao(); 
	
	public void setUser(UserDao userDao){
		this.userDao = userDao;
	}

	public boolean authenticate(String authCredentials, HttpServletRequest hreq) {

		if (authCredentials == null)
		{	System.out.println("authCredentials is null");
			return false;
		}
		// header value format will be "Basic encoded string" for Basic
		// authentication. Example "Basic YWRtaW46YWRtaW4="
		final String encodedUserPassword = authCredentials.replaceFirst("Basic"+ " ", "");
		String usernameAndPassword = null;
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(encodedUserPassword);
			usernameAndPassword = new String(decodedBytes, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();

		System.out.println(username);
		System.out.println(password);
		// we have fixed the userid and password as admin
		// call some UserService/LDAP here
		User user = userDao.getUser(username);
		
		System.out.println(user);
		boolean authenticationStatus = false;
		if(user != null){
			authenticationStatus = user.getName().equals(username)
					&& user.getPassword().equals(password);
			
			if(authenticationStatus)
				hreq.getSession().setAttribute("user", username);
			
		}		
		return authenticationStatus;
	}
}