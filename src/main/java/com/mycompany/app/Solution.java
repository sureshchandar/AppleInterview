package com.mycompany.app;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author sususubr
 *
 */

public class Solution {

	/**
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public List<Car> getCars(File file) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, Car.class));
	}

	/**
	 * @param file
	 * @param make
	 * @param color
	 * @return
	 * @throws Exception
	 */
	public List<Car> getCars(File file, String make, String color) throws Exception {
		List<Car> cars = new ArrayList<>();

		for (Car car : getCars(file)) {
			if (car.getMake().equals(make) && car.getMetadata().getColor().equals(color)) {
				cars.add(car);
			}
		}
		return cars;
	}

	
	/**
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public List<Car> getCarsWithLowestRentalPrice(File file) throws Exception {
		List<Car> result = new ArrayList<>();
		List<Car> cars = getCars(file);
		if (cars.size() > 0) {
			float minimum = cars.get(0).getPerdayrent().get("price");
			for (Car car : cars) {
				if (car.getPerdayrent().get("price") < minimum) {
					minimum = car.getPerdayrent().get("price");
				}
			}

			for (Car car : cars) {
				if (car.getPerdayrent().get("price") == minimum) {
					result.add(car);
				}
			}
		} else {
			throw new Exception("No cars");
		}
		return result;
	}

	/**
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public Car getCarsWithLowestRentalPriceAfterDiscount(File file) throws Exception {
		List<Car> cars = getCars(file);
		Car lowestCar = cars.get(0);
		float price = lowestCar.getPerdayrent().get("price");
		float lowestRentalAfterDiscount = price - (price * (lowestCar.getPerdayrent().get("discount") / 100));

		float discount = 0;
		for (Car car : cars) {
			price = car.getPerdayrent().get("price");
			discount = car.getPerdayrent().get("discount");

			float totalAmount = price - (price * discount / 100);
			if (totalAmount < lowestRentalAfterDiscount) {
				lowestRentalAfterDiscount = totalAmount;
				lowestCar = car;
			}
		}
		return lowestCar;
	}

	/**
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public Car getMostProfitableCar(File file) throws Exception {
		List<Car> cars = getCars(file);

		float price = 0, discount = 0, profit = 0;

		Car c = cars.get(0);
		float lowestRental = c.getPerdayrent().get("price");

		Car maxProfitCar = c;
		float revenue = c.getMetrics().getRentalcount().get("yeartodate") * lowestRental;
		float maxProfit = revenue - (c.getMetrics().getYoymaintenancecost() + c.getMetrics().getDepreciation());

		for (Car car : cars) {
			price = car.getPerdayrent().get("price");
			discount = car.getPerdayrent().get("discount");
			float total = price - (price * (discount / 100));
			
			revenue = car.getMetrics().getRentalcount().get("yeartodate") * total;
			profit = revenue - (car.getMetrics().getYoymaintenancecost() + car.getMetrics().getDepreciation());
			if (profit > maxProfit) {
				maxProfit = profit;
				maxProfitCar = car;
			}
		}

		return maxProfitCar;
	}
}