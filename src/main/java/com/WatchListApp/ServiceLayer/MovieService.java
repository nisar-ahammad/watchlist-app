package com.WatchListApp.ServiceLayer;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WatchListApp.ModelLayer.Movie;
import com.WatchListApp.RepositoryLayer.MovieRepository;



@Service
public class MovieService {
	
	@Autowired
   MovieRepository movieRepository;
	
	
	@Autowired
	RatingServices ratingServices;

	
	public void rating(Movie movie)
	{
		String rating=ratingServices.getRating(movie.getTitle());
		if(rating!=null)
		{
			movie.setRating(Float.parseFloat(rating));
		}
		if(Float.parseFloat(rating)<=5)
		{
			movie.setPriority("L");
		}
	    if(Float.parseFloat(rating)>5&&Float.parseFloat(rating)<8)
		{
			movie.setPriority("M");
		}
	    if(Float.parseFloat(rating)>8&&Float.parseFloat(rating)<=10)
		{
			movie.setPriority("H");
		}
		
	}
	public void createMovie(Movie movie) {
		// TODO Auto-generated method stub
		
		rating(movie);
		movieRepository.save(movie);
	}
	
	public List<Movie> getMovieList()
	{
		return movieRepository.findAll();
	}

	public Movie getMovieById(Integer id) {
		// TODO Auto-generated method stub
		return movieRepository.findById(id).get();
		
		
	}

	public void updateMovieById(Movie movie, Integer id) {
		// TODO Auto-generated method stub
		Movie updatedMovie=getMovieById(id);
		updatedMovie.setTitle(movie.getTitle());
		updatedMovie.setRating(movie.getRating());
		updatedMovie.setPriority(movie.getPriority());
		updatedMovie.setComment(movie.getComment());
		
		rating(updatedMovie);
        
		movieRepository.save(updatedMovie);
	}
	
	public void delete(Integer id)
	{
		
	    movieRepository.deleteById(id);
	    
	}
	
	

}
