import java.io.*;
import java.lang.Integer;
import java.util.Arrays;

public class MaxChange {
    public static void main(String[] args) throws IOException {
        //http://people.cs.clemson.edu/~bcdean/dp_practice/dp_2.swf
        int[] A = {1, 5, 10, 25}; // =
        int N = 63;
        System.out.println(ans(A, N));
    }
    public static int ans(int[] ar, int W) {
        int[] dp = new int[W+1];
        for (int i = 0; i < ar.length; i++)
            dp[ar[i]] = 1;
        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < ar.length && ar[j] <= i; j++)
                if(i-ar[j] >= 0 && dp[i-ar[j]] < min)
                    min = dp[i-ar[j]];
            dp[i] = min + 1;
        }
        return dp[W];
    }
}
