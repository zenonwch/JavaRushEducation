package com.javarush.test.level26.lesson15.big01;

public enum Operation {
	INFO,
	DEPOSIT,
	WITHDRAW,
	EXIT;

	private static final Operation[] ops = Operation.values();

	public static Operation getAllowableOperationByOrdinal(Integer i) {
		if (i < 1 || i > ops.length) throw new IllegalArgumentException("Incorrect operation number.");
		return ops[i - 1];
	}
}