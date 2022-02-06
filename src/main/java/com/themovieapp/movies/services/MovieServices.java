package com.themovieapp.movies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.themovieapp.movies.models.Movies;
import com.themovieapp.movies.movierepository.MovieRepo;
@Service
public class MovieServices {

	@Autowired
	private MovieRepo movierepo;
	
	public Movies saveMovies( Movies movies) {
			
			return movierepo.save(movies);
		}
	
	// search by movie name
	public List<Movies> getMoviesbyName(String title) {
		try {

			var movieList = movierepo.getAllByTitle(title);
			return movieList;
		}
		catch(Exception e) {
			System.out.print(e);
		}
		return null;
		}
		
}

