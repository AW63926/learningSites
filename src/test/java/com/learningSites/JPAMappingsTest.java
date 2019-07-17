package com.learningSites;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import javax.annotation.Resource;

import java.util.Collection;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JPAMappingsTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private WebsiteRepository websiteRepo;

	@Resource
	private ReviewerRepository reviewerRepo;

	@Resource
	private ReviewRepository reviewRepo;

	@Test
	public void shouldSaveAndLoadWebsite() {
		Website website = websiteRepo.save(new Website("website", "webImage","review", "StarRating","starRating2", "starRating3"));
		long websiteId = website.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Website> result = websiteRepo.findById(websiteId);
		result.get();
		assertThat(website.getName(), is("website"));
	}

	@Test
	public void shouldGenerateWebsiteById() {
		Website website = websiteRepo.save(new Website("website","webImage","review", "StarRating","starRating2", "starRating3"));
		long websiteId = website.getId();

		entityManager.flush();
		entityManager.clear();

		assertThat(websiteId, is(greaterThan(0L)));

	}

	@Test
	public void shouldSaveAndLoadReviewer() {
		Reviewer reviewer = new Reviewer("reviewer name", "description","imageName");
		reviewer = reviewerRepo.save(reviewer);
		long reviewerId = reviewer.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Reviewer> result = reviewerRepo.findById(reviewerId);
		reviewer = result.get();
		assertThat(reviewer.getName(), is("reviewer name"));
	}

	@Test
	public void shouldEstablishReviewerToWebsiteRelationships() {
		Website udemy = websiteRepo.save(new Website("Udemy", "webImage","review", "StarRating","starRating2", "starRating3"));
		Website lynda = websiteRepo.save(new Website("Lynda","webImage","review", "StarRating","starRating2", "starRating3"));

		Reviewer reviewer = new Reviewer();
		reviewer = reviewerRepo.save(reviewer);
		long reviewerId = reviewer.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Reviewer> result = reviewerRepo.findById(reviewerId);
		reviewer = result.get();

		assertThat(reviewer.getWebsites(), containsInAnyOrder(udemy, lynda));
	}

	@Test
	public void shouldFindReviewerForWebsite() {
		Website udemy = websiteRepo.save(new Website("udemy", "webImage","review", "StarRating", "starRating2", "starRating3"));

		Reviewer mary = reviewerRepo.save(new Reviewer("Mary", "review of Udemy","udemyLogo_200.png"));
		Reviewer adam = reviewerRepo.save(new Reviewer("Adam", "review of W3Schools", "W3logo_200.png"));

		entityManager.flush();
		entityManager.clear();

		Collection<Reviewer> reviewersforWebsite = reviewerRepo.findByWebsitesContains(udemy);

		assertThat(reviewersforWebsite, containsInAnyOrder(mary, adam));

	}

	@Test
	public void shouldFindReviewersForWebsiteId() {
		Website udemy = websiteRepo.save(new Website("udemy","webImage","review", "StarRating", "starRating2", "starRating3"));
		long websiteId = udemy.getId();

		Reviewer mary = reviewerRepo.save(new Reviewer("Mary", "review of Udemy","udemyLogo_200.png"));
		Reviewer adam = reviewerRepo.save(new Reviewer("Adam", "review of W3Schools", "W3logo_200.png"));

		entityManager.flush();
		entityManager.clear();

		Collection<Reviewer> reviewersForWebsite = reviewerRepo.findByWebsitesId(websiteId);

		assertThat(reviewersForWebsite, containsInAnyOrder(mary, adam));

	}

//	@Test
//	public void shouldEstablishReviewToReviewerRelationships() {
//		Reviewer reviewer = new Reviewer("name", "description", "grace.JPG");
//		reviewerRepo.save(reviewer);
//		long reviewerId = reviewer.getId();
//
//		Review element = new Review("title", reviewer,"accessibility", "contentRating","reviewText");
//		reviewRepo.save(element);
//
//		Review element2 = new Review("title two", reviewer, "accessibility", "contentRating","reviewText");
//		reviewRepo.save(element2);
//
//		entityManager.flush();
//		entityManager.clear();
//
//		Optional<Reviewer> result = reviewerRepo.findById(reviewerId);
//		reviewer = result.get();
//		assertThat(reviewer.getReviews(), containsInAnyOrder(element, element2));
//
//	}
	
	@Test 
	public void shouldSortReviewers() {
		Reviewer adam = new Reviewer("Adam", "review of W3Schools", "W3logo_200.png");
		adam = reviewerRepo.save(adam);
		
		Reviewer mary = new Reviewer( "Mary", "review of Udemy","udemyLogo_200.png");
		mary = reviewerRepo.save(mary);
		
		entityManager.flush();
		entityManager.clear();
		
		Collection<Reviewer> sortedReviewers = reviewerRepo.findAllByOrderByNameAsc();
		assertThat(sortedReviewers, contains(adam, mary));
	}

}