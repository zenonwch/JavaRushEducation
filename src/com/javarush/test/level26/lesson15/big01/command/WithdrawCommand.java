package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Map;

class WithdrawCommand implements Command {
	@Override
	public void execute() throws InterruptOperationException {
		String currencyCode = ConsoleHelper.askCurrencyCode();
		CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
		while (true) {
			try {
				ConsoleHelper.writeMessage("Пожалуйста, введите сумму.");
				int amount = Integer.parseInt(ConsoleHelper.readString());
				if (manipulator.isAmountAvailable(amount)) {
					Map<Integer, Integer> withdraw = manipulator.withdrawAmount(amount);
					for (Map.Entry<Integer, Integer> pair : withdraw.entrySet())
						ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());
				} else {
					throw new NotEnoughMoneyException();
				}
				break;
			} catch (NumberFormatException e) {
				ConsoleHelper.writeMessage("Пожалуйста, введите корректные данные.");
			} catch (NotEnoughMoneyException e) {
				ConsoleHelper.writeMessage("Извините, в банкомате не хватает средств.");
			}
		}
	}
}
