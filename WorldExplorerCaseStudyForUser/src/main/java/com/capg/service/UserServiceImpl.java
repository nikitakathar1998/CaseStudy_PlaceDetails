package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.exception.DataNotFoundException;
import com.capg.model.PlaceDetails;
import com.capg.repository.PlaceDetailsRepository;



@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private PlaceDetailsRepository pdRepo;
	
	
    public UserServiceImpl(PlaceDetailsRepository pdRepo) {
        super();
        this.pdRepo = pdRepo;
    }

	@Override
	public List<PlaceDetails> getAllplace() throws DataNotFoundException{
		// TODO Auto-generated method stub
		return (List<PlaceDetails>) pdRepo.findAll();
		
	}

}
