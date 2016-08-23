package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.sun.media.sound.InvalidDataException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void writeMessage(String message) {
		System.out.println(message);
	}

	public static String readString() throws InterruptOperationException {
		String message = "";
		try {
			message = reader.readLine();
			if (message.toUpperCase().equals("EXIT")) throw new InterruptOperationException();
		}
		catch (IOException e) {
		}
		return message;
	}

	public static String askCurrencyCode() throws InterruptOperationException {
		String currencyCode;
		writeMessage("Введите, пожалуйста, код валюты.");
		while (true) {
			try {
				currencyCode = readString();
				if (currencyCode.length() != 3) throw new IOException();
				break;
			}
			catch (IOException e) {
				writeMessage("Пожалуйста, введите корректные данные");
			}
		}
		return currencyCode.toUpperCase();
	}

	public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
		String[] validTwoDigits;
		writeMessage("Введите, пожалуйста, через пробел номинал и количество банкнот.");
		while (true) {
			try {
				validTwoDigits = readString().split(" ");
				if (validTwoDigits.length != 2) throw new InvalidDataException();
				break;
			}
			catch (InvalidDataException e) {
				writeMessage("Пожалуйста, введите два числа, разделенные пробелом.");
			}
		}
		return validTwoDigits;
	}

	public static Operation askOperation() throws InterruptOperationException {
		Operation op;
		writeMessage("Пожалуйста, выберите номер операции:\n1 - Info\n2 - Deposit\n3 - Withdraw\n4 - Exit");
		while (true) {
			try {
				op = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
				break;
			}
			catch (IllegalArgumentException e) {
				writeMessage("Пожалуйста, введите корректные данные");
			}
		}
		return op;
	}
}
