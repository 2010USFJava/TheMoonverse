package com.revature.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Profile;
import com.revature.beans.Users;
import com.revature.exception.ResourceNotFoundException;
import com.revature.repos.ProfileRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2")
public class ProfileController {
	@Autowired
	private ProfileRepository profileRepo;
	
	@GetMapping("/profile")
	public List<Profile> getAllProfiles(){

		 return profileRepo.findAll();
		
	}
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping("/profile/{id}")
	public ResponseEntity<Profile> getProfileByUserId(@PathVariable(value = "id") int userId)
			throws ResourceNotFoundException {
		List<Profile> profileList = getAllProfiles();
		Profile profile = new Profile();
		Iterator<Profile> iterator = profileList.iterator();
		while(iterator.hasNext()) {
			profile = iterator.next();
			if(profile.getUser().getUserId() == userId) {
			return ResponseEntity.ok().body(profile);
			}
		}
		throw new ResourceNotFoundException("Profile Not Found For User with this Id :: " + userId);
		
	}
	
	@PostMapping("/addprofile")
	public Profile createProfile (@RequestBody Profile profile) {
		return profileRepo.save(profile);
		//ToDO - log new profile created
}
	@PutMapping("/profile/{profile_id}")
	public ResponseEntity<Profile> updateProfile(@PathVariable(value="profile_id")int profileId, @RequestBody Profile profileDetails)
		throws ResourceNotFoundException{
				Profile profile = profileRepo.findById(profileId)
						.orElseThrow(() -> new ResourceNotFoundException("Profile not found for this id::" + profileId));
				
		profile.setAboutMe(profileDetails.getAboutMe());
		profile.setUserId(profileDetails.getUserId());
		profile.setAge(profileDetails.getAge());
		profile.setCity(profileDetails.getCity());
		profile.setProfession(profileDetails.getProfession());
		profile.setFavoritePlanet(profileDetails.getFavoritePlanet());
		profile.setProfilePicture(profileDetails.getProfilePicture());
		
		final Profile updatedProfile = profileRepo.save(profile);
		return ResponseEntity.ok(updatedProfile);
	}

}