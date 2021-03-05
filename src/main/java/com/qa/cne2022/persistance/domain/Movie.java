
package com.qa.cne2022.persistance.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity

public class Movie {
	
	
	//variables
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY) // auto_increment
	private int id;
	
	@Column
	@NotNull
	private String movieName;
	
	@Column
	@NotNull
	private String movieDirector;
	
	@Column
	@NotNull
	private	 String movieRating;
	
	@Column
	@NotNull
	@Max(1260)
	private int movieLength;
	
	@Column	
	@NotNull
	@Min (1888)
	@Max(2021)
	private int yearOfRelease;
	
	//constructors
	
	
	public Movie (String movieName, String movieDirector, String movieRating, int movieLength, int yearOfRelease) {
		super();
		this.setMovieName(movieName) ;
		this.setMovieDirector(movieDirector);
		this.setMovieRating(movieRating);
		this.setMovieLength(movieLength);
		this.setYearOfRelease(yearOfRelease);
}
	public Movie() {}
	
	
	//Getter/Setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMovieName() {
		return movieName;
	}
	
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	public String getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
	
	public String getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(String movieRating) {
		if (movieRating.equals("U") || movieRating.equals("PG") || movieRating.equals("12A") || movieRating.equals("15") ||movieRating.equals("18"))
		{
			this.movieRating = movieRating; }
		else {
			System.out.println("RATING NOT FOUND");
		}
		
	}
	
	public int getMovieLength() {
		return movieLength;
	}
	public void setMovieLength(int movieLength) {
		this.movieLength = movieLength;
	}
	
	public int getYearOfRelease() {
		return yearOfRelease;
	}
	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	//to string method
	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieName=" + movieName + ", movieDirector=" + movieDirector + ", movieRating="
				+ movieRating + ", movieLength=" + movieLength + ", yearOfRelease=" + yearOfRelease + "]";
	}
	
	
}