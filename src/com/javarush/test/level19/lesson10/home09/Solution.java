package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.*;

public class Solution {
	public static TestString testString = new TestString();

	public static void main(String[] args) throws IOException {
		PrintStream oldStream = System.out;
		ByteArrayOutputStream myStream = new ByteArrayOutputStream();
		PrintStream newStream = new PrintStream(myStream);
		System.setOut(newStream);

		testString.printSomething();

		System.setOut(oldStream);
		BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(myStream.toByteArray())));
		int counter = 0;
		while (reader.ready()) {
			String line = reader.readLine();
			System.out.println(line);
			counter++;
			if (counter % 2 == 0) System.out.println("JavaRush - курсы Java онлайн");
		}
		reader.close();
	}

	public static class TestString {
		public void printSomething() {
			System.out.println("first");
			System.out.println("second");
			System.out.println("third");
			System.out.println("fourth");
			System.out.println("fifth");
		}
	}
}