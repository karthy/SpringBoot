package com.dragon.model;

import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie_detail")
public class MovieDetails {
	
	@Id
    @Column(name="movie_id")
	int movieId;
	
	@Column(name="movie_name")
	String movie_name;
	
	@Column(name="rent_price")
	int rent_price;
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public int getRent_price() {
		return rent_price;
	}
	public void setRent_price(int rent_price) {
		this.rent_price = rent_price;
	}
	
	public String toString() {
		return "For movie "+getMovie_name()+"- Reteal Price will be "+getRent_price();
	}
}
