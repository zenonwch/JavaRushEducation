package com.javarush.test.level03.lesson03.task03;

/* 10 процентов
Реализуйте метод addTenPercent, который увеличивает переданное целое число на 10%.
Исправьте ошибку в сигнатуре метода.
Подсказка: подумайте, какие у этого метода входные и выходные данные.
*/
public class Solution {
	public static double addTenPercent(int i) {
		return (double) i * 110 / 100;
	}

	public static void main(String[] args) {
		System.out.println(addTenPercent(10));
	}
}
