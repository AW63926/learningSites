package com.learningSites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {
	
	@Id
	@GeneratedValue

	private long id;

	private String name;
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Review() {
	}

	public Review(String name) {
		this.name = name;

	}


}


