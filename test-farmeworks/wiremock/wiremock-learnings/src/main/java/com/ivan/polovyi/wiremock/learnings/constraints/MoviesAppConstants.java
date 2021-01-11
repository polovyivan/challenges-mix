package com.ivan.polovyi.wiremock.learnings.constraints;

import java.net.URI;
import java.util.function.Function;
import org.springframework.web.util.UriBuilder;

public class MoviesAppConstants {


  public static final String GET_ALL_V1 = "/movieservice/v1/allMovies";
  public static final String MOVIE_BY_ID_PATH_PARAM_V1 = "/movieservice/v1/movie/{id}";
  public static final String MOVIE_BY_NAME_QUERY_PARAM_V1 = "/movieservice/v1/movieName";
  public static final String MOVIE_BY_YEAR_QUERY_PARAM_V1 = "/movieservice/v1/movieYear";
  public static final String ADD_MOVIE_V1 = "/movieservice/v1/movie";

}
