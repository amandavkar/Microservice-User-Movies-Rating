package com.atul.usermovierating.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atul.usermovierating.DAO.UserDAO;
import com.atul.usermovierating.DAO.UserMoviesDAO;
import com.atul.usermovierating.model.Movie;
import com.atul.usermovierating.model.MovieRating;
import com.atul.usermovierating.model.Moviesbyuser;
import com.atul.usermovierating.model.User;
import com.atul.usermovierating.model.UserMovieRating;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/usermovierating")
public class UserMovieRatingService {

	@Autowired
	UserMoviesDAO userMoviesDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(path="/user/{userid}", produces= {"application/json"})
	@ApiOperation(value ="gets Movies rated by a user",
					notes = "Provide an userid to look up the movies rated by that user",
					response = UserMovieRating.class)
	public UserMovieRating getUserMovies(@ApiParam(value = "ID value of the user for whom you need to get movie ratings", required = true)
										@PathVariable("userid") String userid) {
		
		UserMovieRating usermovierating = new UserMovieRating();
		usermovierating.setUserid(userid);
		
		//Get the user name from user table
		User username = userDAO.findById(userid).orElse(new User());
		usermovierating.setUsername(username.getName());
		
		
		// Get list of movies and ratings for a user
		// List<MoviesByUser> movielist = (List<MoviesByUser>) userMoviesDAO.findMoviesByUser_id(userid);
		List<Moviesbyuser> movielist = (List<Moviesbyuser>) userMoviesDAO.findAllByUserid(userid);
		
		List<MovieRating> mr =  movielist.stream()
				.map(usermovie -> this.getMovieRatings(usermovie))
				.collect(Collectors.toList());
		
		usermovierating.setMovieRating(mr);
		return usermovierating;
	}
	
	public MovieRating getMovieRatings(Moviesbyuser moviesbyuser) {
		Movie mv = restTemplate.getForObject("http://localhost:8082/movieinfo/movieid/"+moviesbyuser.getmovieid(), Movie.class);
		return new MovieRating(mv, moviesbyuser.getRating());
	}
}