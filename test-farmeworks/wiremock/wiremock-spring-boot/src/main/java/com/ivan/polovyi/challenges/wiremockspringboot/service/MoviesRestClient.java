package com.ivan.polovyi.challenges.wiremockspringboot.service;


import com.ivan.polovyi.challenges.wiremockspringboot.constraints.MoviesAppConstants;
import com.ivan.polovyi.challenges.wiremockspringboot.dto.Movie;
import com.ivan.polovyi.challenges.wiremockspringboot.exception.MovieErrorResponse;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Component
public class MoviesRestClient {

  @Autowired
  private WebClient webClient;


  public List<Movie> retrieveAllMovies() {

    //http://localhost:8081/movieservice/v1/allMovies
    try {
      return webClient.get().uri(MoviesAppConstants.GET_ALL_V1)
          .retrieve()
          .bodyToFlux(Movie.class)
          .collectList()
          .block();
    } catch (WebClientResponseException ex) {
      log.error("WebClientResponseException in retrieveAllMovies. Status code is {} and the message is {} ", ex.getRawStatusCode(), ex.getResponseBodyAsString());
      throw new MovieErrorResponse(ex.getStatusText(), ex);
    } catch (Exception ex) {
      log.error("Exception in retrieveAllMovies and the message is {} ", ex.getMessage() + ex);
      throw new MovieErrorResponse(ex);
    }
  }

  public Movie retrieveMovieById(Integer movieId) {
    try {
      return webClient.get().uri(MoviesAppConstants.MOVIE_BY_ID_PATH_PARAM_V1, movieId)
          .retrieve()
          .bodyToMono(Movie.class)
          .block();
    } catch (WebClientResponseException e) {
      log.error("WebClientException in retrieveMovieById.Status code as {} and message is {}",
          e.getStatusCode(), e.getResponseBodyAsString());
      throw new MovieErrorResponse(e.getStatusText(), e);
    } catch (Exception e) {
      log.error("WebClientException in retrieveMovieById. Message is {}", e);
      throw new MovieErrorResponse(e);
    }
  }


  public List<Movie> retrieveMovieByName(String movieName) {

    String retrieveByNameUri = UriComponentsBuilder
        .fromUriString(MoviesAppConstants.MOVIE_BY_NAME_QUERY_PARAM_V1)
        .queryParam("movie_name", movieName)
        .buildAndExpand()
        .toUriString();
    try {
      return webClient.get().uri(retrieveByNameUri)
          .retrieve()
          .bodyToFlux(Movie.class)
          .collectList()
          .block();
    } catch (WebClientResponseException e) {
      log.error("WebClientException in retrieveMovieByName.Status code as {} and message is {}",
          e.getStatusCode(), e.getResponseBodyAsString());
      throw new MovieErrorResponse(e.getStatusText(), e);
    } catch (Exception e) {
      log.error("WebClientException in retrieveMovieByName. Message is {}", e);
      throw new MovieErrorResponse(e);
    }
  }


  public List<Movie> retrieveMovieByYear(Integer year) {

    String retrieveByNameUri = UriComponentsBuilder
        .fromUriString(MoviesAppConstants.MOVIE_BY_YEAR_QUERY_PARAM_V1)
        .queryParam("year", year)
        .buildAndExpand()
        .toUriString();
    try {
      return webClient.get().uri(retrieveByNameUri)
          .retrieve()
          .bodyToFlux(Movie.class)
          .collectList()
          .block();
    } catch (WebClientResponseException e) {
      log.error("WebClientException in retrieveMovieByYear. Status code as {} and message is {}",
          e.getStatusCode(), e.getResponseBodyAsString());
      throw new MovieErrorResponse(e.getStatusText(), e);
    } catch (Exception e) {
      log.error("WebClientException in retrieveMovieByYear. Message is {}", e);
      throw new MovieErrorResponse(e);
    }
  }


  public Movie createMovie(Movie movie) {
    try {
    return webClient.post().uri(MoviesAppConstants.ADD_MOVIE_V1)
        .syncBody(movie)
        .retrieve()
        .bodyToMono(Movie.class)
        .block();
    } catch (WebClientResponseException e) {
      log.error("WebClientException in createMovie. Status code as {} and message is {}",
          e.getStatusCode(), e.getResponseBodyAsString());
      throw new MovieErrorResponse(e.getStatusText(), e);
    } catch (Exception e) {
      log.error("WebClientException in createMovie. Message is {}", e);
      throw new MovieErrorResponse(e);
    }
  }



  public Movie updateMovie(Integer movieId, Movie movie) {
    try {
      return webClient.put().uri(MoviesAppConstants.MOVIE_BY_ID_PATH_PARAM_V1,movieId)
          .syncBody(movie)
          .retrieve()
          .bodyToMono(Movie.class)
          .block();
    } catch (WebClientResponseException e) {
      log.error("WebClientException in updateMovie. Status code as {} and message is {}",
          e.getStatusCode(), e.getResponseBodyAsString());
      throw new MovieErrorResponse(e.getStatusText(), e);
    } catch (Exception e) {
      log.error("WebClientException in updateMovie. Message is {}", e);
      throw new MovieErrorResponse(e);
    }
  }

  public String deleteMovieById(Integer movieId) {
    try {
      return webClient.delete().uri(MoviesAppConstants.MOVIE_BY_ID_PATH_PARAM_V1, movieId)
          .retrieve()
          .bodyToMono(String.class)
          .block();
    } catch (WebClientResponseException e) {
      log.error("WebClientException in deleteMovieById. Status code as {} and message is {}",
          e.getStatusCode(), e.getResponseBodyAsString());
      throw new MovieErrorResponse(e.getStatusText(), e);
    } catch (Exception e) {
      log.error("WebClientException in deleteMovieById. Message is {}", e);
      throw new MovieErrorResponse(e);
    }
  }

  public String deleteMovieByName(String movieName) {

    String deleteMovieByNameURI = UriComponentsBuilder
        .fromUriString(MoviesAppConstants.MOVIE_BY_NAME_QUERY_PARAM_V1)
        .queryParam("movie_name", movieName)
        .buildAndExpand()
        .toUriString();

    try {
       webClient.delete().uri(deleteMovieByNameURI, movieName)
          .retrieve()
          .bodyToMono(Void.class)
          .block();
    } catch (WebClientResponseException e) {
      log.error("WebClientException in deleteMovieByName. Status code as {} and message is {}",
          e.getStatusCode(), e.getResponseBodyAsString());
      throw new MovieErrorResponse(e.getStatusText(), e);
    } catch (Exception e) {
      log.error("WebClientException in deleteMovieByName. Message is {}", e);
      throw new MovieErrorResponse(e);
    }
    return "Movie Deleted Successfully";
  }


}
