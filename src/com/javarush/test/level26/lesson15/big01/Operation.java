package com.javarush.test.level26.lesson15.big01;

public enum Operation {
	LOGIN,
	INFO,
	DEPOSIT,
	WITHDRAW,
	EXIT;

	private static final Operation[] ops = Operation.values();

	public static Operation getAllowableOperationByOrdinal(Integer i) {
		if (i < 1 || i > ops.length - 1) throw new IllegalArgumentException("Incorrect operation number.");
		return ops[i];
	}
}