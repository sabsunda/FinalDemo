package com.mydomain.dao;
import java.util.List;
import org.mongodb.morphia.Datastore;
import com.mydomain.model.Post;
import com.mydomain.service.ServicesFactory;

public class PostDao {

	public Post getPost(String title) {
		Datastore dataStore = ServicesFactory.getMongoDB();
		return dataStore.createQuery(Post.class).field("title")
						.equal(title).get();
	}

	public List<Post> getPosts() {
		
		Datastore dataStore = ServicesFactory.getMongoDB();
		List<Post> posts = dataStore.createQuery(Post.class).asList();
		System.out.println("posts = " + posts);
		return posts;
	}
	
	public List<Post> getPostsByCategory(String category) {
		Datastore dataStore = ServicesFactory.getMongoDB();
		List<Post> posts = dataStore.createQuery(Post.class).field("category").equal(category).asList();
		System.out.println("posts = " + posts);
		return posts;
	}

	public List<Post> getPostsByCategoryAndtag(String category, String tag) {
		Datastore dataStore = ServicesFactory.getMongoDB();
		List<Post> posts = dataStore.createQuery(Post.class).field("category").equal(category).field("tag").equal(tag).asList();
		System.out.println("posts = " + posts);
		return posts;
	}
	
	public void createPost(Post p){
		Datastore dataStore = ServicesFactory.getMongoDB();
		dataStore.save(p);
	}
	
	public void updatePost(Post p){
		Datastore dataStore = ServicesFactory.getMongoDB();
		dataStore.save(p);
	}


}