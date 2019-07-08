package com.learningSites;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class ReviewerControllerTest {

	@InjectMocks
	private ReviewerController underTest;

	@Mock
	private Reviewer reviewer;
	Long reviewerId;
	
	

	@Mock
	private Reviewer anotherReviewer;

	@Mock
	private ReviewerRepository reviewerRepo;

	@Mock
	private Review review;

	@Mock
	private Review anotherReview;

	@Mock
	private ReviewRepository reviewRepo;

	@Mock
	private Model model;

	@Mock
	private Website website;
	Long websiteId;

	@Mock
	private Website anotherWebsite;

	@Mock
	private WebsiteRepository websiteRepo;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldAddSingleReviewerToModel() throws ReviewersNotFoundException {
		long reviewerId = 1;
		when(reviewerRepo.findById(reviewerId)).thenReturn(Optional.of(reviewer));

		underTest.findOneReviewer(reviewerId, model);
		verify(model).addAttribute("reviewers", reviewer);

	}

	@Test
	public void shouldAddAllReviewersToModel() {
		Collection<Reviewer> allReviewers = Arrays.asList(reviewer, anotherReviewer);
		when(reviewerRepo.findAll()).thenReturn(allReviewers);

		underTest.findAllReviewers(model);
		verify(model).addAttribute("reviewers", allReviewers);
	}

	@Test
	public void shouldAddSingleWebsiteToModel() throws WebsiteNotFoundException {
		long websiteId = 1;
		when(websiteRepo.findById(websiteId)).thenReturn(Optional.of(website));

		underTest.findOneWebsite(websiteId, model);
		verify(model).addAttribute("websites", website);
	}

	@Test
	public void shouldAddAllWebsitesToModel() {
		Collection<Website> allWebsites = Arrays.asList(website, anotherWebsite);
		when(websiteRepo.findAll()).thenReturn(allWebsites);

		underTest.findAllWebsites(model);
		verify(model).addAttribute("websites", allWebsites);
	}

	@Test
	public void shouldAddSingleReviewToModel() throws ReviewNotFoundException {
		long reviewId = 1;
		when(reviewRepo.findById(reviewId)).thenReturn(Optional.of(review));

		underTest.findOneReview(reviewId, model);
		verify(model).addAttribute("reviews", review);

	}

	@Test
	public void shouldAddAllReviewsToModel() {
		Collection<Review> allReviews = Arrays.asList(review, anotherReview);
		when(reviewRepo.findAll()).thenReturn(allReviews);
		underTest.findAllReviews(model);
		verify(model).addAttribute("review", allReviews);
	}
	
	@Test 
	public void shouldAddAdditionalReviewersToModel() {
		String websiteName = "website name";
		Website newWebsite = websiteRepo.findByName(websiteName);
		String reviewerName = "new reviewer";
		String reviewerDescription = "new reviewer description";
		String reviewerImageName = "new reviewer imageName";
		underTest.addReviewer(reviewerName, reviewerDescription, reviewerImageName, websiteName);
		Reviewer newReviewer = new Reviewer(reviewerName, reviewerDescription, reviewerImageName, newWebsite);
		when(reviewerRepo.save(newReviewer)).thenReturn(newReviewer);
		
	}
	@Test 
	public void shouldRemoveReviewerFromModelByName() {
		String reviewerName = reviewer.getName();
		when(reviewerRepo.findByName(reviewerName)).thenReturn(reviewer);
		underTest.deleteReviewerByName(reviewerName);
		verify(reviewerRepo).delete(reviewer);
	}
	@Test 
	public void shouldRemoveReviewerFromModelById() {
		underTest.deleteReviewerById(reviewerId);
		verify(reviewerRepo).deleteById(reviewerId);
	}
	
	@Test
	public void shouldAddAdditionalWebsiteToModel() {
		String websiteName = "testWebsite";
		String websiteReview = "test web review";
		underTest.addWebsite(websiteName, websiteReview);
		Website newWebsite = new Website(websiteName, websiteReview);
		when(websiteRepo.save(newWebsite)).thenReturn(newWebsite);
	}
	@Test 
	public void shouldRemoveWebsiteFromModelByName() {
		String websiteName = website.getName();
		when(websiteRepo.findByName(websiteName)).thenReturn(website);
		underTest.deleteWebsiteByName(websiteName);
		verify(websiteRepo).delete(website);
	}
	@Test 
	public void shouldRemoveWebsiteFromModelById() {
		underTest.deleteWebsiteById(websiteId);
		verify(websiteRepo).deleteById(websiteId);
	}
	

	}

