package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName = reader.readLine();
		reader.close();
		BufferedReader fr = new BufferedReader(new FileReader(fileName));
		int id = 1;
		while (fr.ready()) {
			String line = fr.readLine();
			if (line.isEmpty()) break;
			id = Integer.parseInt(line.substring(0, 8).trim());
		}
		fr.close();
		id = id == 99999999 ? 0 : id + 1;
		FileOutputStream fos = new FileOutputStream(fileName, true);
		if (args[0].equals("-c")) {
			fos.write(newStringWithLength(String.valueOf(id), 8).getBytes());
			fos.write(newStringWithLength(args[1], 30).getBytes());
			fos.write(newStringWithLength(args[2], 8).getBytes());
			fos.write(newStringWithLength(args[3], 4).getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
		}
		fos.close();
	}

	public static String newStringWithLength(String s, int length) {
		if (s.length() > length) s = s.substring(0, length);
		else {
			for (int i = s.length(); i < length; i++) {
				s += " ";
			}
		}
		return s;
	}
}