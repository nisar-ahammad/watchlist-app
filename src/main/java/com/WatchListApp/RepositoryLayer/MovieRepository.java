package com.WatchListApp.RepositoryLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WatchListApp.ModelLayer.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	
	
}
