package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, String> map = new TreeMap<>();
		while (true) {
			String line = reader.readLine();
			if (line.equals("end")) break;
			map.put(Integer.parseInt(line.split(".part")[1]) - 1, line);
		}
		reader.close();

		FileOutputStream fos = new FileOutputStream(map.get(1).split(".part")[0]);

		for (Map.Entry<Integer, String> pair : map.entrySet()) {
			FileInputStream fis = new FileInputStream(pair.getValue());
			byte[] buff = new byte[fis.available()];
			while (fis.available() > 0) {
				fis.read(buff);
				fos.write(buff);
			}
			fis.close();
		}
		fos.close();
	}
}
