package com.qa.cne2022.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.cne2022.persistance.domain.Movie;
import com.qa.cne2022.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	//passes things to the service
	private MovieService service ;

	
	@Autowired
	public MovieController(MovieService service) {
		super();
		this.service = service;
	}
	
	//create
	@PostMapping ("/create")
	
	public ResponseEntity <Movie> create(@RequestBody Movie movie){
		Movie createdObject = this.service.create(movie);
		return new ResponseEntity<>(createdObject, HttpStatus.CREATED) ; //CODE 201
		
	}
	
	//readbyID
	@GetMapping ("/read/{id}")
	public ResponseEntity <Movie> readbyID(@PathVariable long id) {
		Movie returnedObject = this.service.readByID(id);
		return ResponseEntity.ok(returnedObject) ; 
	}
	//readAll	 
	@GetMapping ( "/readall")
	public ResponseEntity <List< Movie >> readAll() {
		return ResponseEntity.ok(this.service.readAll());  // CODE 200
	}
	
	//updatebyID
	@PutMapping ( "/update/{id}" )
	public ResponseEntity<Movie> updatebyId (@PathVariable long id, @RequestBody Movie movie){
		Movie updatedObject = this.service.updateById(id ,movie);
		return new ResponseEntity<>(updatedObject,HttpStatus.ACCEPTED); // CODE 202
		
	}
	
	
	//deletebyID
	
	@DeleteMapping ("/delete/{id}")
	public  ResponseEntity <Movie> deletebyId (@PathVariable long id) {
		if (this.service.deletebyId(id)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); //CODE 204
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //CDOE 503
		}
	}
	

}
//Status Codes - 2XX WORKED, 4XX- user ERROR, 5XX - DEVELOPER ERROR
