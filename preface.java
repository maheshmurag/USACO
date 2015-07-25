/*
TASK: preface
LANG: JAVA
ID: maheshm2
 */

import java.io.*;
import java.util.Arrays;

public class preface {
    static int[] out;

    public static void main(String[] args) throws java.io.IOException {
        String prob = "preface";
        StreamTokenizer input = new StreamTokenizer(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new FileWriter(prob + ".out"));
        input.nextToken();
        int n = (int) input.nval;
        out = new int[7];
        for (int i = 0; i <= n; i++)
            generate(i);
        String str = "";
        for (int i = 0; i < out.length; i++) {
            if (out[i] != 0) {
                switch (i) {
                    case 0:
                        str += ("I ");
                        break;
                    case 1:
                        str += ("V ");
                        break;
                    case 2:
                        str += ("X ");
                        break;
                    case 3:
                        str += ("L ");
                        break;
                    case 4:
                        str += ("C ");
                        break;
                    case 5:
                        str += ("D ");
                        break;
                    case 6:
                        str += ("M ");
                        break;
                }
                str += (out[i]) + "\n";
            }
        }
        output.println(str.trim());
        output.close();
    }

    static void add(int x) {
        int o = 0;
        if (x >= 10 && x < 100) o = 2;
        else if (x >= 100 && x < 1000) o = 4;
        else if (x >= 1000) o = 6;
        int p = x, num = 0;
        while (p > 9) {
            p /= 10;
            num++;
        }
        x /= Math.pow(10, num);
        switch (x) {//I=0,V=1,X=2,L=3,C=4,L=5,M=6
            case 1:
                out[0 + o]++;
                break;
            case 2:
                out[0 + o] += 2;
                break;
            case 3:
                out[0 + o] += 3;
                break;
            case 4:
                out[0 + o]++;
                out[1 + o]++;
                break;
            case 5:
                out[1 + o]++;
                break;
            case 6:
                out[0 + o]++;
                out[1 + o]++;
                break;
            case 7:
                out[0 + o] += 2;
                out[1 + o]++;
                break;
            case 8:
                out[1 + o]++;
                out[0 + o] += 3;
                break;
            case 9:
                out[2 + o]++;
                out[0 + o]++;
                break;
        }
    }

    static void generate(int n) {
        String a = "";
        int i = n, times = 1;
        while (i >= 1) {
            add((i % 10) * times);
            i /= 10;
            times *= 10;
        }
    }
}

