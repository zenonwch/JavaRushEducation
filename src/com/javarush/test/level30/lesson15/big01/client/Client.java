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

	public void run() {
		SocketThread socketThread = getSocketThread();
		socketThread.setDaemon(true);
		socketThread.start();
		try {
			synchronized (this) {
				this.wait();
			}
		}
		catch (InterruptedException e) {
			ConsoleHelper.writeMessage("An exception occurred");
			return;
		}
		if (clientConnected) ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
		else ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
		while (clientConnected) {
			String text = ConsoleHelper.readString();
			if (text.equals("exit")) return;
			if (shouldSentTextFromConsole()) sendTextMessage(text);
		}
	}

	public static void main(String[] args) {
		new Client().run();
	}

	public class SocketThread extends Thread {
		protected void processIncomingMessage(String message) {
			ConsoleHelper.writeMessage(message);
		}

		protected void informAboutAddingNewUser(String userName) {
			ConsoleHelper.writeMessage(userName + " has joined the chat.");
		}

		protected void informAboutDeletingNewUser(String userName) {
			ConsoleHelper.writeMessage(userName + " has left the chat.");
		}

		protected void notifyConnectionStatusChanged(boolean clientConnected) {
			Client.this.clientConnected = clientConnected;
			synchronized (Client.this) {
				Client.this.notify();
			}
		}

		protected void clientHandshake() throws IOException, ClassNotFoundException {
			while (true) {
				Message message = Client.this.connection.receive();
				if (message.getType() == MessageType.NAME_REQUEST)
					connection.send(new Message(MessageType.USER_NAME, getUserName()));
				else if (message.getType() == MessageType.NAME_ACCEPTED) {
					notifyConnectionStatusChanged(true);
					break;
				}
				else throw new IOException("Unexpected MessageType");
			}
		}

		protected void clientMainLoop() throws IOException, ClassNotFoundException {
			while (!Thread.currentThread().isInterrupted()) {
				Message message = connection.receive();
				if (message.getType() == MessageType.TEXT)
					processIncomingMessage(message.getData());
				else if (message.getType() == MessageType.USER_ADDED)
					informAboutAddingNewUser(message.getData());
				else if (message.getType() == MessageType.USER_REMOVED)
					informAboutDeletingNewUser(message.getData());
				else throw new IOException("Unexpected MessageType");
			}
		}
	}
}
