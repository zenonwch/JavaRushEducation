package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
	private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

	public static void sendBroadcastMessage(Message message) {
		try {
			for (Map.Entry<String, Connection> pair : connectionMap.entrySet())
				pair.getValue().send(message);
		}
		catch (IOException e) {
			ConsoleHelper.writeMessage("Message was not sent!");
		}
	}

	public static void main(String[] args) {
		ConsoleHelper.writeMessage("Please enter port number.");
		int port = ConsoleHelper.readInt();

		try (ServerSocket serverSocket = new ServerSocket(port)) {
			ConsoleHelper.writeMessage("Server is running...");
			while (true) {
				Socket socket = serverSocket.accept();
				Handler handler = new Handler(socket);
				handler.start();
			}
		}
		catch (Exception e) {
			ConsoleHelper.writeMessage(e.getMessage());
		}
	}


	private static class Handler extends Thread {
		private Socket socket;

		public Handler(Socket socket) {
			this.socket = socket;
		}

		private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
			String userName;

			while(true) {
				connection.send(new Message(MessageType.NAME_REQUEST));
				Message message = connection.receive();

				if (message.getType() == MessageType.USER_NAME) {
					userName = message.getData();

					if (userName != null && !userName.isEmpty() && !connectionMap.containsKey(userName)) {
						connectionMap.put(userName, connection);
						connection.send(new Message(MessageType.NAME_ACCEPTED));
						break;
					}

				}

			}

			return userName;
		}
	}
}