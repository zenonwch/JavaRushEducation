package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
	public static void main(String[] args) throws IOException {
		Map<String, Double> salaries = new TreeMap<>();
		BufferedReader fr = new BufferedReader(new FileReader(args[0]));
		while (fr.ready()) {
			String line = fr.readLine();
			String name = line.split(" ")[0];
			double salary = Double.parseDouble(line.split(" ")[1]);
			if (salaries.containsKey(name)) salaries.put(name, salaries.get(name) + salary);
			else salaries.put(name, salary);
		}
		fr.close();
		double maxSalary = Double.MIN_VALUE;
		String ownersOfMaxSalary = "";
		for (Map.Entry<String, Double> pair : salaries.entrySet()) {
			if (pair.getValue() >= maxSalary) {
				if (pair.getValue() == maxSalary) ownersOfMaxSalary += " " + pair.getKey();
				else ownersOfMaxSalary = pair.getKey();
				maxSalary = pair.getValue();
			}
		}
		System.out.println(ownersOfMaxSalary);
	}
}
