package com.mycompany.app;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonMappingException;

import junit.framework.Assert;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	/*
	 *  Question 1: Print all the blue Teslas received in the web service response. Also print the notes
	 */
	@Test
	public void verifyMakeAndColor() throws Exception {
		String make = "Tesla", color = "Blue";
		Solution s = new Solution();
		File file = new File("src/main/resources/cars2.json");
		List<Car> cars = s.getCars(file, make, color);
		Assert.assertEquals(cars.size(), 2);
		for (Car car : cars) {
			System.out.println(car.getMake() + " " + car.getModel() + ", " + car.getMetadata().getColor() + ", " + car.getMetadata().getNotes());			Assert.assertEquals(car.getMake(), make);
			Assert.assertEquals(car.getMetadata().getColor(), color);
		}
	}

	/*
	 * Question 2: Return all cars which have the lowest per day rental cost for both cases:
	 * a. Price only
	 */
	@Test
	public void verifyLowestRental() throws Exception {
		Solution s = new Solution();
		File file = new File("src/main/resources/cars2.json");
		List<Car> cars = s.getCarsWithLowestRentalPrice(file);
		System.out.println(cars.size());
		for (Car car : cars) {
			System.out.println("Lowest Rental Car : "+car);
		}
		Assert.assertEquals(2, cars.size());
	}

	/*
	 * Question 2: Return all cars which have the lowest per day rental cost for both cases:
	 * Price after discounts
	 */
	@Test
	public void verifyLowestRentalAfterDiscount() throws Exception {
		Solution s = new Solution();
		File file = new File("src/main/resources/cars2.json");
		Car car = s.getCarsWithLowestRentalPriceAfterDiscount(file);
		System.out.println("Lowest Rental Car After Discont : "+car);
		Assert.assertEquals("Tesla", car.getMake());
		
	}
	
	/*
	 * Question 3: Find the highest revenue generating car. year over year maintenance cost + depreciation is the total expense per car for the full year for the rental car company.
	 * 
	 */
	@Test
	public void verifyProfitableRentalCar() throws Exception {
		Solution s = new Solution();
		File file = new File("src/main/resources/cars2.json");
		Car car = s.getMostProfitableCar(file);
		System.out.println("Most Profitable Rental Car : " + car);
		Assert.assertEquals("Tesla", car.getMake());
	}
}
