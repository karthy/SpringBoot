package com.dragon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragon.model.MovieDetails;
import com.dragon.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepository;
	
	public List<MovieDetails> getAllMovies(){
		List<MovieDetails> movieList = movieRepository.findAll();
		
		if(movieList.size()>0) {
			return movieList;
		}else {
			return null;
		}
	}

	public MovieDetails createOrUpdateMovieDetails(MovieDetails movieDetail) {
		System.out.println(movieDetail.getMovieId());
		Optional<MovieDetails> updatedDetails = movieRepository.findById(movieDetail.getMovieId());
		
		if(updatedDetails.isPresent()) {
			MovieDetails updateMovie =updatedDetails.get();
			updateMovie.setMovie_name(movieDetail.getMovie_name());
			updateMovie.setRent_price(movieDetail.getRent_price());
			
			updateMovie =movieRepository.save(updateMovie);
			
			return updateMovie;
		}else {
			movieDetail = movieRepository.save(movieDetail);
			return movieDetail;
		}
	}

	public void deleteMovie(int id) {
		Optional<MovieDetails> movieDetail= movieRepository.findById(id);
		System.out.println(id);
		if(movieDetail.isPresent()) {
			System.out.println("Entered into present");
			movieRepository.deleteById(id);
		}
		
	}

}
