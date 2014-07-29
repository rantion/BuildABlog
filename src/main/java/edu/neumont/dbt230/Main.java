package edu.neumont.dbt230;

import java.util.List;
import java.util.Scanner;

/**
 * Created by jjensen on 7/28/14.
 */
public class Main {
	private static Blog blog = new Blog();
    public static void main(String[] args) {

    	User rachel = new User("rantion", "password");
    	User jon = new User("jon","password");
    	User caleb = new User("caleb", "password");
    	User glenn = new User("glenn", "password");
    	
    	blog.addUser(rachel);
    	blog.addUser(jon);
    	blog.addUser(caleb);
    	blog.addUser(glenn);
    	
    	Post post = new Post(rachel, "This is a post");
    	Post post1 = new Post(jon, "This is another post");
    	Comment comment = new Comment(rachel, "comment");
    	post.addComment(comment);
    	
    	blog.addPost(post);
    	blog.addPost(post1);
    	
    	User user = getUser();
    	while(true){
    	getOption(user);
    	}
    	
    	
    	
    }
    
    public static void getOption(User user){
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter 1 to view the blog");
    	System.out.println("Enter 2 to make a post");
    	System.out.println("Enter 3 to comment on a post");
    	System.out.println("Enter 4 to exit");
    	String option = scan.next();
    	if(option.equals("1")){
    		blog.showPosts();
    	}
    	else if(option.equals("2")){
    		System.out.println("Enter your post: \n");
    		String postContent = scan.nextLine();
    		Post post = new Post(user, postContent);
    		blog.addPost(post);
    	}
    	else if(option.equals("3")){
    		List<Post> posts = blog.getPosts();
    		System.out.println("Enter the number of the Post you would like to comment on\n");
    		for(int i = 0; i<posts.size(); i++){
    			System.out.println(i+") "+posts.get(i).toString());
    		}
    		String index = scan.next();
    		Post postToComment = posts.get(Integer.parseInt(index));
    		System.out.println("Enter your comment: \n");
    		String _comment = scan.nextLine();
    		Comment comment = new Comment(user, _comment);
    		postToComment.addComment(comment);
    	}
    	else if(option.equals("4")){
    		System.exit(0);
    	}
    	else{
    		getOption(user);
    	}
    }
    
     public static User getUser(){

    	Scanner scan = new Scanner(System.in);
    	User user = null;
    	System.out.println("Enter 1 if you are a new User");
    	System.out.println("Enter 2 if you are a returning User");
    	String option = scan.next();
    	if(option.equals("1")){
    		System.out.println("Enter your UserName");
    		String userName = scan.next();
    		System.out.println("Enter your Password");
    		String password = scan.next();
    		user = new User(userName, password);
    		blog.addUser(user);
    	}
    	else if(option.equals("2")){
    		System.out.println("Enter the Number of your UserName \n");
    		List<User> users = blog.getUsers();
    		for(int i = 0; i<users.size(); i++){
    			System.out.println(i+") "+ users.get(i).getUserName());
    		}
    		String index = scan.next();
    		user = users.get(Integer.parseInt(index));
    	}
    	else{
    		getUser();
    	}
    	return user;
    }
}
