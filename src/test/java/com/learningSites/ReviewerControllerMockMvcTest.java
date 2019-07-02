package com.learningSites;

import java.util.Optional;
import java.util.Collection;
import java.util.Arrays;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewerController.class)
public class ReviewerControllerMockMvcTest {

	@Resource
	private MockMvc mvc;

	@MockBean
	private ReviewerRepository reviewerRepo;

	@MockBean
	private WebsiteRepository websiteRepo;
	
	@MockBean
	private ReviewRepository reviewRepo;

	@Mock
	private Reviewer reviewer;

	@Mock
	private Reviewer anotherReviewer;

	@Mock
	private Website website;

	@Mock
	private Website anotherWebsite;
	
	@Mock
	private Review review;
	
	@Mock
	private Review anotherReview;

	@Test
	public void shouldRouteToSingleWebsiteView() throws Exception {
		long arbitraryWebsiteId = 42;
		when(websiteRepo.findById(arbitraryWebsiteId)).thenReturn(Optional.of(website));
		mvc.perform(get("/website?id=42")).andExpect(view().name(is("website")));
	}

	@Test
	public void shouldBeOkForSingleWebsite() throws Exception {
		long arbitraryWebsiteId = 42;
		when(websiteRepo.findById(arbitraryWebsiteId)).thenReturn(Optional.of(website));
		mvc.perform(get("/website?id=42")).andExpect(status().isOk());
	}

	@Test
	public void shouldBeNotOkForSingleWebiste() throws Exception {
		mvc.perform(get("/website?id=42")).andExpect(status().isNotFound());

	}

	@Test
	public void shouldPutSingleWebsiteIntoModel() throws Exception {
		when(websiteRepo.findById(1L)).thenReturn(Optional.of(website));

		mvc.perform(get("/website?id=42")).andExpect(model().attribute("websites", is(website)));

	}

	@Test
	public void shouldBeOkForAllWebsites() throws Exception {
		mvc.perform(get("/websites")).andExpect(status().isOk());

	}

	@Test
	public void shouldRouteToAllWebsitesView() throws Exception {
		mvc.perform(get("/websites")).andExpect(view().name(is("websites")));

	}

	@Test
	public void shouldPutAllWebsitesIntoModel() throws Exception {
		Collection<Website> allWebsites = Arrays.asList(website, anotherWebsite);
		when(websiteRepo.findAll()).thenReturn(allWebsites);

		mvc.perform(get("/websites")).andExpect(model().attribute("websites", is(allWebsites)));
	}

	@Test
	public void shouldRouteToSingleReviewerView() throws Exception {
		long arbitraryReviewerId = 1;
		when(reviewerRepo.findById(arbitraryReviewerId)).thenReturn(Optional.of(reviewer));
		mvc.perform(get("/reviewer?id=1")).andExpect(view().name(is("reviewer")));
	}

	@Test
	public void shouldBeOkForSingleReviewer() throws Exception {
		long arbitraryReviewerId = 1;
		when(reviewerRepo.findById(arbitraryReviewerId)).thenReturn(Optional.of(reviewer));
		mvc.perform(get("/reviewer?id=1")).andExpect(status().isOk());
	}

	@Test
	public void shouldBeNotOkForSingleReviewer() throws Exception {
		mvc.perform(get("/reviewer?id=1")).andExpect(status().isNotFound());

	}

	@Test
	public void shouldPutSingleReviewerIntoModel() throws Exception {
		when(reviewerRepo.findById(1L)).thenReturn(Optional.of(reviewer));

		mvc.perform(get("/reviewer?id=1")).andExpect(model().attribute("reviewers", is(reviewer)));

	}

	@Test
	public void shouldRouteToAllReviewersView() throws Exception {
		mvc.perform(get("/reviewers")).andExpect(view().name(is("reviewers")));

	}

	@Test
	public void shouldBeOkForAllReviewers() throws Exception {
		mvc.perform(get("/reviewers")).andExpect(status().isOk());

	}

	@Test
	public void shouldPutAllReviewersIntoModel() throws Exception {
		Collection<Reviewer> allReviewers = Arrays.asList(reviewer, anotherReviewer);
		when(reviewerRepo.findAll()).thenReturn(allReviewers);

		mvc.perform(get("/reviewers")).andExpect(model().attribute("reviewers", is(allReviewers)));
	}

}
