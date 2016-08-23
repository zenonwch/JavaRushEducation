package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Collections;
import java.util.TreeMap;
import java.util.Map;

public class CurrencyManipulator {
	private String currencyCode;
	private Map<Integer, Integer> denominations = new TreeMap<>(Collections.reverseOrder());

	public CurrencyManipulator(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void addAmount(int denomination, int count) {
		if (denominations.containsKey(denomination))
			denominations.put(denomination, denominations.get(denomination) + count);
		else denominations.put(denomination, count);
	}

	public int getTotalAmount() {
		int amount = 0;
		for (Map.Entry<Integer, Integer> pair : denominations.entrySet())
			amount += pair.getKey() * pair.getValue();
		return amount;
	}

	public boolean hasMoney() {
		return !denominations.isEmpty();
	}

	public boolean isAmountAvailable(int expectedAmount) {
		return (getTotalAmount() - expectedAmount >= 0);
	}

	public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
		Map<Integer, Integer> result = new TreeMap<>(Collections.reverseOrder());
		for (Map.Entry<Integer, Integer> denomination : denominations.entrySet()) {
			int amount = denomination.getKey();
			int availableCount = denomination.getValue();
			while (expectedAmount - amount >= 0 && availableCount > 0) {
				if (result.containsKey(amount))
					result.put(amount, result.get(amount) + 1);
				else result.put(amount, 1);
				expectedAmount -= denomination.getKey();
				availableCount--;
			}
		}
		if (expectedAmount > 0) throw new NotEnoughMoneyException();
		for (Map.Entry<Integer, Integer> pair : result.entrySet()) {
			denominations.put(pair.getKey(), denominations.get(pair.getKey()) - pair.getValue());
		}
		return result;
	}
}
