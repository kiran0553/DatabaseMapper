package com.imcs.database.mapper.database.mapper;

import java.util.Hashtable;

import org.json.JSONArray;

import com.imcs.database.mapper.database.mapper.models.Emails;
import com.imcs.database.mapper.database.mapper.models.EmergencyContacts;
import com.imcs.database.mapper.database.mapper.models.Employee;
import com.imcs.database.mapper.database.mapper.models.Phones;

public class Application {
	static Hashtable<String, JSONArray> emergencyContacts;
	static Hashtable<String, JSONArray> emails;
	static Hashtable<String, JSONArray> phones;

	public static void main(String[] args) {
		emergencyContacts = new EmergencyContacts().GenerateDictionary("csv/emergencycontacts.csv");
		emails = new Emails().GenerateDictionary("csv/emails.csv");
		phones = new Phones().GenerateDictionary("csv/phones.csv");
		new Employee().GenerateEmployeeOutputFile("csv/employees.csv", "employeesOutput.txt", emergencyContacts, emails,
				phones);
		System.out.println("Generated the EmployeesOutput.csv");
	}
}
