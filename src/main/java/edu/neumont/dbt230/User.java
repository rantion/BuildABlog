package edu.neumont.dbt230;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String userName;
	private String password;

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString(){
		return "User: "+userName;
	}
	
	public String toJson(){
		return this.toJson();
	}
	
}
