package com.javarush.test.level04.lesson10.task05;

import java.io.*;

/* Таблица умножения
Вывести на экран таблицу умножения 10х10 используя цикл while.
Числа разделить пробелом.
1 2 3 4 5 6 7 8 9 10
2 4 6 8 10 12 14 16 18 20
...
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		int i = 1;
		while (i < 11) {
			int j = 1;
			while (j < 11) {
				System.out.print(i * j + " ");
				j++;
			}
			System.out.println();
			i++;
		}
	}
}
