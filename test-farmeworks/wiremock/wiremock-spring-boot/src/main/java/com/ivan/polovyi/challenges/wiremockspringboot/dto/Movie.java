package com.ivan.polovyi.challenges.wiremockspringboot.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

  private Long movie_id;
  private String name;
  private String cast;
  private LocalDate release_date;
  public Integer year;

}
