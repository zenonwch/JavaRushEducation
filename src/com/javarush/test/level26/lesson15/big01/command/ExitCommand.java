package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

class ExitCommand implements Command {
	private static final String exitProps = "com.javarush.test.level26.lesson15.big01.resources.exit";
	private ResourceBundle res = PropertyResourceBundle.getBundle(exitProps, Locale.ENGLISH);

	@Override
	public void execute() throws InterruptOperationException {
		ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
		if (ConsoleHelper.readString().equals(res.getString("yes")))
			ConsoleHelper.writeMessage(res.getString("thank.message"));
	}
}
