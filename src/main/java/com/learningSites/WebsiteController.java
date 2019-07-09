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
	public String findOneReviewer(@RequestParam(value = "id") long id, Model model) throws ReviewersNotFoundException {
		Optional<Reviewer> reviewer = reviewerRepo.findById(id);

		if (reviewer.isPresent()) {
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
	public String findOneWebsite(@RequestParam(value = "id") long id, Model model) throws WebsiteNotFoundException {
		Optional<Website> website = websiteRepo.findById(id);

		if (website.isPresent()) {
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
	public String findOneReview(@RequestParam(value = "id") long id, Model model) throws ReviewNotFoundException {
		Optional<Review> review = reviewRepo.findById(id);

		if (review.isPresent()) {
			model.addAttribute("reviews", review.get());
			return "review";
		}
		throw new ReviewNotFoundException();
	}

	@RequestMapping("/reviews")
	public String findAllReviews(Model model) {
		model.addAttribute("review", reviewRepo.findAll());
		return ("reviews");

	}

	@RequestMapping("/add-reviewer")
	public String addReviewer(String reviewerName, String reviewerDescription, String reviewerImageName,
			String websiteName) {
		Website website = websiteRepo.findByName(websiteName);
		Reviewer newReviewer = reviewerRepo.findByName(reviewerName);

		if (newReviewer == null) {
			newReviewer = new Reviewer(reviewerName, reviewerDescription, reviewerImageName, website);
			reviewerRepo.save(newReviewer);
		}
		return "redirect:/reviewers";
	}

	@RequestMapping("/delete-reviewer")
	public String deleteReviewerByName(String reviewerName) {
		if(reviewerRepo.findByName(reviewerName) !=null) {
			Reviewer deletedReviewer = reviewerRepo.findByName(reviewerName);
			reviewerRepo.delete(deletedReviewer);
		}
		return "redirect:/reviewers";

	}

	@RequestMapping("/del-reviewer")
	public String deleteReviewerById(Long reviewerId) {

		reviewerRepo.deleteById(reviewerId);
		
		return "redirect:/reviewers";
	}
	
	@RequestMapping("/find-by-website")
	public String findReviewersByWebsite(String websiteName, Model model) {
		Website website = websiteRepo.findByName(websiteName);
		model.addAttribute("reviewers", reviewerRepo.findByWebsitesContains(website));
		
		return"/website";
	}

	@RequestMapping("/sort-reviewers")
	public String sortReviewers(Model model) {
		model.addAttribute("reviewers", reviewerRepo.findAllByOrderByNameAsc());
		
		return "reviewers";
	}

	@RequestMapping("/add-website")
	public String addWebsite(String websiteName, String websiteReview) {
		Website newWebsite = websiteRepo.findByName(websiteName);
		if(newWebsite==null) {
			newWebsite = new Website(websiteName, websiteReview);
			websiteRepo.save(newWebsite);
		}
		return "redirect:/websites";
		
	}

	
	@RequestMapping("/delete-website")
	public String deleteWebsiteById(Long websiteId) {
		websiteRepo.deleteById(websiteId);
		return "redirect:/websites";
	}

	
	@RequestMapping("/del-website")
	public String deleteWebsiteByName(String websiteName) {
		if(websiteRepo.findByName(websiteName) !=null) {
			Website deletedWebsite = websiteRepo.findByName(websiteName);
			websiteRepo.delete(deletedWebsite);
		}
		return "redirect:/websites";

	}
		
	}

