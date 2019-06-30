package com.learningSites;


import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

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
	
	@Mock 
	private ReviewerRepository reviewerRepo;
	
	
	@Mock
	private Model model;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldAddSingleReviewerToModel() {
		long reviewerId = 1;
		when(reviewerRepo.findById(reviewerId)).thenReturn(Optional.of(reviewer));
		
		
		underTest.findOneReviewer(reviewerId, model);
		verify(model).addAttribute("reviewers", reviewer);
		
		
	}
	
	
	

}
