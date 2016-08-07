package com.javarush.test.level14.lesson06.home01;

public class MoldovanHen extends Hen {
	private int countOfEggsPerMonth = 20;

	@Override
	public int getCountOfEggsPerMonth() {
		return countOfEggsPerMonth;
	}

	@Override
	public String getDescription() {
		return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + countOfEggsPerMonth + " яиц в месяц.";
	}
}
