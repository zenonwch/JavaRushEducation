package com.javarush.test.level26.lesson15.big01;

import java.util.Map;
import java.util.HashMap;

public final class CurrencyManipulatorFactory {
	private static Map<String, CurrencyManipulator> manipulators = new HashMap<>();

	private CurrencyManipulatorFactory() {
	}

	public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
		if (!manipulators.containsKey(currencyCode))
			manipulators.put(currencyCode, new CurrencyManipulator(currencyCode));
		return manipulators.get(currencyCode);
	}
}