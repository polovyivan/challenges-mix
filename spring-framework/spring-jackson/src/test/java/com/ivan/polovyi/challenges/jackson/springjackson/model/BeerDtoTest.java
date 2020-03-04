package com.ivan.polovyi.challenges.jackson.springjackson.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@JsonTest
class BeerDtoTest extends BaseTest {


    @Test
    void testSerializedDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();
        String jsonString = objectMapper.writeValueAsString(beerDto);
        System.out.println("jsonString = " + jsonString);
    }

    @Test
    void testDeserialization() throws JsonProcessingException {
        String jsonString = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":\"12.99\",\"createdDate\":\"2020-03-04T10:56:24-0300\",\"lastUpdatedDate\":\"2020-03-04T10:56:24.8719859-03:00\",\"myLocalDate\":\"20200304\",\"beerId\":\"a291c1f9-7aca-48b3-a4fb-5ebb0b0eeb8e\"}";
        BeerDto beerDto = objectMapper.readValue(jsonString, BeerDto.class);
        System.out.println("beerDto = " + beerDto);
    }

}