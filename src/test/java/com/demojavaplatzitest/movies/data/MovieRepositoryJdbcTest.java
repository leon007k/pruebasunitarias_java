package com.demojavaplatzitest.movies.data;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Statement;
import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import com.demojavaplatzitest.app.DemojavaplatzitestApplication;
import com.demojavaplatzitest.movies.model.Genre;
import com.demojavaplatzitest.movies.model.Movie;

@SpringBootTest(classes = DemojavaplatzitestApplication.class,webEnvironment =  WebEnvironment.RANDOM_PORT)
class MovieRepositoryJdbcTest {

	@Mock
	private DataSource dataSource;
	
	@Mock
	private JdbcTemplate jdbcTemplate;
	
	@InjectMocks
	private MovieRepositoryJdbc movieRepository;
	
	@BeforeEach
	public void setUp() throws ScriptException, SQLException {
		// * conexion a la base de datos
		dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
		
		// * ejecucion de scripts
		ScriptUtils.executeSqlScript(dataSource.getConnection(), 
				new ClassPathResource("sql_scripts/test-data.sql"));
		
		// * Creacion de JdbcTemplate para el constructo de movieRepository
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		movieRepository = new MovieRepositoryJdbc(jdbcTemplate);
	}
	
	@Test
	void loadAllMovies() throws SQLException{
		assertEquals(Arrays.asList(
				new Movie(1, "Dark Knight", 152, Genre.ACTION),
				new Movie(2, "Memento", 113, Genre.DRAMA),
				new Movie(3, "There is Something About Marty", 119, Genre.COMEDY),
				new Movie(4, "Super 8", 112, Genre.THRILLER),
				new Movie(5, "Scream", 111, Genre.HORROR),
				new Movie(6, "Home Alone", 103, Genre.COMEDY),
				new Movie(7, "Matrix", 136, Genre.ACTION),
				new Movie(8,"Superman", 136, Genre.ACTION),
			    new Movie(9,"Spiderman: de regreso a casa", 126, Genre.ACTION),
			    new Movie(10,"Supercan", 136, Genre.ACTION),
			    new Movie(11,"Rapidos y furiosos 10", 126, Genre.ACTION),
			    new Movie(12,"John Wick 2", 146, Genre.ACTION),
			    new Movie(13,"John Wick 3", 146, Genre.ACTION),
			    new Movie(14,"John Wick 4", 146, Genre.ACTION)),movieRepository.findAll());
	}
	
	@Test
	@Order(2)
	void loadMovieById() {
		Movie movie = movieRepository.findById(1);
		
		assertEquals(movie, new Movie(1, "Dark Knight", 152, Genre.ACTION));
	}
	
	@Test
	@Order(3)
	void insertAMovie() {
		Movie movie = new Movie("Cars",112,Genre.DRAMA);
		
		movieRepository.saveOrUpdate(movie);
	
		Movie movieFounded = movieRepository.findById(15);
	
		assertEquals(movieFounded, new Movie(15,"Cars",112,Genre.DRAMA));
	}
	
	@After
	void tearDown() throws Exception{
		// * Despues de cada prueba ejecutada, se borran los datos de la bd
		final Statement s = dataSource.getConnection().createStatement();
		s.execute("shutdown");
	}
}
