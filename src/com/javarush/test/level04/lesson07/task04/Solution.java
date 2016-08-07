package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(reader.readLine());
		int b = Integer.parseInt(reader.readLine());
		int c = Integer.parseInt(reader.readLine());
		int countNegative = 0;
		int countPositive = 0;
		if (a > 0) countPositive++;
		else if (a < 0) countNegative++;
		if (b > 0) countPositive++;
		else if (b < 0) countNegative++;
		if (c > 0) countPositive++;
		else if (c < 0) countNegative++;
		System.out.println("количество отрицательных чисел: " + countNegative);
		System.out.println("количество положительных чисел: " + countPositive);
	}
}
