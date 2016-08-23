package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class LoginCommand implements Command {
	private static final String verifiedCardsProps = "com/javarush/test/level26/lesson15/big01/resources/verifiedCards";
	private ResourceBundle validCreditCards = PropertyResourceBundle.getBundle(verifiedCardsProps, Locale.ENGLISH);

	@Override
	public void execute() throws InterruptOperationException {
		while (true) {
			try {
				ConsoleHelper.writeMessage("Введите номер карты (12 цифр).");
				String inputCurdNumber = ConsoleHelper.readString();
				if (inputCurdNumber.length() != 12 || !validCreditCards.keySet().contains(inputCurdNumber))
					throw new NumberFormatException();
				ConsoleHelper.writeMessage("Введите пин-код (4 цифры).");
				String inputPIN = ConsoleHelper.readString();
				if (inputPIN.length() != 4 || !inputPIN.equals(validCreditCards.getString(inputCurdNumber)))
					throw new NumberFormatException();
				ConsoleHelper.writeMessage("Верификация прошла успешно");
				break;
			}
			catch (NumberFormatException e) {
				ConsoleHelper.writeMessage("Вы ввели не правильные данные.");
			}
		}
	}
}
