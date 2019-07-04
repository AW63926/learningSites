package com.learningSites;

//import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long>{

//	Collection<Review> findByWebsitesContains(Website udemy);
//
//	Collection<Review> findByWebsitesId(Long id);

}