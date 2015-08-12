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
        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= max; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (i != j) {
                    if (arr[i][j] <= 50) {
                        sum = 0;
                        for (int k = 1; k <= max; k++) {
//                        if (j != k && k != i && arr[i][k] > 50)
                            if (arr[i][k] > 50)
                                sum += arr[k][j];
                            if (sum > 50) {
                                String str = i + " " + j;
                                if (!out.contains(str)) out.add(str);
                                break;
                            }
                        }
                        if (sum != 0) System.out.println(sum + ":i:" + i + ":" + j);
                    } else {
                        String str = i + " " + j;
                        if (!out.contains(str)) out.add(str);
                    }
                }
            }
        }


        String[] outArr = new String[out.size()];
        out.toArray(outArr);
        Arrays.sort(outArr);
        for (int i = 0; i < outArr.length; i++)
            output.println(outArr[i]);
        output.close();

    }

    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

