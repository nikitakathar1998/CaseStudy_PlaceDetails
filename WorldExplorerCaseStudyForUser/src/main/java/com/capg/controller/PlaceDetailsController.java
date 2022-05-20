package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.exception.DataNotFoundException;
import com.capg.model.PlaceDetails;
import com.capg.service.UserService;


@RestController
@RequestMapping("/api/v1")
public class PlaceDetailsController {
	
	@Autowired
	private UserService ser;
	
	//Parametarized constructor
	public PlaceDetailsController(UserService ser) {
		super();
		this.ser = ser;
	}

	@GetMapping("/getall")
	public ResponseEntity <List<PlaceDetails>> getAllplace() throws DataNotFoundException{
		return new ResponseEntity <List<PlaceDetails>>((List<PlaceDetails>)ser.getAllplace(),HttpStatus.OK);
	}
}

