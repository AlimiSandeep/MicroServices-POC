# MicroServices-POC
Created three microservices
-MovieCatalogService
-MovieInfoService
-MovieRatingService

MovieCatalogService returns list of movies their description and ratings for the corresponding userID
MovieInfoService gives movie description for corresponding movieId
MovieRatingService gives movie ratings for corresponding movieId

Made use of Spring Cloud RestTemplate for calling microservices API
Used Eureka Server for Service Discovery and Registration
