package com.atul.usermovierating.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atul.usermovierating.model.Moviesbyuser;

@Repository
public interface UserMoviesDAO extends JpaRepository<Moviesbyuser, String> {

	public List<Moviesbyuser> findAllByUserid(String userid); 

	//@Query("SELECT * FROM movie_by_userid WHERE user_id = ?0")
	//public List<MoviesByUser> findMoviesByUser_id(String user_id);
	
}
