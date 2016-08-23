package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

class DepositCommand implements Command {
	private static final String depoPropsPath = "com.javarush.test.level26.lesson15.big01.resources.deposit";
	private ResourceBundle res = PropertyResourceBundle.getBundle(depoPropsPath, Locale.ENGLISH);

	@Override
	public void execute() throws InterruptOperationException {
		String currencyCode = ConsoleHelper.askCurrencyCode();
		String[] denominationAndCount = ConsoleHelper.getValidTwoDigits(currencyCode);
		ConsoleHelper.writeMessage(res.getString("before"));
		CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
		try {
			int denomination = Integer.parseInt(denominationAndCount[0]);
			int count = Integer.parseInt(denominationAndCount[1]);
			manipulator.addAmount(denomination, count);
			ConsoleHelper.writeMessage(String.format(res.getString("success.format"), denomination * count, currencyCode));
		}
		catch (NumberFormatException e) {
			ConsoleHelper.writeMessage(res.getString("invalid.data"));
		}
	}
}