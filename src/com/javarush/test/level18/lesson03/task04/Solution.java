package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName = reader.readLine();
		FileInputStream fileReader = new FileInputStream(fileName);
		HashMap<Integer, Integer> bytes = new HashMap<>();
		while(fileReader.available() > 0) {
			int data = fileReader.read();
			if (bytes.containsKey(data)) bytes.put(data, bytes.get(data) + 1);
			else bytes.put(data, 1);
		}
		reader.close();
		fileReader.close();
		String res = "";
		int minRepetitions = Integer.MAX_VALUE;
		for (Map.Entry<Integer, Integer> pair : bytes.entrySet()) {
			if (pair.getValue() <= minRepetitions) {
				if (pair.getValue() == minRepetitions) res += " " + pair.getKey();
				else res = "" + pair.getKey();
				minRepetitions = pair.getValue();
			}
		}
		System.out.println(res);
	}
}