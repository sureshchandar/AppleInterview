package com.mycompany.app;

import java.util.Map;

public class Metrics {

	private float yoymaintenancecost;
	
	private float depreciation;
	
	private Map<String, Integer> rentalcount;
	
	public float getYoymaintenancecost() {
		return yoymaintenancecost;
	}

	public void setYoymaintenancecost(float yoymaintenancecost) {
		this.yoymaintenancecost = yoymaintenancecost;
	}

	public float getDepreciation() {
		return depreciation;
	}

	public void setDepreciation(float depreciation) {
		this.depreciation = depreciation;
	}

	public Map<String, Integer> getRentalcount() {
		return rentalcount;
	}

	public void setRentalcount(Map<String, Integer> rentalcount) {
		this.rentalcount = rentalcount;
	}

}
