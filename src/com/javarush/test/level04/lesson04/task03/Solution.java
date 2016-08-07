package com.javarush.test.level04.lesson04.task03;

/* Интервал
Реализовать метод checkInterval. Метод должен проверять попало ли целое число в интервал от 50 до 100
и сообщить результат на экран в следующем виде: "Число а не содержится в интервале." или "Число а содержится в интервале.",
где  а - аргумент метода.
Пример для числа 112:
Число 112 не содержится в интервале.
Пример для числа 60:
Число 60 содержится в интервале.
*/

public class Solution {
	public static void main(String[] args) {
		checkInterval(60);
		checkInterval(112);
	}

	public static void checkInterval(int a) {
		if ((a < 50) || (a > 100)) System.out.println("Число " + a + " не содержится в интервале.");
		else System.out.println("Число " + a + " содержится в интервале.");
	}
}