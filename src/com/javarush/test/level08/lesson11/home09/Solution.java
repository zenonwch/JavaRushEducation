package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution {
	public static void main(String[] args)  throws Exception {
		String date = "MAY 1 2013";
		System.out.println(date + " = " + isDateOdd(date));
	}

	public static boolean isDateOdd(String date) throws Exception {

		Date inputDate = new Date(date);
		inputDate.setHours(0);
		inputDate.setMinutes(0);
		inputDate.setSeconds(0);

		Date startCurrYear = new Date();
		startCurrYear.setDate(0);
		startCurrYear.setMonth(0);
		startCurrYear.setYear(inputDate.getYear());
		startCurrYear.setHours(0);
		startCurrYear.setMinutes(0);
		startCurrYear.setSeconds(0);

		long difference = inputDate.getTime() - startCurrYear.getTime();
		long diffDays = difference / (24 * 60 * 60 * 1000);

		return ((diffDays + 1) % 2 != 0);
	}
}
