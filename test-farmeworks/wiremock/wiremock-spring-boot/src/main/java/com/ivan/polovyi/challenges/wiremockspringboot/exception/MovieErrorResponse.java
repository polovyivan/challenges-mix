package com.ivan.polovyi.challenges.wiremockspringboot.exception;

import org.springframework.web.reactive.function.client.WebClientResponseException;

public class MovieErrorResponse extends
    RuntimeException {

  public MovieErrorResponse(String statusText, WebClientResponseException ex) {
  }

  public MovieErrorResponse(Exception e) {

  }
}
