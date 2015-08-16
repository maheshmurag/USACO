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
            long[] arr = new long[(int)m];
            for (int j = 0; j < m; j++)
                arr[j] = sc.nextLong();
            for (int j = arr.length - 1; j >= 0; j--) {
                long a1 = arr[j], a2 = 0;
                if (j + 2 < arr.length)
                    a1 += arr[j + 2];
                if (j + 1 < arr.length)
                    a2 = arr[j + 1];
                arr[j] = Math.max(a1, a2);
            }
            out += "Case " + (i + 1) + ": " + arr[0] + "\n";
        }
        System.out.print(out);
    }
}