package com.javarush.test.level02.lesson08.task04;

/* Минимум четырех чисел
Написать функцию, которая вычисляет минимум из четырёх чисел.
Функция min(a,b,c,d) должна использовать (вызывать) функцию min(a,b)
Подсказка:
Нужно написать тело обеих существующих функций min и исправить их возвращаемые значения.
*/
public class Solution {
	public static int min(int a, int b, int c, int d) {
		int min1 = min(a, b);
		int min2 = min(c, d);
		int min;
		if (min2 < min1) min = min2;
		else min = min1;
		return min;
	}

	public static int min(int a, int b) {
		int min;
		if (b < a) min = b;
		else min = a;
		return min;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(min(-20, -10));
		System.out.println(min(-20, -10, -30, -40));
		System.out.println(min(-20, -10, -30, 40));
	}
}