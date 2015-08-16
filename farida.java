import java.lang.Math;
import java.lang.String;
import java.lang.System;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class farida {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        String out = "";
        long n = sc.nextLong();
        for (int i = 0; i < n; i++) {
            long m = sc.nextLong();
            if (m == 0) {
                sc.nextLine();
                out += "Case " + (i + 1) + ": " + 0 + "\n";
                continue;
            }
            long[] arr = new long[(int) m];
            for (int j = 0; j < m; j++)
                arr[j] = sc.nextLong();
            //decision: either take j, or ignore it and take the next one
            for (int j = arr.length - 1; j >= 0; j--) {//loop from end to front
                long a1 = 0, a2 = 0;
                if (j + 2 < arr.length)//if you take j, skip monster j+1 and add j+2
                    a1 = arr[j + 2];
                if (j + 1 < arr.length)//if you skip j, get value of the one to the right of j
                    a2 = arr[j + 1];
                arr[j] = Math.max(arr[j] + a1, a2);//max between taking j & j+2 and taking only j+1
            }
            out += "Case " + (i + 1) + ": " + arr[0] + "\n";//arr[0] holds answer
        }
        System.out.print(out);
    }
}