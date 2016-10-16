package com.javarush.test.level31.lesson02.home01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
	public static void main(String[] args) throws IOException {
		if (args.length < 2) return;

		String path = args[0];
		String resultFileAbsolutePath = args[1];
		File allContent = new File(resultFileAbsolutePath);
		List<File> filteredList = getAllFilesLessThan50Bytes(new File(path), allContent);
		Collections.sort(filteredList, new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		FileOutputStream fos = new FileOutputStream(allContent);
		for (File file : filteredList) {
			if (file.equals(allContent)) continue;
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[fis.available()];

			fis.read(buffer);
			fos.write(buffer);

			fos.write("\n".getBytes());
			fis.close();
		}
		fos.flush();
		fos.close();

		allContent.renameTo(new File(allContent.getParent() + "/allFilesContent.txt"));
	}

	public static List<File> getAllFilesLessThan50Bytes(File folder, File resultFile) {
		List<File> selectedFiles = new ArrayList<>();
		Stack<File> stack = new Stack<>();
		stack.push(folder);
		while (!stack.isEmpty()) {
			File child = stack.pop();
			if (child.isDirectory()) {
				if (!child.delete())
					for (File file : child.listFiles()) stack.push(file);
			} else {
				if (child.length() > 50 && !child.equals(resultFile)) child.delete();
				else selectedFiles.add(child);
			}
		}
		return selectedFiles;
	}
}
