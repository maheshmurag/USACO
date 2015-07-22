/*
TASK: holstein
LANG: JAVA
ID: maheshm2
 */

import java.io.*;
import java.lang.Integer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        ArrayList<Integer> ret1a = dfs(vit, true, 0, new ArrayList<>());
        ArrayList<Integer> ret2a = dfs(vit, false, 0, new ArrayList<>());
        Integer[] ret1 = new Integer[ret1a.size()];
        Integer[] ret2 = new Integer[ret2a.size()];
        ret1a.toArray(ret1);
        ret2a.toArray(ret2);

//        System.out.println("answer:  " + Arrays.toString(dfs(vit, true, 0, new ArrayList<>()).toArray()));
//        System.out.println("answer:  " + Arrays.toString(dfs(vit, false, 0, new ArrayList<>()).toArray()));
        Integer[] out = ret1.length < ret2.length ? ret1 : ret2;
        System.out.print(out.length + " ");
        for (int i = 0; i < out.length; i++) System.out.print((out[i]+1) + " ");
        System.out.println();
        output.println();
        output.close();

    }

    public static ArrayList<Integer> dfs(int[] arr, boolean enable, int index, ArrayList<Integer> x) {
        System.out.println(index+":"+Arrays.toString(arr)+":"+Arrays.toString(x.toArray()));
        boolean t = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < vits[i]) {
                t = false;
                break;
            }
        }
        if (t || index == G) {
//            if (t)
//                System.out.println("printing at 55: " + Arrays.toString(arr) + " with x: " + Arrays.toString(x.toArray()));
//            if (index == G) System.out.println("printing at 56: met limit before getting to fill vitamins");
            return x;
        }
        int[] newarr = Arrays.copyOf(arr, arr.length);
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = 0; i < x.size(); i++)
            newList.add(x.get(i).intValue());

        if (enable) {
            newList.add(index);
            for (int i = 0; i < arr.length; i++)
                newarr[i] += feeds[index][i];
        }
//        System.out.println("dfs with: " + Arrays.toString(arr) + ". newarr:" + Arrays.toString(newarr) + ":" + enable + ":" + index + ":" + Arrays.toString(x.toArray()));
        ArrayList<Integer> o = dfs(newarr, true, index + 1, newList);
        ArrayList<Integer> p = dfs(newarr, false, index + 1, newList);

        if (o.size() == 0) {
            if (p.size() == 0)
                System.out.print("");
//                System.out.println("this is retarded: both are 0");
            else return p;
        } else if (p.size() == 0) {
            if (o.size() == 0)
                System.out.print("");
//                System.out.println("this is retarded: both are 0");
            else return o;
        }
//        System.out.println("pring at 84: " + Arrays.toString(o.toArray()) + ":" + Arrays.toString(p.toArray()));
        return (o.size() < p.size() ? o : p);

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
