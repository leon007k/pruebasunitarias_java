package com.demojavaplatzitest.movies.service;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demojavaplatzitest.movies.data.MovieRepository;
import com.demojavaplatzitest.movies.model.Genre;
import com.demojavaplatzitest.movies.model.Movie;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	public Collection<Movie> findMoviesByGenre(Genre genre) {
		return movieRepository.findAll().stream()
				.filter(movie -> movie.getGenre() == genre).toList();
	}

	public Collection<Movie> findMoviesByLength(int length) {
		return movieRepository.findAll().stream()
				.filter(movie -> movie.getMinutes() <= length).toList();
	}
	
	public Collection<Movie> findMoviesByName(String name){
		return movieRepository.findAll().stream()
				.filter(movie -> movie.getName().toLowerCase().contains(
						name.toLowerCase().trim()
						)).toList();
	}
	
	public Collection<Movie> findMoviesByTemplate(Movie template) {
	    Predicate<Movie> filter = movie -> true;
	    
	    if (template.getId() != null && template.getId() > 0) {
	       Collection<Movie> movieData = movieRepository.findAll()
	    		   .stream().filter(movie -> movie.getId().equals(template.getId())).toList();
	       return movieData != null ? movieData : Collections.emptyList();
	    }
	    
	    if (template.getName() != null) {
	        String name = template.getName().toLowerCase().trim();
	        filter = filter.and(movie -> movie.getName().toLowerCase().contains(name));
	    }
	    
	    if (template.getMinutes() != null) {
	        int minutes = template.getMinutes();
	        if (minutes < 0) {
	            throw new IllegalArgumentException("Negative times are not allowed");
	        }
	        filter = filter.and(movie -> movie.getMinutes() <= minutes);
	    }
	    
	    if (template.getGenre() != null) {
	        Genre genre = template.getGenre();
	        filter = filter.and(movie -> movie.getGenre() == genre);
	    }
	    
	    return movieRepository.findAll().stream()
	            .filter(filter).toList();
	}

}
