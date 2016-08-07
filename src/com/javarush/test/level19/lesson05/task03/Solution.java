package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String inputFileName = reader.readLine();
		String outputFileName = reader.readLine();
		reader.close();
		BufferedReader fr = new BufferedReader(new FileReader(inputFileName));
		BufferedWriter fw = new BufferedWriter(new FileWriter(outputFileName));
		while (fr.ready()) {
			String text = fr.readLine();
			String[] words = text.split("[\\p{IsPunctuation}\\p{IsWhite_Space}]+");
			for (String w : words) {
				String n = "";
				try {
					n = String.valueOf(Integer.parseInt(w)) + " ";
				} catch (NumberFormatException e) {	}
				fw.write(n);
			}
		}
		fr.close();
		fw.close();
	}
}