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
                dp[i][j] = -1;//fill dp with -1
        solve(n, h);
        output.println(dp[n][h] % 9901!=-1?dp[n][h] % 9901:0);//if dp[n][h] is still -1, print 0
        output.close();
    }

    public static int solve(int i, int j) {
        if (i % 2 == 0 || 2 * j - 1 > i) return 0;//if out of bounds or # nodes is even
        if (j == 1) return i == 1 ? 1 : 0;//if height is 1, only answers are 1 and 0
        if (dp[i][j] != -1) return dp[i][j];//if is cached, return cached value
        dp[i][j] = 0;
        for (int a = 1; a < (i + 1) / 2; a += 2) {//loop through possible # of nodes
            int n1 = a;//left gets a nodes
            int n2 = i - 1 - a;//right gets the rest (total-rootnode-left)
            int sol = 0;
            for (int b = 1; b + 1 < j; b++) {//try all possible heights from 1 to j-2
                sol += solve(n1, b) * solve(n2, j - 1);//at least 1 must have height j-1 to make parent tree of height j
                sol += solve(n1, j - 1) * solve(n2, b);//the other one gets b
                sol %= 9901;
            }
            sol += solve(n1, j - 1) * solve(n2, j - 1);//check when both are of height j-1
            sol %= 9901;
            dp[i][j] += ((n1 != n2)?2:1) * sol;//if # nodes in subtrees are unequal you can double the count by swapping the two subtrees
            dp[i][j] %= 9901;
        }
        return dp[i][j];
    }

    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

