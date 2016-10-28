package com.javarush.test.level31.lesson15.big01.command;

import com.javarush.test.level31.lesson15.big01.ConsoleHelper;
import com.javarush.test.level31.lesson15.big01.ZipFileManager;
import com.javarush.test.level31.lesson15.big01.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand {
	@Override
	public void execute() throws Exception {
		try {
			ConsoleHelper.writeMessage("Распаковывание архива.");

			ZipFileManager zipFileManager = getZipFileManager();

			ConsoleHelper.writeMessage("Введите полное имя директории для разархивации:");
			Path outputFolder = Paths.get(ConsoleHelper.readString());
			zipFileManager.extractAll(outputFolder);

			ConsoleHelper.writeMessage("Архив распакован.");
		}
		catch (PathIsNotFoundException e) {
			ConsoleHelper.writeMessage("Вы неверно указали имя директории.");
		}
	}
}
