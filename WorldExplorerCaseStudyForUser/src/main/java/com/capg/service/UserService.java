package com.capg.service;

import java.util.List;

import com.capg.exception.DataNotFoundException;
import com.capg.model.PlaceDetails;

public interface UserService {

	
	public List<PlaceDetails> getAllplace()throws DataNotFoundException;
}
