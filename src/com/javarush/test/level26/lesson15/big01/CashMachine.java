package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;

public class CashMachine {
	public static void main(String[] args) {
		try {
			Locale.setDefault(Locale.ENGLISH);
			Operation selectedOp = Operation.LOGIN;
			CommandExecutor.execute(selectedOp);
			do {
				selectedOp = ConsoleHelper.askOperation();
				CommandExecutor.execute(selectedOp);
			}
			while (selectedOp != Operation.EXIT);
		} catch (InterruptOperationException e) {
			ConsoleHelper.writeMessage(ConsoleHelper.res.getString("the.end"));
		}
	}
}
