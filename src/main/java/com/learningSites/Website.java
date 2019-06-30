package com.learningSites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Website {

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

	public Website() {
	}

	public Website(String name) {
		this.name = name;

	}


}
