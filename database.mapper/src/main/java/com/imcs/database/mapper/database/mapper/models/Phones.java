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

public class Phones extends CommonMethods implements ICSVRead {

	@Override
	public Hashtable<String, JSONArray> GenerateDictionary(String fileName) {
		Hashtable<String, JSONArray> phones = new Hashtable<String, JSONArray>();
		String row = "";
		try {
			File file = getFileFromResources(fileName);
			BufferedReader csvReader = new BufferedReader(new FileReader(file));
			String header = csvReader.readLine();
			String[] headerArray = header.split(",");
			while ((row = csvReader.readLine()) != null) {
				String[] data = row.split(",");
				JSONObject jo = new JSONObject();
				jo.put(headerArray[5], data[5]);
				jo.put(headerArray[7], data[7]);
				if (phones.containsKey(data[6])) {
					JSONArray jsonArray = phones.get(data[6]);
					jsonArray.put(jo.toString());
					phones.put(data[6], jsonArray);
				} else {
					JSONArray jsonArray = new JSONArray();
					jsonArray.put(jo.toString());
					phones.put(data[6], jsonArray);
				}
			}
			csvReader.close();
		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phones;
	}

}
