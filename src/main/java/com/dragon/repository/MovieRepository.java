package com.dragon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dragon.model.MovieDetails;

@Repository
public interface MovieRepository extends JpaRepository<MovieDetails, Integer> {

}
