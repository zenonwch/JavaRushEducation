package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> numbers = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			numbers.add(Integer.parseInt(reader.readLine()));
		}
		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 5; j++)
			if (numbers.get(j) < numbers.get(i)) {
				int tmp = numbers.get(i);
				numbers.set(i, numbers.get(j));
				numbers.set(j, tmp);
			}
		}
		for (int n : numbers) {
			System.out.println(n);
		}
	}
}
