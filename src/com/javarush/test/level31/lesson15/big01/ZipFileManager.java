package com.javarush.test.level31.lesson15.big01;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
	private Path zipFile;

	public ZipFileManager(Path zipFile) {
		this.zipFile = zipFile;
	}

	public void createZip(Path source) throws Exception {
		try (ZipOutputStream zipOut = new ZipOutputStream(Files.newOutputStream(zipFile))) {
			ZipEntry entry = new ZipEntry(source.getFileName().toString());
			zipOut.putNextEntry(entry);
			try (InputStream is = Files.newInputStream(source)) {
				byte[] buffer = new byte[2048];
				int size;
				while ((size = is.read(buffer)) > 0)
					zipOut.write(buffer, 0, size);
			}
			zipOut.closeEntry();
		}
	}
}
