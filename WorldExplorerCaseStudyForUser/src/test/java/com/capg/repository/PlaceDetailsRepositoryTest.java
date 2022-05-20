package com.capg.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capg.model.PlaceDetails;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PlaceDetailsRepositoryTest {

	@Autowired
	private PlaceDetailsRepository pdRepo;
	@Test
	public void getAllplace() 
	{
		PlaceDetails pd1 = new PlaceDetails(431001,"Aurangabad","Bebika Makpara");//user input
		PlaceDetails pd2 = new PlaceDetails(568943,"Mumbai","Gate Way of India");//user input
		PlaceDetails pd3 = new PlaceDetails(986123,"Pune","Ockayama Garden");//user input
		
		pdRepo.save(pd1);//data saved to database
		pdRepo.save(pd2);
		pdRepo.save(pd3);
		
		List<PlaceDetails> placeList1 =(List<PlaceDetails>)pdRepo.findAll();//fetching data from database
		assertEquals("Bebika Makpara",placeList1.get(2).getFamouse_place());
		
	}
	
	/*@Test
	public void mustReturnPincode() 
	{
		PlaceDetails pd4 = new PlaceDetails(981056,"Delhi","The Red Fort");//user input
		pdRepo.save(pd4);
			
		PlaceDetails pd5 = pdRepo.findById(pd4.getPincode()).get();
		assertNotNull(pd5); // to check if it is returning Student Object
		assertEquals(pd4.getFamouse_place(),pd5.getDestination());
	}*/
}
