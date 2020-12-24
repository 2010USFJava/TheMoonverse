package com.revature.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Profile;
import com.revature.exception.ResourceNotFoundException;
import com.revature.repos.ProfileRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2")
public class ProfileController {
	@Autowired
	private ProfileRepository profileRepository;
	
	@GetMapping("/profile")
	public List<Profile> getAllProfiles(){
		List<Profile> profiles = new ArrayList<>();
		 this.profileRepository.findAll().forEach(profiles::add);
		 return profiles;
		
	}
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping("/profile/{profileId}")
	public Optional<Profile> getProfileById(@PathVariable(value = "id") Integer profileID)
		{Optional<Profile> profile = profileRepository.findById(profileID);
		return profile;
		}
	
	@PostMapping("/add")
	public Profile createProfile ( @RequestBody Profile profile) {
		return profileRepository.save(profile);
		//ToDO - log new profile created
}
	@PutMapping("/Profile/{id}")
	public ResponseEntity<Profile> updateProfile(@PathVariable(value="id")int profileId, @RequestBody Profile profileDetails)
		throws ResourceNotFoundException{
				Profile profile = profileRepository.findById(profileId)
						.orElseThrow(() -> new ResourceNotFoundException("Profile not found for this id::" + profileId));
				
		profile.setAboutMe(profileDetails.getAboutMe());
		profile.setAge(profileDetails.getAge());
		profile.setCity(profileDetails.getCity());
		profile.setProfession(profileDetails.getProfession());
		profile.setFavoritePlanet(profileDetails.getFavoritePlanet());
		profile.setProfilePicture(profileDetails.getProfilePicture());
		
		final Profile updatedProfile = profileRepository.save(profile);
		return ResponseEntity.ok(updatedProfile);
	}
		
		@DeleteMapping("/profile/{id}")
	   public Map<String, Boolean> updateProfile(@PathVariable(value="id")int ProfileId )
		throws ResourceNotFoundException{
			Profile profile = profileRepository.findById(ProfileId)
					.orElseThrow(() -> new ResourceNotFoundException("Profile not found for this id::" + ProfileId));
			
		
		profileRepository.delete(profile);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;
	}

}