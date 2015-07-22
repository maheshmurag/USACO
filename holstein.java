/*
TASK: holstein
LANG: JAVA
ID: maheshm2
 */

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class holstein {
    static int V, G;
    static int[] vits;
    static int[][] feeds;

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
//        int counter = Math.max(dfs(vit, true, 0, 1), dfs(vit, false, 0, 0));
        System.out.println(dfs(vit, true, 0, 1));
        System.out.println(dfs(vit, false, 0, 1));
        output.println();
        output.close();

    }

    public static intb dfs(int[] arr, boolean enable, int index, int count) {
        boolean t = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < vits[i]) {
                t = false;
                break;
            }
        }
        if (t) {
            System.out.println(Arrays.toString(arr));
            return 0;
        }
        if(index==G)
            return 0;
        int[] newarr = Arrays.copyOf(arr, arr.length);
        if (enable)
            for (int i = 0; i < arr.length; i++)
                newarr[i] += feeds[index][i];
//        System.out.println("dfs with: " + Arrays.toString(arr) + ". newarr:" + Arrays.toString(newarr) + ":" + enable + ":" + index + ":" + count);
        return count+Math.min(dfs(newarr, true, index+1, (enable?1:0)), dfs(newarr, false, index+1, (enable?1:0)));

    }

    static class Vitamin {
        int[] vit;
    }

    public static void printFArr() {
        for (int i = 0; i < feeds.length; i++) {
            for (int j = 0; j < feeds[i].length; j++)
                System.out.print(feeds[i][j] + " ");
            System.out.println();
        }
    }

    public static void printVArr() {
        for (int i = 0; i < vits.length; i++)
            System.out.print(vits[i] + " ");
    }

}
