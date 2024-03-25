package com.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * JsonReader class helps to read test data from json file and retruns into
 * string.
 *
 * @author Ashok
 *
 */
public class JsonReader {

	private static String dataPath = new File(PropertiesFile.getProperty("test.data.path")).getAbsolutePath()
			+ File.separator;
	private static JSONParser parser = new JSONParser();
	private static Object body;

	/**
	 * getRequestBody(String jsonFileName, String jsonKey) method will read json
	 * data with combination of file name and key name at runtime we can give file
	 * name and jsonkey by passing through parameter.
	 *
	 * @param jsonFileName
	 * @param jsonKey
	 * @return
	 */
	public static String getRequestBody(String jsonFileName, String jsonKey) {
		try {
			body = ((JSONObject) parser.parse(new FileReader(dataPath + jsonFileName))).get(jsonKey);
			if (body == null) {
				throw new RuntimeException(
						"NO DATA FOUND in JSON file '" + jsonFileName + "' for key '" + jsonKey + "'");
			}
		} catch (FileNotFoundException fnfe) {
			throw new RuntimeException("JSON file not found at path: " + dataPath + jsonFileName);
		} catch (IOException e) {
			throw new RuntimeException("IOException while reading file: " + jsonFileName);
		} catch (ParseException e) {
			throw new RuntimeException("Parse Exception occured while Parsing: " + jsonFileName);
		}
		return body.toString();
	}
}
