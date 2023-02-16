package com.demojavaplatzitest.movies.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import com.demojavaplatzitest.app.DemojavaplatzitestApplication;
import com.demojavaplatzitest.movies.data.MovieRepository;
import com.demojavaplatzitest.movies.model.Genre;
import com.demojavaplatzitest.movies.model.Movie;

@SpringBootTest(classes = DemojavaplatzitestApplication.class,webEnvironment =  WebEnvironment.RANDOM_PORT)
class MovieServiceTest {
	
	@Mock
	private MovieRepository movieRepository;
	
	@InjectMocks
	private MovieService movieService;
	
	@BeforeEach
	public void setUp() {
		movieService = new MovieService(movieRepository);
		
		when(movieRepository.findAll()).thenReturn(
				Arrays.asList(
						new Movie(1, "Dark Knight", 152, Genre.ACTION),
						new Movie(2, "Memento", 113, Genre.DRAMA),
						new Movie(3, "There is Something About Marty", 119, Genre.COMEDY),
						new Movie(4, "Super 8", 112, Genre.THRILLER),
						new Movie(5, "Scream", 111, Genre.HORROR),
						new Movie(6, "Home Alone", 103, Genre.COMEDY),
						new Movie(7, "Matrix", 136, Genre.ACTION),
						new Movie(8,"Superman", 126, Genre.ACTION),
					    new Movie(9,"Spiderman: de regreso a casa", 126, Genre.ACTION),
					    new Movie(10,"Supercan", 136, Genre.ACTION),
					    new Movie(11,"Rapidos y furiosos 10", 126, Genre.ACTION),
					    new Movie(12,"John Wick 2", 146, Genre.ACTION),
					    new Movie(13,"John Wick 3", 146, Genre.ACTION),
					    new Movie(14,"John Wick 4", 146, Genre.ACTION)
					)
				);
	}
	
	private List<Integer> getMovieIds(Collection<Movie> movies) {
		return movies.stream().map(Movie::getId)
				.toList();
	}
	
	@Test
	void returnMoviesByGenre() {
		Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
		
		assertEquals(Arrays.asList(3,6),getMovieIds(movies));
	}

	@Test
	void returnMoviesByLength() {
		Collection<Movie> movies = movieService.findMoviesByLength(119);
		
		assertEquals(Arrays.asList(2,3,4,5,6),getMovieIds(movies));
	}
	
	@Test
	void returnMoviesByName() {
		Collection<Movie> movies = movieService.findMoviesByName("john");
		
		assertEquals(Arrays.asList(
				"john wick 2",
				"john wick 3",
				"john wick 4"), movies.stream().map(Movie::getName)
				.map(String::toLowerCase).toList());
	}
	
	@Test
	void returnMoviesIdByNameAndMinutes() {
		Collection<Movie> movies = movieService.findMoviesByTemplate(
				new Movie(null,"John",146,null));
		
		assertEquals(Arrays.asList(12,13,14),getMovieIds(movies));
	}
	
	@Test
	void returnMoviesNameById() {
		Collection<Movie> movies = movieService.findMoviesByTemplate(
				new Movie(1,null,null,Genre.ACTION));
		
		assertEquals(Arrays.asList("dark knight"), 
				movies.stream().map(Movie::getName).map(String::toLowerCase).toList());
	}
	
	@Test
	void usingNegativeMinutes() {
		Exception exception = assertThrows(IllegalArgumentException.class, 
				()-> {
					movieService.findMoviesByTemplate(
						new Movie(null,null,-146,Genre.ACTION));
				});
		assertEquals("Negative times are not allowed", exception.getMessage());
	}
	
	@Test
	void returnMoviesNameByMinutesAndGenre() {
		Collection<Movie> movies = movieService.findMoviesByTemplate(
				new Movie(null,null,136, Genre.ACTION));
		
		assertEquals(Arrays.asList(
				"matrix","superman","spiderman: de regreso a casa",
				"supercan","rapidos y furiosos 10"
				), movies.stream().map(Movie::getName)
				.map(String::toLowerCase).toList());
	}
	
	@Test
	void returnMoviesGenreByNameAndMinutes() {
		Collection<Movie> movieList = movieService.findMoviesByTemplate(
				new Movie(null,"super",130,null));
		
		assertEquals(Arrays.asList(4,8), getMovieIds(movieList));
	}
	
}
