package com.javarush.test.level02.lesson02.task04;

/* Прибавка к зарплате
Реализуй метод public static void salary(int a).
Метод должен увеличить переданное число на 100 и вывести на экран надпись: «Твоя зарплата составляет: a долларов в месяц.»
Где a - это число, которое увеличили на 100.
Пример вывода на экран для а = 700:
Твоя зарплата составляет: 800 долларов в месяц.
*/
public class Solution
{
    public static void main(String[] args)
    {
        salary(700);
    }

    public static void salary(int a)
    {
        System.out.println("Твоя зарплата составляет: " + (a + 100) + " долларов в месяц.");
    }
}
