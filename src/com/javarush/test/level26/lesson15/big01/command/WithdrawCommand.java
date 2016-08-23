package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Locale;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

class WithdrawCommand implements Command {
	private static final String withdrawPropsPath = CashMachine.RESOURCE_PATH + "withdraw";
	private ResourceBundle res = PropertyResourceBundle.getBundle(withdrawPropsPath, Locale.ENGLISH);

	@Override
	public void execute() throws InterruptOperationException {
		String currencyCode = ConsoleHelper.askCurrencyCode();
		CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
		while (true) {
			try {
				ConsoleHelper.writeMessage(res.getString("specify.amount"));
				int amount = Integer.parseInt(ConsoleHelper.readString());
				ConsoleHelper.writeMessage(res.getString("before"));
				if (manipulator.isAmountAvailable(amount)) {
					Map<Integer, Integer> withdraw = manipulator.withdrawAmount(amount);
					for (Map.Entry<Integer, Integer> pair : withdraw.entrySet())
						ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());
				} else {
					throw new NotEnoughMoneyException();
				}
				ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, currencyCode));
				break;
			}
			catch (NumberFormatException e) {
				ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
			}
			catch (NotEnoughMoneyException e) {
				if (e.getStackTrace()[0].getMethodName().equals("withdrawAmount"))
					ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
				else
					ConsoleHelper.writeMessage(res.getString("not.enough.money"));
			}
		}
	}
}
