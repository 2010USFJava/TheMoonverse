package com.revature.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile,Integer> {

}
