package com.revature.beans;

import java.time.LocalDate;

public class Profile {

	private int profileId; //serial
	private String aboutMe;
	private int age;
	private String city;
	private String profession;
	private LocalDate birthDate;
	private String favoritePlanet;
	private String profilePicture;
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profile(int profileId, String aboutMe, int age, String city, String profession, LocalDate birthDate,
			String favoritePlanet, String profilePicture) {
		super();
		this.profileId = profileId;
		this.aboutMe = aboutMe;
		this.age = age;
		this.city = city;
		this.profession = profession;
		this.birthDate = birthDate;
		this.favoritePlanet = favoritePlanet;
		this.profilePicture = profilePicture;
	}
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getFavoritePlanet() {
		return favoritePlanet;
	}
	public void setFavoritePlanet(String favoritePlanet) {
		this.favoritePlanet = favoritePlanet;
	}
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", aboutMe=" + aboutMe + ", age=" + age + ", city=" + city
				+ ", profession=" + profession + ", birthDate=" + birthDate + ", favoritePlanet=" + favoritePlanet
				+ ", profilePicture=" + profilePicture + "]";
	}
	
	
	
	
}
