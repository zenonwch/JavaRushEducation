package com.javarush.test.level01.lesson04.task02;

import java.lang.String;

/* JavaRush. Learn once - use anywhere
Напиши программу, которая выводит на экран надпись: «JavaRush. Learn once - use anywhere» 10 раз.
*/
public class Solution
{
    public static void main(String[] args)
    {
        String text = "JavaRush. Learn once - use anywhere";
        print5Times(text);
        print5Times(text);
    }


    public static void print5Times(String s)
    {
        System.out.println(s);
        System.out.println(s);
        System.out.println(s);
        System.out.println(s);
        System.out.println(s);
    }
}
