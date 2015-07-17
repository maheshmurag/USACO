/*
TASK: numtri
LANG: JAVA
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

public class numtri {
    static int max = 0, numrows = 5;
//    static List<List<Integer>> arr;
//    static int[][] m;

    public static void main(String[] args) throws java.io.IOException {
        StreamTokenizer input =new StreamTokenizer(new BufferedReader(new FileReader("numtri.in")));
        PrintWriter output=new PrintWriter(new FileWriter("numtri.out"));
        int N;
        input.nextToken();
        numrows=(int)input.nval;
        int[][] b=new int[numrows][];
        for(int i=0;i<numrows;i++){
            b[i]=new int[i+1];
            for(int j=0;j<=i;j++){
                input.nextToken();
                b[i][j]=(int)input.nval;
            }
        }
        for(int i=numrows-2;i>=0;i--)
            for(int j=0;j<=i;j++)
                b[i][j]=b[i][j]+Math.max(b[i + 1][j], b[i + 1][j + 1]);
        output.println(b[0][0]);
        output.close();

    }

//    public static int dfs(int r, int c) {
//        if (r < numrows && c < r+1 && m[r][c] != -1) {
//            return m[r][c];
//        } else if (r < numrows && c < r+1) {
//            m[r][c] = b[r][c] + Math.max(dfs(r + 1, c), dfs(r + 1, c + 1));
//            return m[r][c];
//        } else {
//            return 0;
//        }
//    }
}
