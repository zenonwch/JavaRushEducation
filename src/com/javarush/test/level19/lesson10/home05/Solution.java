package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader fr = new BufferedReader(new FileReader(args[0]));
		BufferedWriter fw = new BufferedWriter(new FileWriter(args[1]));
		while (fr.ready()) {
			String[] words = fr.readLine().split(" ");
			for (String w : words) if (w.matches(".*\\d.*")) fw.write(w + " ");
		}
		fr.close();
		fw.close();
	}
}
