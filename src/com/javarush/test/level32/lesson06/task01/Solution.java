package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream password = getPassword();
		System.out.println(password.toString());
	}

	public static ByteArrayOutputStream getPassword() throws IOException {
		char[] numbers = "0123456789".toCharArray();
		char[] lowerCase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		char[] upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		List<Character> result = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			int idx = new Random().nextInt(lowerCase.length);
			result.add(lowerCase[idx]);
		}
		for (int i = 4; i < 6; i++) {
			int idx = new Random().nextInt(upperCase.length);
			result.add(upperCase[idx]);
		}
		for (int i = 6; i < 8; i++) {
			int idx = new Random().nextInt(numbers.length);
			result.add(numbers[idx]);
		}
		Collections.shuffle(result);

		StringBuilder sb = new StringBuilder();
		for (char ch : result)
		sb.append(ch);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos.write(sb.toString().getBytes());
		return baos;
	}
}
