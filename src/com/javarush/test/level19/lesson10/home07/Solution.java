package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader fr = new BufferedReader(new FileReader(args[0]));
		BufferedWriter fw = new BufferedWriter(new FileWriter(args[1]));
		boolean firstWord = true;
		while (fr.ready()) {
			String[] words = fr.readLine().split(" ");
			for (String w : words)
				if (w.length() > 6) {
					if (firstWord) {
						fw.write(w);
						firstWord = false;
					} else fw.write("," + w);
				}
		}
		fr.close();
		fw.close();
	}
}
