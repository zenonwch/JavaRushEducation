package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName1 = reader.readLine();
		String fileName2 = reader.readLine();
		reader.close();

		FileInputStream fis1 = new FileInputStream(fileName1);
		FileInputStream fis2 = new FileInputStream(fileName2);

		int f1Length = fis1.available();
		int f2Length = fis2.available();
		byte[] buff = new byte[f1Length + f2Length];
		int count = 0;

		while (fis2.available() > 0) count = fis2.read(buff);
		while (fis1.available() > 0) count += fis1.read(buff, f2Length, f1Length);
		fis1.close();
		fis2.close();

		FileOutputStream fos = new FileOutputStream(fileName1);
		fos.write(buff, 0, count);
		fos.close();
	}
}