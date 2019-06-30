package com.learningSites;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class ReviewerController {
	
	@Resource
	ReviewerRepository reviewerRepo;
	

	public void findOneReviewer(long id, Model model) {
		Optional<Reviewer> reviewer = reviewerRepo.findById(id);
		
	}

}
