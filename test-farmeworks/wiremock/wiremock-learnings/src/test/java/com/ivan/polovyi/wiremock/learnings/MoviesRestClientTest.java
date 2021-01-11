package com.ivan.polovyi.wiremock.learnings;

import com.github.jenspiegsa.wiremockextension.ConfigureWireMock;
import com.github.jenspiegsa.wiremockextension.InjectServer;
import com.github.jenspiegsa.wiremockextension.WireMockExtension;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.core.Options;

import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.ivan.polovyi.wiremock.learnings.constraints.MoviesAppConstants;
import com.ivan.polovyi.wiremock.learnings.dto.Movie;
import com.ivan.polovyi.wiremock.learnings.exception.MovieErrorResponse;
import com.ivan.polovyi.wiremock.learnings.service.MoviesRestClient;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(WireMockExtension.class)
public class MoviesRestClientTest {

  private MoviesRestClient moviesRestClient;
  private WebClient webClient;

  @InjectServer
  private WireMockServer wireMockServer;

  @ConfigureWireMock
  private Options options = wireMockConfig()
      .port(8088)
      .notifier(new ConsoleNotifier(true))
      .extensions(new ResponseTemplateTransformer(true));


  @BeforeEach
  void setUp() {
    int port = wireMockServer.port();
    String baseUrl = String.format("http://localhost:%s", port);
    System.out.println("baseUrl = " + baseUrl);
    webClient = WebClient.create(baseUrl);
    moviesRestClient = new MoviesRestClient(webClient);
  }

  @Test
  public void retrieveAllMovies() {
    //given
    stubFor(get(anyUrl())
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.OK.value())
            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .withBodyFile("all-movies.json")));

    // when
    List<Movie> movies = moviesRestClient.retrieveAllMovies();
    System.out.println("movies = " + movies);
    //then
    assertTrue(movies.size() > 0);

  }

  @Test
  public void retrieveAllMoviesMatchURL() {
    //given
    stubFor(get(urlEqualTo(MoviesAppConstants.GET_ALL_V1))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.OK.value())
            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .withBodyFile("all-movies.json")));

    // when
    List<Movie> movies = moviesRestClient.retrieveAllMovies();
    System.out.println("movies = " + movies);
    //then

  }

  @Test
  public void retrieveMovieById() {
    //given
    stubFor(get(urlPathMatching("/movieservice/v1/movie/[0-9]"))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.OK.value())
            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .withBodyFile("movie.json")));
    Integer movieId = 1;

    //when
    Movie movie = moviesRestClient.retrieveMovieById(movieId);

    //then
    assertEquals("Batman Begins", movie.getName());

  }


  @Test
  public void retrieveMovieByIdResponseTemplating() {
    //given
    stubFor(get(urlPathMatching("/movieservice/v1/movie/[0-9]"))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.OK.value())
            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .withBodyFile("movie.json")));
    Integer movieId = 1;

    //when
    Movie movie = moviesRestClient.retrieveMovieById(movieId);

    //then
    assertEquals("Batman Begins", movie.getName());
    assertEquals(1, movie.getMovie_id().intValue());
  }

  @Test
  public void retrieveMovieByIdNotFound() {
    //given
    stubFor(get(urlPathMatching("/movieservice/v1/movie/[0-9]+"))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.NOT_FOUND.value())
            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .withBodyFile("404-movieId.json")));

    Integer movieId = 100;
    //then
    Assertions.assertThrows(MovieErrorResponse.class,
        () -> moviesRestClient.retrieveMovieById(movieId));
  }

  @Test
  public void retrieveMovieByName() {
    //given
    String movieName = "Avengers";
    stubFor(get(urlEqualTo(
        MoviesAppConstants.MOVIE_BY_NAME_QUERY_PARAM_V1 + "?movie_name=" + movieName))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.OK.value())
            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .withBodyFile("avenger.json")));

    //when
    List<Movie> movies = moviesRestClient.retrieveMovieByName(movieName);
    //then
    assertEquals(4, movies.size());
  }

  @Test
  public void retrieveMovieByNameResponseTemplating() {
    //given
    String movieName = "Avengers";
    stubFor(get(urlEqualTo(
        MoviesAppConstants.MOVIE_BY_NAME_QUERY_PARAM_V1 + "?movie_name=" + movieName))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.OK.value())
            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .withBodyFile("movie-by-name-template.json")));

    //when
    List<Movie> movies = moviesRestClient.retrieveMovieByName(movieName);
    //then
    assertEquals(4, movies.size());
  }

  @Test
  public void retrieveMovieByNameApproach2() {
    //given
    String movieName = "Avengers";
    stubFor(get(urlPathEqualTo(MoviesAppConstants.MOVIE_BY_NAME_QUERY_PARAM_V1))
        //.withQueryParam("movie_name",equalTo(movieName))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.OK.value())
            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .withBodyFile("avenger.json")));

    //when
    List<Movie> movies = moviesRestClient.retrieveMovieByName(movieName);
    //then
    assertEquals(4, movies.size());
  }

