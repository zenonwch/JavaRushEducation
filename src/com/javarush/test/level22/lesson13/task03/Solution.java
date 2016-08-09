package com.javarush.test.level22.lesson13.task03;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {

	public static void main(String[] args) {
		System.out.println(checkTelNumber("+380501234567")); //true
		System.out.println(checkTelNumber("+38(050)1234567")); //true
		System.out.println(checkTelNumber("+38(050)123-45-67")); //true
		System.out.println(checkTelNumber("(050)1234567")); //true
		System.out.println(checkTelNumber("0501234567")); //true
		System.out.println(checkTelNumber("+38050123-45-67")); //true
		System.out.println(checkTelNumber("050123-4567")); //true

		System.out.println();
		System.out.println(checkTelNumber("38)050(1234567")); //false
		System.out.println(checkTelNumber("+38(050)1-23-45-6-7")); //false
		System.out.println(checkTelNumber("050ххх4567")); //false
		System.out.println(checkTelNumber("050123456")); //false
		System.out.println(checkTelNumber("+01234567891234")); //false
		System.out.println(checkTelNumber("(0)501234567")); //false
	}

	public static boolean checkTelNumber(String telNumber) {
		if (telNumber == null || telNumber.isEmpty()) return false;
		int length = telNumber.length();
		int countDigits = telNumber.replaceAll("\\D", "").length();
		int indOpen = telNumber.indexOf("(");
		int indClose = telNumber.indexOf(")");
		int indMinus = telNumber.indexOf("-");
		if ((telNumber.charAt(0) == '+') && countDigits != 12) return false;
		if (telNumber.matches("(^\\(|^\\d)\\S+") && countDigits != 10) return false;
		if ((length - telNumber.replaceAll("\\-", "").length()) > 2) return false;
		if ((length - telNumber.replaceAll("\\-{2}", "").length()) > 0) return false;
		if (indOpen != -1 && (length - telNumber.replaceAll("\\(", "").length()) != 1) return false;
		if (indClose != -1 && (length - telNumber.replaceAll("\\)", "").length()) != 1) return false;
		if (indOpen != -1 && indClose != -1 && indClose - indOpen != 4) return false;
		if (indClose != -1 && indMinus != -1 && indMinus < indClose) return false;
		if (!telNumber.matches("\\S+\\d$")) return false;
		try {
			Long.parseLong(telNumber.replaceAll("[\\(,\\),\\+\\-]", ""));
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}