package com.javarush.test.level30.lesson15.big01.client;

import java.util.Random;

public class BotClient extends Client {
	@Override
	protected SocketThread getSocketThread() {
		return new BotSocketThread();
	}

	@Override
	protected boolean shouldSentTextFromConsole() {
		return false;
	}

	@Override
	protected String getUserName() {
		return "date_bot_" + new Random(100);
	}

	public static void main(String[] args) {
		new BotClient().run();
	}

	public class BotSocketThread extends SocketThread {

	}
}
