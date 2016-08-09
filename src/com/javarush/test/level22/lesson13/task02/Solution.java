package com.javarush.test.level22.lesson13.task02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251 (кодировка файла UTF-8).
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8 (кодировка файла Windows-1251).
*/
public class Solution {
	static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\tmp_new\\res2.txt");
		FileOutputStream fos = new FileOutputStream("C:\\tmp_new\\res.txt");

		byte[] buffer = new byte[fis.available()];
		while (fis.available() > 0) {
			fis.read(buffer);
		}
		byte[] newBuffer = new String(buffer, Charset.forName("UTF-8")).getBytes(Charset.forName("Windows-1251"));
		fos.write(newBuffer);
		fos.flush();

		fis.close();
		fos.close();
	}
}
