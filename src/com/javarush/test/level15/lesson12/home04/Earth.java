package com.javarush.test.level15.lesson12.home04;

public class Earth implements Planet {
	private Earth() {}

	private static Earth INSTANCE = new Earth();

	public static Earth getInstance() {
		return INSTANCE;
	}
}