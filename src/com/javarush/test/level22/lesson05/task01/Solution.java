package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {

	public static void main(String[] args) throws Exception {
//		String s = "JavaRush - лучший сервис обучения Java.";
//		String s = null;
//		String s = "    k"; //вывод k (4 пробела)
//		String s = "JavaRush — лучший сервисобученияJava . ."; //ексепшен
//		String s = "    "; //exception (4 пробела)
//		String s = "     "; //exception(5 пробелов)
//		String s = "     6"; //exception(5 пробелов и число)
//		String s = "    ."; //exception(4 пробела)
		String s = "    5"; //exception(4 пробела и число)
		String subS = getPartOfString(s);
		System.out.println(subS);
	}

	public static String getPartOfString(String string) throws TooShortStringException {
		if (string == null) throw new TooShortStringException();
		String[] arr = string.split(" ");
		if (arr.length < 5 || arr[4].equals("") || !Character.isLetter(arr[4].charAt(0))) throw new TooShortStringException();
		String res = arr[1];
		for (int i = 2; i < 5; i++) {
			res += " " + arr[i];
		}
		return res;
	}

	public static class TooShortStringException extends Exception {

		public TooShortStringException() {}

		public TooShortStringException(String message) {
			super(message);
		}
	}
}
