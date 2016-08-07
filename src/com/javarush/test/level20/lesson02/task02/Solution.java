package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
	public static void main(String[] args) {
		//you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
		//вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
		try {
			File your_file_name = File.createTempFile("res", ".txt", new File("C:\\tmp_new\\"));
			OutputStream outputStream = new FileOutputStream(your_file_name);
			InputStream inputStream = new FileInputStream(your_file_name);

			JavaRush javaRush = new JavaRush();
			User user = new User();
			user.setFirstName("Pavel");
			user.setLastName("Petrov");
			user.setBirthDate(new SimpleDateFormat("dd MM yyyy").parse("24 07 2000"));
			user.setMale(true);
			user.setCountry(User.Country.OTHER);
			javaRush.users.add(user);
			javaRush.save(outputStream);
			outputStream.flush();

			JavaRush loadedObject = new JavaRush();
			loadedObject.load(inputStream);
			//check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

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

	public static class JavaRush {
		public List<User> users = new ArrayList<>();

		public void save(OutputStream outputStream) throws Exception {
			PrintWriter writer = new PrintWriter(outputStream);
			for (User user : users) {
				writer.println(user.getFirstName());
				writer.println(user.getLastName());
				writer.println(new SimpleDateFormat("dd MM yyyy").format(user.getBirthDate()));
				writer.println(user.isMale());
				writer.println(user.getCountry().getDisplayedName());
				writer.flush();
			}
		}

		public void load(InputStream inputStream) throws Exception {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			while (reader.ready()) {
				User user = new User();
				user.setFirstName(reader.readLine());
				user.setLastName(reader.readLine());
				user.setBirthDate(new SimpleDateFormat("dd MM yyyy").parse(reader.readLine()));
				user.setMale(Boolean.parseBoolean(reader.readLine()));
				user.setCountry(User.Country.valueOf(reader.readLine().toUpperCase()));
				users.add(user);
			}
			reader.close();
		}
	}
}
