package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.exception.DataAlreadyDeletedException;
import com.capg.exception.DataAlreadyExistsException;
import com.capg.model.PlaceDetails;
import com.capg.service.PlaceDetailsForAdmin;

@RestController
@RequestMapping("/api/v1")
public class PlaceDetailsController {

	private PlaceDetailsForAdmin pdadmin;
	
	//Parametarized Constructor
	@Autowired
	public PlaceDetailsController(PlaceDetailsForAdmin pdadmin) {
		super();
		this.pdadmin = pdadmin;
	}
	
	@PostMapping("/addplace")
	public ResponseEntity <PlaceDetails> Addplaces(@RequestBody PlaceDetails pd)throws DataAlreadyExistsException {
		PlaceDetails savePlace = pdadmin.addplace(pd);
	return new ResponseEntity<>(savePlace, HttpStatus.CREATED);

	}
	
	@GetMapping("/getall")
	public ResponseEntity <List<PlaceDetails>> getAllplace(){
		return new ResponseEntity <List<PlaceDetails>>((List<PlaceDetails>)pdadmin.getAllplace(),HttpStatus.OK);
	}
	
	@DeleteMapping("place/{pincode}")
	public ResponseEntity<Void> deleteplaceByPincode(@PathVariable int pincode)throws DataAlreadyDeletedException{
		pdadmin.deleteplaceByPincode(pincode);
		return ResponseEntity.noContent().build();
		}
	
	@PutMapping("/update")
	public PlaceDetails updatePlace(@RequestBody PlaceDetails updateplace) {
		return pdadmin.updateplace(updateplace);
	}
}
