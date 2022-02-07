package com.themovieapp.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.themovieapp.movies.models.Movies;
import com.themovieapp.movies.services.MovieServices;

@RestController
@RequestMapping(value = "/")
public class MovieController {
	@Autowired
	private MovieServices movieservice;

	@GetMapping("/message")
	public String welcomeMessage() {
		return "Welcome to movies demo web application!";
	}

// save moviesinfo to db
	@PostMapping("/addmovies")
	public Movies saveMovies(@RequestBody Movies movies) {
		try {
			Movies mov = movieservice.saveMovies(movies);

			return mov;

		} catch (Exception e) {
			System.out.print(e);
		}
		return movies;
	}

	// search by movie name
	@GetMapping("search/movie")
	public List<Movies> getMoviesbyName(@RequestParam(name = "apikey") String apikey,
			@RequestParam(name = "query") String title) {

		return movieservice.getMoviesbyName(title);
	}
}