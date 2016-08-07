package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(reader.readLine());
		int b = Integer.parseInt(reader.readLine());
		int c = Integer.parseInt(reader.readLine());
		if (a > b && b > c) System.out.println(a + " " + b  + " " + c);
		else if (a > c && c > b) System.out.println(a + " " + c + " " + b);
		else if (b > a && a > c) System.out.println(b + " " + a + " " + c);
		else if (b > c && c > a) System.out.println(b + " " + c + " " + a);
		else if (c > a && a > b) System.out.println(c + " " + a + " " + b);
		else System.out.println(c + " " + b + " " + a);
	}
}
