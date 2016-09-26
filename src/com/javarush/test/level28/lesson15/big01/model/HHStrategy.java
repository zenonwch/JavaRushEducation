package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class HHStrategy implements Strategy {
	private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
	private static final String userAgent = "Mozilla/5.0 (jsoup)";
	private static final int timeout = 5 * 1000;

	@Override
	public List<Vacancy> getVacancies(String searchString) {
		Document doc;
		try {
			doc = Jsoup.connect(String.format(URL_FORMAT, searchString, 1)).userAgent(userAgent).timeout(timeout).get();
		}
		catch (IOException ignored) {}
		return null;
	}
}
