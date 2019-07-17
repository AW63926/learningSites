package com.learningSites;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show-websites")

public class WebsiteRestController {

	@Resource
	private ReviewerRepository reviewerRepo;

	@Resource
	private WebsiteRepository websiteRepo;

	@RequestMapping("")
	public Iterable<Website> findAllWebsites() {
		return websiteRepo.findAll();
	}

	@RequestMapping("/{id}")
	public Optional<Website> findOneWebsite(@PathVariable long id) {
		return websiteRepo.findById(id);
	}

	@RequestMapping("/{websiteName}/reviewers")
	public Collection<Reviewer> findAllReviewersByWebsite(@PathVariable(value = "websiteName") String websiteName) {
		Website website = websiteRepo.findByNameIgnoreCaseLike(websiteName);
		return reviewerRepo.findByWebsitesContains(website);
	}

}
