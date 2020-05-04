package com.imcs.database.mapper.database.mapper.models;

import java.io.File;
import java.net.URL;

public class CommonMethods {
	public File getFileFromResources(String fileName) {

		ClassLoader classLoader = ClassLoader.getSystemClassLoader();

		URL resource = classLoader.getResource(fileName);
		if (resource == null) {
			throw new IllegalArgumentException("file is not found!");
		} else {
			return new File(resource.getFile());
		}

	}
}
