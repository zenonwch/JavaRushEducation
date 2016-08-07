package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
	public static final List<Person> PEOPLE = new ArrayList<>();

	public static void main(String[] args) throws IOException, ParseException {
		BufferedReader fr = new BufferedReader(new FileReader(args[0]));
		while (fr.ready()) {
			String line = fr.readLine();
			String[] data = line.split(" ");
			int l = data.length;
			String name = "";
			for (int i = 0; i < l - 3; i++) name += data[i] + " ";
			Date birthDate = new SimpleDateFormat("dd MM yyyy").parse(data[l - 3] + " " + data[l - 2] + " " + data[l - 1]);
			PEOPLE.add(new Person(name.trim(), birthDate));
		}
		fr.close();
	}
}
