package com.learningSites;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CourseControllerTest {
	
	
	
	@Mock
	private Reviewer reviewer;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldAddSingleReviewerToModel() {
		long reviewerId = 1;
		when(reviewerRepo.findById(reviewerId)).thenReturn(reviewer));
	}
	
	
	

}
