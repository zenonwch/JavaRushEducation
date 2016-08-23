package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;

public class CashMachine {
	public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";
	private static boolean confirmExit = false;

	public static void setConfirmExit(boolean confirmExit) {
		CashMachine.confirmExit = confirmExit;
	}

	public static void main(String[] args) {
		try {
			Locale.setDefault(Locale.ENGLISH);
			Operation selectedOp = Operation.LOGIN;
			CommandExecutor.execute(selectedOp);
			while (!confirmExit) {
				try {
					selectedOp = ConsoleHelper.askOperation();
					CommandExecutor.execute(selectedOp);
				}
				catch (InterruptOperationException e) {
					if (e.getMessage().equals("exit"))
						throw new InterruptOperationException();
				}
			}
		}
		catch (InterruptOperationException e) {
			ConsoleHelper.printExitMessage();
		}
	}
}
