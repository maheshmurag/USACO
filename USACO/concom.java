/*
TASK: concom
LANG: JAVA
ID: maheshm2
 */
import java.io.*;
import java.lang.String;
import java.lang.System;
import java.util.ArrayList;
import java.util.Arrays;
public class concom {
    static StreamTokenizer input;
    public static void main(String[] args) throws java.io.IOException {
        String prob = "concom";
        input = new StreamTokenizer(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new FileWriter(prob + ".out"));
        int[][] arr = new int[101][101];
        int n = nextInt(), a = 0, b = 0, c = 0, max = -1;
        for (int i = 0; i < n; i++) {
            a = nextInt();
            b = nextInt();
            c = nextInt();
            if (a > max) max = a;
            if (b > max) max = b;
            arr[a][b] = c;
            arr[a][a] = 100;
            arr[b][b] = 100;
        }
        int sum = 0;
        ArrayList<String> out = new ArrayList<String>();
        boolean v[][] = new boolean[101][101];
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (i != j && !v[i][j] && arr[i][j] > 50) {
                    v[i][j] = true;
                    for (int k = 1; k <= max; k++) {
                        arr[i][k] += arr[j][k];
                        if(v[j][k]) v[i][k] = true;
                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                if(v[i][j] && i!=j)
                    output.println(i+" " +j);
        output.close();
    }

    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

