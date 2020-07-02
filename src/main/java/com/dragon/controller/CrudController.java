package com.dragon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.model.MovieDetails;
import com.dragon.service.MovieService;

@RestController
@RequestMapping("/movie")
public class CrudController {
	
	@Autowired
	MovieService movieService;
	
	@GetMapping("/list")
	public ResponseEntity<List<MovieDetails>> getMovieDetails() {
		
		List<MovieDetails> movieList = movieService.getAllMovies();
		
		return new ResponseEntity<List<MovieDetails>>(movieList,new HttpHeaders(), HttpStatus.OK);
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<MovieDetails> createOrUpdateMovieDetails(@RequestBody MovieDetails movieDetail) {
		System.out.println(movieDetail.getMovieId());
		MovieDetails updateMovieList = movieService.createOrUpdateMovieDetails(movieDetail);
		
		return new ResponseEntity<MovieDetails>(updateMovieList,new HttpHeaders(), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public HttpStatus deleteMovie(@PathVariable("id") int id) {
		movieService.deleteMovie(id);
		return HttpStatus.FORBIDDEN;
	}

}
