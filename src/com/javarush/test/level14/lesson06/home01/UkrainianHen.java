package com.javarush.test.level14.lesson06.home01;

public class UkrainianHen extends Hen {
	private int countOfEggsPerMonth = 28;

	@Override
	public int getCountOfEggsPerMonth() {
		return countOfEggsPerMonth;
	}

	@Override
	public String getDescription() {
		return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + countOfEggsPerMonth + " яиц в месяц.";
	}
}
