package com.javarush.test.level31.lesson15.big01.command;

import com.javarush.test.level31.lesson15.big01.ConsoleHelper;
import com.javarush.test.level31.lesson15.big01.ZipFileManager;
import com.javarush.test.level31.lesson15.big01.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipAddCommand extends ZipCommand {
	@Override
	public void execute() throws Exception {
		try {
			ConsoleHelper.writeMessage("Добавление файла в архив.");

			ZipFileManager zipFileManager = getZipFileManager();

			ConsoleHelper.writeMessage("Введите полный путь файла, который хотите добавить в архив:");
			Path sourcePath = Paths.get(ConsoleHelper.readString());
			zipFileManager.addFile(sourcePath);

			ConsoleHelper.writeMessage("Добавление файла в архив завершено.");
		}
		catch (PathIsNotFoundException e) {
			ConsoleHelper.writeMessage("Неверный путь к добавляемому файлу.");
		}
	}
}
