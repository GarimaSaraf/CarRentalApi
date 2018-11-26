package com.car.rental;

public class CarRentalCalculation {
	
	
	private double kilometers;
	private double finalPay;
	
	private double sourceToDestination;
	
	public double calculateTrip(String destination,String vechileType,String oilType) {
		
		if(destination.equals("Chennai")) {
			kilometers=TravelDetails.CHENNAI_DISTANCE;
		}else if(destination.equals("Banglore")) {
			kilometers=TravelDetails.BANGLORE_DISTANCE;
		}else if(destination.equals("Mumbai")) {
			kilometers=TravelDetails.MUMBAI_DISTANCE;
		}else {
			System.out.println("Service is not Provided to"+destination);
		}
		
		sourceToDestination=kilometers*2;
		
		if(vechileType.equals(TravelDetails.VECHILETYPE_NON_SUV)&& oilType.equals(TravelDetails.OIL_TYPE_PETROL)) {
			
			finalPay=	sourceToDestination*TravelDetails.STANDARD_CHARGES_PER_KM;
			}else if (oilType.equals(TravelDetails.OIL_TYPE_DIESIL)) {
			double diesilCharges=TravelDetails.STANDARD_CHARGES_PER_KM-1;
			if(vechileType.equals(TravelDetails.VECHILETYPE_SUV)) {
				double suvCharges=diesilCharges+TravelDetails.AC_CHARGES;
				finalPay=	sourceToDestination*suvCharges;
				
			}else if(vechileType.equals(TravelDetails.VECHILETYPE_VAN)) {
				finalPay=sourceToDestination*diesilCharges;
			}else if(vechileType.equals(TravelDetails.VECHILETYPE_BUS)){
				double discountCharges=calculateDiscount(TravelDetails.STANDARD_CHARGES_PER_KM,TravelDetails.DISCOUNT_PERCENTAGE);
				finalPay=sourceToDestination*discountCharges;
			}
			
		} else {
			System.out.println("Please select PETROL and DIESIL Vechiles");
		}
		System.out.println("FinalPay value :"+finalPay);	
		return finalPay;
		
		
	}
	
	public double calculateDiscount(double standardChargesPerKM,double discount) {
		
		
		double s=100-discount;
 
       double afterDiscount= (s*standardChargesPerKM)/100;
 
	  //  System.out.println("amount after discount="+afterDiscount);
		
		
		return afterDiscount;
		
	}
	
	public static void main(String[] args) {
		
		CarRentalCalculation rate=new CarRentalCalculation();
		
		rate.calculateTrip("Mumbai","BUS","DIESIL");
		
	}

}
