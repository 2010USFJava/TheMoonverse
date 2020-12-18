package com.revature.beans;

import java.time.LocalDate;
import java.util.ArrayList;

public class Posts {
	
	
	private int postId; //serial
	private int userId;
	private int countLikes;
	private String postText;
	private LocalDate postDate;
	private String postMediaUrl;
	
	public Posts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Posts(int postId, int userId, int countLikes, String postText, LocalDate postDate, String postMediaUrl) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.countLikes = countLikes;
		this.postText = postText;
		this.postDate = postDate;
		this.postMediaUrl = postMediaUrl;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCountLikes() {
		return countLikes;
	}
	public void setCountLikes(int countLikes) {
		this.countLikes = countLikes;
	}
	public String getPostText() {
		return postText;
	}
	public void setPostText(String postText) {
		this.postText = postText;
	}
	public LocalDate getPostDate() {
		return postDate;
	}
	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}
	public String getPostMediaUrl() {
		return postMediaUrl;
	}
	public void setPostMediaUrl(String postMediaUrl) {
		this.postMediaUrl = postMediaUrl;
	}
	@Override
	public String toString() {
		return "Posts [postId=" + postId + ", userId=" + userId + ", countLikes=" + countLikes + ", postText="
				+ postText + ", postDate=" + postDate + ", postMediaUrl=" + postMediaUrl + "]";
	}
	
	
	

}
