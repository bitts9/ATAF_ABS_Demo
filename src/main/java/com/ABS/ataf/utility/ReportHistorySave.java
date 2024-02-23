package com.ABS.ataf.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportHistorySave {

	private static final String DEFAULT_FILE_PATTERN = "yyyyMMddHHmmss";

	public static String createFileName() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat(DEFAULT_FILE_PATTERN);
		return format.format(date);
	}
	
	public static void copyReport() {
		File directoryPath = new File("target/cucumber-html-report");
		String folderName = "/reportHistory" + createFileName();
		File filePathFinal = new File(directoryPath + folderName);
		boolean bool = filePathFinal.mkdirs();
		if (bool) {
			System.out.println("Directory created successfully");
		} else {
			System.out.println("Sorry couldnt create specified directory");
		}

		File filesList[] = directoryPath.listFiles();

		System.out.println("List of files and directories in the specified directory:");
		for (int x = 0; x < filesList.length; x++) {
			System.out.println("File path: " + filesList[x].getAbsolutePath());
			System.out.println("File name:" + filesList[x].getName());

			if (!filesList[x].getName().contains("reportHistory")) {
				File src = new File("target/cucumber-html-report/" + filesList[x].getName());
				File dest = new File("target/cucumber-html-report/" + folderName + "/" + filesList[x].getName());
				try {
					Files.copy(src.toPath(), dest.toPath());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
