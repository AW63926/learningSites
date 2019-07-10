package com.learningSites;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ReviewerRestController {

	@Resource
	private ReviewerRepository reviewerRepo;
	
	@Resource 
	private WebsiteRepository websiteRepo;
	
	@RequestMapping("/show-reviewers")
	public Iterable<Reviewer>findAllCourses(){
		return reviewerRepo.findAll();
	}
	
	@RequestMapping("/show-reviewers/{id}")
	public Optional<Reviewer>findOneReviewer(@PathVariable long id){
		return reviewerRepo.findById(id);
	}
	
	@RequestMapping("show-reviewers/websites/{websiteName}")
	public Collection<Reviewer>findAllReviewersByWebsite(@PathVariable(value="websiteName") String websiteName) {
		Website website = websiteRepo.findByNameIgnoreCaseLike(websiteName);
				return reviewerRepo.findByWebsitesContains(website);
	}
}
