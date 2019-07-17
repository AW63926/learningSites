package com.learningSites;

import java.util.HashSet;
import static java.lang.String.format;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learningSites.Review;
import com.learningSites.Website;

import java.util.ArrayList;
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

	@JsonIgnore
	@ManyToMany
	private Collection<Website> websites;

	@JsonIgnore
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

	public String getImage() {
		return imageName;
	}

	public Collection<Website> getWebsites() {
		return websites;
	}

	public Collection<Review> getReviews() {

		return reviews;
	}

	public Collection<String> getWebsitesUrls() {
		Collection<String> urls = new ArrayList<>();
		for (Website w : websites) {
			urls.add(format("/show-reviewers/%d/websites/%s", this.getId(), w.getName()));
		}
		return urls;
	}

	public Reviewer(String name, String description, String imageName, Website... websites) {
		this.name = name;
		this.description = description;
		this.imageName = imageName;
		this.websites = new HashSet<>(Arrays.asList(websites));
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

}
