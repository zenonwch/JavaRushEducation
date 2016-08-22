package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void writeMessage(String message) {
		System.out.println(message);
	}

	public static String readString() {
		String message = "";
		try {
			message = reader.readLine();
		} catch (IOException e) {}
		return message;
	}
}
