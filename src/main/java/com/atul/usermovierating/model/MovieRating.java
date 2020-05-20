package com.atul.usermovierating.model;


public class MovieRating {
	
	Movie movie;
	int rating;
	
	public MovieRating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieRating(Movie movie, int rating) {
		super();
		this.movie = movie;
		this.rating = rating;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "MovieRating [movie=" + movie + ", rating=" + rating + "]";
	}

	
}
