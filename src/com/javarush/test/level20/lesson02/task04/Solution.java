package com.javarush.test.level20.lesson02.task04;

import java.io.*;

/* Читаем и пишем в файл статики
Реализуйте логику записи в файл и чтения из файла для класса ClassWithStatic
Метод load должен инициализировать объект включая статические поля данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
	public static void main(String[] args) {
		//you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
		//вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
		try {

			File your_file_name = File.createTempFile("tmp", ".txt", new File("C:\\tmp_new\\"));
			OutputStream outputStream = new FileOutputStream(your_file_name);
			InputStream inputStream = new FileInputStream(your_file_name);

			ClassWithStatic classWithStatic = new ClassWithStatic();
			classWithStatic.i = 3;
			classWithStatic.j = 4;
			classWithStatic.save(outputStream);
			outputStream.flush();

			ClassWithStatic loadedObject = new ClassWithStatic();
			loadedObject.staticString = "something";
			loadedObject.i = 6;
			loadedObject.j = 7;

			loadedObject.load(inputStream);
			System.out.println(loadedObject.staticString);
			System.out.println(loadedObject.i);

			outputStream.close();
			inputStream.close();

		}
		catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Oops, something wrong with my file");
		}
		catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Oops, something wrong with save/load method");
		}
	}

	public static class ClassWithStatic {
		public static String staticString = "it's test static string";
		public int i;
		public int j;

		public void save(OutputStream outputStream) throws Exception {
			PrintWriter writer = new PrintWriter(outputStream);
			writer.println(staticString);
			writer.println(i);
			writer.println(j);
			writer.flush();
			writer.close();
		}

		public void load(InputStream inputStream) throws Exception {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			ClassWithStatic.staticString = reader.readLine();
			this.i = Integer.parseInt(reader.readLine());
			this.j = Integer.parseInt(reader.readLine());
			reader.close();
		}
	}
}
