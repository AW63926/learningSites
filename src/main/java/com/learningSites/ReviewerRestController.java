package com.learningSites;

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
	
	@RequestMapping("/show-reviewers")
	public Iterable<Reviewer>findAllCourses(){
		return reviewerRepo.findAll();
	}
	
	@RequestMapping("/show-reviewers/{id}")
	public Optional<Reviewer>findOneReviewer(@PathVariable long id){
		return reviewerRepo.findById(id);
	}
}
