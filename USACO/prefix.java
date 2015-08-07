/*
TASK: prefix
LANG: JAVA
ID: maheshm2
 */

import java.io.*;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class prefix {
    static Scanner input;

    public static void main(String[] args) throws java.io.IOException {
        String prob = "prefix";
        input = new Scanner(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new File(prob + ".out"));
        String s = "";
        while(true) {
            String tmp = input.next();
            if(tmp.equals(".")) break;
            s += tmp + " ";
        }
        int plen = s.length() - s.replaceAll(" ", "").length() + 1;
        String[] prefixes = new String[plen];

        int c = 0;
        for (int i = 0; i < prefixes.length; i++) {
            int x = s.indexOf(" ", c);
            prefixes[i] = s.substring(c, x == -1 ? s.length() : x);
            c += (prefixes[i].length() + 1);
        }
        String S = "";
        while(input.hasNext()) S+=input.next();

        boolean dp[] = new boolean[S.length() + 1];
        dp[0] = true;
        for (int i = 0; i < prefixes.length; i++)
            if (S.substring(0, prefixes[i].length()).equals(prefixes[i]))
                dp[prefixes[i].length()] = true;

        for (int i = 0; i < S.length(); i++) {
            if (!dp[i]) continue;
            for (int j = 0; j < prefixes.length; j++) {

                int len = prefixes[j].length();
                if (i + len <= S.length() && S.substring(i, i + len).equals(prefixes[j])) {
                    dp[i + len] = true;
//                    System.out.println(prefixes[j] + " at " );
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i] != false) {
                output.println(i);
                break;
            }
        }
        output.close();
    }
}

