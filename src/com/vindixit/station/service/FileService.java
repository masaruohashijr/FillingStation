package com.vindixit.station.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.vindixit.station.domain.CsvRow;
import com.vindixit.station.domain.FuelType;
import com.vindixit.station.domain.Model;
import com.vindixit.station.domain.Vehicle;

/**
 * Service that reads a file and creates instances with the line data read.
 * 
 * @author Logus
 *
 */
public class FileService {

	private static FileService instance;

	public static FileService getInstance() {
		if (instance == null) {
			instance = new FileService();
		}
		return instance;
	}

	/**
	 * Read each line creating objects related to each given file.
	 * 
	 * @param fileName
	 * @param clazz
	 * @return
	 */
	public ArrayList<CsvRow> loadAll(String fileName, Class clazz) {
		Map<String, CsvRow> map = null;
		ArrayList<CsvRow> valueList = null;
		if (Cache.getInstance().getMap().containsKey(clazz)) {
			map = Cache.getInstance().getMap().get(clazz);
		} else {
			try {
				map = new HashMap<String, CsvRow>();
				valueList = new ArrayList<CsvRow>();
				BufferedReader reader = new BufferedReader(new FileReader("database/" + fileName));
				String line = null;
				reader.readLine(); // Header
				while ((line = reader.readLine()) != null) {
					CsvRow c = newCsvRow(clazz, line);
					map.put(c.getName(), c);
					valueList.add(c);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			Cache.getInstance().getMap().put(clazz, map);
		}
		return valueList;
	}

	/**
	 * Factory method for each type of object that can be read from a given file.
	 * 
	 * @param clazz
	 * @param line
	 * @return
	 */

	private CsvRow newCsvRow(Class clazz, String line) {
		String[] split = line.split(CsvRow.TOKEN_SEPARATOR);
		CsvRow csvRow = null;
		Map<Class, Map<String, CsvRow>> map = Cache.getInstance().getMap();
		Map<String, CsvRow> clazzMap = map.get(clazz);
		if (clazz.equals(Vehicle.class)) {
			csvRow = new Vehicle();
			String modelName = split[0];
			String plate = split[1];
			Model model = (Model) Cache.getInstance().getMap().get(Model.class).get(modelName);
			((Vehicle) csvRow).setModel(model);
			((Vehicle) csvRow).setPlate(plate);
		} else {
			csvRow = new Model();
			String modelName = split[0].trim();
			String ec = split[1].replace(",", ".").trim();
			if (!ec.isEmpty()) {
				Double ethanolConsumption = Double.valueOf(ec);
				((Model) csvRow).putConsumption(FuelType.ETHANOL, ethanolConsumption);
			}
			String gc = split[2].replace(",", ".").trim();
			if (!gc.isEmpty()) {
				Double gasConsumption = Double.valueOf(gc);
				((Model) csvRow).putConsumption(FuelType.GAS, gasConsumption);
			}
			Double fuelCapacity = Double.valueOf(split[3].trim());
			((Model) csvRow).setName(modelName);
			((Model) csvRow).setFuelCapacity(fuelCapacity);
		}
		return csvRow;
	}
}
