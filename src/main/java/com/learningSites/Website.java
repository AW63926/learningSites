package com.learningSites;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Website {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	
	private String review;
	
	private String starRating;
	
	private String starRating2;
	
	private String starRating3;

	@ManyToMany(mappedBy = "websites")
	private Collection<Reviewer> reviewers;

	private String websiteImage;

	public Long getId() {
		return id;

	}

	public String getName() {
		return name;
	}
	
	public String getImage() {
		return websiteImage;
	}

	public Website() {
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
		Website other = (Website) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Website(String name, String webImage, String review, String starRating, String starRating2, String starRating3) {
		this.name = name;
		this.websiteImage = webImage;
		this.review = review;
		this.starRating = starRating;
		this.starRating2 = starRating2;
		this.starRating3 = starRating3;

	}
	
	public Website(String name, String review, String starRating, String starRating2, String starRating3) {
	this.name = name;
	this.websiteImage = "user.png";
	this.review = review;
	this.starRating = starRating;
	this.starRating2 = starRating2;
	this.starRating3 = starRating3;
	
	}

	public String getReview() {
		return review;
	}

	public String getStarRating() {
		return starRating;
	}

	public void setStarRating(String starRating) {
		this.starRating = starRating;
	}

	public String getStarRating2() {
		return starRating2;
	}

	public void setStarRating2(String starRating2) {
		this.starRating2 = starRating2;
	}

	public String getStarRating3() {
		return starRating3;
	}

	public void setStarRating3(String starRating3) {
		this.starRating3 = starRating3;
	}

	

}
