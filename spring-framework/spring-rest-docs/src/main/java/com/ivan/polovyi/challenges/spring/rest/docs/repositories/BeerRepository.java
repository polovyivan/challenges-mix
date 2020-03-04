package com.ivan.polovyi.challenges.spring.rest.docs.repositories;

import com.ivan.polovyi.challenges.spring.rest.docs.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;


public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
