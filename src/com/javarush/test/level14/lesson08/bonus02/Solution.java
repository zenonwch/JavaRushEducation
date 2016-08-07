package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(reader.readLine());
		int b = Integer.parseInt(reader.readLine());
		int m, n, nod;
		if (a > b) {
			m = a;
			n = b;
		} else {
			m = b;
			n = a;
		}
		while (true) {
			if (m % n == 0) {
				nod = n;
				break;
			} else {
				int tmp = n;
				n = m % n;
				m = tmp;
			}
		}
		System.out.println(nod);
	}
}