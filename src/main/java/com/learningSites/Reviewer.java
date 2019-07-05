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
	private String imageName;

	private String name;
	private String description;
	private String reviewText;
	private String siteName;
	private String certification;
	private String accessibility;

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
	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getAccessibility() {
		return accessibility;
	}

	public void setAccessibility(String accessibility) {
		this.accessibility = accessibility;
	}


	public String getImage() {
		return imageName;
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

	public Reviewer(String name, String description, String imageName, Website... websites) {
		this.name = name;
		this.description = description;
		this.imageName = imageName;
		this.websites = new HashSet<>(Arrays.asList(websites));
	}


	public Reviewer (Long id, String reviewText, String siteName, String certification, String accessibility){
     this.id = id;
     this.reviewText = reviewText;
     this.siteName = siteName;
     this.certification = certification;
     this.accessibility = accessibility;
	}
	public Collection<Website> getWebsites() {
		return websites;
	}

	public Collection<Review> getReviews() {

		return reviews;
	}

}
