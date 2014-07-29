package edu.neumont.dbt230;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Blog {
	List<User> users;
	PriorityQueue<Post> posts;
	
	public Blog(){
		this.users = new ArrayList<User>();
		posts = new PriorityQueue<Post>();
	}
	
	public void addUser(User user){
		users.add(user);
	}
	
	public void addPost(Post post){
		posts.add(post);
	}
	
	public List<Post> getPosts(){
		List<Post>_posts = new ArrayList<Post>();
		Iterator it = posts.iterator();
		while(it.hasNext()){
			Post post = (Post)it.next();
			_posts.add(post);
		}
		return _posts;		
	}
	
	public void showPosts(){
		for(Post post: posts){
			System.out.println(post);
		}
	}
	
	public List<User> getUsers(){
		return users;
	}
	
	public String toJson(){
		return this.toJson();
	}
	
	

}
