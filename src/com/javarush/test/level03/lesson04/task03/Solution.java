package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution {
	public static void main(String[] args) {
		Zerg zerg0 = new Zerg();
		Zerg zerg1 = new Zerg();
		Zerg zerg2 = new Zerg();
		Zerg zerg3 = new Zerg();
		Zerg zerg4 = new Zerg();
		Zerg zerg5 = new Zerg();
		Zerg zerg6 = new Zerg();
		Zerg zerg7 = new Zerg();
		Zerg zerg8 = new Zerg();
		Zerg zerg9 = new Zerg();
		Protos protos0 = new Protos();
		Protos protos1 = new Protos();
		Protos protos2 = new Protos();
		Protos protos3 = new Protos();
		Protos protos4 = new Protos();
		Terran terran00 = new Terran();
		Terran terran01 = new Terran();
		Terran terran02 = new Terran();
		Terran terran03 = new Terran();
		Terran terran04 = new Terran();
		Terran terran05 = new Terran();
		Terran terran06 = new Terran();
		Terran terran07 = new Terran();
		Terran terran08 = new Terran();
		Terran terran09 = new Terran();
		Terran terran10 = new Terran();
		Terran terran11 = new Terran();
		zerg0.name = "z0";
		zerg1.name = "z1";
		zerg2.name = "z2";
		zerg3.name = "z3";
		zerg4.name = "z4";
		zerg5.name = "z5";
		zerg6.name = "z6";
		zerg7.name = "z7";
		zerg8.name = "z8";
		zerg9.name = "z9";
		protos0.name ="p0";
		protos1.name ="p1";
		protos2.name ="p2";
		protos3.name ="p3";
		protos4.name ="p4";
		terran00.name = "t00";
		terran01.name = "t01";
		terran02.name = "t02";
		terran03.name = "t03";
		terran04.name = "t04";
		terran05.name = "t05";
		terran06.name = "t06";
		terran07.name = "t07";
		terran08.name = "t08";
		terran09.name = "t09";
		terran10.name = "t10";
		terran11.name = "t11";
	}

	public static class Zerg {
		public String name;
	}

	public static class Protos {
		public String name;
	}

	public static class Terran {
		public String name;
	}
}