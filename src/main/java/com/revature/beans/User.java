package com.revature.beans;

public class User {
	
	private int userId; //serial
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private int numberPosts;
	private boolean isAdmin;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String email, String password, String firstName, String lastName, int numberPosts) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.numberPosts = numberPosts;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getNumberPosts() {
		return numberPosts;
	}
	public void setNumberPosts(int numberPosts) {
		this.numberPosts = numberPosts;
	}
	@Override
	public String toString() {
		return "user [userId=" + userId + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", numberPosts=" + numberPosts + "]";
	}
	
	

}
