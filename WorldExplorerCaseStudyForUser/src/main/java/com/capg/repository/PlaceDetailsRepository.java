package com.capg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capg.model.PlaceDetails;

public interface PlaceDetailsRepository extends MongoRepository<PlaceDetails, Integer> {

	
}
