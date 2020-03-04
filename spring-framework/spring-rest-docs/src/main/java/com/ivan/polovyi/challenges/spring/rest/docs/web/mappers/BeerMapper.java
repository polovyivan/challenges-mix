package com.ivan.polovyi.challenges.spring.rest.docs.web.mappers;


import com.ivan.polovyi.challenges.spring.rest.docs.domain.Beer;
import com.ivan.polovyi.challenges.spring.rest.docs.web.model.BeerDto;
import org.mapstruct.Mapper;


@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto BeerToBeerDto(Beer beer);

    Beer BeerDtoToBeer(BeerDto dto);
}
