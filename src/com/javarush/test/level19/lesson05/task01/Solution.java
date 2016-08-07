package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String inputFileName = reader.readLine();
		String outputFileName = reader.readLine();
		reader.close();
		FileReader fr = new FileReader(inputFileName);
		FileWriter fw = new FileWriter(outputFileName);
		int counter = 0;
		while (fr.ready()) {
			int data = fr.read();
			counter++;
			if (counter % 2 == 0) fw.write(data);
		}
		fr.close();
		fw.close();
	}
}
