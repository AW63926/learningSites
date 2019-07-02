package com.learningSites;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewerPopulator implements CommandLineRunner {
	
	@Resource 
	private ReviewerRepository reviewerRepo;
	
	@Resource
	private WebsiteRepository websiteRepo;

	@Resource
	private ReviewRepository reviewRepo;
	
	@Override
	public void run(String...args) throws Exception {
		
		Website udemy = new Website("Udemy");
		udemy = websiteRepo.save(udemy);
		Website lynda = new Website("Lynda");
		lynda = websiteRepo.save(lynda);
		Website edX = new Website("EdX");
		edX = websiteRepo.save(edX);
		Website w3school = new Website("W3school");
		w3school = websiteRepo.save(w3school);
		
		Reviewer adam = new Reviewer ("Adam","Cost of learning", udemy);
		adam = reviewerRepo.save(adam);
		
		Reviewer mary = new Reviewer ("Adam","Cost of learning", udemy);
		mary = reviewerRepo.save(mary);
		
		Reviewer grace = new Reviewer ("Adam","Cost of learning", udemy);
		grace = reviewerRepo.save(grace);
		
		reviewRepo.save(new Review("Cost of Learning", grace));
		reviewRepo.save(new Review("Accessibility", adam));
		reviewRepo.save(new Review("validity of certification", mary));
}
}
