package com.vindixit.station.domain;

import com.vindixit.station.service.CostPerKmCalculator;

/**
 * Responsible for storing information related to each vehicle.
 * 
 * @author Logus
 *
 */
public class Vehicle implements CsvRow {
	/**
	 * Vehicle license plate.
	 */
	private String plate;
	/**
	 * Vehicle model.
	 */
	private Model model;

	public Vehicle() {
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	/**
	 * Method responsible for choosing the most economical pump for filling up, taking
	 * into account the fuel consumption rates by fuel type of the model of this vehicle.
	 * 
	 * @param pumps
	 * @return
	 */
	public FuelPump choosePump(FuelPump... pumps) {
		FuelPump choosenPump = null;
		Double minimun = Double.MAX_VALUE;
		for (int j = 0; j < pumps.length; j++) {
			if (this.getModel().getConsuptionsMap().containsKey(pumps[j].getFuelType())) {
				Double costPerKm = CostPerKmCalculator.getInstance().calculate(this, pumps[j]);
				if (costPerKm < minimun) {
					choosenPump = pumps[j];
					minimun = costPerKm;
				}
			}
		}
		return choosenPump;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public String getName() {
		return this.plate;
	}

}
