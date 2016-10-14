package com.javarush.test.level30.lesson15.big01;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
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
			System.out.println(e.getMessage());
		}
	}


	private static class Handler extends Thread {
		private Socket socket;

		public Handler(Socket socket) {
			this.socket = socket;
		}
	}
}