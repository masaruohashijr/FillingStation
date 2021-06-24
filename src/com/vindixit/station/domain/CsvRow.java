package com.vindixit.station.domain;
/**
 * Interface representing a line of a CSV file.
 */
public interface CsvRow {
	/**
	 * Token used to separate the values on each line of the file.
	 */
	String TOKEN_SEPARATOR = ";";
	/**
	 * Returns the name of the entity that implements this interface.
	 * @return
	 */
	String getName();
}
