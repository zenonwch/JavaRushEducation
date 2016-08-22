package com.javarush.test.level26.lesson15.big01;

import java.util.Locale;

public class CashMachine {
	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);
		String currencyCode = ConsoleHelper.askCurrencyCode();
		String[] denominationAndCount = ConsoleHelper.getValidTwoDigits(currencyCode);
		CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
		manipulator.addAmount(Integer.parseInt(denominationAndCount[0]), Integer.parseInt(denominationAndCount[1]));
	}
}
