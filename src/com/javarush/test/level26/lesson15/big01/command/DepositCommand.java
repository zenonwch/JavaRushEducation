package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

class DepositCommand implements Command {
	@Override
	public void execute() throws InterruptOperationException {
		String currencyCode = ConsoleHelper.askCurrencyCode();
		String[] denominationAndCount = ConsoleHelper.getValidTwoDigits(currencyCode);
		CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
		manipulator.addAmount(Integer.parseInt(denominationAndCount[0]), Integer.parseInt(denominationAndCount[1]));
	}
}