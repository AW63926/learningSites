package com.learningSites;

import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.Arrays;
import java.util.Collection;

@Entity
public class Reviewer {
	@Id
	@GeneratedValue

	private long id;

	private String name;
	private String description;

	@ManyToMany
	private Collection<Website> websites;
	

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Reviewer() {

	}

	public Reviewer(String name, String description, Website... websites) {
		this.name = name;
		this.description = description;
		this.websites = new HashSet<>(Arrays.asList(websites));
	}

	public Collection<Website> getWebsites() {
		
		return websites ;
}


}
