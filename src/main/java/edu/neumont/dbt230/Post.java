package edu.neumont.dbt230;

import java.util.Calendar;
import java.util.List;
import java.util.PriorityQueue;

public class Post implements Comparable {

	private User poster;
	private long postTime;
	private String postContent;
	private PriorityQueue<Comment> comments;
	
	public Post(User poster, String postContent){
		this.poster = poster;
		this.postTime = Calendar.getInstance().getTimeInMillis();
		this.postContent = postContent;
	}
	
	public void addComment(Comment comment){
		comments.add(comment);
	}
	
	
	public User getPoster() {
		return poster;
	}

	public void setPoster(User poster) {
		this.poster = poster;
	}

	public long getPostTime() {
		return postTime;
	}

	public void setPostTime(long postTime) {
		this.postTime = postTime;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}	

	public PriorityQueue<Comment> getComments() {
		return comments;
	}

	public void setComments(PriorityQueue<Comment> comments) {
		this.comments = comments;
	}

	public String toString(){
		return "Poster: "+poster+" PostTime: "+postTime+" Post: "+postContent+"\n"+
				"Comments: "+comments+"\n";
	}
	
	public String toJson(){
		return this.toJson();
	}

	public int compareTo(Object o) {
		int result = 0;
		if(o instanceof Post){
			Post other = (Post)o;
			if(other.postTime>this.postTime){
				result = 1;
			}
			else{
				result = -1;
			}
		}
		return result;
	}
	
}
