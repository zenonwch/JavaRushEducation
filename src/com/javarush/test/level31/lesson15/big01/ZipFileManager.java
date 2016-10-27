package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.exception.PathIsNotFoundException;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
	private Path zipFile;

	public ZipFileManager(Path zipFile) {
		this.zipFile = zipFile;
	}

	public void createZip(Path source) throws Exception {
		if (!Files.exists(zipFile.getParent()))
			Files.createDirectories(zipFile.getParent());

		try (ZipOutputStream zipOut = new ZipOutputStream(Files.newOutputStream(zipFile))) {

			if (Files.isRegularFile(source))
				addNewZipEntry(zipOut, source.getParent(), source.getFileName());
			else if (Files.isDirectory(source)) {
				List<Path> fileNames = new FileManager(source).getFileList();

				for (Path fileName : fileNames)
					addNewZipEntry(zipOut, source, fileName);
			} else throw new PathIsNotFoundException();
		}
	}

	private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
		try (InputStream is = Files.newInputStream(filePath.resolve(fileName))) {
			ZipEntry entry = new ZipEntry(fileName.toString());
			zipOutputStream.putNextEntry(entry);

			copyData(is, zipOutputStream);

			zipOutputStream.closeEntry();
		}
	}

	private void copyData(InputStream in, OutputStream out) throws Exception {
		int len;
		byte[] buffer = new byte[2048];

		while ((len = in.read(buffer)) > 0)
			out.write(buffer, 0, len);
	}
}
