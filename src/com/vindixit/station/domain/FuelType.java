package com.vindixit.station.domain;

/**
 * Enumeration that stores the types of fuels sold at the Gas Station along with
 * its names to be user into the reports.
 * 
 * @author Logus
 *
 */
public enum FuelType {
	GAS("GASOLINA"), ETHANOL("ETANOL");

	private String name;

	private FuelType(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
