package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.exception.WrongZipFileException;

import java.io.IOException;

public class Archiver {
	public static Operation askOperation() throws IOException {
		ConsoleHelper.writeMessage("Выберите операцию:\n" +
				"\t " + Operation.CREATE.ordinal() + " - упаковать файлы в архив\n" +
				"\t " + Operation.ADD.ordinal() + " - добавить файл в архив\n" +
				"\t " + Operation.REMOVE.ordinal() + " - удалить файл из архива\n" +
				"\t " + Operation.EXTRACT.ordinal() + " - распаковать архив\n" +
				"\t " + Operation.CONTENT.ordinal() + " - просмотреть содержимое архива\n" +
				"\t " + Operation.EXIT.ordinal() + " - выход");
		return Operation.values()[ConsoleHelper.readInt()];
	}

	public static void main(String[] args) {
		Operation operation = null;

		while (operation != Operation.EXIT) {
			try {
				operation = askOperation();
				CommandExecutor.execute(operation);
			}
			catch (WrongZipFileException ignored) {
				ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
			}
			catch (Exception ignored) {
				ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
			}
		}
	}
}
