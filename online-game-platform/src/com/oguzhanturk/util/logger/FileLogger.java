package com.oguzhanturk.util.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger implements Logger {

	private File logFile;
	private FileWriter logWriter;
	private static final String LOG_FILE_LOCATION = "./logs/";

	public <T> FileLogger(Class clazz) {

		String fullQualifiedName = clazz.getTypeName();
		String[] path = fullQualifiedName.split("\\.");
		String className = path[path.length - 1];
		logFile = new File(LOG_FILE_LOCATION + className.concat("LogFile.txt"));
		try {
			FileWriter fileWriter = logWriter = new FileWriter(logFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void log(String message) {
		try {
			logWriter.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			logWriter.write("\t");
			logWriter.write(message);
			logWriter.write("\n");
			logWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
