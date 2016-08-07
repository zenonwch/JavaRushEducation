package com.javarush.test.level01.lesson08.task01;

import java.lang.String;

/* Nothing personal, it's just business.
Переставьте строки так, чтобы получился текст "Nothing personal, it's just business."
*/
public class Solution
{
    public static void main(String[] args)
    {
        String s = "Nothing";
        s = s + " ";
        s = s + "personal";
        s = s + ",";
        s = s + " ";
        s = s + "it's";
        s = s + " ";
        s = s + "just";
        s = s + " ";
        s = s + "business";
        s = s + ".";

        System.out.println(s);
    }
}
