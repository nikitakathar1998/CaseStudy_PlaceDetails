package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.exception.DataAlreadyDeletedException;
import com.capg.exception.DataAlreadyExistsException;
import com.capg.model.PlaceDetails;
import com.capg.repository.PlaceDetailsRepository;


@Service
public class PlaceDetailsAdminImpl implements PlaceDetailsForAdmin {
	
	@Autowired
	private PlaceDetailsRepository pdRepo;
	
	
	@Override
	public PlaceDetails addplace(PlaceDetails pd)throws DataAlreadyExistsException{
		// TODO Auto-generated method stub
		PlaceDetails pdtemp =  pdRepo.insert(pd);
		return pdtemp;
	}


	@Override
	public List<PlaceDetails> getAllplace() {
		// TODO Auto-generated method stub
		return (List<PlaceDetails>) pdRepo.findAll();
	}


	@Override
	public PlaceDetails deleteplaceByPincode(int pincode)throws DataAlreadyDeletedException {
		// TODO Auto-generated method stub
		pdRepo.deleteById(pincode);
		return null;
	}


	@Override
	public PlaceDetails updateplace(PlaceDetails updatepd) {
		// TODO Auto-generated method stub
		PlaceDetails record;
		Optional<PlaceDetails> opti = pdRepo.findById(updatepd.getPincode());
		if(opti.isPresent()) {
			record=opti.get();
		record.setDestination(updatepd.getDestination());
			record.setFamouse_place(updatepd.getFamouse_place());
			pdRepo.save(record);
		}else {
			return new PlaceDetails();
		}
		return record;
	}

}
