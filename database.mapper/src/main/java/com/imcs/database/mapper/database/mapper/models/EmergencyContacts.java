package com.imcs.database.mapper.database.mapper.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.imcs.database.mapper.database.mapper.interfaces.ICSVRead;

public class EmergencyContacts extends CommonMethods implements ICSVRead {

	@Override
	public Hashtable<String, JSONArray> GenerateDictionary(String fileName) {
		Hashtable<String, JSONArray> emergencyContacts = new Hashtable<String, JSONArray>();
		String row = "";

		try {
			File file = getFileFromResources(fileName);
			BufferedReader csvReader = new BufferedReader(new FileReader(file));
			String header = csvReader.readLine();
			String[] headerArray = header.split(",");
			while ((row = csvReader.readLine()) != null) {
				String[] data = row.split(",");
				JSONObject jo = new JSONObject();
				jo.put(headerArray[5], data[5].substring(1, data[5].length() - 1));
				jo.put(headerArray[6], data[6]);
				jo.put(headerArray[7], data[7]);
				jo.put(headerArray[8], data[8].substring(1, data[8].length() - 1));

				if (emergencyContacts.containsKey(data[9])) {
					JSONArray jsonArray = emergencyContacts.get(data[9]);
					jsonArray.put(jo.toString());
					emergencyContacts.put(data[9], jsonArray);
				} else {
					JSONArray jsonArray = new JSONArray();
					jsonArray.put(jo.toString());
					emergencyContacts.put(data[9], jsonArray);
				}
			}
			csvReader.close();
		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emergencyContacts;
	}

}
