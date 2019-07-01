package com.learningSites;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewerController {
	
	@Resource
	ReviewerRepository reviewerRepo;
	
	@Resource
	WebsiteRepository websiteRepo;
	
	@RequestMapping("/reviewer")
	public String findOneReviewer(@RequestParam(value="id")long id, Model model) throws ReviewersNotFoundException {
		Optional<Reviewer> reviewer = reviewerRepo.findById(id);
		
		if(reviewer.isPresent()) {
			model.addAttribute("reviewers", reviewer.get());
			return "reviewer";
		}
		throw new ReviewersNotFoundException();
	}
	
	
	@RequestMapping("/reviewers")
	public String findAllReviewers(Model model) {
		model.addAttribute("reviewers", reviewerRepo.findAll());
		return ("reviewers");
		
	}
	
	@RequestMapping("/website")
	public String findOneWebsite(@RequestParam(value="id")long id, Model model) throws WebsiteNotFoundException {
		Optional<Website> website = websiteRepo.findById(id);
		
		if(website.isPresent()) {
			model.addAttribute("websites", website.get());
			return "website";
		}
		throw new WebsiteNotFoundException();
	}
	
	
	@RequestMapping("/websites")
	public String findAllWebsites(Model model) {
		model.addAttribute("websites", websiteRepo.findAll());
		return ("websites");
		
	}
	
	

}
