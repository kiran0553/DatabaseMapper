package com.imcs.database.mapper.database.mapper.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;

import org.json.JSONArray;

public class Employee extends CommonMethods {
	public void GenerateEmployeeOutputFile(String inputFileName, String outputFileName,
			Hashtable<String, JSONArray> emergencyContacts, Hashtable<String, JSONArray> emails,
			Hashtable<String, JSONArray> phones) {
		String row = "";

		try {
			File file = getFileFromResources(inputFileName);
			File outputFile = new File(outputFileName);
			outputFile.createNewFile();
			FileWriter csvWriter = new FileWriter(outputFile);
			BufferedReader csvReader = new BufferedReader(new FileReader(file));
			String header = csvReader.readLine();
			String[] headerArray = header.split(",");
			for (String headerItem : headerArray) {
				csvWriter.append(headerItem + ";");
			}
			csvWriter.append("\n");
			while ((row = csvReader.readLine()) != null) {
				String[] data = row.split(",");
				for (int i = 0; i < 12; i++) {
					csvWriter.append(data[i] + ";");
				}
				if (emails.containsKey(data[0]))
					csvWriter.append(
							emails.get(data[0]).toString().replace("\\", "").replace("\"{", "{").replace("}\"", "}"));
				csvWriter.append(";");
				for (int i = 13; i < 14; i++) {
					csvWriter.append(data[i] + ";");
				}
				if (phones.containsKey(data[0]))
					csvWriter.append(
							phones.get(data[0]).toString().replace("\\", "").replace("\"{", "{").replace("}\"", "}"));
				csvWriter.append(";");
				for (int i = 15; i < 27; i++) {
					csvWriter.append(data[i] + ";");
				}
				if (emergencyContacts.containsKey(data[0]))
					csvWriter.append(emergencyContacts.get(data[0]).toString().replace("\\", "").replace("\"{", "{")
							.replace("}\"", "}"));
				csvWriter.append(";");
				for (int i = 28; i < 29; i++) {
					csvWriter.append(data[i] + ";");
				}
				csvWriter.append("\n");
			}
			csvReader.close();
			csvWriter.flush();
			csvWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
