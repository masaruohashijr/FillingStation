package com.vindixit.station.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.vindixit.station.domain.FuelPump;
import com.vindixit.station.domain.Vehicle;

/**
 * Class responsible for registering the movement of vehicles in the Cash Book,
 * recording times and supplies made.
 * 
 * @author Logus
 *
 */
public class CashBook {
	private static CashBook instance = null;

	public static CashBook getInstance() {
		if (instance == null) {
			instance = new CashBook();
		}
		return instance;
	}

	private List<Register> eventsList = new ArrayList<Register>();

	public void register(LocalTime instantTime, FuelPump fuelPump, Vehicle v) {
		eventsList.add(new Register(instantTime, v, fuelPump));
	}

	public String report(FuelPump... pumps) {
		StringBuilder sb = new StringBuilder();
		for (Register register : eventsList) {
			sb.append(register.print()+"\n");
		}
		sb.append("\n\nResumo da simulação\n");
		sb.append("-------------------\n");
		for (int i = 0; i < pumps.length; i++) {
			sb.append("Total abastecido na bomba " + (i + 1) + " (" + pumps[i].getFuelType().getName() + "):"
					+ pumps[i].getTotal() + " litros\n");
		}
		return sb.toString();
	}
}

/**
 * Records information for each supply.
 * 
 * @author Logus
 *
 */
class Register {
	public Register(LocalTime timeStamp, Vehicle vehicle, FuelPump fuelPump) {
		super();
		this.timeStamp = timeStamp;
		this.vehicle = vehicle;
		this.fuelPump = fuelPump;
	}

	private FuelPump fuelPump;
	private LocalTime timeStamp;
	private Vehicle vehicle;
	/**
	 * Prints in a customized way the informations of the supply.
	 * @return
	 */
	public String print() {
		return "[" + this.timeStamp + "] Veículo modelo " + vehicle.getModel().getName() + ", placa "
				+ vehicle.getPlate() + " foi abastecido com " + vehicle.getModel().getFuelCapacity() + " litros de "
				+ fuelPump.getFuelType().getName() + ".";
	}
}
