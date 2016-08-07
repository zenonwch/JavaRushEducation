package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<String> list = new ArrayList<>();
 		try {
			String URL = reader.readLine();
			String[] s = URL.split("\\?")[1].split("&");
		    list = Arrays.asList(s);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		for (String s : list) System.out.print(s.split("=")[0] + " ");
		System.out.println();
		for (String s : list) {
			if (s.split("=")[0].equals("obj")) {
				try {
					alert(Double.parseDouble(s.split("=")[1]));
				} catch (NumberFormatException e) {
					alert(s.split("=")[1]);
				}
			}
		}
	}

	public static void alert(double value) {
		System.out.println("double " + value);
	}

	public static void alert(String value) {
		System.out.println("String " + value);
	}
}
