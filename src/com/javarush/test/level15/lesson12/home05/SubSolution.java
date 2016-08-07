package com.javarush.test.level15.lesson12.home05;

public class SubSolution extends Solution {
	public SubSolution(int a) {
		super(a);
	}

	public SubSolution(String s) {
		super(s);
	}

	public SubSolution(boolean b) {
		super(b);
	}

	protected SubSolution(int a, int b) {
		super(a, b);
	}

	protected SubSolution(String s, String ss) {
		super(s, ss);
	}

	protected SubSolution(boolean t, boolean f) {
		super(t, f);
	}

	SubSolution(int a, String s) {
		super(a, s);
	}

	SubSolution(String s, int a) {
		super(s, a);
	}

	SubSolution(boolean b, int a) {
		super(b, a);
	}

	private SubSolution(int a, int b, int c) {
		super(a);
	}
	private SubSolution(String s, String ss, String sss) {
		super(s);
	}
	private SubSolution(boolean t, boolean f, boolean b) {
		super(b);
	}
}
