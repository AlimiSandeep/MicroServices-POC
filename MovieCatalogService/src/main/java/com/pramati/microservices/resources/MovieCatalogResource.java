package com.pramati.microservices.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.microservices.models.CatalogItem;
import com.pramati.microservices.models.UserRating;
import com.pramati.microservices.service.MovieInfo;
import com.pramati.microservices.service.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private UserRatingInfo userRatingInfo;
	
	@Autowired
	private MovieInfo movieInfo;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		UserRating userRating = userRatingInfo.getUserRating(userId);
		return userRating.getRatings().stream().map(rating -> movieInfo.getCatalogItem(rating)).collect(Collectors.toList());

	}


	public List<CatalogItem> getFallBackCatalog(@PathVariable("userId") String userId) {
		return Arrays.asList(new CatalogItem("No movie", " ", 0));
	}

}
