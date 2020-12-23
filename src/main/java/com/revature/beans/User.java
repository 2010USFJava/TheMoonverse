package com.revature.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column (name="User_id")
	private int userId; //serial
	
	@Column (name="email", nullable = false)
	private String email;
	
	@Column (name="password", nullable = false)
	private String password;
	
	@Column (name="first_name", nullable = false)
	private String firstName;
	
	@Column (name="last_name", nullable = false)
	private String lastName;
	
	@Column (name="number_posts")
	private int numberPosts;
	
	@Column (name="is_admin")
	private boolean isAdmin;
	
	@Column(name="birth_date")
	private LocalDate birthDate;
	
	public User() {
		super();
			}
	public User(int userId, String email, String password, String firstName, String lastName, int numberPosts,Boolean isAdmin, LocalDate birthDate) {
		super();
		
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.numberPosts = numberPosts;
		this.isAdmin = isAdmin;
		this.birthDate = birthDate;
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
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "user [userId=" + userId + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", numberPosts=" + numberPosts + "Is an administrator: " +isAdmin+ "]";
	}
	
	

}
