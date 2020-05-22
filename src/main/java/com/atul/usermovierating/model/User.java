package com.atul.usermovierating.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User implements Serializable{
	
	@Id
	String userid;
	String name;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userid, String name) {
		super();
		this.userid = userid;
		this.name = name;
	}

	public String getuserid() {
		return userid;
	}

	public void setuserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + "]";
	}
	
	
	

}
