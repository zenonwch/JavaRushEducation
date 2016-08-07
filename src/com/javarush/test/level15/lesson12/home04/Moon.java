package com.javarush.test.level15.lesson12.home04;

public class Moon implements Planet {
	private Moon() {}

	private static Moon INSTANCE = new Moon();

	public static Moon getInstance() {
		return INSTANCE;
	}
}