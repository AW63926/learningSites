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
		
		Website udemy = new Website("Udemy", "udemyLogo_200.png", "Udemy offers many courses and learning paths that will cover the entire breadth of a subject and offers searchable content.");
		udemy = websiteRepo.save(udemy);
		Website lynda = new Website("Lynda", "lynda_logo_200.png", "Lynda.com is a great resource for Learning full subjects, and even offers learning paths with certificates that can be published to your LinkedIn.    ");
		lynda = websiteRepo.save(lynda);
		Website edX = new Website("EdX", "Edx_200.png", "Edx offers courses sourced from universities and learning institutions from all over the world, but is not built for focused searching.");
		edX = websiteRepo.save(edX);
		Website w3school = new Website("W3schools", "W3logo_200.png", "The descriptions on the W3Schools are typically brief and focused, which makes it difficult to learn broader concepts, but an excellent tool for problem solving.  ");
		w3school = websiteRepo.save(w3school);
		
		Reviewer adam = new Reviewer ("Adam","As a software developer in process, I am always looking for learning resources.  I have ample experience with each of the learning websites we have listed, and I am gathering more experience by the minute!!", "profile.jpg", udemy);
		adam = reviewerRepo.save(adam);
		
		Reviewer mary = new Reviewer ("Mary","Bio goes here", "mary.JPG", udemy);
		mary = reviewerRepo.save(mary);
		
		Reviewer grace = new Reviewer ("Grace","Bio goes here","grace.JPG", udemy);
		grace = reviewerRepo.save(grace);
		
		
		
		reviewRepo.save(new Review("Lynda", adam, "Stars5.png", "Stars4.png", "Lynda.com is a great resource for Learning full subjects, "
				+ "and even offers learning paths with certificates that can be published to your LinkedIn."));
		reviewRepo.save(new Review("Udemy", adam, "Stars5.png", "Stars4.png", "Udemy offers many courses and learning paths that will cover the entire breadth of a subject.  LIke lynda, Udemy offers a search feature "
				+ "that will allow the user to target specific topics with a larger course."));
		reviewRepo.save(new Review("W3Schools", adam, "Stars5.png", "Stars4.png", "W3Schools offers great tutorials on specific subject like HTML and CSS."));
		reviewRepo.save(new Review("Edx", adam, "Stars5.png", "Stars4.png", "Edx offers courses sourced from universities and learning institutions from all over the world."));
		reviewRepo.save(new Review("Udemy", grace, "Stars5.png", "Stars4.png", "really reviewed this and said things here"));
		reviewRepo.save(new Review("validity of certification", mary, "Stars5.png", "Stars4.png", "really reviewed this and said things here"));
		
}
}