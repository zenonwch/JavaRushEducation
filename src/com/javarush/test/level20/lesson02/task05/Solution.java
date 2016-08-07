package com.javarush.test.level20.lesson02.task05;

import java.io.*;

/* И еще раз о синхронизации
Разберитесь почему не работает метод main()
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
	public static void main(java.lang.String[] args) {
		//you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
		//вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
		try {
			File your_file_name = File.createTempFile("tmp", ".txt", new File("C:\\tmp_new\\"));
			OutputStream outputStream = new FileOutputStream(your_file_name);
			InputStream inputStream = new FileInputStream(your_file_name);

			Object object = new Object();
			object.string1 = new String();   //string #1
			object.string2 = new String();   //string #2
			object.save(outputStream);
			outputStream.flush();

			Object loadedObject = new Object();
			loadedObject.string1 = new String(); //string #3
			loadedObject.string2 = new String(); //string #4


			loadedObject.load(inputStream);
			loadedObject.string1.print();
			loadedObject.string2.print();

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


	public static class Object {
		public String string1;
		public String string2;

		public void save(OutputStream outputStream) throws Exception {
			PrintWriter writer = new PrintWriter(outputStream);
			writer.println(this.string1.number);
			writer.println(this.string2.number);
			writer.flush();
			writer.close();
		}

		public void load(InputStream inputStream) throws Exception {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			int tmpCountStrings = Solution.countStrings;
			while (reader.ready()) {
				Solution.countStrings = Integer.parseInt(reader.readLine()) - 1;
				this.string1 = new String();
				Solution.countStrings = Integer.parseInt(reader.readLine()) - 1;
				this.string2 = new String();
			}
			reader.close();
			Solution.countStrings = tmpCountStrings;
		}
	}

	public static int countStrings;

	public static class String {
		private final int number;

		public String() {
			number = ++countStrings;
		}

		public void print() {
			System.out.println("string #" + number);
		}
	}
}
