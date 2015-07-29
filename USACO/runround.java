/*
TASK: runround
LANG: JAVA
ID: maheshm2
 */

import java.io.*;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import java.util.Arrays;

public class runround {
    public static void main(String[] args) throws java.io.IOException {
        String prob = "runround";
        StreamTokenizer input = new StreamTokenizer(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new FileWriter(prob + ".out"));
        input.nextToken();
        long a = (long) input.nval + 1;
        String n = Long.toString(a);
        while (!isRun(n)) {
            a++;
            n = Long.toString(a);
        }
        output.println(a);
        output.close();
    }

    public static boolean isUniqueChars(String str) {
        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val])
                return false;
            char_set[val] = true;
        }
        return true;
    }

    public static boolean isRun(String s) {
        if (!isUniqueChars(s)) return false;
        int[] arr = new int[s.length()];
        int x, i = 0;
        while (arr[0] != 2) {
            if (i == 0 && arr[0] > 0) {
                for (int j = 0; j < arr.length; j++)
                    if (arr[j] != 1)
                        return false;
                return true;
            }
            x = s.charAt(i);
            i += (x - 48);
            i %= s.length();
            if (i != 0 && arr[i] > 0)
                return false;
            arr[i]++;
        }
        return true;
    }
}

