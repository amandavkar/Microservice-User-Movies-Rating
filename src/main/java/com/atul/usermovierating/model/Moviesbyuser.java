package com.atul.usermovierating.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Moviesbyuser  implements Serializable {
	
	@Id @GeneratedValue  @Column(nullable = false)
	int id;
	
	String userid;
	String movieid;
	int rating;

	public Moviesbyuser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Moviesbyuser(String userid, String movieid, int rating) {
		super();
		this.userid = userid;
		this.movieid = movieid;
		this.rating = rating;
	}

	public String getuserid() {
		return userid;
	}

	public void setuserid(String userid) {
		this.userid = userid;
	}

	public String getmovieid() {
		return movieid;
	}

	public void setmovieid(String movieid) {
		this.movieid = movieid;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "MoviesByUser [userid=" + userid + ", movieid=" + movieid + ", rating=" + rating + "]";
	}
}
