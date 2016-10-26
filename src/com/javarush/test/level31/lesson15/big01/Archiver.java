package com.javarush.test.level31.lesson15.big01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Archiver {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Please enter full path to zip archive");
			Path zipFilePath = Paths.get(reader.readLine());
			ZipFileManager zipFileManager = new ZipFileManager(zipFilePath);
			System.out.println("Please enter full path to file you want to add to archive");
			Path filePath = Paths.get(reader.readLine());
			zipFileManager.createZip(filePath);
		}
		catch (Exception ignored) {
		}
	}
}
