package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		OutputStream os = new FileOutputStream(reader.readLine());
		Writer writer = new OutputStreamWriter(os);
		while (true) {
			String line = reader.readLine();
			writer.write(line);
			writer.write(System.getProperty("line.separator"));
			if (line.equals("exit")) break;
			}
		reader.close();
		writer.close();
		os.close();
	}
}
