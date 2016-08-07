package com.javarush.test.level15.lesson12.home04;

public class Sun implements Planet {
	private Sun() {}

	private static Sun INSTANCE = new Sun();

	public static Sun getInstance() {
		return INSTANCE;
	}
}