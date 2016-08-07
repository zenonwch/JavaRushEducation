package com.javarush.test.level00.lesson07.task02;

/* Обмен
Раскоментируйте некоторые строчки, чтобы программа вывела на экран числа 12 и 2 (сначала 12, а затем 2).
*/
public class Solution
{
    public static void main(String[] args)
    {
        int x = 2;
        int y = 12;

        //x = x * 3;
        y = x + y;
        x = y - x;
        y = y - x;

        System.out.println(x);
        System.out.println(y);
    }
}
