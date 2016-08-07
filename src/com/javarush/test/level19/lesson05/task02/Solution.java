package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName = reader.readLine();
		reader.close();
		int counter = 0;
		BufferedReader fr = new BufferedReader(new FileReader(fileName));
		while (fr.ready()) {
			String text = fr.readLine();
			if (!text.isEmpty()) {
				String[] words = text.split("[\\p{IsPunctuation}\\p{IsWhite_Space}]+");
				for (String word : words) {
					if (word.equals("world")) counter++;
				}
			}
		}
		System.out.println(counter);
		fr.close();
	}
}
