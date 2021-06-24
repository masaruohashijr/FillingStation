package com.vindixit.station.service;

import java.util.HashMap;
import java.util.Map;

import com.vindixit.station.domain.CsvRow;

/**
 * 
 * Class responsible for storing in memory collections of data that can be
 * reused during processing.
 * 
 * @author Logus
 *
 */
public class Cache {

	private static Cache instance = null;

	public static Cache getInstance() {
		if (instance == null) {
			instance = new Cache();
		}
		return instance;
	}

	private Map<Class, Map<String, CsvRow>> map = new HashMap<Class, Map<String, CsvRow>>();

	public Map<Class, Map<String, CsvRow>> getMap() {
		return map;
	}

}
