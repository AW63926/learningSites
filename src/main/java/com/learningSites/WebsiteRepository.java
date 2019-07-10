package com.learningSites;

import org.springframework.data.repository.CrudRepository;

public interface WebsiteRepository extends CrudRepository<Website, Long> {

	Website findByName(String websiteName);

	Website findByNameIgnoreCaseLike(String websiteName);
}
