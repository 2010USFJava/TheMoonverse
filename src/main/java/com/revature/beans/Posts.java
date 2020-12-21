package com.revature.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="posts")
public class Posts {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="post_id")
	private int postId; //serial
	@Column(name="user_id")
	private int userId;
	@Column(name="count_likes")
	private int countLikes;
	@Column(name="post_text")
	private String postText;
	@Column(name="post_date")
	private LocalDate postDate;
	@Column(name="post_media_url")
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
