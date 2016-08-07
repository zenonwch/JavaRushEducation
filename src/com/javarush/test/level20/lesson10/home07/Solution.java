package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
	private transient FileOutputStream stream;
	public String fileName = null; //чтобы в другом метсе при десериализации создался такой же файл

	public static void main(String[] args) throws Exception {
		Solution solution = new Solution("C:\\tmp_new\\res.txt");
		solution.writeObject("Hi");

		//SAVE
		FileOutputStream fileOutputStream = new FileOutputStream("C:\\tmp_new\\res2.txt");
		ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
		outputStream.writeObject(solution);
		outputStream.flush();
		outputStream.close();
		//LOAD
		FileInputStream fileInputStream = new FileInputStream("C:\\tmp_new\\res2.txt");
		ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
		Solution t2 = (Solution) inputStream.readObject();
		inputStream.close();
		t2.writeObject("Hi2");
		solution.close();
		System.out.println(t2.fileName);
	}

	public Solution(String fileName) throws FileNotFoundException {
		this.fileName = fileName;
		this.stream = new FileOutputStream(this.fileName);
	}

	public void writeObject(String string) throws IOException {
		stream.write(string.getBytes());
		stream.write("\n".getBytes());
		stream.flush();
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		this.stream = new FileOutputStream(this.fileName, true); //true чтобы продолжить запись
	}

	@Override
	public void close() throws Exception {
		System.out.println("Closing everything!");
		stream.close();
	}
}