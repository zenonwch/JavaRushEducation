package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

public class LoginCommand implements Command {
	private long curdNumber = 123456789012L;
	private long PIN = 1234;

	@Override
	public void execute() throws InterruptOperationException {
		while (true) {
			try {
				ConsoleHelper.writeMessage("Введите номер карты (12 цифр).");
				String inputCurdNumber = ConsoleHelper.readString();
				if (inputCurdNumber.length() != 12 || Long.parseLong(inputCurdNumber) != curdNumber)
					throw new NumberFormatException();
				ConsoleHelper.writeMessage("Введите пин-код (4 цифры).");
				String inputPIN = ConsoleHelper.readString();
				if (inputPIN.length() != 4 || Long.parseLong(inputPIN) != PIN)
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
