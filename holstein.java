/*
TASK: holstein
LANG: JAVA
ID: maheshm2
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class holstein {
    static int V, G;
    static int[] vits;
    static int[][] feeds;
    static String str;

    public static void main(String[] args) throws java.io.IOException {
        String prob = "holstein";
        Scanner input = new Scanner(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new FileWriter(prob + ".out"));
        V = input.nextInt();
        vits = new int[V];
        for (int i = 0; i < V; i++)
            vits[i] = input.nextInt();
        G = input.nextInt();
        feeds = new int[G][V];
        for (int i = 0; i < G; i++)
            for (int j = 0; j < V; j++)
                feeds[i][j] = input.nextInt();
        int[] vit = new int[V];
        dfs(vit, true, 0, "");
        dfs(vit, false, 0, "");
        output.print(countStr(str));
        output.println(str);
        output.close();

    }

    public static void dfs(int[] arr, boolean enable, int index, String x) {
//        System.out.println(index + ":" + Arrays.toString(arr) + ":" + x);
        boolean t = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < vits[i]) {
                t = false;
                break;
            }
        }
        if (t || index == G) {
            if (t && countStr(x) < countStr(str) && countStr(x) != 0) str = x;
            return;
        }
        String newStr = "" + x;
        int[] newarr = Arrays.copyOf(arr, arr.length);
        if (enable) {
            newStr += " " + (index + 1);
            for (int i = 0; i < newarr.length; i++)
                newarr[i] += feeds[index][i];
        }
        dfs(newarr, true, index + 1, newStr);
        dfs(newarr, false, index + 1, newStr);
    }

    public static int countStr(String s) {
        if (s == null || s.length() == 0) return Integer.MAX_VALUE;
        int ret = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                ret++;
            }
        }
        return ret;
    }
}
