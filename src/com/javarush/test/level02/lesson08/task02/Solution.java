package com.javarush.test.level02.lesson08.task02;

/* Максимум двух чисел
Написать функцию, которая вычисляет максимум из двух чисел.
Подсказка:
Нужно написать тело существующей функции max и исправить возвращаемое значение.
*/
public class Solution {
	public static int max(int a, int b) {
		if (a < b) return b;
		else return a;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(max(10, 20));
		System.out.println(max(-10, -20));
		System.out.println(max(-100, 0));
	}

}