package com.themovieapp.movies.movierepository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.themovieapp.movies.models.Movies;
@Repository
public interface MovieRepo extends MongoRepository<Movies,String>  {

 List<Movies> getAllByTitle(String title);
}
