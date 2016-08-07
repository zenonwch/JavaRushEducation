package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

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
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName = reader.readLine();
		reader.close();
		File inputFile = new File(fileName);
		File tmpFile = new File(System.getProperty("java.io.tmpdir") + File.separator + "tmp.txt");
		BufferedReader fr = new BufferedReader(new FileReader(inputFile));
		BufferedWriter fw = new BufferedWriter(new FileWriter(tmpFile));
		while (fr.ready()) {
			String line = fr.readLine();
			if (line.substring(0, 8).trim().equals(String.valueOf(args[1]))) {
				if (args[0].equals("-d")) continue;
				if (args[0].equals("-u"))
					line = newStringWithLength(args[1], 8) + newStringWithLength(args[2], 30) + newStringWithLength(args[3], 8) + newStringWithLength(args[4], 4);
			}
			fw.write(line);
			fw.write(System.getProperty("line.separator"));
		}
		fr.close();
		fw.close();
		inputFile.delete();
		tmpFile.renameTo(inputFile);
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