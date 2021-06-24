package com.vindixit.station.service;

import java.util.Map;

import com.vindixit.station.domain.FuelPump;
import com.vindixit.station.domain.FuelType;
import com.vindixit.station.domain.Vehicle;
/**
 * Price/km driven ratio calculation service.
 * @author Logus
 *
 */
public class CostPerKmCalculator {
	
	private static CostPerKmCalculator instance;
	
	public static CostPerKmCalculator getInstance() {
		if (instance == null) {
			instance = new CostPerKmCalculator();
		}
		return instance;
	}
	/**
	 * Method that calculates the price/km driven ratio.
	 * @param v
	 * @param pump
	 * @return
	 */
	public Double calculate(Vehicle v, FuelPump pump) {
		Map<FuelType, Double> consuptionsMap = v.getModel().getConsuptionsMap();
		return pump.getPrice()/consuptionsMap.get(pump.getFuelType());
		
	}
}
