package com.vindixit.station.domain;

import java.time.LocalTime;

import com.vindixit.station.service.CashBook;

/**
 * Class that represents a fuel pump and controls its usage time
 * individually per vehicle. 
 * @author Logus
 *
 */
public class FuelPump {
	/**
	 * Variable that records the instant each fuel tank is filled up.
	 */
	private LocalTime instantTime = LocalTime.of(0, 0);
	/**
	 * Record the price of fuel in this pump.
	 */
	private final Double price;
	/**
	 * Pump fill speed.
	 */
	private final Double fuelSupplySpeed;
	/**
	 * Type of fuel.
	 */
	private final FuelType fuelType;
	/**
	 * Totalizer of liters consumed.
	 */
	private Double total = 0.0;

	/**
	 * Constructor
	 * 
	 * @param fuelType
	 * @param price
	 * @param fuelSupplySpeed
	 */
	public FuelPump(FuelType fuelType, Double price, Double fuelSupplySpeed) {
		this.fuelType = fuelType;
		this.price = price;
		this.fuelSupplySpeed = fuelSupplySpeed;
	}

	public Double getPrice() {
		return price;
	}

	public Double getFuelSupplySpeed() {
		return fuelSupplySpeed;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void supplys(Vehicle v) {
		Double fuelCapacity = v.getModel().getFuelCapacity();
		double durationInMinutes = fuelCapacity / fuelSupplySpeed;
		instantTime = instantTime.plusMinutes(Math.round(durationInMinutes));
		CashBook.getInstance().register(instantTime, this, v);
		this.total += v.getModel().getFuelCapacity();
	}

	public Double getTotal() {
		return total;
	}
}
