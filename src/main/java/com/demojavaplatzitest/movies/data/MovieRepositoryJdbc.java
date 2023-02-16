package com.demojavaplatzitest.movies.data;


import java.util.Collection;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.demojavaplatzitest.movies.model.Genre;
import com.demojavaplatzitest.movies.model.Movie;

public class MovieRepositoryJdbc implements MovieRepository{

	private JdbcTemplate jdbcTemplate;
	
	public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Movie findById(long id) {
		Object[] args = {id};
		return jdbcTemplate.queryForObject("select * from movies where id = ?", movieMapper, args);
	}

	@Override
	public Collection<Movie> findAll() {
		return jdbcTemplate.query("select * from movies", movieMapper);
	}

	@Override
	public void saveOrUpdate(Movie movie) {
		jdbcTemplate.update("insert into movies (name,minutes,genre) values(?,?,?)",
				movie.getName(), movie.getMinutes(), movie.getGenre().toString());
	}
	
	//* tranformamos cada pelicula en un objeto
	private static RowMapper<Movie> movieMapper = (rs,rowNum) ->
		new Movie(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getInt("minutes"),
					Genre.valueOf(rs.getString("genre")));
	
}
