package com.mydomain.dao;

import java.util.List;
import org.mongodb.morphia.Datastore;
import com.mydomain.model.User;
import com.mydomain.service.ServicesFactory;

public class UserDao {

	public User getUser(String name) {
		Datastore dataStore = ServicesFactory.getMongoDB();
		
		System.out.println( dataStore.createQuery(User.class).field("name")
						.equal(name).get());
		return dataStore.createQuery(User.class).field("name")
						.equal(name).get();
	}

	public List<User> getUsers() {
		
		Datastore dataStore = ServicesFactory.getMongoDB();
		List<User> users = dataStore.createQuery(User.class).asList();
		System.out.println("users = " + users);
		return users;
	}
	
	public void createUser(User u){
		Datastore dataStore = ServicesFactory.getMongoDB();
		dataStore.save(u);
	}

	public void updateUser(User u){
		Datastore dataStore = ServicesFactory.getMongoDB();
		dataStore.save(u);
	}
}