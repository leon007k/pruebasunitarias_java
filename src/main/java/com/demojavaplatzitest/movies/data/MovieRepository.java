package com.demojavaplatzitest.movies.data;

import java.util.Collection;

import com.demojavaplatzitest.movies.model.Movie;

public interface MovieRepository {

	Movie findById(long id);
	Collection<Movie> findAll();
	void saveOrUpdate(Movie movie);
}
