package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;

class InfoCommand implements Command {
	@Override
	public void execute() {
		boolean hasMoney = false;
		Collection<CurrencyManipulator> manipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();
		for (CurrencyManipulator manipulator : manipulators) {
			if (manipulator.hasMoney()) {
				ConsoleHelper.writeMessage(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
				hasMoney = true;
			}
		}
		if (!hasMoney) ConsoleHelper.writeMessage("No money available.");
	}
}
