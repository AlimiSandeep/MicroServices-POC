package com.pramati.microservices.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.microservices.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@RequestMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieId) {
		return new Movie(movieId, "Bumble Bee");

	}
}
