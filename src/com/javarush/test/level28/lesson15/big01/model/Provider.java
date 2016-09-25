package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

public class Provider {
	private Strategy strategy;

	public Provider(Strategy strategy) {
		this.strategy = strategy;
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public List<Vacancy> getJavaVacancies(String searchString) {
		return null;
	}
}
