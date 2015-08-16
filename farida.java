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
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();

            if(m==0){
                sc.next();
                continue;
            }

            int[] arr = new int[m];
            boolean[] taken = new boolean[m];
            int vals[] = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = sc.nextInt();
            }

            //try taking j & not taking j
            //1 2 3 4 5
            //if 1 is taken, vals[0] = 1
            //if j-1 is taken, vals[j] = vals[j-1]
            //else
            //vals[j] = vals[j-2] + arr[j]
            taken[0] = true;
            vals[0] = arr[0];
            for (int j = 1; j < m; j++) {
                    if (taken[j - 1]) {
                        arr[j] = arr[j - 1];
                        taken[j] = false;
                    } else {
                        arr[j] = Math.max(arr[j], arr[j - 2] + arr[j]);
                        taken[j] = true;
                    }
            }
            out += vals[vals.length - 1] + "\n";
        }
        System.out.print(out);
    }
}