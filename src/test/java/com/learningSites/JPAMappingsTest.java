package com.learningSites;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
//import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import javax.annotation.Resource;

//import java.util.Collection;
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
		Website website = websiteRepo.save(new Website("website", "image"));
		long websiteId = website.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Website> result = websiteRepo.findById(websiteId);
		result.get();
		assertThat(website.getName(), is("website"));
	}

	@Test
	public void shouldGenerateWebsiteById() {
		Website website = websiteRepo.save(new Website("website", "image"));
		long websiteId = website.getId();

		entityManager.flush();
		entityManager.clear();

		assertThat(websiteId, is(greaterThan(0L)));

	}

	@Test
	public void shouldSaveAndLoadReviewer() {
		Reviewer reviewer = new Reviewer("reviewer name", "description", "image", null);
		reviewer = reviewerRepo.save(reviewer);
		long reviewerId = reviewer.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Reviewer> result = reviewerRepo.findById(reviewerId);
		reviewer = result.get();
		assertThat(reviewer.getName(), is("reviewer name"));
	}

//	@Test
//	public void shouldEstablishReviewerToWebsiteRelationships() {
//		Website udemy = websiteRepo.save(new Website("Udemy", "image"));
//		Website lynda = websiteRepo.save(new Website("Lynda", "image"));
//
//		Reviewer reviewer = new Reviewer("cost", "description", "image",udemy, lynda);
//		reviewer = reviewerRepo.save(reviewer);
//		long reviewerId = reviewer.getId();
//
//		entityManager.flush();
//		entityManager.clear();
//
//		Optional<Reviewer> result = reviewerRepo.findById(reviewerId);
//		reviewer = result.get();
//
//		assertThat(reviewer.getWebsites(), containsInAnyOrder(udemy, lynda));
//	}

//	@Test
//	public void shouldFindReviewerForWebsite() {
//		Website udemy = websiteRepo.save(new Website("udemy", "image"));
//
//		Reviewer cost = reviewerRepo.save(new Reviewer("cost", "Description", "image", udemy));
//		Reviewer certification = reviewerRepo.save(new Reviewer("Certification", "Description", "image",udemy));
//
//		entityManager.flush();
//		entityManager.clear();
//
//		Collection<Reviewer> reviewersforWebsite = reviewerRepo.findByWebsitesContains(udemy);
//
//		assertThat(reviewersforWebsite, containsInAnyOrder(cost, certification));
//
//	}

//	@Test
//	public void shouldFindReviewersForWebsiteId() {
//		Website udemy = websiteRepo.save(new Website("udemy", "image"));
//		long websiteId = udemy.getId();
//
//		Reviewer cost = reviewerRepo.save(new Reviewer("cost", "Description", "image", udemy));
//		Reviewer certification = reviewerRepo.save(new Reviewer("Certification", "Description", "image", udemy));
//
//		entityManager.flush();
//		entityManager.clear();
//
//		Collection<Reviewer> reviewersForWebsite = reviewerRepo.findByWebsitesId(websiteId);
//
//		assertThat(reviewersForWebsite, containsInAnyOrder(cost, certification));
//
//	}

//	@Test
//	public void shouldEstablishReviewToReviewerRelationships() {
//		Reviewer reviewer = new Reviewer("name", "description", "image", null);
//		reviewerRepo.save(reviewer);
//		long reviewerId = reviewer.getId();
//
//		Review element = new Review("title", reviewer);
//		reviewRepo.save(element);
//
//		Review element2 = new Review("title two", reviewer);
//		reviewRepo.save(element2);
//
//		entityManager.flush();
//		entityManager.clear();
//
//		Optional<Reviewer> result = reviewerRepo.findById(reviewerId);
//		reviewer = result.get();
//		assertThat(reviewer.getReviewers(), containsInAnyOrder(element, element2));
//
//	}

}