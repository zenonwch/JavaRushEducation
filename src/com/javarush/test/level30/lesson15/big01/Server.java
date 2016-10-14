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

			while (true) {
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

		private void sendListOfUsers(Connection connection, String userName) throws IOException {
			for (Map.Entry<String, Connection> pair : connectionMap.entrySet())
				if (!pair.getKey().equals(userName))
					connection.send(new Message(MessageType.USER_ADDED, pair.getKey()));
		}

		private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
			while (true) {
				Message message = connection.receive();
				if (message.getType() == MessageType.TEXT)
					sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
				else ConsoleHelper.writeMessage("Received message is not of type TEXT.");
			}
		}

		public void run() {
			ConsoleHelper.writeMessage("New connection established with " + socket.getRemoteSocketAddress());
			String userName = null;
			try (Connection connection = new Connection(socket)) {
				userName = serverHandshake(connection);
				sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
				sendListOfUsers(connection, userName);
				serverMainLoop(connection, userName);
			}
			catch (IOException | ClassNotFoundException e) {
				ConsoleHelper.writeMessage("Communication error");
			}
			if (userName != null) {
				connectionMap.remove(userName);
				sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
			}
			ConsoleHelper.writeMessage("Connection to the " + socket.getRemoteSocketAddress() + " was closed");
		}
	}
}