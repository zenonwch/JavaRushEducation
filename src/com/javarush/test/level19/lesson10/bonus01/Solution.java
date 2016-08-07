package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1         строка1             SAME строка1
строка2                             REMOVED строка2
строка3         строка3             SAME строка3
строка4                             REMOVED строка4
строка5         строка5             SAME строка5
						строка0          ADDED строка0
строка1         строка1             SAME строка1
строка2                             REMOVED строка2
строка3         строка3             SAME строка3
						строка5          ADDED строка5
строка4         строка4             SAME строка4
строка5                             REMOVED строка5
*/

public class Solution {
	public static List<LineItem> lines = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName1 = reader.readLine();
		String fileName2 = reader.readLine();
		reader.close();

		BufferedReader fr1 = new BufferedReader(new FileReader(fileName1));
		BufferedReader fr2 = new BufferedReader(new FileReader(fileName2));

		boolean flagReadF1 = true;
		boolean flagReadF2 = true;
		String currF1Line = "";
		String currF2Line = "";
		String prevF1Line;
		String prevF2Line;

		while (fr1.ready() || fr2.ready()) {
			if (flagReadF1) currF1Line = fr1.readLine();
			if (flagReadF2) currF2Line = fr2.readLine();

			if (currF1Line != null && currF2Line != null) {
				if (currF2Line.equals(currF1Line)) {
					lines.add(new LineItem(Type.SAME, currF1Line));
					flagReadF1 = true;
					flagReadF2 = true;
				} else {
					prevF1Line = currF1Line;
					currF1Line = fr1.readLine();
					if (currF2Line.equals(currF1Line)) {
						lines.add(new LineItem(Type.REMOVED, prevF1Line));
						flagReadF1 = false;
						flagReadF2 = false;
					} else {
						prevF2Line = currF2Line;
						currF2Line = fr2.readLine();
						if (currF2Line.equals(prevF1Line)) {
							lines.add(new LineItem(Type.ADDED, prevF2Line));
							lines.add(new LineItem(Type.SAME, prevF1Line));
							flagReadF1 = false;
						}
					}
				}
			}
			if (currF1Line == null && currF2Line != null) lines.add(new LineItem(Type.ADDED, currF2Line));
			if (currF1Line != null && currF2Line == null) lines.add(new LineItem(Type.REMOVED, currF1Line));
		}

		fr1.close();
		fr2.close();

		for (LineItem item : lines) {
			System.out.println(item.type + " " + item.line);
		}
	}


	public static enum Type {
		ADDED,        //добавлена новая строка
		REMOVED,      //удалена строка
		SAME          //без изменений
	}

	public static class LineItem {
		public Type type;
		public String line;

		public LineItem(Type type, String line) {
			this.type = type;
			this.line = line;
		}
	}
}