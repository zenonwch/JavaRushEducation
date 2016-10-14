package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;

public class Client {
	protected Connection connection;
	private volatile boolean clientConnected = false;

	protected String getServerAddress() {
		ConsoleHelper.writeMessage("Please enter server IP address (xxx.xxx.xxx.xxx or localhost)");
		return ConsoleHelper.readString();
	}

	protected int getServerPort() {
		ConsoleHelper.writeMessage("Please enter port");
		return ConsoleHelper.readInt();
	}

	protected String getUserName() {
		ConsoleHelper.writeMessage("Please enter UserName");
		return ConsoleHelper.readString();
	}

	protected boolean shouldSentTextFromConsole() {
		return true;
	}

	protected SocketThread getSocketThread() {
		return new SocketThread();
	}

	protected void sendTextMessage(String text) {
		try {
			connection.send(new Message(MessageType.TEXT, text));
		}
		catch (IOException e) {
			ConsoleHelper.writeMessage("An exception occurred");
			clientConnected = false;
		}
	}

	public class SocketThread extends Thread {

	}
}
