package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class LoginCommand implements Command {
	private static final String verifiedCardsProps = "com.javarush.test.level26.lesson15.big01.resources.verifiedCards";
	private static final String loginPropsPath = "com.javarush.test.level26.lesson15.big01.resources.login";
	private ResourceBundle validCreditCards = PropertyResourceBundle.getBundle(verifiedCardsProps, Locale.ENGLISH);
	private ResourceBundle res = PropertyResourceBundle.getBundle(loginPropsPath, Locale.ENGLISH);

	@Override
	public void execute() throws InterruptOperationException {

		ConsoleHelper.writeMessage(res.getString("specify.data"));
		while (true) {
			String inputCardNumber;
			try {
				inputCardNumber = ConsoleHelper.readString();
				String inputPIN = ConsoleHelper.readString();
				ConsoleHelper.writeMessage(res.getString("before"));
				if (inputCardNumber.length() != 12 || inputPIN.length() != 4)
					throw new NumberFormatException();
				if (validCreditCards.keySet().contains(inputCardNumber) && inputPIN.equals(validCreditCards.getString(inputCardNumber))) {
					ConsoleHelper.writeMessage(String.format(res.getString("success.format"), inputCardNumber));
					break;
				} else {
					ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), inputCardNumber));
					ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
				}
			}
			catch (NumberFormatException e) {
				ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
			}
		}
	}
}
