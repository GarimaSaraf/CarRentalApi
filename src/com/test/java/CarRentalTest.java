package com.test.java;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.car.rental.CarRentalCalculation;
import com.pki.nextgen.testordermanagement.controller.TestOrderManagementController;

@RunWith(MockitoJUnitRunner.class)
public class CarRentalTest {
	
	@InjectMocks
	CarRentalCalculation carRentalCalculation;
	
	private double kilometers;
	private double finalPay;
	
	private double sourceToDestination;
	
	@Before
	public void setup() {
		 kilometers=200;
		 finalPay=5880;
		 sourceToDestination=400;
	}

	
	@Test
	public void calculateTrip() throws Exception {
		String destination="Mumbai";
		String vechileType="BUS";
		String oilType="DIESIL";
		when(carRentalCalculation.calculateTrip("Mumbai", "BUS", "DIESIL")).thenReturn(finalPay);
		
		assertNotNull(finalPay);
	}
}
