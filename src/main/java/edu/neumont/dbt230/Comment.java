package edu.neumont.dbt230;

import java.util.Calendar;
import java.util.Date;

public class Comment implements Comparable {
	
	private User poster;
	private long postTime;
	private String comment;
	
	public Comment(User poster, String comment){
		this.poster = poster;
		this.postTime = Calendar.getInstance().getTimeInMillis();
		this.comment = comment;		
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



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}



	public String toString(){
		return "Poster: "+poster+" PostTime: "+postTime+" Comment: "+comment+"\n";
	}
	
	public String toJson(){
		return this.toJson();
	}
	
	public int compareTo(Object o) {
		int result = 0;
		if(o instanceof Comment){
			Comment other = (Comment)o;
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
