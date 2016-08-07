package com.javarush.test.level02.lesson02.task02;

/* Вычитание чисел
Реализуй метод public static int subtraction(int a, int b). Метод возвращает результат вычитания из числа a числа b.
*/
public class Solution {

	public static void main(String[] args) {
		int c = subtraction(10, 5);
		System.out.println(c);
	}

	public static int subtraction(int a, int b) {
		return a - b;
	}
}
