package com.javarush.test.level31.lesson15.big01;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
	private Path rootPath;
	private List<Path> fileList = new ArrayList<>();

	public FileManager(Path rootPath) throws IOException {
		this.rootPath = rootPath;
		this.collectFileList(rootPath);
	}

	public List<Path> getFileList() {
		return fileList;
	}

	private void collectFileList(Path path) throws IOException {
		if (Files.isRegularFile(path))
			fileList.add(rootPath.relativize(path));
		if (Files.isDirectory(path))
			try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
				for (Path entry : stream)
					collectFileList(entry);
			}
	}
}
