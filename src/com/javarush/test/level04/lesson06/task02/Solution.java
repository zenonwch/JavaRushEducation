package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(reader.readLine());
		int b = Integer.parseInt(reader.readLine());
		int c = Integer.parseInt(reader.readLine());
		int d = Integer.parseInt(reader.readLine());
		int max1, max2, max;
		if (a < b) max1 = b;
		else max1 = a;
		if (c < d) max2 = d;
		else max2 = c;
		if (max1 < max2) max = max2;
		else max = max1;
		System.out.println(max);
	}
}
