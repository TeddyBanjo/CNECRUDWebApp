package com.qa.cne2022.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.cne2022.persistance.domain.Movie;
import com.qa.cne2022.persistance.repository.MovieRepository;

@Service 
public class MovieService {
	
	private MovieRepository repo ;
	
	@Autowired
	public MovieService( MovieRepository repo) {
		super();
		this.repo = repo ;
		
		}
	
	//methods
	
	public Movie create(Movie movie) {
		Movie created = this.repo.save(movie); 
		return created ;
	}
	

	public Movie readByID(long id ) {
		Movie thingReadFromDb = this.repo.getOne(id);
		return thingReadFromDb;
				
	}
	
	
	public List<Movie> readAll() {
		List<Movie> thingReadFromDb = this.repo.findAll();
		return thingReadFromDb ; 
	}
	
	
	public Movie updateById(long id, Movie updatedMovie) {
		Movie thingToUpdate = this.repo.getOne(id); 
		
		thingToUpdate.setMovieName(updatedMovie.getMovieName());
		thingToUpdate.setMovieDirector(updatedMovie.getMovieDirector());
		thingToUpdate.setMovieLength(updatedMovie.getMovieLength());
		thingToUpdate.setMovieRating(updatedMovie.getMovieRating());
		thingToUpdate.setYearOfRelease(updatedMovie.getYearOfRelease());
		
		return this.repo.save(thingToUpdate) ; 
		}
	
	
	public boolean deletebyId(long id ) {
		this.repo.deleteById(id);
		
		return !this.repo.existsById(id) ;		
	}
	
	

}
