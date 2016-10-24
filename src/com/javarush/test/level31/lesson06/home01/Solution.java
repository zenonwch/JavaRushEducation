package com.javarush.test.level31.lesson06.home01;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
	public static void main(String[] args) throws IOException {
		if (args.length < 2) return;
		Path filePath = Paths.get(args[0]);
		String fileName = filePath.getFileName().toString();
		String zipFile = args[1];

		Map<ZipEntry, byte[]> entryMap = new HashMap<>();

		ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFile));
		ZipEntry entry;
		while ((entry = zipIn.getNextEntry()) != null) {
			byte[] fileContent;

			if (fileName.equals(entry.getName())) {

				FileInputStream fis = new FileInputStream(filePath.toString());
				fileContent = new byte[fis.available()];

				while (fis.available() > 0)
					fis.read(fileContent);

				fis.close();

				entryMap.put(new ZipEntry("new/" + fileName), fileContent);

			} else {
				fileContent = new byte[(int) entry.getSize()];
				zipIn.read(fileContent);
				entryMap.put(entry, fileContent);
			}
			zipIn.closeEntry();
		}
		zipIn.close();

		ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
		for (Map.Entry<ZipEntry, byte[]> pair : entryMap.entrySet()) {
			zipOut.putNextEntry(pair.getKey());
			zipOut.write(pair.getValue());
			zipOut.closeEntry();
		}
		zipOut.close();
	}
}