//  @Test
//  @Ignore
//  public void retrieveMovieByNameNotFound() {
//    //given
//    String movieName = "ABC";
//    //then
//    Assertions.assertThrows(MovieErrorResponse.class,
//        () -> moviesRestClient.retrieveMovieByName(movieName));
//  }


  @Test
  public void retrieveMovieByYear() {
    //given
    Integer movieYear = 2012;

    //given
    stubFor(get(urlEqualTo(MoviesAppConstants.MOVIE_BY_YEAR_QUERY_PARAM_V1 + "?year=" + movieYear))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.OK.value())
            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .withBodyFile("year-template.json")));

    //when
    List<Movie> movies = moviesRestClient.retrieveMovieByYear(movieYear);
    //then
    assertEquals(2, movies.size());
  }

  @Test
  public void retrieveMovieByYearNotFound() {
    //given
    Integer year = 1950;
    stubFor(get(urlEqualTo(MoviesAppConstants.MOVIE_BY_YEAR_QUERY_PARAM_V1 + "?year=" + year))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.NOT_FOUND.value())
            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .withBodyFile("404-movie-by-year.json")));
    //then
    Assertions.assertThrows(MovieErrorResponse.class,
        () -> moviesRestClient.retrieveMovieByYear(year));
  }

  @Test
  public void addMovie() {
    //given
    Movie movie = new Movie(null, "Toy story 4", "Tom Hanks, Tim All", LocalDate.of(2019, 06, 20),
        2019);

    stubFor(post(urlPathEqualTo(MoviesAppConstants.ADD_MOVIE_V1))
        //.withQueryParam("movie_name",equalTo(movieName))
        .withRequestBody(matchingJsonPath("$.name", equalTo("Toy story 4")))
        .withRequestBody(matchingJsonPath("$.cast", containing("Tom Hanks")))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.OK.value())
            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .withBodyFile("add-movie.json")));
    //when
    Movie returnedMovie = moviesRestClient.createMovie(movie);
    //then
    assertNotNull(returnedMovie);
  }


  @Test
  public void addMovieResponseTemplating() {
    //given
    Movie movie = new Movie(null, "Toy story 4", "Tom Hanks, Tim All", LocalDate.of(2019, 06, 20),
        2019);

    stubFor(post(urlPathEqualTo(MoviesAppConstants.ADD_MOVIE_V1))
        //.withQueryParam("movie_name",equalTo(movieName))
        .withRequestBody(matchingJsonPath("$.name", equalTo("Toy story 4")))
        .withRequestBody(matchingJsonPath("$.cast", containing("Tom Hanks")))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.OK.value())
            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .withBodyFile("add-movie-templating.json")));
    //when
    Movie returnedMovie = moviesRestClient.createMovie(movie);
    //then
    assertNotNull(returnedMovie);
  }

  @Test
  public void createMovieBadRequest() {
    Movie movie = new Movie(null, null, "Tom Hanks, Tim All", LocalDate.of(2019, 06, 20), 2019);

    stubFor(post(urlPathEqualTo(MoviesAppConstants.ADD_MOVIE_V1))
        //.withQueryParam("movie_name",equalTo(movieName))
        .withRequestBody(matchingJsonPath("$.cast", containing("Tom Hanks")))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.BAD_REQUEST.value())
            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .withBodyFile("400-invalid-input.json")));

    // when
    String expectedErrorMessage = "Please pass all the input fields : [name]";
    Assertions.assertThrows(MovieErrorResponse.class,
        () -> moviesRestClient.createMovie(movie), expectedErrorMessage);
  }

  @Test
  public void updateMovie() {
    //given
    Integer movieId = 3;
    String cast = "ABC";
    Movie movie = new Movie(null, null, cast, null, null);
    stubFor(put(urlPathMatching("/movieservice/v1/movie/[0-9]+"))
        .withRequestBody(matchingJsonPath("$.cast", containing(cast)))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.OK.value())
            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .withBodyFile("update-movie-templating.json")));

    //when
    Movie returnedMovie = moviesRestClient.updateMovie(movieId, movie);
    //then
    assertTrue(returnedMovie.getCast().contains(cast));
  }


  @Test
  public void updateMovieBadRequest() {
    String cast = "ABC";
    Movie movie = new Movie(null, null, cast, null, null);
    stubFor(put(urlPathMatching("/movieservice/v1/movie/[0-9]+"))
        .withRequestBody(matchingJsonPath("$.cast", containing(cast)))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.NOT_FOUND.value())
            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)));
    //when
    Assertions.assertThrows(MovieErrorResponse.class,
        () -> moviesRestClient.updateMovie(100, movie));
  }


  @Test
  public void deleteMovieById() {
    //given
    //given
    Movie movie = new Movie(null, "Toy story 5", "Tom Hanks, Tim All", LocalDate.of(2019, 06, 20),
        2019);

    stubFor(post(urlPathEqualTo(MoviesAppConstants.ADD_MOVIE_V1))
        .withRequestBody(matchingJsonPath("$.name", equalTo("Toy story 5")))
        .withRequestBody(matchingJsonPath("$.cast", containing("Tom Hanks")))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.OK.value())
            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .withBodyFile("add-movie-templating.json")));

    //when
    Movie returnedMovie = moviesRestClient.createMovie(movie);

    String movieDeletedSuccessfully = "Movie Deleted Successfully";

    stubFor(delete(urlPathMatching("/movieservice/v1/movie/[0-9]+"))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.OK.value())
            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .withBody(movieDeletedSuccessfully)));

    //when
    String response = moviesRestClient.deleteMovieById(returnedMovie.getMovie_id().intValue());

    //then

    assertEquals(movieDeletedSuccessfully, response);

  }

  @Test
  public void deleteMovieBadRequest() {

    stubFor(delete(urlPathMatching("/movieservice/v1/movie/[0-9]+"))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.NOT_FOUND.value())
            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)));

    //when
    Assertions.assertThrows(MovieErrorResponse.class,
        () -> moviesRestClient.deleteMovieById(100));
  }


  @Test
  public void deleteMovieByName() {
    //given
    //given
    Movie movie = new Movie(null, "Toy story 5", "Tom Hanks, Tim All", LocalDate.of(2019, 06, 20),
        2019);

    stubFor(post(urlPathEqualTo(MoviesAppConstants.ADD_MOVIE_V1))
        .withRequestBody(matchingJsonPath("$.name", equalTo("Toy story 5")))
        .withRequestBody(matchingJsonPath("$.cast", containing("Tom Hanks")))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.OK.value())
            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .withBodyFile("add-movie-templating.json")));

    //when
    Movie returnedMovie = moviesRestClient.createMovie(movie);

    String movieDeletedSuccessfully = "Movie Deleted Successfully";

    stubFor(delete(urlEqualTo(
        MoviesAppConstants.MOVIE_BY_NAME_QUERY_PARAM_V1 + "?movie_name=Toy%20story%205"))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.OK.value())
            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)));

    //when
    String response = moviesRestClient.deleteMovieByName(returnedMovie.getName());

    //then

    assertEquals(movieDeletedSuccessfully, response);

    verify(exactly(1), postRequestedFor(urlPathEqualTo(MoviesAppConstants.ADD_MOVIE_V1))
        .withRequestBody(matchingJsonPath("$.name", equalTo("Toy story 5")))
        .withRequestBody(matchingJsonPath("$.cast", containing("Tom Hanks"))));


    verify(exactly(1), deleteRequestedFor(urlEqualTo(
        MoviesAppConstants.MOVIE_BY_NAME_QUERY_PARAM_V1 + "?movie_name=Toy%20story%205")));

  }

}
