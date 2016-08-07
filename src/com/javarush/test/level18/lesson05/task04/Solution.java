package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String file1 = reader.readLine();
		String file2 = reader.readLine();
		reader.close();
		FileInputStream fileInputStream = new FileInputStream(file1);
		byte[] buff = new byte[fileInputStream.available()];
		FileOutputStream fileOutputStream = new FileOutputStream(file2);
		while (fileInputStream.available() > 0) {
			int count = fileInputStream.read(buff);
			byte[] reversBuff = new byte[count];
			for (int i = count - 1; i >= 0; i--) {
				reversBuff[count - 1 - i] = buff[i];
			}
			fileOutputStream.write(reversBuff, 0, count);
		}
		fileInputStream.close();
		fileOutputStream.close();
	}
}
