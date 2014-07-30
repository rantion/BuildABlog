package edu.neumont.dbt230;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Blog {
	List<User> users;
	PriorityQueue<Post> posts;
	private CassandraInteraction cassandra;

    public Blog(){
		this.users = new ArrayList<User>();
		posts = new PriorityQueue<Post>();
        cassandra = new CassandraInteraction();
	}
	
	public void addUser(User user){
		cassandra.addUser(user);
	}
	
	public void addPost(Post post){
		cassandra.addPost(post);
	}
	
	public List<Post> getPosts(){
		List<Post>_posts = new ArrayList<Post>();
		posts = cassandra.getAllPosts();
        Iterator it = posts.iterator();
		while(it.hasNext()){
			Post post = (Post)it.next();
			_posts.add(post);
		}
		return _posts;		
	}
	
	public void showPosts(){
        posts = cassandra.getAllPosts();
		for(Post post: posts){
			System.out.println(post);
		}
	}
	
	public List<User> getUsers(){
		return cassandra.getAllUsers();
	}
	
	public String toJson(){
		return this.toJson();
	}
	
	

}
