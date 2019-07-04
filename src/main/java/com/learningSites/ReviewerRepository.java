package com.learningSites;

//import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface ReviewerRepository extends CrudRepository<Reviewer, Long> {
//
//	Collection<Reviewer> findByWebsitesContains(Website udemy);
//
//	Collection<Reviewer> findByWebsitesId(Long id);
}