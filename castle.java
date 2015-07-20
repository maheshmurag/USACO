/*
TASK: castle
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
import java.util.Arrays;

public class castle {
    static int M, N;
    static int[][] arr;
    static int[][] comps;
    static int[] cmps;
    static boolean[][] visited;
    static int highestcomp = 0;
    static int c = 1;
    static int maxcomp = 0;
    static int maxcompx = 0;
    static int maxcompy = 0;
    static int maxcompdir = Integer.MAX_VALUE;
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static String[] dirstr = {"N", "E", "S", "W"};

    //                      N       E         S        W
    public static void main(String[] args) throws java.io.IOException {
        String prob = "castle";
        StreamTokenizer input = new StreamTokenizer(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new FileWriter(prob + ".out"));
        input.nextToken();
        M = (int) input.nval;
        input.nextToken();
        N = (int) input.nval;
        arr = new int[N][M];
        comps = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                input.nextToken();
                arr[i][j] = (int) input.nval;
            }
        }
        cmps = new int[2501];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (comps[i][j] == 0) {
                    int tmp = dfs(i, j, c);
                    if (tmp != 0)
                        c++;
                    else
                        comps[i][j] = c + 1;

                }
                cmps[comps[i][j]]++;
            }
        }

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                dfs(i, j, comps[i][j]);
//            }
//        }
        for (int i = 0; i<arr.length; i++) {
            for (int j = arr[0].length-1; j >= 0; j--) {
                dfs(i, j, comps[i][j]);
            }
        }
        Arrays.sort(cmps);

//        printArr(comps);
//        System.out.println(c);
//        System.out.println(cmps[cmps.length - 1]);
//        System.out.println(maxcomp);
//        System.out.println(maxcompx + " " + maxcompy + " " + dirstr[maxcompdir]);

        output.println(c);
        output.println(cmps[cmps.length - 1]);
        output.println(maxcomp);
        output.println(maxcompx + " " + maxcompy + " " + dirstr[maxcompdir]);


        output.close();
    }

    public static int dfs(int i, int j, int comp) {
        int tmpx, tmpy, count = 0;
        for (int x = 0; x < dirs.length; x++) {
            tmpx = i + dirs[x][0];
            tmpy = j + dirs[x][1];
            if (withinBounds(tmpx, tmpy)) {
                if (!a(arr[i][j], x) && comps[tmpx][tmpy] == 0) {
//                System.out.println("found friend: from (" + (i + 1) + "," + (j + 1) + ") in dir " + dirstr[x] + " to (" + (tmpx + 1) + "," + (tmpy + 1) + ") for comp " + comp);
                    count++;
                    comps[tmpx][tmpy] = comp;
                    dfs(tmpx, tmpy, comp);
                } else if (a(arr[i][j], x)) {
                    boolean b = true;
                    if (comps[tmpx][tmpy] != comps[i][j] && (cmps[comps[tmpx][tmpy]] + cmps[comp] >= maxcomp)) {
//                        if ((cmps[comps[tmpx][tmpy]] + cmps[comp] == maxcomp)) {
//                            if (!(tmpx < maxcompx)) {
//                                b = false;
//                            } else if (!(tmpx == maxcompx && tmpy > maxcompy)) {
//                                b = false;
//                            }
//                        }
//                        if(b) {
//                            maxcomp = cmps[comps[tmpx][tmpy]] + cmps[comp];
//                            maxcompx = tmpx;
//                            maxcompy = tmpy;
//                            maxcompdir = x;
//                        }
                        maxcomp = cmps[comps[tmpx][tmpy]] + cmps[comp];
                        maxcompx = i+1;
                        maxcompy = j+1;
                        maxcompdir = x;
                    }
                }
            }

        }
        return count;
//        if (count == 0) {
//            for (int x = 0; x < dirs.length; x++) {
//                tmpx = i + dirs[x][0];
//                tmpy = j + dirs[x][1];
//                if (withinBounds(tmpx, tmpy) && comps[tmpx][tmpy] == 0 && a(arr[i][j], x)) {
//                    System.out.println(i+":"+j+":"+tmpx+":"+tmpy+":"+arr[i][j]+":"+x+":"+comp+":"+a(arr[i][j], x));
//                    System.out.println(comps[0][1]);
//                    System.out.println("found break: from (" +(i+1)+ "," + (j+1) + ") in dir " + dirstr[x] + " to (" +(tmpx+1)+ "," + (tmpy+1) + ") for new comp " + (comp+1));
//                    dfs(tmpx, tmpy, highestcomp + 1);
//
//                }
//            }
//        }
    }

    public static boolean withinBounds(int x, int y) {
        return ((x < N && x >= 0) && (y < M && y >= 0));
    }


    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static boolean a(int n, int d) {
        switch (d) {
            case 0:
                return (n == 2 || n == 3 || n == 6 || n == 7 || n == 10 || n == 11 || n == 14 || n == 15);
            case 1:
                return ((n >= 4 && n <= 7) || (n >= 12));
            case 2:
                return (n >= 8);
            case 3:
                return (n % 2 != 0);
        }
        return false;
    }
}
