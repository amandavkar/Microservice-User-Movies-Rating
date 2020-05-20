package com.atul.usermovierating.model;

import java.util.List;

public class UserMovieRating {
	
	String userid;
	String username;
	List<MovieRating> movieRating;
	public UserMovieRating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserMovieRating(String userid, String username, List<MovieRating> movieRating) {
		super();
		this.userid = userid;
		this.username = username;
		this.movieRating = movieRating;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<MovieRating> getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(List<MovieRating> movieRating) {
		this.movieRating = movieRating;
	}
	@Override
	public String toString() {
		return "UserMovieRating [userid=" + userid + ", username=" + username + ", movieRating=" + movieRating + "]";
	} 

}
