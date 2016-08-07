package com.javarush.test.level14.lesson06.home01;

public class RussianHen extends Hen {
	private int countOfEggsPerMonth = 22;

	@Override
	public int getCountOfEggsPerMonth() {
		return countOfEggsPerMonth;
	}

	@Override
	public String getDescription() {
		return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + countOfEggsPerMonth + " яиц в месяц.";
	}
}
