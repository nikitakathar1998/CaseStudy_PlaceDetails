package com.capg.service;

import java.util.List;

import com.capg.exception.DataAlreadyDeletedException;
import com.capg.exception.DataAlreadyExistsException;
import com.capg.model.PlaceDetails;

public interface PlaceDetailsForAdmin {

	public PlaceDetails addplace(PlaceDetails pd)throws DataAlreadyExistsException;
	public List<PlaceDetails> getAllplace();
	public PlaceDetails deleteplaceByPincode(int pincode)throws DataAlreadyDeletedException;
	public PlaceDetails updateplace(PlaceDetails updatepd);
}
