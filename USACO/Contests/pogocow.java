import java.io.*;
import java.lang.Comparable;
import java.util.Arrays;

public class pogocow {
    static StreamTokenizer input;
    static Thing[] cows;
    static int[][] dp;
    static int n;

    public static void main(String[] args) throws java.io.IOException {
        String prob = "pogocow";
        input = new StreamTokenizer(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new FileWriter(prob + ".out"));
        n = nextInt();
        cows = new Thing[n];
        for (int i = 0; i < n; i++)
            cows[i] = new Thing(nextInt(), nextInt());
        Arrays.sort(cows);
        dp = new int[n + 1][n + 1];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = 0;
        for (int ii = 1; ii >= -1; ii -= 2) {
            for (int i = (ii == 1 ? n - 1 : 0); (ii == 1 ? i >= 0 : i < n); i -= ii) {
                for (int j = (ii == 1 ? 0 : i - 1); (ii == 1 ? j < i : j >= 0); j += ii) {
                    int m = Integer.MIN_VALUE;
                    for (int k = j + ii; (ii == 1 ? k < i : k >= 0); k += ii)
                        if (dp[j][k] < m && Math.abs(cows[j].x - cows[i].x) <= Math.abs(cows[k].x - cows[j].x))
                            m = dp[j][k];
                    dp[i][j] = Math.max(cows[i].p + m, dp[i][j]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (dp[i][j] > max)
                    max = dp[i][j];
            }
        }
        System.out.println(max);
        output.close();
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

//    public static int dp(int ci, int prev, boolean dir, int points) {//true or 1 = right, false or 0= left
//        if (ci < 0 || ci >= n ){
////            dp[dir?1:0][ci] = points;
//            return points;
//        }
//        System.out.println(x[prev]+" to "+x[ci]+":"+(dir?"right":"left")+":"+points +":"+dp[dir?1:0][ci]);
//        if (dir) {
//            if (dp[1][ci] != -1) return dp[1][ci];
//            for (int i = 0; i < n; i++) {
//                if (cows[i].x > x[ci]) {
//                    if (Math.abs(cows[i].x - x[ci]) >= Math.abs(x[ci] - x[prev])) {
//                        dp[1][ci] = dp(i, ci, true, points + p[ci]);
//                    }
//                }
//            }
//        }
//        else {
//            if (dp[0][ci] != -1) return dp[0][ci];
//            for (int i = 0; i < n; i++)
//                if (cows[i].x < x[ci] && Math.abs(cows[i].x - x[ci]) >= Math.abs(x[ci] - x[prev]))//if next-cur >= cur-prev
//                    dp[0][ci] = dp(i, ci, false, points + p[ci]);
//        }
//        return points+p[ci];
//    }

    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

