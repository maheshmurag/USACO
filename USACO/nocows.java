/*
TASK: nocows
LANG: JAVA
ID: maheshm2
 */

import java.io.*;
import java.util.Arrays;

public class nocows {
    static int n, h;
    static int dp[][];
    static StreamTokenizer input;
    public static void main(String[] args) throws java.io.IOException {
        String prob = "nocows";
        input = new StreamTokenizer(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new FileWriter(prob + ".out"));
        n = nextInt();
        h = nextInt();
        dp = new int[n + 1][h + 1];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;
        solve(n, h);
        output.println(dp[n][h] % 9901);
        output.close();
    }

    public static int solve(int i, int j) {
        if (i % 2 == 0 || 2 * j - 1 > i) return 0;
        if (j == 1) return i == 1 ? 1 : 0;
        if (dp[i][j] != -1) return dp[i][j];
        dp[i][j] = 0;
        for (int a = 1; a < (i + 1) / 2; a += 2) {
            int n1 = a;
            int n2 = i - a - 1;
            int sol = 0;
            for (int b = 1; b + 1 < j; b++) {
                sol += solve(n1, b) * solve(n2, j - 1);
                sol += solve(n1, j - 1) * solve(n2, b);
                sol %= 9901;
            }
            sol += solve(n1, j - 1) * solve(n2, j - 1);
            sol %= 9901;
            if (n1 != n2) dp[i][j] += 2 * sol;
            else dp[i][j] += sol;
            dp[i][j] %= 9901;
        }
        return dp[i][j];
    }

    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

