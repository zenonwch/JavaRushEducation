package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
	public static TestString testString = new TestString();

	public static void main(String[] args) {
		PrintStream oldStream = System.out;
		ByteArrayOutputStream myStream = new ByteArrayOutputStream();
		PrintStream newStream = new PrintStream(myStream);
		System.setOut(newStream);

		testString.printSomething();
		String res = myStream.toString();

		System.setOut(oldStream);

		String[] expression = res.split(" ");
		int firstOperand = Integer.parseInt(expression[0]);
		int secondOperand = Integer.parseInt(expression[2]);
		String sign = expression[1];
		switch (sign) {
			case "+":
				res += firstOperand + secondOperand;
				break;
			case "-":
				res += firstOperand - secondOperand;
				break;
			case "*":
				res += firstOperand * secondOperand;
				break;
		}

		System.out.println(res.replace(System.lineSeparator(), ""));
	}

	public static class TestString {
		public void printSomething() {
			System.out.println("3 + 6 = ");
		}
	}
}

