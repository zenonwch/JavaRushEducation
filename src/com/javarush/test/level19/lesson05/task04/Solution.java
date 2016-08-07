package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
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
			String line = fr.readLine().replaceAll("\\.", "!");
			fw.write(line);
			fw.write(System.lineSeparator());
		}
		fr.close();
		fw.close();
	}
}
