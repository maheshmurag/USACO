/*
TASK: sort3
LANG: JAVA
ID: maheshm2
 */

import java.io.*;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.Arrays;

public class sort3 {
    static int n;
    static int arr[];
    static int carr[];
    static int counter = 0, min;
    static int a, b, c;

    public static void main(String[] args) throws java.io.IOException {
        String prob = "sort3";
        StreamTokenizer input = new StreamTokenizer(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new FileWriter(prob + ".out"));
        input.nextToken();
        n = (int) input.nval;
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            input.nextToken();
            arr[i] = (int) input.nval;
        }
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        a = 0;
        while (a < sorted.length && sorted[a] == 1) a++;
        b = a;//a, b, c are starting regions of 1,2,3 respectively
        while (b < sorted.length && sorted[b] == 2) b++;
        b -= a;
        c = sorted.length - b - a;
        int x, y;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                x = arr[i];
                y = arr[j];
                if (x != y && inPlace(x, j) && inPlace(y, i)) {
                    swap(i, j);
                    counter++;
                }
            }
        }
//        System.out.println(Arrays.toString(arr) + ":" + counter);
        int c = 0;
        for (int i = 0; i < arr.length; i++)
            if (!inPlace(arr[i], i))
                c++;
        counter += 2 * (c / 3);
        output.println(counter);


//        min = Integer.MAX_VALUE;
//        ArrayList<Integer> condensed = new ArrayList<Integer>();
//
//
//        for (int i = 0; i < arr.length; i += 0) {
//            if (arr[i] < min)
//                min = arr[i];
//            condensed.add(arr[i++]);
//            while (i < arr.length && arr[i] == arr[i - 1])
//                i++;
//        }
////        System.out.println(Arrays.toString(condensed.toArray()));
//        carr = new int[condensed.size()];
//        for (int i = 0; i < condensed.size(); i++)
//            carr[i] = condensed.get(i);
//        int start = 0, imin, tmp;
//        while (!isSorted(carr)) {
//            if (arr[start] != min) {
//                //do swap
//                imin = iMin(start);
//                if(imin==-1) {
//                    System.out.println("failure: " + Arrays.toString(carr));
//                    break;
//                }
//                tmp = arr[start];
//                arr[start] = arr[imin];
//                arr[imin] = tmp;
//                counter++;
//            }
//            start++;
//        }
//        System.out.println(counter);
        output.close();
    }

    public static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static boolean inPlace(int val, int index) {
        switch (val) {
            case 1:
                return index < a;
            case 2:
                return index >= a && index < a + b;
            case 3:
                return index >= a + b;
        }
        return false;
    }


    public static int iMin(int s) {
        int m = 4, im = -1;
        for (int i = s; i < carr.length; i++) {
            if (carr[i] == min)
                return i;
            if (carr[i] < m) {
                m = carr[i];
                im = i;
            }
        }
        return im;
    }

    public static boolean isSorted(int[] a) {
        if (a.length < 2) return true;
        for (int i = 1; i < a.length; i++)
            if (a[i] < a[i - 1])
                return false;
        return true;
    }
}
