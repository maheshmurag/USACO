/*
TASK: knapsack2
LANG: JAVA
ID: maheshm2
 */

import java.io.*;
import java.util.Arrays;

public class knapsack2 {
    public static void main(String[] args) throws java.io.IOException {
        int val[] = {6, 10, 12};
        int wt[] = {1, 2, 3};
        int W = 5;
        int[][] arr = new int[wt.length][W + 1];
        for (int i = 0; i < arr.length; i++)
            Arrays.fill(arr[i], 0);
        for (int j = 0; j < arr[0].length; j++)//initializes first row
            if (wt[0] <= j)
                arr[0][j] = val[0];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (wt[i] > j)
                    arr[i][j] = arr[i - 1][j];//if item i can't fit, use best value when excluding this item (i.e. i-1)
                else
                    arr[i][j] = Math.max(arr[i - 1][j], val[i] + arr[i - 1][j - wt[i]]);
                //max of (without this item but same capacity, or with this item & capacity reduced by item's weight)
            }
        }
        System.out.println(arr[arr.length - 1][arr[0].length - 1]);
    }
}

