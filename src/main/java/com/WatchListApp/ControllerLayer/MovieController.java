package com.WatchListApp.ControllerLayer;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.WatchListApp.ModelLayer.Movie;
import com.WatchListApp.ServiceLayer.MovieService;

import jakarta.validation.Valid;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;
	
	@GetMapping("/submitform")
	public ModelAndView getSubmitForm(@RequestParam(required = false) Integer id)
	{
		String viewName="submitform";
		Map<String, Object> model=new HashMap<>();
		
		if(id==null)
		{
			model.put("submit", new Movie());
			return new ModelAndView(viewName,model);
		}
		else {
			model.put("submit",movieService.getMovieById(id));
		}
		
		return new ModelAndView(viewName,model);
	}
	
	



	@PostMapping("/submitform")
	public ModelAndView postSubmitForm(@Valid @ModelAttribute("submit")Movie movie,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return new ModelAndView("submitform");
		}
		
		Integer id=movie.getId();
		if(id==null)
		{
			movieService.createMovie(movie);
			
		}
		else {
			movieService.updateMovieById(movie,id);
		}
		
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl("/watchlist");
		
		return new ModelAndView(redirectView);
	}
	
	@GetMapping("/watchlist")
	public ModelAndView getWatchlist(Movie movie)
	{
		Integer id=movie.getId();
	    
		String viewName="watchlist";
		List<Movie> list=movieService.getMovieList();
		Map<String, Object> model=new HashMap<>();
		if(id==null) {
		model.put("getwatchlist", list);
		model.put("no_of_movies", list.size());
		}
		else
		{
			movieService.delete(id);
			RedirectView redirectView=new RedirectView();
		    redirectView.setUrl("/watchlist");
		    return new ModelAndView(redirectView);
		}
			
	    return new ModelAndView(viewName,model);
		
	}
	
	

	
	
	
}
