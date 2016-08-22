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
		}
		catch (IOException e) {
		}
		return message;
	}

	public static String askCurrencyCode() {
		String currencyCode;
		System.out.println("Введите, пожалуйста, код валюты.");
		while (true) {
			try {
				currencyCode = reader.readLine();
				if (currencyCode.length() != 3) throw new IOException();
				break;
			}
			catch (IOException e) {
				System.out.println("Пожалуйста, введите корректные данные");
			}
		}
		return currencyCode.toUpperCase();
	}

	public static String[] getValidTwoDigits(String currencyCode) {
		String[] validTwoDigits;
		System.out.println("Введите, пожалуйста, через пробел номинал и количество банкнот.");
		while (true) {
			try {
				validTwoDigits = reader.readLine().split(" ");
				if (validTwoDigits.length != 2) throw new IOException();
				Integer.parseInt(validTwoDigits[0]);
				Integer.parseInt(validTwoDigits[1]);
				break;
			}
			catch (IOException | NumberFormatException e) {
				System.out.println("Пожалуйста, введите корректные данные.");
			}
		}
		return validTwoDigits;
	}

	public static Operation askOperation() {
		Operation op;
		System.out.println("Пожалуйста, выберите номер операции.");
		while (true) {
			try {
				op = Operation.getAllowableOperationByOrdinal(Integer.parseInt(reader.readLine()));
				break;
			}
			catch (IOException | IllegalArgumentException e) {
				System.out.println("Пожалуйста, введите корректные данные");
			}
		}
		return op;
	}
}
