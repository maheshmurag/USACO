/*
TASK: pprime
LANG: JAVA
ID: maheshm2
 */

import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.lang.Integer;
import java.lang.System;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class pprime {
    static PrintWriter pw;
    public static void main(String[] args) throws java.io.IOException {
        StreamTokenizer input =new StreamTokenizer(new BufferedReader(new FileReader("pprime.in")));
        pw=new PrintWriter(new FileWriter("pprime.out"));
        input.nextToken();
        int small = (int)input.nval;
        input.nextToken();
        int big = (int)input.nval;

        int palindrome;
        String str = "";
        int k1 = ("" + small).length();
        int k2 = ("" + big).length();
        for (int i = k1; i <= k2; i++) {
            switch (i) {
                case 1:
                    one(small, big);
                    break;
                case 2:
                    two(small, big);
                    break;
                case 3:
                    three(small, big);
                    break;
                case 4:
                    four(small, big);
                    break;
                case 5:
                    five(small, big);
                    break;
                case 6:
                    six(small, big);
                    break;
                case 7:
                    seven(small, big);
                    break;
                case 8:
                    eight(small, big);
                    break;
            }
        }

        pw.close();
//        output.close();

    }

    public static void one(int small, int big) {
        int palindrome = 0;
        for (int d1 = 5; d1 <= 9; d1 += 2) {
            palindrome = d1;
            if (palindrome <= big && palindrome >= small) {
                if (isPrime(palindrome))
                    pw.println(palindrome); 
            }
        }
    }

    public static void two(int small, int big) {
        //2
        int palindrome = 0;
        for (int d1 = 1; d1 <= 9; d1 += 2) {
            palindrome = 10 * d1 + d1;
            if (palindrome <= big && palindrome >= small) {
                if (isPrime(palindrome))
                    pw.println(palindrome); 
            }
        }
    }

    public static void three(int small, int big) {
        //3
        int palindrome = 0;
        for (int d1 = 1; d1 <= 9; d1 += 2) {
            for (int d2 = 0; d2 <= 9; d2++) {
                palindrome = 100 * d1 + 10 * d2 + d1;
                if (palindrome <= big && palindrome >= small) {
                    if (isPrime(palindrome))
                        pw.println(palindrome); 
                }
            }
        }
    }

    public static void four(int small, int big) {
        //4
        int palindrome = 0;
        for (int d1 = 1; d1 <= 9; d1 += 2) {
            for (int d2 = 0; d2 <= 9; d2++) {
                palindrome = 1000 * d1 + 100 * d2 + 10 * d2 + d1;
                if (palindrome <= big && palindrome >= small) {
                    if (isPrime(palindrome))
                        pw.println(palindrome); 
                }
            }
        }
    }

    public static void five(int small, int big) {
        //5
        int palindrome = 0;
        for (int d1 = 1; d1 <= 9; d1 += 2) {
            for (int d2 = 0; d2 <= 9; d2++) {
                for (int d3 = 0; d3 <= 9; d3++) {
                    palindrome = 10000 * d1 + 1000 * d2 + 100 * d3 + 10 * d2 + d1;
                    if (palindrome <= big && palindrome >= small)
                        if (isPrime(palindrome))
                            pw.println(palindrome); 
                }
            }
        }
    }

    public static void six(int small, int big) {
        //6
        int palindrome = 0;
        for (int d1 = 1; d1 <= 9; d1 += 2) {
            for (int d2 = 0; d2 <= 9; d2++) {
                for (int d3 = 0; d3 <= 9; d3++) {
                    palindrome = 100000 * d1 + 10000 * d2 + 1000 * d3 + 100 * d3 + 10 * d2 + d1;
                    if (palindrome <= big && palindrome >= small)
                        if (isPrime(palindrome))
                            pw.println(palindrome); 
                }
            }
        }
    }

    public static void seven(int small, int big) {
        //7
        int palindrome = 0;
        for (int d1 = 1; d1 <= 9; d1 += 2) {
            for (int d2 = 0; d2 <= 9; d2++) {
                for (int d3 = 0; d3 <= 9; d3++) {
                    for (int d4 = 0; d4 <= 9; d4++) {
                        palindrome = 1000000 * d1 + 100000 * d2 + 10000 * d3 + 1000 * d4 + 100 * d3 + 10 * d2 + d1;
                        if (palindrome <= big && palindrome >= small)
                            if (isPrime(palindrome))
                                pw.println(palindrome); 
                    }
                }
            }
        }
    }

    public static void eight(int small, int big) {
        //8
        int palindrome = 0;
        for (int d1 = 1; d1 <= 9; d1 += 2) {
            for (int d2 = 0; d2 <= 9; d2++) {
                for (int d3 = 0; d3 <= 9; d3++) {
                    for (int d4 = 0; d4 <= 9; d4++) {
                        palindrome = 10000000 * d1 + 1000000 * d2 + 100000 * d3 + 10000 * d4 + 1000 * d4 + 100 * d3 + 10 * d2 + d1;
                        if (palindrome <= big && palindrome >= small)
                            if (isPrime(palindrome))
                                pw.println(palindrome); 
                    }
                }
            }
        }
    }

    public static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        long sqrtN = (long) Math.sqrt(n) + 1;
        for (long i = 6L; i <= sqrtN; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) return false;
        }
        return true;
    }


}
