package com.javarush.test.level01.lesson08.task05;

/* Вызов метода
Напиши программу, которая вызывает метод sum с параметрами 2 и 2
*/
public class Solution {
	public static void main(String[] args) {
		sum(2, 2);
	}

	public static void sum(int a, int b) {
		int c = a + b;
		System.out.print(c);
	}
}
