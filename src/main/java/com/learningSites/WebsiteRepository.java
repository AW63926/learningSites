package com.learningSites;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface WebsiteRepository extends CrudRepository<Website, Long> {
   Collection<Website>findByReviewsContains(Review review);
   
   Collection<Website>findByReviewsId(Long id);
}
