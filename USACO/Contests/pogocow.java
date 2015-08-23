import java.io.*;

public class pogocow {
    static StreamTokenizer input;
    static int[] x;
    static int[] p;
    static int[][] dp;
    static int n;

    public static void main(String[] args) throws java.io.IOException {
        String prob = "pogocow";
        input = new StreamTokenizer(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new FileWriter(prob + ".out"));
        n = nextInt();
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            p[i] = nextInt();
        }
        dp = new int[n + 1][2];

        for (int i = 1; i < n - 1; i++) {
            dp(i - 1, false, p[i]);
            dp(i + 1, true, p[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n - 1; i++) {
            int tmp = Math.max(dp[i][1], dp[i][0]);
            if (tmp > max) max = tmp;
        }

        output.println(max);
        output.close();
    }

    public static void dp(int ci, int prev, boolean dir, int points) {//true or 1 = right, false or 0= left
        if (ci <= 0 || ci >= n - 1) return;
        if (dir) {
            if (dp[ci][1] != -1) return dp[ci][1];
            for (int i = ci + 1; i < n; i++) {
                if (Math.abs(x[i] - x[ci]) >= Math.abs(x[ci] - x[ci - 1]))
                    dp[ci][1] = dp(ci + 1, true, points + p[ci]);
            }
        } else {
            if (dp[ci][0] != -1) return dp[ci][0];
            for (int i = 0; i < ci; i++) {
                if (Math.abs(x[ci] - x[i]) >= Math.abs(x[ci + 1] - x[ci]))
                    dp[ci][1] = dp(ci + 1, true, points + p[ci]);
            }
        }
    }

    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

