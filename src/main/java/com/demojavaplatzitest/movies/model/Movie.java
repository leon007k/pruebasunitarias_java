package com.demojavaplatzitest.movies.model;

import java.util.Objects;

public class Movie {

	private Integer id;
	private String name;
	private Integer minutes;
	private Genre genre;
	
	public Movie(String name, Integer minutes, Genre genre) {
		this(null,name,minutes,genre);
	}
	
	public Movie(Integer id, String name, Integer minutes, Genre genre) {
		this.id = id;
		this.name = name;
		this.minutes = minutes;
		this.genre = genre;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the minutes
	 */
	public Integer getMinutes() {
		return minutes;
	}

	/**
	 * @param minutes the minutes to set
	 */
	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(genre, id, minutes, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return genre == other.genre && Objects.equals(id, other.id) && Objects.equals(minutes, other.minutes)
				&& Objects.equals(name, other.name);
	}


}
