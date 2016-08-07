package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName1 = reader.readLine();
		String fileName2 = reader.readLine();
		String fileName3 = reader.readLine();
		reader.close();
		FileOutputStream fos = new FileOutputStream(fileName1);
		FileInputStream fis1 = new FileInputStream(fileName2);
		FileInputStream fis2 = new FileInputStream(fileName3);
		while (fis1.available() > 0) {
			fos.write(fis1.read());
		}
		while (fis2.available() > 0) {
			fos.write(fis2.read());
		}
		fis1.close();
		fis2.close();
		fos.close();
	}
}
