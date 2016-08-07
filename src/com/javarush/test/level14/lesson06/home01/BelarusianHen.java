package com.javarush.test.level14.lesson06.home01;

public class BelarusianHen extends Hen {
	private int countOfEggsPerMonth = 30;

	@Override
	public int getCountOfEggsPerMonth() {
		return countOfEggsPerMonth;
	}

	@Override
	public String getDescription() {
		return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + countOfEggsPerMonth + " яиц в месяц.";
	}
}
