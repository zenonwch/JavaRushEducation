package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws IOException {
		String tag = args[0];

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName = reader.readLine();
		reader.close();

		String text = "";
		BufferedReader fr = new BufferedReader(new FileReader(fileName));
		while (fr.ready()) text += fr.readLine();
		fr.close();

		Stack<Integer> startIndexes = new Stack<>();
		Stack<String> lines = new Stack<>();
		int indTag = text.indexOf(tag);
		while (indTag >= 0) {
			if (text.substring(indTag - 1, indTag).equals("<")) startIndexes.add(indTag - 1);
			else if (text.substring(indTag - 2, indTag).equals("</")) {
				lines.add(text.substring(startIndexes.pop(), indTag) + tag + ">");
				if (startIndexes.size() == 0) {
					while (lines.size() > 0) System.out.println(lines.pop());
				}
			}
			indTag = text.indexOf(tag, indTag + 1);
		}
	}
}
