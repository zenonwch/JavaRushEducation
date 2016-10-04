package com.javarush.test.level29.lesson15.big01.human;

import java.util.List;

public class University {
	private String name;
	private int age;
	private List<Student> students;

	public University(String name, int age) {
		this.name = name;
		this.age = age;
		this.students = StudentsDataBase.students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student getStudentWithAverageGrade(double averageGrade) {
		Student student = null;

		for (Student s : students)
			if (s.getAverageGrade() == averageGrade) {
				student = s;
				break;
			}

		return student;
	}

	public Student getStudentWithMaxAverageGrade() {
		Student student = null;
		double maxAverageGrade = Double.MIN_VALUE;

		for (Student s : students)
			if (s.getAverageGrade() > maxAverageGrade) {
				maxAverageGrade = s.getAverageGrade();
				student = s;
			}

		return student;
	}

	public Student getStudentWithMinAverageGrade() {
		Student student = null;
		double minAverageGrade = Double.MAX_VALUE;

		for (Student s : students)
			if (s.getAverageGrade() < minAverageGrade) {
				minAverageGrade = s.getAverageGrade();
				student = s;
			}

		return student;
	}

	public void expel(Student student) {
		students.remove(student);
	}
}
