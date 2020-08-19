package com.myDomain;

import java.util.Scanner;

public class StringReverse {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char[] charArr = str.toCharArray();

        for(int head = 0, tail = str.length() - 1; head < tail; head++,tail--){
            char temp = charArr[head];
            charArr[head] = charArr[tail];
            charArr[tail] = temp;
        }

        String output = new String(charArr);
        System.out.println(output);

    }
}
