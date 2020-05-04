package com.imcs.database.mapper.database.mapper.interfaces;

import java.util.Hashtable;

import org.json.JSONArray;

public interface ICSVRead {
	public Hashtable<String, JSONArray> GenerateDictionary(String fileName);
}
