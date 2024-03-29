package com.learningSites;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface ReviewRepository extends CrudRepository<Review, Long>{
	
	List<Review> findByReviewer(String reviewer);


}
