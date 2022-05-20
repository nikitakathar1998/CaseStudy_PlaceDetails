package com.capg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.exception.DataNotFoundException;
import com.capg.model.PlaceDetails;
import com.capg.repository.PlaceDetailsRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PlaceDetailsService {

	@Mock
    private PlaceDetailsRepository pdr;

    @InjectMocks             //used in implementation layer
    private UserServiceImpl usrl;
    
    @Test
    public void testGetAllPlace() throws DataNotFoundException
    {
    	PlaceDetails pd1=new PlaceDetails(431001,"Aurangabad","Bebika Makpara"); // user input
    	PlaceDetails pd2=new PlaceDetails(568943,"Mumbai","Gate Way of India"); //user input
    	PlaceDetails pd3=new PlaceDetails(986123,"Pune","Ockayama Garden"); //user input
        pdr.save(pd1); //data saved to database
        pdr.save(pd2); //data saved to database
        pdr.save(pd3); //data saved to database

        List<PlaceDetails> pdlist=new ArrayList<>();  // creating list object
        pdlist.add(pd1);
        pdlist.add(pd2);
        pdlist.add(pd3);

        when(pdr.findAll()).thenReturn(pdlist); // return place list
        List<PlaceDetails> pdlist1 = usrl.getAllplace();
        assertEquals(pdlist, pdlist1); //checking both objects are equal
        verify(pdr,times(1)).save(pd1);
        verify(pdr,times(1)).findAll();

    }
}
