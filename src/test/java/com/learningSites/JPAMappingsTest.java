package com.learningSites;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import javax.annotation.Resource;
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

	@Test
	public void shouldSaveAndLoadWebsite() {
		Website website = websiteRepo.save(new Website("website"));
		long websiteId = website.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Website> result = websiteRepo.findById(websiteId);
		result.get();
		assertThat(website.getName(), is("website"));
	}

	@Test
	public void shouldGenerateWebsiteById() {
		Website website = websiteRepo.save(new Website("website"));
		long websiteId = website.getId();

		entityManager.flush();
		entityManager.clear();

		assertThat(websiteId, is(greaterThan(0L)));

	}

	@Test
	public void shouldSaveAndLoadReviewer() {
		Reviewer reviewer = new Reviewer("reviewer name", "description");
		reviewer = reviewerRepo.save(reviewer);
		long reviewerId = reviewer.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Reviewer> result = reviewerRepo.findById(reviewerId);
		result.get();
		assertThat(reviewer.getName(), is("reviewer name"));
	}

	@Test
	public void shouldEstablishReviewerToWebsiteRelationships() {
		Website udemy = websiteRepo.save(new Website("Udemy"));
		Website lynda = websiteRepo.save(new Website("Lynda"));

		Reviewer reviewer = new Reviewer("cost", "description", udemy, lynda);
		reviewer = reviewerRepo.save(reviewer);
		long reviewerId = reviewer.getId();

		Optional<Reviewer> result = reviewerRepo.findById(reviewerId);
		reviewer = result.get();
		
		assertThat(reviewer.getWebsites(), containsInAnyOrder(udemy,lynda));
	}
}
