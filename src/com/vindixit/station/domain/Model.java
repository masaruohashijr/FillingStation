package com.vindixit.station.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Responsible for storing information related to each vehicle model as fuel
 * tank capacity and fuel consumption data per type.
 * 
 * @author Logus
 *
 */
public class Model implements CsvRow {
	protected String name;
	protected Map<FuelType, Double> consuptionsMap = new HashMap<FuelType, Double>();
	protected Double fuelCapacity;

	public Model() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(Double fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public void putConsumption(FuelType fuelType, Double consumption) {
		this.consuptionsMap.put(fuelType, consumption);
	}

	public Map<FuelType, Double> getConsuptionsMap() {
		return consuptionsMap;
	}

}
