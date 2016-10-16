package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
	public static void main(String[] args) throws IOException {
		for (String path : getFileTree("c:\\tmp_new\\Test - Copy\\"))
			System.out.println(path);
	}

	public static List<String> getFileTree(String root) throws IOException {
		List<String> filesPaths = new ArrayList<>();
		Queue<File> queue = new LinkedList<>();

		if (root == null) return filesPaths;

		File rootDir = new File(root);
		File[] listFiles = rootDir.listFiles();
		if (rootDir.isDirectory() && listFiles != null && listFiles.length > 0)
			Collections.addAll(queue, listFiles);

		while (!queue.isEmpty()) {
			File file = queue.poll();

			if (file.isDirectory()) {
				File[] sublistFiles = file.listFiles();
				if (sublistFiles != null && sublistFiles.length > 0) Collections.addAll(queue, sublistFiles);
			}
			else filesPaths.add(file.getAbsolutePath());
		}

		return filesPaths;
	}
}
