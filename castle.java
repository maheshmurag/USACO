/*
TASK: numtri
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
    static boolean[][] visited;

//
    static int highestcomp=0;
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0,-1}};
    static String[] dirstr = {"N","E","S","W"};

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

        dfs(0, 0, 1);
        output.println();
        printArr(comps);
        output.close();

    }

    public static boolean withinBounds(int x, int y) {
        return ((x < N && x >= 0) && (y < M && y >= 0));
    }

    public static void dfs(int i, int j, int comp) {
        if(comp>highestcomp)highestcomp=comp;
        if (comps[i][j] == 0)
        {
            comps[i][j] = comp;
            visited[i][j] = true;
//            System.out.println("Setting comps["+i+"]["+j+"] to " + comp);
        }

        int tmpx, tmpy, count = 0;
        for (int x = 0; x < dirs.length; x++) {
            tmpx = i + dirs[x][0];
            tmpy = j + dirs[x][1];
            if (withinBounds(tmpx, tmpy) && !visited[tmpx][tmpy] && comps[tmpx][tmpy] == 0 && !a(arr[i][j], x)) {
                System.out.println("found friend: from (" +(i+1)+ "," + (j+1) + ") in dir " + dirstr[x] + " to (" +(tmpx+1)+ "," + (tmpy+1) + ") for comp " + comp);
                count++;
                visited[i][j] = true;
                dfs(tmpx, tmpy, comp);
            }
        }
        if (count == 0) {
            for (int x = 0; x < dirs.length; x++) {
                tmpx = i + dirs[x][0];
                tmpy = j + dirs[x][1];
                if (withinBounds(tmpx, tmpy) && comps[tmpx][tmpy] == 0 && a(arr[i][j], x)) {
//                    System.out.println(i+":"+j+":"+tmpx+":"+tmpy+":"+arr[i][j]+":"+x+":"+comp+":"+a(arr[i][j], x));
//                    System.out.println(comps[0][1]);
                    System.out.println("found break: from (" +(i+1)+ "," + (j+1) + ") in dir " + dirstr[x] + " to (" +(tmpx+1)+ "," + (tmpy+1) + ") for new comp " + (comp+1));
                    dfs(tmpx, tmpy, highestcomp + 1);

                }
            }
        }
    }

//    public static void rec(int x, int y, int prevX, int prevY, int comp) {
//        int c = 0;
//        if (aN(arr[x][y]) || (x == prevX && y == prevY)) c++;
//        if (aE(arr[x][y]) || (x == prevX && y == prevY)) c++;
//        if (aS(arr[x][y]) || (x == prevX && y == prevY)) c++;
//        if (aW(arr[x][y]) || (x == prevX && y == prevY)) c++;
//        if (c == 4) {
//            comps.get(comp)++;
//            return;
//        }
//
//        rec(x, y + 1, x, y, comp);
//
//
//    }

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

    public static boolean aN(int n) {
        return (n == 2 || n == 3 || n == 6 || n == 7 || n == 10 || n == 11 || n == 14 || n == 15);
    }
    public static boolean aE(int n) {
        return ((n >= 4 && n <= 7) || (n >= 12));
    }
    public static boolean aS(int n) {
        return n >= 8;
    }



    public static boolean aW(int n) {
        return (n % 2 != 0);
    }
}
