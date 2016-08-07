package com.javarush.test.level03.lesson01.task01;

/* Реализация метода
Реализуйте метод public static void div(int a, int b).
Метод должен делить первое число на второе, и выводить на экран результат деления а / b.
*/
public class Solution {
	public static void main(String[] args) {
		div(6, 3);
		div(10, 6);
		div(2, 4);
	}

	public static void div(int a, int b) {
		System.out.println(a/b);
	}
}
