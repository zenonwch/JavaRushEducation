package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

class InfoCommand implements Command {
	private static final String infoPropsPath = CashMachine.RESOURCE_PATH + "info";
	private ResourceBundle res = PropertyResourceBundle.getBundle(infoPropsPath, Locale.ENGLISH);

	@Override
	public void execute() {
		boolean hasMoney = false;
		Collection<CurrencyManipulator> manipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();
		ConsoleHelper.writeMessage(res.getString("before"));
		for (CurrencyManipulator manipulator : manipulators) {
			if (manipulator.hasMoney()) {
				ConsoleHelper.writeMessage(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
				hasMoney = true;
			}
		}
		if (!hasMoney) ConsoleHelper.writeMessage(res.getString("no.money"));
	}
}
