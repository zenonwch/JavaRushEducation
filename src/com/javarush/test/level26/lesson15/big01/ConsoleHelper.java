package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.sun.media.sound.InvalidDataException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ConsoleHelper {
	private static final String commonPropsPath = CashMachine.RESOURCE_PATH + "common";
	private static ResourceBundle res = PropertyResourceBundle.getBundle(commonPropsPath, Locale.ENGLISH);
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void writeMessage(String message) {
		System.out.println(message);
	}

	public static String readString() throws InterruptOperationException {
		String message = "";
		try {
			message = reader.readLine();
			if (message.toUpperCase().equals("EXIT")) throw new InterruptOperationException("exit");
			if (message.toUpperCase().equals("MENU")) throw new InterruptOperationException("menu");
		}
		catch (IOException e) {
		}
		return message;
	}

	public static String askCurrencyCode() throws InterruptOperationException {
		String currencyCode;
		writeMessage(res.getString("choose.currency.code"));
		while (true) {
			try {
				currencyCode = readString();
				if (currencyCode.length() != 3) throw new IOException();
				break;
			}
			catch (IOException e) {
				writeMessage(res.getString("invalid.data"));
			}
		}
		return currencyCode.toUpperCase();
	}

	public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
		String[] validTwoDigits;
		writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
		while (true) {
			try {
				validTwoDigits = readString().split(" ");
				if (validTwoDigits.length != 2) throw new InvalidDataException();
				break;
			}
			catch (InvalidDataException e) {
				writeMessage(res.getString("invalid.data"));
			}
		}
		return validTwoDigits;
	}

	public static Operation askOperation() throws InterruptOperationException {
		Operation op;
		writeMessage(res.getString("choose.operation"));
		writeMessage("1: " + res.getString("operation.INFO"));
		writeMessage("2: " + res.getString("operation.DEPOSIT"));
		writeMessage("3: " + res.getString("operation.WITHDRAW"));
		writeMessage("4: " + res.getString("operation.EXIT"));
		while (true) {
			try {
				op = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
				break;
			}
			catch (IllegalArgumentException e) {
				writeMessage(res.getString("invalid.data"));
			}
		}
		return op;
	}

	public static void printExitMessage() {
		writeMessage(res.getString("the.end"));
	}
}
