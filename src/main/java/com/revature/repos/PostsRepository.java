package com.revature.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Posts;

@Repository
public interface PostsRepository extends CrudRepository<Posts,Integer> {

}
