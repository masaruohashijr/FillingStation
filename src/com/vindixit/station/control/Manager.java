package com.vindixit.station.control;

import java.util.List;

import com.vindixit.station.domain.CsvRow;
import com.vindixit.station.domain.FuelPump;
import com.vindixit.station.domain.FuelType;
import com.vindixit.station.domain.Model;
import com.vindixit.station.domain.Vehicle;
import com.vindixit.station.service.CashBook;
import com.vindixit.station.service.FileService;
import com.vindixit.station.service.ShowDetails;

/**
 * Class responsible for following the order of the single line at the entrance
 * to the gas station, direct vehicles to the individual rows of each fuel pump.
 */
public class Manager {

	/**
	 * Main method that starts and control the whole process.
	 * @param args
	 */
	public static void main(String[] args) {
		FileService fileService = FileService.getInstance();
		List<CsvRow> models = fileService.loadAll("modelos.csv", Model.class);
		List<CsvRow> vehicles = fileService.loadAll("veiculos.csv", Vehicle.class);
		FuelPump gasPump = new FuelPump(FuelType.GAS, 2.90, 10.0);
		FuelPump ethanolPump = new FuelPump(FuelType.ETHANOL, 2.27, 12.0);
		for (CsvRow csvRow : vehicles) {
			Vehicle vehicle = (Vehicle) csvRow;
			FuelPump chosenPump = vehicle.choosePump(gasPump, ethanolPump);
			chosenPump.supplys(vehicle);
		}
		String report = CashBook.getInstance().report(gasPump, ethanolPump);
		ShowDetails.getInstance().showInputDialog("Gas Station Report",report);
	}

}
