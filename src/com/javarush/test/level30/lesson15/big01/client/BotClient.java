package com.javarush.test.level30.lesson15.big01.client;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
		return "date_bot_" + new Random().nextInt(100);
	}

	public static void main(String[] args) {
		new BotClient().run();
	}

	public class BotSocketThread extends SocketThread {
		@Override
		protected void clientMainLoop() throws IOException, ClassNotFoundException {
			sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
			super.clientMainLoop();
		}

		@Override
		protected void processIncomingMessage(String message) {
			super.processIncomingMessage(message);
			if (message.split(": ").length > 1) {
				SimpleDateFormat sdp;
				switch (message.split(": ")[1]) {
					case "дата":
						sdp = new SimpleDateFormat("d.MM.YYYY");
						break;
					case "день":
						sdp = new SimpleDateFormat("d");
						break;
					case "месяц":
						sdp = new SimpleDateFormat("MMMM");
						break;
					case "год":
						sdp = new SimpleDateFormat("YYYY");
						break;
					case "время":
						sdp = new SimpleDateFormat("H:mm:ss");
						break;
					case "час":
						sdp = new SimpleDateFormat("H");
						break;
					case "минуты":
						sdp = new SimpleDateFormat("m");
						break;
					case "секунды":
						sdp = new SimpleDateFormat("s");
						break;
					default:
						sdp = null;
						break;
				}
				if (sdp != null)
				sendTextMessage("Информация для " + message.split(":")[0] + ": " + sdp.format(Calendar.getInstance().getTime()));
			}
		}
	}
}
