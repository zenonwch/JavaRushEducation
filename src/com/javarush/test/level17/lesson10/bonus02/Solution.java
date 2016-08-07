package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
	public static List<Person> allPeople = new ArrayList<>();

	static {
		allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
		allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
	}

	public static void main(String[] args) throws ParseException {
		String action = args[0];
		if (action.equals("-c")) {
			Person p = null;
			for (int i = 1, l = args.length; i < l; i += 3) {
				Date bd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i + 2]);
				if (args[i + 1].equals("м")) p = Person.createMale(args[i], bd);
				if (args[i + 1].equals("ж")) p = Person.createFemale(args[i], bd);
				synchronized (Solution.class) {
					allPeople.add(p);
				}
				System.out.print(allPeople.indexOf(p) + " ");
			}
		}

		if (action.equals("-u")) {
			for (int i = 1, l = args.length; i < l; i += 4) {
				Date db = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i + 3]);
				Person p = allPeople.get(Integer.parseInt(args[i]));
				synchronized (Solution.class) {
					p.setName(args[i + 1]);
					if (args[i + 2].equals("м")) p.setSex(Sex.MALE);
					if (args[i + 2].equals("ж")) p.setSex(Sex.FEMALE);
					p.setBirthDay(db);
				}
			}
		}

		if (action.equals("-d")) {
			for (int i = 1, l = args.length; i < l; i++) {
				Person p = allPeople.get(Integer.parseInt(args[i]));
				synchronized (Solution.class) {
					p.setName(null);
					p.setSex(null);
					p.setBirthDay(null);
				}
			}
		}

		if (action.equals("-i")) {
			for (int i = 1, l = args.length; i < l; i++) {
				Person p = allPeople.get(Integer.parseInt(args[i]));
				synchronized (Solution.class) {
					String bd = new SimpleDateFormat("dd-MMM-yyyy").format(p.getBirthDay());
					System.out.println(p.getName() + " " + (p.getSex().equals(Sex.MALE) ? "м" : "ж") + " " + bd);
				}
			}
		}
	}
}
