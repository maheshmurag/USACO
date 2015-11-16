import java.io.*;
import java.lang.Comparable;
import java.util.Arrays;

public class pogocow {
    static StreamTokenizer input;
//    static int[] x;
//    static int[] p;
    static Thing[] cows;
    static int[][] dp;
    static int n;

    public static void main(String[] args) throws java.io.IOException {
        String prob = "pogocow";
        input = new StreamTokenizer(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new FileWriter(prob + ".out"));
        n = nextInt();
//        x = new int[n];
//        p = new int[n];
        cows = new Thing[n];
        for (int i = 0; i < n; i++) {
//            x[i] = nextInt();
//            p[i] = nextInt();
            cows[i] = new Thing(nextInt(), nextInt());
        }
        Arrays.sort(cows);
        dp = new int[2][n + 1];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j <= i; j++) {
                if(i-j >= 0)
                    dp(i - j, i, false, cows[i].p);
                if(i + j < n)
                    dp(i + j, i, true, cows[i].p);
            }
        }
//        System.out.println(dp(2, 1, true, cows[1].p));
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n - 1; i++) {
            int tmp = Math.max(dp[1][i], dp[0][i]);
            if (tmp > max) max = tmp;
        }
        System.out.println("left: " + Arrays.toString(dp[0]));
        System.out.println("right: " + Arrays.toString(dp[1]));
        output.println(max);
        output.close();
    }

    public static int dp(int ci, int prev, boolean dir, int points) {//true or 1 = right, false or 0= left
        if (ci < 0 || ci >= n) {
//            dp[dir?1:0][ci] = points;
            return points;
        }
//        System.out.println(cows[prev].x + " to " + cows[ci].x + ":" + (dir ? "right" : "left") + ":" + points + ":" + dp[dir ? 1 : 0][ci]);
        if (dir) {
            if (dp[1][ci] != -1) return dp[1][ci];
            for (int i = 0; i < n; i++) {
                if (cows[i].x > cows[ci].x) {
                    if (Math.abs(cows[i].x - cows[ci].x) >= Math.abs(cows[ci].x - cows[prev].x)) {
                        int t = dp(i, ci, true, points + cows[ci].p);
                        if(dp[1][ci]==-1)
                            dp[1][ci] = t;
                        else if(t > dp[1][ci])
                            dp[1][ci] = t;
                    }
                }
            }
        }
        else {
            if (dp[0][ci] != -1) return dp[0][ci];
            for (int i = 0; i < n; i++) {
                if (cows[i].x < cows[ci].x) {
                    if (Math.abs(cows[i].x - cows[ci].x) >= Math.abs(cows[ci].x - cows[prev].x)) {
                        int t = dp(i, ci, false, points + cows[ci].p);
                        if(dp[0][ci]==-1)
                            dp[0][ci] = t;
                        else if(t > dp[0][ci])
                            dp[0][ci] = t;
                    }
                }
            }
        }
        return points + cows[ci].p;
    }

    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }

    static class Thing implements Comparable<Thing> {
        int x, p;

        public Thing(int xx, int pp) {
            x = xx;
            p = pp;
        }

        public int compareTo(Thing o) {
            return this.x - o.x;
        }

        public String toString() {
            return x + ":" + p;
        }
    }
}

