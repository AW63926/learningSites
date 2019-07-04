package com.learningSites;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class WebsitePopulator implements CommandLineRunner {
	
	@Resource
	private WebsiteRepository websiteRepo;
	
	@Resource 
	private ReviewerRepository reviewerRepo;
	
	@Resource
	private ReviewRepository reviewRepo;
	
	@Override
	public void run(String...args) throws Exception {
		
//		Website udemy = new Website("Udemy", "udemyLogo_200.png");
//		udemy = websiteRepo.save(udemy);
//		Website lynda = new Website("Lynda", "lynda_logo_200.png");
//		lynda = websiteRepo.save(lynda);
//		Website edX = new Website("EdX", "Edx_200.png");
//		edX = websiteRepo.save(edX);
//		Website w3school = new Website("W3schools", "W3logo_200.png");
//		w3school = websiteRepo.save(w3school);
//		
//		Reviewer adam = new Reviewer ("Adam","As a software developer in process, I am always looking for learning resources.  I have ample experience with each of the learning websites we have listed, and I am gathering more experience by the minute!!", "profile.jpg", udemy);
//		adam = reviewerRepo.save(adam);
//		
//		Reviewer mary = new Reviewer ("Mary","Cost of learning", "mary.JPG", udemy);
//		mary = reviewerRepo.save(mary);
//		
//		Reviewer grace = new Reviewer ("Grace","In my software developer apprentice journey, an array of online courses have provided knowledge to me that have guided my learning experince. Here i discuss how this experience has reflected with each learning site ","grace.JPG", udemy);
//		grace = reviewerRepo.save(grace);
//		
//		reviewRepo.save(new Review("Cost of Learning", grace));
//		reviewRepo.save(new Review("Accessibility", adam));
//		reviewRepo.save(new Review("validity of certification", mary));
//}
		
		Review cost = reviewRepo.save(new Review("Cost"));
		Review accessibility = reviewRepo.save(new Review("Accessibility"));
		Review certification = reviewRepo.save(new Review("Certification"));
		Review rating = reviewRepo.save(new Review("Rating"));
		
		Website udemy = websiteRepo.save(new Website ("udemyLogo_200.png", "udemy.com", cost, certification));
		Website edX = websiteRepo.save(new Website("Edx_200.png", "EdX.com", certification, rating));
		Website lynda = websiteRepo.save(new Website("lynda_logo_200.png", "lynda.com", rating, cost));
		Website w3Schools = websiteRepo.save(new Website("W3logo_200.png", "w3Schools.com", accessibility, rating));
		
		reviewerRepo.save(new Reviewer("Adam", "As a software developer in process, I am always looking for learning resources.I have ample experience with each of the learning websites we have listed, and I am gathering more experience by the minute!!", "profile.jpg", udemy, edX, w3Schools, lynda));
		reviewerRepo.save(new Reviewer("Grace","In my software developer apprentice journey, an array of online courses have provided knowledge to me that have guided my learning experince. Here i discuss how this experience has reflected with each learning site ","grace.JPG", udemy, edX, w3Schools, lynda));
		reviewerRepo.save(new Reviewer("Mary", "Mary Text here", "mary.JPG", udemy, edX, lynda, w3Schools));
		
}}
