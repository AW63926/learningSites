package com.learningSites;


import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;


public class ReviewerControllerTest {
	
	
	
	@Mock
	private Reviewer reviewer;
	
	@Mock 
	private ReviewerRepository reviewerRepo;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldAddSingleReviewerToModel() {
		long reviewerId = 1;
		when(reviewerRepo.findById(reviewerId)).thenReturn(Optional.of(reviewer));
	}
	
	
	

}
