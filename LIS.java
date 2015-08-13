/*
TASK: LIS
LANG: JAVA
ID: maheshm2
 */

import java.io.*;
import java.util.Arrays;

public class LIS {
    public static void main(String[] args) throws java.io.IOException {
//        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
        int arr[] = genArr(1000);
        int max = -1;
        int a[] = new int[arr.length];
        Arrays.fill(a,1);
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < i; j++)
                if(arr[i] > arr[j]) {
                    a[i] = Math.max(a[i], 1 + a[j]);
                    if(a[i] > max)
                        max = a[i];
                }
        System.out.println(max);
    }
    static int[] genArr(int len){
        int out[] = new int[len];
        for (int i = 0; i < len; i++) {
            out[i] = (int)(Math.random() * 100000);
        }
        return out;
    }
}

