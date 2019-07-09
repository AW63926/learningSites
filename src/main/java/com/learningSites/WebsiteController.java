package com.learningSites;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebsiteController {
	
	@Resource
	ReviewerRepository reviewerRepo;
	
	@Resource
	WebsiteRepository websiteRepo;
	
	@Resource
	ReviewRepository reviewRepo;
	
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

	@RequestMapping("/review")
	public String findOneReview(@RequestParam(value="id")Long id, Model model) throws ReviewNotFoundException {
		Optional<Review> review = reviewRepo.findById(id);
		
		if(review.isPresent()) {
			model.addAttribute("reviews", review.get());
			return "review";
		}
		throw new ReviewNotFoundException();
	}

	@RequestMapping("/reviews")
	public String findAllReviews(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		return ("reviews");
		
	}

}
