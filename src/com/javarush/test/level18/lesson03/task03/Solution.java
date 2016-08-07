package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName = reader.readLine();
		FileInputStream fileReader = new FileInputStream(fileName);
		HashMap<Integer, Integer> bytes = new HashMap<>();
		while (fileReader.available() > 0) {
			int data = fileReader.read();
			if (bytes.containsKey(data)) bytes.put(data, bytes.get(data) + 1);
			else bytes.put(data, 1);
		}
		reader.close();
		fileReader.close();
		int maxRepetition = 0;
		String keys = "";
		for (Map.Entry<Integer, Integer> pair : bytes.entrySet()) {
			if (pair.getValue() >= maxRepetition) {
				if (pair.getValue() == maxRepetition) keys += " " + pair.getKey();
				else keys = "" + pair.getKey();
				maxRepetition = pair.getValue();
			}
		}
		System.out.println(keys);
	}
}
