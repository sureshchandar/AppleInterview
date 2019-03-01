package com.mycompany.app;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Car {

	@JsonProperty(value = "make")
	private String make;

	private String model;

	private String vin;

	private Metadata metadata;

	private Map<String, Integer> perdayrent;

	private Metrics metrics;

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public Map<String, Integer> getPerdayrent() {
		return perdayrent;
	}

	public void setPerdayrent(Map<String, Integer> perdayrent) {
		this.perdayrent = perdayrent;
	}

	public Metrics getMetrics() {
		return metrics;
	}

	public void setMetrics(Metrics metrics) {
		this.metrics = metrics;
	}

	public String toString() {
		return make + " " + model + ", $" + perdayrent.get("price");
	}

}
