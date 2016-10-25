package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
	public static void main(String[] args) throws IOException {
		String resultFileName = args[0];
		List<File> parts = new ArrayList<>();
		for (int i = 1, l = args.length; i < l; i++) {
			parts.add(new File(args[i]));
		}

		Collections.sort(parts);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		for (File part : parts) {
			Files.copy(part.toPath(), baos);
		}

		ZipInputStream zipIn = new ZipInputStream(new ByteArrayInputStream(baos.toByteArray()));
		ZipEntry entry = zipIn.getNextEntry();

		FileOutputStream fos = new FileOutputStream(resultFileName);
		if (entry != null) {
			byte[] buffer = new byte[1024]; //size selected for buffer to avoid out of memory
			int len;
			System.out.println(entry.getSize());
			System.out.println((int) entry.getSize());
			while ((len = zipIn.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			fos.flush();
			fos.close();
		}

		zipIn.closeEntry();
		zipIn.close();
		baos.close();
	}
}