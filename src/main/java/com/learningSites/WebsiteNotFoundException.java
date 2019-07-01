package com.learningSites;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class WebsiteNotFoundException extends Exception {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class WebstieNotFoundException extends Exception {
		
	}

}
