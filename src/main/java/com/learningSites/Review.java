package com.learningSites;

//import java.util.Arrays;
import java.util.Collection;
//import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;
//
	private String title;

//	@ManyToOne
//	private Reviewer reviewer;
//	
//	@OneToMany(mappedBy = "review")
//	private Collection<Review> reviews;

	@ManyToMany(mappedBy = "reviews")
	private Collection<Website> websites;

	public Review() {

	}

	public Review(String title) {
		this.title = title;
//		this.reviewer = reviewer;

	}

	public String getName() {
		return title.toString();
	}

	public Long getId() {
		return id;
	}

//	public String getTitle() {
//		return title;
//
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Review other = (Review) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Collection<Website> getWebsites() {
		return websites;
	}

//public Collection<Review> getReviews() {
//
//	return reviews;
//}

}
