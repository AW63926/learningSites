package com.learningSites;

//import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;

//import java.util.Arrays;
//import java.util.Collection;

@Entity
public class Reviewer {

	@Id
	@GeneratedValue
	private Long id;

	private String imageName;
	private String name;
	private String description;
	private String reviewer;

	public Reviewer(String name, String description, String imageName, Website udemy, Website edX, Website w3Schools, Website lynda) {

	}
//	@ManyToMany
//	private Collection<Website> websites;
//
//	@OneToMany(mappedBy = "reviewer")
//	private Collection<Review> reviews;

	@ManyToOne
	private Website website;

	public Reviewer(String name, String description, String imageName, Website website) {
		this.name = name;
		this.description = description;
		this.imageName = imageName;
//	this.websites = new HashSet<>(Arrays.asList(websites));
		this.website = website;
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

	public String getImage() {
		return imageName;
	}

	public String getReviewers() {
		return reviewer;
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

//	public Collection<Website> getWebsites() {
//		return websites;
//	}
//
//	public Collection<Review> getReviews() {
//
//		return reviews;
//	}

}
