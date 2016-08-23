package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

class DepositCommand implements Command {
	@Override
	public void execute() {
		String currencyCode = ConsoleHelper.askCurrencyCode();
		String[] denominationAndCount = ConsoleHelper.getValidTwoDigits(currencyCode);
		CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
		manipulator.addAmount(Integer.parseInt(denominationAndCount[0]), Integer.parseInt(denominationAndCount[1]));
	}
}