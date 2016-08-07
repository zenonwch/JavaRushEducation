package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String file = reader.readLine();
		FileInputStream fileReader = new FileInputStream(file);
		int maxByte = Integer.MIN_VALUE;
		while (fileReader.available() > 0) {
			int data = fileReader.read();
			if (data > maxByte) maxByte = data;
		}
		System.out.println(maxByte);
		reader.close();
		fileReader.close();
	}
}
