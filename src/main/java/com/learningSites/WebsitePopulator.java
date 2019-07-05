package com.learningSites;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class WebsitePopulator implements CommandLineRunner {

	@Resource
	private ReviewerRepository reviewerRepo;

	@Resource
	private WebsiteRepository websiteRepo;

	@Resource
	private ReviewRepository reviewRepo;

	@Override
	public void run(String...args) throws Exception {

		Website udemy = new Website("Udemy", "udemyLogo_200.png");
		udemy = websiteRepo.save(udemy);
		Website lynda = new Website("Lynda", "lynda_logo_200.png");
		lynda = websiteRepo.save(lynda);
		Website edX = new Website("EdX", "Edx_200.png");
		edX = websiteRepo.save(edX);
		Website w3school = new Website("W3schools", "W3logo_200.png");
		w3school = websiteRepo.save(w3school);

		Reviewer adam = new Reviewer ("Adam","As a software developer in process, I am always looking for learning resources.  I have ample experience with each of the learning websites we have listed, and I am gathering more experience by the minute!!", "profile.jpg", udemy);
		adam = reviewerRepo.save(adam);

		Reviewer mary = new Reviewer ("Mary","Cost of learning", "mary.JPG", udemy);
		mary = reviewerRepo.save(mary);

		Reviewer grace = new Reviewer ("Grace","Cost of learning","grace.JPG", udemy);
		grace = reviewerRepo.save(grace);

		reviewRepo.save(new Review("Cost of Learning", grace));
		reviewRepo.save(new Review("Accessibility", adam));
		reviewRepo.save(new Review("validity of certification", mary));
	}
}