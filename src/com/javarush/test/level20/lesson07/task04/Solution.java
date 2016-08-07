package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable {
	public static void main(String[] args) {
		try {
			File tmp_file = File.createTempFile("tmp", ".txt", new File("C:\\tmp_new\\"));
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tmp_file));
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(tmp_file));

			Solution savedObject = new Solution(25);
			oos.writeObject(savedObject);
			oos.close();

			Solution savedObject2 = new Solution(30);
			Solution loadedObject = (Solution) ois.readObject();
			ois.close();

			System.out.println(savedObject);
			System.out.println(loadedObject);
		}
		catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Oops, something wrong with my file");
		}
		catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Oops, something wrong with save/load method");
		}
		System.out.println(new Solution(4));
	}

	transient private final String pattern = "dd MMMM yyyy, EEEE";
	transient private Date currentDate;
	transient private int temperature;
	String string;

	public Solution () {}

	public Solution(int temperature) {
		this.currentDate = new Date();
		this.temperature = temperature;

		string = "Today is %s, and current temperature is %s C";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		this.string = String.format(string, format.format(currentDate), temperature);
	}

	@Override
	public String toString() {
		return this.string;
	}
}