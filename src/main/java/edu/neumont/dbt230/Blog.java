package edu.neumont.dbt230;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Blog {
	List<User> users;
	PriorityQueue<Post> posts;
	
	public Blog(){
		this.users = new ArrayList<User>();
	}
	
	public void addUser(User user){
		users.add(user);
	}
	
	

}
