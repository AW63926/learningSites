package com.learningSites;

import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import java.util.Arrays;
import java.util.Collection;

@Entity
public class Reviewer {
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String description;

	@ManyToMany
	private Collection<Website> websites;

	@OneToMany(mappedBy = "reviewer")
	private Collection<Review> reviews;

	public Reviewer() {

	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reviewer other = (Reviewer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Reviewer(String name, String description, Website... websites) {
		this.name = name;
		this.description = description;
		this.websites = new HashSet<>(Arrays.asList(websites));
	}

	public Collection<Website> getWebsites() {
		return websites;
	}

	public Collection<Review> getReviews() {

		return reviews;
	}

}
