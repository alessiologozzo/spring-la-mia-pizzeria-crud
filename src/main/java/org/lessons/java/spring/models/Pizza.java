package org.lessons.java.spring.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 255, nullable = false)
	private String name;

	@Column(length = 255, nullable = false)
	private String description;

	@Column(length = 255, nullable = true)
	private String url;

	@Column(nullable = false)
	private float price;

	@SuppressWarnings("unused")
	private Pizza() {
	} // Just for Spring

	public Pizza(String name, String description, String url, float price) throws IllegalArgumentException {
		setName(name);
		setDescription(description);
		setUrl(url);
		setPrice(price);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setPrice(float price) throws IllegalArgumentException {
		if (price < 0)
			throw new IllegalArgumentException("Price cannot be lower than 0.");
		else
			this.price = price;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getUrl() {
		return url;
	}

	public float getPrice() {
		return price;
	}
}
