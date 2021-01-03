package com.ivan.polovyi.challeges.cacheannotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheAnnotationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheAnnotationsApplication.class, args);
	}

}
