package com.atul.usermovierating.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Movie details")
public class Movie {

	@ApiModelProperty(notes = "Unique id of the movie")
	String imdbid;
	
	@ApiModelProperty(notes = "Name of the movie")
	String title;
	
	@ApiModelProperty(notes = "Plot of the movie")
	String plot;
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(String imdbid, String title, String plot) {
		super();
		this.imdbid = imdbid;
		this.title = title;
		this.plot = plot;
	}
	public String getimdbid() {
		return imdbid;
	}
	public void setimdbid(String imdbid) {
		this.imdbid = imdbid;
	}
	public String gettitle() {
		return title;
	}
	public void settitle(String title) {
		this.title = title;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	@Override
	public String toString() {
		return "Movie [imdbid=" + imdbid + ", title=" + title + ", plot=" + plot + "]";
	}
	
	
}
