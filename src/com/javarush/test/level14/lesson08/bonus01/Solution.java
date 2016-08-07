package com.javarush.test.level14.lesson08.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution {
	public static List<Exception> exceptions = new ArrayList<>();

	public static void main(String[] args) {
		initExceptions();

		for (Exception exception : exceptions) {
			System.out.println(exception);
		}
	}

	private static void initExceptions() {   //it's first exception
		try {float i = 1 / 0;}
		catch (ArithmeticException e) {exceptions.add(e);}
		try {int[] a = {1, 2}; int b = a[2];}
		catch (ArrayIndexOutOfBoundsException e) {exceptions.add(e);}
		try {int[] a = new int[-4];}
		catch (NegativeArraySizeException e) {exceptions.add(e);}
		try {Object[] a = new String[5]; a[1] = Integer.valueOf(6);}
		catch (ArrayStoreException e) {exceptions.add(e);}
		try {int a = Integer.parseInt("s");}
		catch (NumberFormatException e) {exceptions.add(e);}
		try {List<String> list = null; list.add("s");}
		catch (NullPointerException e) {exceptions.add(e);}
		try {Object ch = new Character('*'); byte b = (byte) ch;}
		catch (ClassCastException e) {exceptions.add(e);}
		try {char ch = "123".charAt(5);}
		catch (StringIndexOutOfBoundsException e) {exceptions.add(e);}
		try {String fieldValue =String.valueOf(exceptions.getClass().getField("i"));}
		catch (NoSuchFieldException e) {exceptions.add(e);}
		try {	InputStream is = new FileInputStream("test.txt");}
		catch (FileNotFoundException e) {exceptions.add(e);}
	}
}
